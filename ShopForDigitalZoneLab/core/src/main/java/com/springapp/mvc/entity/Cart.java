package com.springapp.mvc.entity;

import java.util.Map;

public class Cart {

    private Map<Long, Integer> goodsId;

    public Map<Long, Integer> getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Map<Long, Integer> goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getCount(Long goodId) {
        if (goodsId == null || goodId == null)
            return null;
        return goodsId.get(goodId);
    }

    public boolean containsGoodId(Long goodId){
        if (goodsId == null || goodId == null)
            return false;
        return goodsId.containsKey(goodId);
    }

    private Map<Long, Good> goods;

    public Map<Long, Good> getGoods() {
        return goods;
    }

    public void setGoods(Map<Long, Good> goods) {
        this.goods = goods;
    }

    public Integer getSize(){
        return goods.size();
    }

    public Good getGood(Long goodId){
        if (goods == null || goodId == null){
            return null;
        }
        return goods.get(goodId);
    }


}
