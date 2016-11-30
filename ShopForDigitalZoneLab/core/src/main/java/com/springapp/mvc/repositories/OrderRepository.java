package com.springapp.mvc.repositories;

import com.springapp.mvc.entity.Order;
import com.springapp.mvc.entity.User;

import java.util.List;

public interface OrderRepository {
    void addOrder(Order order);
    void updateOrder(Order order);
    void remove(Order order);
}
