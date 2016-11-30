package com.springapp.mvc.services;

import com.springapp.mvc.entity.Categories;
import com.springapp.mvc.entity.Good;
import com.springapp.mvc.repositories.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodService {

    @Autowired
    private GoodRepository goodRepository;

    @Transactional
    public List<Good> getAll(){
        return goodRepository.getAll();
    }

    @Transactional
    public Good getGoodById(Long id){
        return goodRepository.getGoodById(id);
    }

    @Transactional
    public List<Good> getGoodsByCategoryByAsc(Categories categories){
        return goodRepository.getGoodsByCategoryByAsc(categories);
    }
}
