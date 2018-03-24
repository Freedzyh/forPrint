package com.github.xuejike.springboot.print.controller.api.admin;

import com.bidanet.bdcms.core.bean.ApiResult;
import com.bidanet.bdcms.core.vo.Page;
import com.github.xuejike.springboot.print.controller.BaseAdminController;
import com.github.xuejike.springboot.print.entity.RepairOrder;
import com.github.xuejike.springboot.print.service.RepairOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xuemingyu 2018/3/22
 */
@Controller
@RequestMapping("/api/admin/repairOrder")
@ResponseBody
public class RepairOrderAdminController extends BaseAdminController {
    @Autowired
    private RepairOrderService repairOrderService;

    @RequestMapping("/findOne")
    public ApiResult findOne(Long id) {
        RepairOrder repairOrder = repairOrderService.findOne(id);
        return ApiResult.success(repairOrder);
    }

    @RequestMapping("/getPageData")
    public ApiResult getPageData(RepairOrder repairOrder, Page<RepairOrder> page) {
        repairOrderService.queryLike(repairOrder, page);
        return ApiResult.success(page);
    }

    @RequestMapping("/insert")
    public ApiResult insert(RepairOrder repairOrder) {
        repairOrderService.insert(repairOrder);
        return ApiResult.success("添加成功");
    }

    @RequestMapping("/update")
    public ApiResult update(RepairOrder repairOrder) {
        repairOrderService.update(repairOrder);
        return ApiResult.success("更新成功");
    }

    @RequestMapping("/delete")
    public ApiResult delete(Long id) {
        repairOrderService.delete(id);
        return ApiResult.success("删除成功");
    }
}
