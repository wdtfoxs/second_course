package ru.dz.labs.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ru.dz.labs.api.deserializers.EventDeserializer;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Nikita Prozorov on 15.05.2016.
 */
@Entity
@Table(name = "events")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonDeserialize(using = EventDeserializer.class)
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String eventName;

    private Integer status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonManagedReference
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MissingPeople> peopleInfo;

    @JsonManagedReference
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Polyline> polylines;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "figurePoints_event", joinColumns = @JoinColumn(name = "event_id"), inverseJoinColumns = @JoinColumn(name = "figurePoint_id"))
    private List<Point> figurePoints;

    @ManyToMany(mappedBy = "events", fetch = FetchType.LAZY)
    private List<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<MissingPeople> getPeopleInfo() {
        return peopleInfo;
    }

    public void setPeopleInfo(List<MissingPeople> peopleInfo) {
        this.peopleInfo = peopleInfo;
    }

    public List<Point> getFigurePoints() {
        return figurePoints;
    }

    public void setFigurePoints(List<Point> figurePoints) {
        this.figurePoints = figurePoints;
    }

    public List<Polyline> getPolylines() {
        return polylines;
    }

    public void setPolylines(List<Polyline> polylines) {
        this.polylines = polylines;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Event(String eventName, Integer status, User user, List<MissingPeople> peopleInfo) {
        this.eventName = eventName;
        this.status = status;
        this.user = user;
        this.peopleInfo = peopleInfo;
    }

    public Event() {
    }
}
