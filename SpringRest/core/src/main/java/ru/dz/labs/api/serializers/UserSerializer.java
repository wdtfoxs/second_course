package ru.dz.labs.api.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.stereotype.Service;
import ru.dz.labs.api.model.User;

import java.io.IOException;

/**
 * Created by Nikita Prozorov on 21.05.2016.
 */
@Service
public class UserSerializer extends JsonSerializer<User> {
    @Override
    public void serialize(User user, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", user.getId());
        jsonGenerator.writeStringField("login", user.getLogin());
        jsonGenerator.writeStringField("phone", user.getPhone());
        jsonGenerator.writeEndObject();
    }
}
