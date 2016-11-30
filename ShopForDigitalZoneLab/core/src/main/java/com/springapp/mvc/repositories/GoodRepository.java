package com.springapp.mvc.repositories;

import com.springapp.mvc.entity.Categories;
import com.springapp.mvc.entity.Good;

import java.util.List;

public interface GoodRepository {
    void add(Good good);
    List<Good> getAll();
    Good getGoodById(Long id);
    List<Good> getGoodsByCategoryByAsc(Categories categories);
}
