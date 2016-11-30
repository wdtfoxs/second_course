package ru.dz.labs.api.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.api.model.Event;
import ru.dz.labs.api.model.MissingPeople;
import ru.dz.labs.api.model.User;
import ru.dz.labs.api.repository.UserRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikita Prozorov on 21.05.2016.
 */
@Component
public class EventDeserializer extends JsonDeserializer<Event> {
    private static UserRepository userRepository;

    @Autowired
    public EventDeserializer(UserRepository uR) {
        userRepository = uR;
    }

    public EventDeserializer() {
    }

    @Override
    @Transactional
    public Event deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Root root = jsonParser.readValueAs(Root.class);

        Event event = new Event();
        event.setEventName(root.eventName);
        event.setStatus(root.status);

        User user = EventDeserializer.userRepository.getUserByLogin(root.login);
        event.setUser(user);

        List<MissingPeople> list = new ArrayList<>();
        for (int i = 0; i< root.peopleInfo.size(); i++) {
            MissingPeople mp = new MissingPeople();
            mp.setName(root.peopleInfo.get(i).name);
            mp.setAge(root.peopleInfo.get(i).age);
            mp.setGender(root.peopleInfo.get(i).gender);
            mp.setFeatures(root.peopleInfo.get(i).features);
            mp.setHeight(root.peopleInfo.get(i).height);
            list.add(mp);
        }
        event.setPeopleInfo(list);

        return event;
    }

    private static class Root{
        public String eventName;
        public Integer status;
        public String login;
        public List<PeopleInfo> peopleInfo;
    }

    private static class PeopleInfo{
        public String name;
        public Integer age;
        public String gender;
        public String features;
        public Integer height;
    }


}
