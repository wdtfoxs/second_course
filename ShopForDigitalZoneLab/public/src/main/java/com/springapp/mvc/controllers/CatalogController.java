package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeCategories;
import com.springapp.mvc.entity.Good;
import com.springapp.mvc.services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private CategoriesService categoriesService;

    @Autowired
    private FilterController filterController;

    @IncludeCategories
    @RequestMapping(value = "/{category}",method = RequestMethod.GET)
    public String showGoodsForMen(@PathVariable String category){
        request.setAttribute("additionalCategory", categoriesService.getAdditionalCategories(category));
        List<Good> goods = categoriesService.getGoodsByCategory(category);
        if (goods == null) {
            request.setAttribute("goods", null);
            request.setAttribute("goodsSize", null);
        } else {
            String sort = request.getParameter("sort");
            if (sort != null && goods.size() != 1) {
                goods = filterController.mainFilter(sort, goods);
            }
            request.setAttribute("goods", goods);
            request.setAttribute("goodsSize", goods.size());
        }
        request.setAttribute("currentCategory", categoriesService.getCategory(category));
        return "catalog/catalog";
    }

}
