package ru.dz.labs.api.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.api.model.User;
import ru.dz.labs.api.repository.UserRepository;

import java.io.IOException;

/**
 * Created by Nikita Prozorov on 21.05.2016.
 */
public class UserDeserializer extends JsonDeserializer<User> {

    @Override
    public User deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        Root root = jsonParser.readValueAs(Root.class);

        User user = new User();

        user.setLogin(root.login);
        user.setPassword(root.password);
        user.setPhone(root.phone);

        return user;
    }

    private static class Root {
        public String login;
        public String password;
        public String phone;
    }
}
