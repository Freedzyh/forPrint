package com.github.xuejike.springboot.print.controller.api;

import com.bidanet.bdcms.core.bean.ApiResult;
import com.github.xuejike.springboot.print.controller.BaseAdminController;
import com.github.xuejike.springboot.print.entity.Order;
import com.github.xuejike.springboot.print.entity.OrderDetail;
import com.github.xuejike.springboot.print.entity.OrderForm;
import com.github.xuejike.springboot.print.service.OrderDetailService;
import com.github.xuejike.springboot.print.service.OrderFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by xuemingyu 2018/3/28
 */
@Controller
@ResponseBody
@RequestMapping("/api/public/Order")
public class OrderApiController extends BaseAdminController {
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private OrderFormService orderFormService;

    @RequestMapping("/orderFormDetail")
    public ApiResult orderFormDetail(Long id) {
        OrderForm orderForm = orderFormService.findOne(id);
        List<OrderDetail> list = orderDetailService.findAllByOrderId(id);
        Order order = new Order();
        order.setOrderForm(orderForm);
        order.setList(list);
        return ApiResult.success(order);

    }
}
