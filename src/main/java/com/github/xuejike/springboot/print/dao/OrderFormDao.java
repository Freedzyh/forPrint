package com.github.xuejike.springboot.print.dao;

import com.github.xuejike.springboot.jkfaststart.repository.BaseJPA;
import com.github.xuejike.springboot.print.entity.OrderForm;

/**
 * Created by xuemingyu 2018/3/22
 */
public interface OrderFormDao extends BaseJPA<OrderForm> {
    OrderForm findFirstById(Long id);

    OrderForm findFirstByName(String name);

    OrderForm findFirstByCompanyName(String companyName);
}
