package com.springapp.mvc.repositories.hibernate;

import com.springapp.mvc.entity.Categories;
import com.springapp.mvc.entity.Good;
import com.springapp.mvc.repositories.CategoriesRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoriesRepositoryHibernate implements CategoriesRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session curSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Categories getAll() {
        return  (Categories) curSession().createCriteria(Categories.class).add(Restrictions.eq("name", "all")).uniqueResult();
    }

    @Override
    public Categories getCategories(String category) {
        return (Categories) curSession().createCriteria(Categories.class).add(Restrictions.eq("name", category)).uniqueResult();
    }

}
