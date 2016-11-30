package com.springapp.mvc.repositories;

import com.springapp.mvc.entity.Categories;
import com.springapp.mvc.entity.Good;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoodRepository{

    @Autowired
    private SessionFactory sessionFactory;

    private Session curSession() {
        return sessionFactory.getCurrentSession();
    }

    public void add(Good good) {
        curSession().save(good);
    }

    public List<Good> getAll() {
        return curSession().createCriteria(Good.class).list();
    }

    public Good getGoodById(Long id) {
        return (Good) curSession().get(Good.class, id);
    }

    public List<Good> getGoodsByCategoryByAsc(Categories categories) {
        return curSession().createCriteria(Good.class).add(Restrictions.eq("categories", categories)).addOrder(Order.asc("price")).list();
    }


}
