package ru.dz.labs.api.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dz.labs.api.model.Polyline;

import java.util.List;

/**
 * Created by Nikita Prozorov on 21.05.2016.
 */
@Repository
public class PolylineRepository {
    @Autowired
    private SessionFactory sessionFactory;

    private Session curSession() {
        return sessionFactory.getCurrentSession();
    }

    public List<Polyline> getPolylinesByEvent(Long id){
        return curSession().createCriteria(Polyline.class).add(Restrictions.eq("event", id)).list();
    }

    public void deletePolyline(Polyline polyline){
        curSession().delete(polyline);
    }

    public void addPolyline(Polyline polyline){
        curSession().save(polyline);
    }

    public Polyline getPolylineById(Long id){
        return (Polyline) curSession().get(Polyline.class, id);
    }

    public void updatePolyline(Polyline polyline){
        curSession().update(polyline);
    }

}
