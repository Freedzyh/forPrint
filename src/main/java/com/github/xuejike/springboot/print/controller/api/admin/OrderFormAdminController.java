package com.github.xuejike.springboot.print.controller.api.admin;

import com.bidanet.bdcms.core.bean.ApiResult;
import com.bidanet.bdcms.core.vo.Page;
import com.github.xuejike.springboot.print.controller.BaseAdminController;
import com.github.xuejike.springboot.print.entity.OrderForm;
import com.github.xuejike.springboot.print.service.OrderFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xuemingyu 2018/3/22
 */
@Controller
@RequestMapping("/api/admin/orderForm")
@ResponseBody
public class OrderFormAdminController extends BaseAdminController {
    @Autowired
    private OrderFormService orderFormService;

    @RequestMapping("/findOne")
    public ApiResult getOrderForm(Long id) {
        OrderForm orderForm = orderFormService.findOne(id);
        return ApiResult.success(orderForm);
    }

    @RequestMapping("/getPageData")
    public ApiResult getPageData(OrderForm orderForm, Page<OrderForm> page) {
        orderFormService.queryLike(orderForm, page);
        return ApiResult.success(page);
    }

    @RequestMapping("/insert")
    public ApiResult insert(OrderForm orderForm) {
        orderFormService.insert(orderForm);
        return ApiResult.success("添加成功");
    }

    @RequestMapping("/update")
    public ApiResult update(OrderForm orderForm) {
        orderFormService.update(orderForm);
        return ApiResult.success("更新成功");
    }

    @RequestMapping("/delete")
    public ApiResult delete(Long id) {
        orderFormService.delete(id);
        return ApiResult.success("删除成功");
    }
}
