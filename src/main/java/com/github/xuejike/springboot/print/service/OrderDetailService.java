package com.github.xuejike.springboot.print.service;

import com.bidanet.bdcms.core.vo.Page;
import com.github.xuejike.springboot.print.entity.OrderDetail;

import java.util.List;

/**
 * Created by xuemingyu 2018/3/28
 */
public interface OrderDetailService extends BaseService<OrderDetail> {
    void queryLike(OrderDetail orderDetail, Page<OrderDetail> page);

    void insert(OrderDetail orderDetail);

    List<OrderDetail> findAllByOrderId(Long orderId);

    void delete(Long id);
}
