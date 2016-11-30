package com.springapp.mvc.repositories;

import com.springapp.mvc.entity.Categories;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoriesRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session curSession() {
        return sessionFactory.getCurrentSession();
    }

    public Categories getAll() {
        return  (Categories) curSession().createCriteria(Categories.class).add(Restrictions.eq("name", "all")).uniqueResult();
    }

    public Categories getCategory(String category) {
        return (Categories) curSession().createCriteria(Categories.class).add(Restrictions.eq("name", category)).uniqueResult();
    }

}
