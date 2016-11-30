package com.springapp.mvc.services;

import com.springapp.mvc.entity.Cart;
import com.springapp.mvc.entity.Good;
import com.springapp.mvc.entity.Order;
import com.springapp.mvc.entity.User;
import com.springapp.mvc.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class OrderServices {


    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public void makeOrder(User user, Long id){
        for (Order ord: user.getOrders()) {
            if (ord.getId().equals(id)){
                ord.setStatus(true);
                orderRepository.updateOrder(ord);
                break;
            }
        }
    }

    @Transactional
    public void reservOrder(HttpSession session, User user, String [] dataAboutCustomer){
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart != null) {

            Order order = new Order();
            List<Good> goods = new ArrayList<Good>();
            Set<Long> keys = cart.getGoods().keySet();
            for (Long key : keys) {
                goods.add(cart.getGoods().get(key));
            }
            order.setGoods(goods);
            order.setUser(user);
            order.setStatus(false);
            order.setName(dataAboutCustomer[0]);
            order.setSurname(dataAboutCustomer[1]);
            order.setOtch(dataAboutCustomer[2]);
            order.setAddress(dataAboutCustomer[3]);
            order.setEmail(dataAboutCustomer[4]);
            order.setTelephone(dataAboutCustomer[5]);
            order.setDate(new Date());

            user.getOrders().add(order);

            orderRepository.addOrder(order);

            session.setAttribute("cart", null);
        }

    }

    @Transactional
    public void cancelOrder(User user, Long id){
        for (Order ord: user.getOrders()) {
            if (ord.getId().equals(id)){
                orderRepository.remove(ord);
                user.getOrders().remove(ord);
                break;
            }
        }

    }

}
