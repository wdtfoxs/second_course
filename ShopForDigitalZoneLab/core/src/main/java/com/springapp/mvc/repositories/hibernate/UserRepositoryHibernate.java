package com.springapp.mvc.repositories.hibernate;

import com.springapp.mvc.entity.User;
import com.springapp.mvc.repositories.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryHibernate implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session curSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void add(User user) {
        curSession().save(user);
    }

    @Override
    public void update(User user) {
        curSession().update(user);
    }


    @Override
    public User getEmail(String email){
        return (User) curSession().createCriteria(User.class)
                .add(Restrictions.eq("email", email)).uniqueResult();
    }

    @Override
    public User getUserByLogin(String login) {
        return (User) curSession().createCriteria(User.class)
                .add(Restrictions.eq("login", login)).uniqueResult();
    }

}
