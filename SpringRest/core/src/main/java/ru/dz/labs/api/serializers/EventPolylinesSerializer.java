package ru.dz.labs.api.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.stereotype.Service;
import ru.dz.labs.api.model.Event;
import ru.dz.labs.api.model.Point;
import ru.dz.labs.api.model.Polyline;

import java.io.IOException;
import java.util.List;

/**
 * Created by Nikita Prozorov on 21.05.2016.
 */
@Service
public class EventPolylinesSerializer extends JsonSerializer<Event> {


    @Override
    public void serialize(Event event, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();

        jsonGenerator.writeFieldName("polylines");
        List<Polyline> polylines = event.getPolylines();
        jsonGenerator.writeStartArray();
        for (Polyline polyline: polylines){
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("id", polyline.getId());
            jsonGenerator.writeNumberField("user_id", polyline.getUser().getId());

            jsonGenerator.writeFieldName("points");
            List<Point> points = polyline.getPoints();
            jsonGenerator.writeStartArray();
            for (Point point: points){
                jsonGenerator.writeStartObject();
                jsonGenerator.writeNumberField("id", point.getId());
                jsonGenerator.writeNumberField("lat", point.getLat());
                jsonGenerator.writeNumberField("lng", point.getLng());
                jsonGenerator.writeEndObject();
            }
            jsonGenerator.writeEndArray();

            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();

        jsonGenerator.writeEndObject();
    }
}
