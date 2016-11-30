package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeCategories;
import com.springapp.mvc.entity.Order;
import com.springapp.mvc.entity.User;
import com.springapp.mvc.security.MyUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/cabinet")
public class CabinetController{

    @Autowired
    private HttpServletRequest request;


    @IncludeCategories
    @RequestMapping(method = RequestMethod.GET)
    public String renderCabinetPage() {
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Order> orders = ((MyUserDetail) user).getUser().getOrders();
        if (orders.size() == 0){
            request.getSession().setAttribute("userOrders", null);
        }else {
            request.getSession().setAttribute("userOrders", orders);
        }
        return "cabinet/cabinet";
    }
}
