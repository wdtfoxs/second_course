package ru.dz.labs.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.api.model.*;
import ru.dz.labs.api.model.json.FigurePointJson;
import ru.dz.labs.api.model.json.PeopleInfoJson;
import ru.dz.labs.api.model.json.PolylineJson;
import ru.dz.labs.api.repository.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikita Prozorov on 20.05.2016.
 */
@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MissingPeopleRepository missingPeopleRepository;
    @Autowired
    private PolylineRepository polylineRepository;


    @Transactional
    public Event getEventById(Long id) {
        return eventRepository.getEventById(id);
    }

    @Transactional
    public List<Event> getEventByStatus(String status) {
        return eventRepository.getEventByStatus(Integer.valueOf(status));
    }

    @Transactional
    public List<Event> getUserEvents(String status, Long id) {
        return eventRepository.getUsersEvents(Integer.valueOf(status), userRepository.getUserById(id));
    }

    @Transactional
    public String addEvent(Event event) {
        if (event.getEventName() != null && event.getUser() != null && (event.getPeopleInfo() != null || event.getPeopleInfo().size() != 0)) {
            eventRepository.addEvent(event);
            for (int i = 0; i < event.getPeopleInfo().size(); i++) {
                event.getPeopleInfo().get(i).setEvent(event);
                missingPeopleRepository.addPeopleInfo(event.getPeopleInfo().get(i));
            }
            return "{\"id\": " + event.getId() + "}";
        } else {
            return "{\"success\": \"false\"," +
                    "\"message\": \"Event creation failed\"}";
        }
    }

    @Transactional
    public String addPolyline(PolylineJson polylineJson) {
        if (polylineJson.getEvent_id() != null && polylineJson.getUser_id() != null) {
            Event event = eventRepository.getEventById(polylineJson.getEvent_id());
            User user = userRepository.getUserById(polylineJson.getUser_id());
            if (event != null && user != null) {
                Polyline polyline = new Polyline();
                polyline.setUser(user);
                polyline.setEvent(event);

                Point point = new Point();
                point.setLat(polylineJson.getLat());
                point.setLng(polylineJson.getLng());
                List<Point> points = new ArrayList<>();
                points.add(point);
                polyline.setPoints(points);

                polylineRepository.addPolyline(polyline);

                event.getPolylines().add(polyline);
                eventRepository.update(event);

                return "{\"success\": \"true\" }";
            }
        }
        return "{\"success\": \"false\"," +
                "\"message\": \"Adding polyline failed\"}";
    }

    @Transactional
    public String addFigurePoint(FigurePointJson figurePointJson) {
        if (figurePointJson.getEvent_id() != null) {
            Event event = eventRepository.getEventById(figurePointJson.getEvent_id());
            if (event != null) {
                Point point = new Point();
                point.setLat(figurePointJson.getLat());
                point.setLng(figurePointJson.getLng());
                event.getFigurePoints().add(point);
                eventRepository.update(event);
                return "{\"success\": \"true\"}";
            }
        }
        return "{\"success\": \"false\"," +
                "\"message\": \"Adding point to event failed\"}";
    }

    @Transactional
    public String addPeople(PeopleInfoJson peopleInfoJson) {
        if (peopleInfoJson.getEvent_id() != null) {
            Event event = eventRepository.getEventById(peopleInfoJson.getEvent_id());
            if (event != null) {
                MissingPeople missingPeople = new MissingPeople();
                missingPeople.setName(peopleInfoJson.getName());
                missingPeople.setGender(peopleInfoJson.getGender());
                missingPeople.setAge(peopleInfoJson.getAge());
                missingPeople.setHeight(peopleInfoJson.getHeight());
                missingPeople.setFeatures(peopleInfoJson.getFeatures());
                missingPeople.setEvent(event);

                missingPeopleRepository.addPeopleInfo(missingPeople);

                eventRepository.update(event);
                return "{\"success\": \"true\"}";
            }
        }
        return "{\"success\": \"false\"," +
                "\"message\": \"Adding peopleInfo failed\"}";
    }


    @Transactional
    public String deleteEvent(Long id) {
        Event event = eventRepository.getEventById(id);
        if (id != null) {
            eventRepository.deleteEvent(event);
            for (User us: event.getUsers()) {
                for (Event ev: us.getEvents()) {
                    if (ev == event) {
                        eventRepository.deleteEvent(ev);
                        break;
                    }
                }
                us.getEvents().remove(event);
                userRepository.updateUser(us);
            }
            return "{\"success\": \"true\"}";
        } else {
            return "{\"success\": \"false\"," +
                    "\"message\": \"Event deleting failed\"}";
        }
    }

    @Transactional
    public String changeStatus(Long id, Integer status) {
        Event event = eventRepository.getEventById(id);
        if (event != null) {
            event.setStatus(status);

            eventRepository.update(event);
            return "{\"success\": \"true\"}";
        } else {
            return "{\"success\": \"false\"," +
                    "\"message\": \"Status change failed\"}";
        }
    }

}
