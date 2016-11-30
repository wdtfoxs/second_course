package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeCategories;
import com.springapp.mvc.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private CartService cartService;

    @IncludeCategories
    @RequestMapping
    public String renderCart() {
        return "cart";
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addInCart(Long goodId) {
        cartService.addInCart(request.getSession(), goodId);
        return "ok";
    }

    @ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public String delInCart(Long goodId) {
        cartService.delInCart(request.getSession(), goodId);
        return "ok";
    }

    @ResponseBody
    @RequestMapping(value = "/minus", method = RequestMethod.POST)
    public Integer minusCountGood(Long goodId){
        return cartService.minus(request.getSession(), goodId);
    }

    @ResponseBody
    @RequestMapping(value = "/plus", method = RequestMethod.POST)
    public Integer plusCountGood(Long goodId){
        return cartService.plus(request.getSession(), goodId);
    }

    @RequestMapping(value = "/empty", method = RequestMethod.POST)
    public void emptyCart(){
        cartService.emptyCart(request.getSession());
    }

    @ResponseBody
    @RequestMapping(value = "/total", method = RequestMethod.POST)
    public Integer totalPrice (){
        Integer total = cartService.total(request.getSession());
        request.getSession().setAttribute("cartTotal", total);
        return total;
    }

    @ResponseBody
    @RequestMapping(value = "/count", method = RequestMethod.POST)
    public Integer countGoods (){
        Integer count = cartService.count(request.getSession());
        request.getSession().setAttribute("cartCount", count);
        return count;
    }
}
