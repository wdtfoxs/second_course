package com.springapp.mvc.repositories;

import com.springapp.mvc.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository{

    @Autowired
    private SessionFactory sessionFactory;

    private Session curSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addOrder(Order order) {
        curSession().save(order);
    }

    public void updateOrder(Order order) {
        curSession().update(order);
    }

    public void remove(Order order) {
        curSession().delete(order);
    }
}
