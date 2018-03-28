package com.github.xuejike.springboot.print.controller.api;

import com.bidanet.bdcms.core.bean.ApiResult;
import com.bidanet.bdcms.core.vo.Page;
import com.github.xuejike.springboot.print.controller.BaseAdminController;
import com.github.xuejike.springboot.print.entity.OrderDetail;
import com.github.xuejike.springboot.print.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xuemingyu 2018/3/28
 */
@Controller
@ResponseBody
@RequestMapping("/api/public/orderDetail")
public class OrderDetailApiController extends BaseAdminController {
    @Autowired
    private OrderDetailService orderDetailService;

    /***
     * 查询单个订单详情
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    public ApiResult findOne(Long id) {
        OrderDetail orderDetail = orderDetailService.findOne(id);
        return ApiResult.success(orderDetail);
    }

    @RequestMapping("/getPageData")
    public ApiResult getPageData(OrderDetail orderDetail, Page<OrderDetail> page) {
        orderDetailService.queryLike(orderDetail, page);
        return ApiResult.success(page);
    }

    @RequestMapping("/insert")
    public ApiResult insert(OrderDetail orderDetail) {
        orderDetailService.insert(orderDetail);
        return ApiResult.success("添加成功");
    }
}
