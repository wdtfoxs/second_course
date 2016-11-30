package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeCategories;
import com.springapp.mvc.entity.User;
import com.springapp.mvc.security.MyUserDetail;
import com.springapp.mvc.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private OrderServices orderServices;

    @IncludeCategories
    @RequestMapping(method = RequestMethod.GET)
    public String showPage(){
        return "order/order";
    }

    @IncludeCategories
    @RequestMapping(value = "/reserve", method = RequestMethod.POST)
    public RedirectView reserveOrder(){
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String [] dataAboutCustomer = new String[6];
        dataAboutCustomer[0] = request.getParameter("name");
        dataAboutCustomer[1] = request.getParameter("surname");
        dataAboutCustomer[2] = request.getParameter("middleName");
        dataAboutCustomer[3] = request.getParameter("address");
        dataAboutCustomer[4] = request.getParameter("email");
        dataAboutCustomer[5] = request.getParameter("telephone");

        orderServices.reservOrder(request.getSession(), ((MyUserDetail) user).getUser(), dataAboutCustomer);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/cabinet");
        return redirectView;
    }

    @IncludeCategories
    @RequestMapping(value = "/make/{id}", method = RequestMethod.POST)
    public RedirectView makeOrder(@PathVariable Long id){
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        orderServices.makeOrder(((MyUserDetail) user).getUser(), id);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/cabinet");
        return redirectView;
    }

    @IncludeCategories
    @RequestMapping(value = "/cancel/{id}", method = RequestMethod.POST)
    public RedirectView cancelOrder(@PathVariable Long id){
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        orderServices.cancelOrder(((MyUserDetail)user).getUser(), id);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/cabinet");
        return redirectView;
    }
}
