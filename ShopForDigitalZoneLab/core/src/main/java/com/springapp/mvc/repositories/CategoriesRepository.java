package com.springapp.mvc.repositories;

import com.springapp.mvc.entity.Categories;
import com.springapp.mvc.entity.Good;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CategoriesRepository {

    Categories getAll();

    Categories getCategories(String category);
}
