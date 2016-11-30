package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeCategories;
import com.springapp.mvc.services.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/good")
public class GoodController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private GoodService goodService;

    @IncludeCategories
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getGoodPage(@PathVariable Long id){
        request.setAttribute("good", goodService.getGoodById(id));
        return "good";
    }


}
