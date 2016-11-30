package com.springapp.mvc.repositories;

import com.springapp.mvc.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository{

    @Autowired
    private SessionFactory sessionFactory;

    private Session curSession() {
        return sessionFactory.getCurrentSession();
    }

    public void add(User user) {
        curSession().save(user);
    }

    public void update(User user) {
        curSession().update(user);
    }

    public User getEmail(String email){
        return (User) curSession().createCriteria(User.class)
                .add(Restrictions.eq("email", email)).uniqueResult();
    }

    public User getUserByLogin(String login) {
        return (User) curSession().createCriteria(User.class)
                .add(Restrictions.eq("login", login)).uniqueResult();
    }

}
