package com.github.xuejike.springboot.print.entity;

import java.util.List;

/**
 * Created by xuemingyu 2018/3/28
 */
public class Order {
    private OrderForm orderForm;
    private List<OrderDetail> list;

    public OrderForm getOrderForm() {
        return orderForm;
    }

    public void setOrderForm(OrderForm orderForm) {
        this.orderForm = orderForm;
    }

    public List<OrderDetail> getList() {
        return list;
    }

    public void setList(List<OrderDetail> list) {
        this.list = list;
    }
}
