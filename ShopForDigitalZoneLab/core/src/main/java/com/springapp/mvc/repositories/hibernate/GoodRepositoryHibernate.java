package com.springapp.mvc.repositories.hibernate;

import com.springapp.mvc.entity.Categories;
import com.springapp.mvc.entity.Good;
import com.springapp.mvc.repositories.GoodRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoodRepositoryHibernate implements GoodRepository{

    @Autowired
    private SessionFactory sessionFactory;

    private Session curSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public void add(Good good) {
        curSession().save(good);
    }

    @Override
    public List<Good> getAll() {
        return curSession().createCriteria(Good.class).list();
    }

    @Override
    public Good getGoodById(Long id) {
        return (Good) curSession().get(Good.class, id);
    }

    @Override
    public List<Good> getGoodsByCategoryByAsc(Categories categories) {
        return curSession().createCriteria(Good.class).add(Restrictions.eq("categories", categories)).addOrder(Order.asc("price")).list();
    }


}
