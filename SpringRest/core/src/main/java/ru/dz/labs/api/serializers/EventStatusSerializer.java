package ru.dz.labs.api.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.stereotype.Service;
import ru.dz.labs.api.model.Event;

import java.io.IOException;

/**
 * Created by Nikita Prozorov on 21.05.2016.
 */
@Service
public class EventStatusSerializer extends JsonSerializer<Event> {
    @Override
    public void serialize(Event event, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", event.getId());
        jsonGenerator.writeStringField("name", event.getEventName());
        jsonGenerator.writeEndObject();
    }
}
