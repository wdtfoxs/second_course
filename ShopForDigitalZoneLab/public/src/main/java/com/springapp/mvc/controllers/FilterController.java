package com.springapp.mvc.controllers;

import com.springapp.mvc.entity.Good;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FilterController {

    public List<Good> mainFilter(String filter, List<Good> goods){
        if (filter.equals("low")){
            return low(goods);
        }
        if (filter.equals("high")){
            return high(goods);
        }
        return null;
    }


    private List<Good> low(List<Good> goods) {
        for (int i = 0; i < goods.size() - 1; i++) {
            for (int j = 0; j < goods.size() - i - 1; j++) {
                if (goods.get(j).getPrice() > goods.get(j + 1).getPrice()) {
                    Good t = goods.get(j);
                    goods.set(j, goods.get(j + 1));
                    goods.set(j + 1, t);
                }
            }
        }
        return goods;
    }

    private List<Good> high(List<Good> goods) {
        for (int i = 0; i < goods.size() - 1; i++) {
            for (int j = 0; j < goods.size() - i - 1; j++) {
                if (goods.get(j).getPrice() < goods.get(j + 1).getPrice()) {
                    Good t = goods.get(j);
                    goods.set(j, goods.get(j + 1));
                    goods.set(j + 1, t);
                }
            }
        }
        return goods;
    }


}
