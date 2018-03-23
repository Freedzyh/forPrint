package com.github.xuejike.springboot.print.service;

import com.bidanet.bdcms.core.vo.Page;
import com.github.xuejike.springboot.print.entity.OrderForm;

/**
 * Created by xuemingyu 2018/3/22
 */
public interface OrderFormService extends BaseService<OrderForm> {
    void queryLike(OrderForm orderForm, Page<OrderForm> page);

    void insert(OrderForm orderForm);

    void update(OrderForm orderForm);

    void delete(Long id);
}
