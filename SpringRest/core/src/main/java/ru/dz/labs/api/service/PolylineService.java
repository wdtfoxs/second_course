package ru.dz.labs.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.api.model.Event;
import ru.dz.labs.api.model.Point;
import ru.dz.labs.api.model.Polyline;
import ru.dz.labs.api.model.json.PointJson;
import ru.dz.labs.api.model.json.PolylineJson;
import ru.dz.labs.api.repository.PolylineRepository;

import java.util.List;

/**
 * Created by Nikita Prozorov on 21.05.2016.
 */
@Service
public class PolylineService {

    @Autowired
    private PolylineRepository polylineRepository;

    @Transactional
    public String addPoint(PointJson pointJson){
        Polyline polyline = polylineRepository.getPolylineById(pointJson.getPolyline_id());
        if (polyline != null){
            Point point = new Point();
            point.setLng(pointJson.getLng());
            point.setLat(pointJson.getLat());
            polyline.getPoints().add(point);
            polylineRepository.updatePolyline(polyline);
            return "{\"success\": \"true\" }";
        }else {
            return "{\"success\": \"false\"," +
                    "\"message\": \"Adding point to polyline failed\"}";
        }
    }

}
