package ru.dz.labs.api.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dz.labs.api.model.MissingPeople;

/**
 * Created by Nikita Prozorov on 21.05.2016.
 */
@Repository
public class MissingPeopleRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session curSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addPeopleInfo(MissingPeople missingPeople){
        curSession().save(missingPeople);
    }
}
