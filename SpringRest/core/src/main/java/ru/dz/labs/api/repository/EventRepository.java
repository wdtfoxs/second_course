package ru.dz.labs.api.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dz.labs.api.model.Event;
import ru.dz.labs.api.model.User;

import java.util.List;

/**
 * Created by Nikita Prozorov on 20.05.2016.
 */
@Repository
public class EventRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session curSession() {
        return sessionFactory.getCurrentSession();
    }

    public Event getEventById(Long id){
        return (Event) curSession().get(Event.class, id);
    }


    public List<Event> getEventByStatus(Integer status){
        return curSession().createCriteria(Event.class).add(Restrictions.eq("status", status)).list();
    }

    public void addEvent(Event event){
        curSession().save(event);
    }


    public void deleteEvent(Event event){
        curSession().delete(event);
    }


    public List<Event> getUsersEvents(Integer status, User user){
        return curSession().createCriteria(Event.class).add(Restrictions.eq("status", status))
                .add(Restrictions.eq("user", user)).list();
    }

    public void update(Event event){
        curSession().update(event);
    }


}
