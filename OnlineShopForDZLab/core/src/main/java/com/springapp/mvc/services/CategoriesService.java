package com.springapp.mvc.services;

import com.springapp.mvc.entity.Categories;
import com.springapp.mvc.entity.Good;
import com.springapp.mvc.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Transactional
    public List<Good> getGoodsByCategory(String category){
        Categories categories = categoriesRepository.getCategory(category);

        if (categories!= null && (categories.getChildren().size() != 0 || categories.getGoods() != null)){
            int mainSize = categories.getChildren().size();
            List<Good> goods = new ArrayList<Good>();
            while (mainSize != 0 || categories.getGoods().size() != 0) {
                while (categories.getChildren().size() != 0) {
                    categories = categories.getChildren().get(0);
                }
                for (Good good : categories.getGoods()) {
                    goods.add(good);
                }
                categories = categories.getParent();
                if (categories.getChildren() != null) {
                    categories.getChildren().remove(0);
                }
                if (categories.getName().equals(category)){
                    mainSize--;
                }
            }
            if (goods.size() != 0) {
                return goods;
            }else {
                return null;
            }
        } else {
            return null;
        }
    }


    @Transactional
    public Categories getCategoryForMenu(){
        return categoriesRepository.getAll();
    }

    @Transactional
    public List<Categories> getAdditionalCategories(String category){
        Categories categories = categoriesRepository.getCategory(category);
        if (categories!= null && categories.getChildren().size() != 0){
            List<Categories> cat = new ArrayList<Categories>();
            for (Categories c: categories.getChildren()
                 ) {
                cat.add(c);
            }
            return cat;
        }else {
            return null;
        }
    }

    @Transactional
    public Categories getCategory(String category){
        return categoriesRepository.getCategory(category);
    }
}
