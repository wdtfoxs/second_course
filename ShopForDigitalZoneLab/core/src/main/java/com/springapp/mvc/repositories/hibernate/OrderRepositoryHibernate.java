package com.springapp.mvc.repositories.hibernate;

import com.springapp.mvc.entity.Order;
import com.springapp.mvc.entity.User;
import com.springapp.mvc.repositories.OrderRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepositoryHibernate implements OrderRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session curSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addOrder(Order order) {
        curSession().save(order);
    }

    @Override
    public void updateOrder(Order order) {
        curSession().update(order);
    }

    @Override
    public void remove(Order order) {
        curSession().delete(order);
    }
}
