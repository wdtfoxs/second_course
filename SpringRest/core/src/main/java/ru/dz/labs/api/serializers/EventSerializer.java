package ru.dz.labs.api.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.stereotype.Service;
import ru.dz.labs.api.model.Event;
import ru.dz.labs.api.model.MissingPeople;
import ru.dz.labs.api.model.Point;

import java.io.IOException;
import java.util.List;

/**
 * Created by Nikita Prozorov on 20.05.2016.
 */
@Service
public class EventSerializer extends JsonSerializer<Event>{
    @Override
    public void serialize(Event event, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", event.getId());
        jsonGenerator.writeStringField("name", event.getEventName());
        jsonGenerator.writeNumberField("status", event.getStatus());
        jsonGenerator.writeStringField("login", event.getUser().getLogin());

        jsonGenerator.writeFieldName("peopleInfo");
        List<MissingPeople> peopleInfo = event.getPeopleInfo();
        jsonGenerator.writeStartArray();
        for (MissingPeople people: peopleInfo){
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("id", people.getId());
            jsonGenerator.writeStringField("name", people.getName());
            jsonGenerator.writeNumberField("age", people.getAge());
            jsonGenerator.writeStringField("gender", people.getGender());
            jsonGenerator.writeStringField("features", people.getFeatures());
            jsonGenerator.writeNumberField("height", people.getHeight());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();

        jsonGenerator.writeFieldName("figurePoints");
        List<Point> figurePoints = event.getFigurePoints();
        jsonGenerator.writeStartArray();
        for (Point fgp: figurePoints){
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("id", fgp.getId());
            jsonGenerator.writeNumberField("lat", fgp.getLat());
            jsonGenerator.writeNumberField("lng", fgp.getLng());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();

        jsonGenerator.writeEndObject();
    }
}
