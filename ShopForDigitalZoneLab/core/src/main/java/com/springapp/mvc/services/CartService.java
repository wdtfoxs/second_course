package com.springapp.mvc.services;

import com.springapp.mvc.entity.Cart;
import com.springapp.mvc.entity.Good;
import com.springapp.mvc.entity.Order;
import com.springapp.mvc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class CartService {

    private static final String SESSION_CART = "cart";

    @Autowired
    private GoodService goodService;

    @Transactional
    public void addInCart(HttpSession session, Long goodId) {
        Cart cart = (Cart) session.getAttribute(SESSION_CART);
        if (cart == null) {
            cart = new Cart();
        }
        if (cart.getGoodsId() == null) {
            Map<Long, Integer> mapId = new HashMap<Long, Integer>();
            mapId.put(goodId, 1);
            cart.setGoodsId(mapId);

            Map<Long, Good> mapGoods = new HashMap<Long, Good>();
            mapGoods.put(goodId, goodService.getGoodById(goodId));
            cart.setGoods(mapGoods);
        } else {
            if (cart.getGoodsId().containsKey(goodId)) {
                cart.getGoodsId().put(goodId, cart.getGoodsId().get(goodId) + 1);
            } else {
                cart.getGoodsId().put(goodId, 1);
                cart.getGoods().put(goodId, goodService.getGoodById(goodId));
            }
        }
        session.setAttribute(SESSION_CART, cart);
    }

    public void delInCart(HttpSession session, Long goodId) {
        Cart cart = (Cart) session.getAttribute(SESSION_CART);
        if (cart.getGoods().size() == 1) {
            cart.getGoodsId().remove(goodId);
            cart.getGoods().remove(goodId);
            cart = null;
        } else {
            cart.getGoodsId().remove(goodId);
            cart.getGoods().remove(goodId);
        }
        session.setAttribute(SESSION_CART, cart);
    }

    public Integer minus(HttpSession session, Long goodId){
        Cart cart = (Cart) session.getAttribute(SESSION_CART);
        if (cart.getGoodsId().get(goodId) != 1){
            cart.getGoodsId().put(goodId, cart.getGoodsId().get(goodId)-1);
        }
        return cart.getGoodsId().get(goodId);
    }

    public Integer plus(HttpSession session, Long goodId){
        Cart cart = (Cart) session.getAttribute(SESSION_CART);
        cart.getGoodsId().put(goodId, cart.getGoodsId().get(goodId)+1);
        return cart.getGoodsId().get(goodId);
    }

    public void emptyCart(HttpSession session){
        session.setAttribute(SESSION_CART, null);
    }

    public Integer total(HttpSession session){
        Cart cart = (Cart) session.getAttribute(SESSION_CART);
        Integer total;
        if (cart == null){
            total = 0;
        }else {
            total = 1;
            Set<Long> keys = cart.getGoods().keySet();
            for (Long key : keys) {
                total += cart.getGoods().get(key).getPrice() * cart.getGoodsId().get(key);
            }
        }
        return total;
    }

    public Integer count(HttpSession session){
        Cart cart = (Cart) session.getAttribute(SESSION_CART);
        Integer count = 0;
        if (cart != null) {
            Set<Long> keys = cart.getGoodsId().keySet();
            for (Long key : keys) {
                count += cart.getGoodsId().get(key);
            }
        }
        return count;
    }
}
