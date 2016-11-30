package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeCategories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class MainController {

    @IncludeCategories
    @RequestMapping("/")
    public String homePage(){
        return "main/main";
    }
}
