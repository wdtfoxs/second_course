package com.springapp.mvc.aspects;

import com.springapp.mvc.entity.Categories;
import com.springapp.mvc.services.CategoriesService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Аспект для добавления списка категорий в меню шапки сайта
 *
 * Gataullin Kamil
 * 14.03.2016 23:24
 */
@Aspect
@Component
public class MainCategoriesAspect {

    private static final String MAIN_CATEGORIES_LIST = "listCategories";

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private CategoriesService categoriesService;

    @Pointcut("@annotation(com.springapp.mvc.aspects.annotation.IncludeCategories)")
    public void includeCategoriesInfoMethod() {
    }

    @Before("includeCategoriesInfoMethod()")
    public void includeMenuInfo() {
        Categories category = categoriesService.getCategoryForMenu();
        List<Categories> categories = new ArrayList<Categories>();
        categories.add(category);
        for (Categories cat : category.getChildren()) {
            categories.add(cat);
        }

        request.setAttribute(MAIN_CATEGORIES_LIST, categories);

    }
}
