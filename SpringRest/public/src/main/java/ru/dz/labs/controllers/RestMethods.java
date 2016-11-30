package ru.dz.labs.controllers;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.dz.labs.api.model.*;
import ru.dz.labs.api.model.json.FigurePointJson;
import ru.dz.labs.api.model.json.PeopleInfoJson;
import ru.dz.labs.api.model.json.PointJson;
import ru.dz.labs.api.model.json.PolylineJson;
import ru.dz.labs.api.serializers.EventPolylinesSerializer;
import ru.dz.labs.api.serializers.EventSerializer;
import ru.dz.labs.api.serializers.EventStatusSerializer;
import ru.dz.labs.api.serializers.UserSerializer;
import ru.dz.labs.api.service.EventService;
import ru.dz.labs.api.service.PolylineService;
import ru.dz.labs.api.service.UserService;

@RestController
public class RestMethods {

    @Autowired
    private UserService userService;
    @Autowired
    private EventService eventService;
    @Autowired
    private PolylineService polylineService;

    //1
    @RequestMapping(value = "/api/v2/event", method = RequestMethod.GET)
    public String getEvent(Long id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.getFactory().configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
        mapper.registerModule(new SimpleModule().addSerializer(Event.class, new EventSerializer()));
        return mapper.writeValueAsString(eventService.getEventById(id));
    }

    //2
    @RequestMapping(value = "/api/v2/polyline", method = RequestMethod.GET)
    public String getPolyline(Long event_id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.getFactory().configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
        mapper.registerModule(new SimpleModule().addSerializer(Event.class, new EventPolylinesSerializer()));
        return mapper.writeValueAsString(eventService.getEventById(event_id));
    }

    //3
    @RequestMapping(value = "/api/v2/events", method = RequestMethod.GET, params = "!id")
    public String getEventByStatus(String status) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.getFactory().configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
        mapper.registerModule(new SimpleModule().addSerializer(Event.class, new EventStatusSerializer()));
        return mapper.writeValueAsString(eventService.getEventByStatus(status));
    }

    //4
    @RequestMapping(value = "/api/v2/events", method = RequestMethod.GET)
    public String getUsersEvents(Long id, String status) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.getFactory().configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
        mapper.registerModule(new SimpleModule().addSerializer(Event.class, new EventStatusSerializer()));
        return mapper.writeValueAsString(eventService.getUserEvents(status, id));
    }

    //5
    @RequestMapping(value = "/api/v2/user", method = RequestMethod.POST)
    public String autorizationForUser(String login, String password){
        return userService.autorization(login, password);
    }

    //6
    @RequestMapping(value = "/api/v2/user", method = RequestMethod.GET)
    public String getUser(String login) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.getFactory().configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
        mapper.registerModule(new SimpleModule().addSerializer(User.class, new UserSerializer()));
        return mapper.writeValueAsString(userService.getUserByLogin(login));
    }

    //7
    @RequestMapping(value = "/api/v2/user/new", method = RequestMethod.POST, consumes = "application/json")
    public String registrationForUser(@RequestBody User user){
        return userService.registrationUser(user);
    }

    //8
    @RequestMapping(value = "/api/v2/events/new", method = RequestMethod.POST, consumes = "application/json")
    public String addEvent(@RequestBody Event event){
        return eventService.addEvent(event);
    }

    //9
    @RequestMapping(value = "/api/v2/peopleInfo", method = RequestMethod.POST, consumes = "application/json")
    public String addPeopleInfo(@RequestBody PeopleInfoJson peopleInfoJson){
        return eventService.addPeople(peopleInfoJson);
    }

    //10
    @RequestMapping(value = "/api/v2/polyline/new", method = RequestMethod.POST, consumes = "application/json")
    public String addPolyline(@RequestBody PolylineJson polylineJson){
        return eventService.addPolyline(polylineJson);
    }

    //11
    @RequestMapping(value = "/api/v2/polyline/point", method = RequestMethod.POST, consumes = "application/json")
    public String addPointPolyline(@RequestBody PointJson pointJson){
        return polylineService.addPoint(pointJson);
    }

    //12
    @RequestMapping(value = "/api/v2/event/figurePoint", method = RequestMethod.POST, consumes = "application/json")
    public String addFigurePoint(@RequestBody FigurePointJson figurePointJson){
        return eventService.addFigurePoint(figurePointJson);
    }

    //13
    @RequestMapping(value = "/api/v2/event/{id}", method = RequestMethod.DELETE)
    public String deleteEvent(@PathVariable Long id){
        return eventService.deleteEvent(id);
    }

    //14
    @RequestMapping(value = "/api/v2/event/{id}", method = RequestMethod.PUT)
    public String changeStatus(@PathVariable Long id, @RequestBody Integer status){
        return eventService.changeStatus(id, status);
    }

}
