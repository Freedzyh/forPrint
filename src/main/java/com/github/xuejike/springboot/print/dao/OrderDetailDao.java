package com.github.xuejike.springboot.print.dao;

import com.github.xuejike.springboot.jkfaststart.repository.BaseJPA;
import com.github.xuejike.springboot.print.entity.OrderDetail;

import java.util.List;

/**
 * Created by xuemingyu 2018/3/28
 */
public interface OrderDetailDao extends BaseJPA<OrderDetail> {
    OrderDetail findFirstById(Long id);

    List<OrderDetail> findAllByOrderId(Long orderId);
}
