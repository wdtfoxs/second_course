package ru.dz.labs.api.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dz.labs.api.model.User;


/**
 * Created by Nikita Prozorov on 20.05.2016.
 */
@Repository
public class UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session curSession() {
        return sessionFactory.getCurrentSession();
    }

    public User getUserById(Long id){
        return (User) curSession().get(User.class, id);
    }

    public User getUserByLogin(String login) {
        return (User) curSession().createCriteria(User.class)
                .add(Restrictions.eq("login", login)).uniqueResult();
    }

    public User getUserByLoginAndPass(String login, String password) {
        return (User) curSession().createCriteria(User.class)
                .add(Restrictions.eq("login", login))
                .add(Restrictions.eq("password", password))
                .uniqueResult();
    }

    public void addUser(User user){
        curSession().save(user);
    }

    public void updateUser(User user){
        curSession().update(user);
    }
}
