package com.github.xuejike.springboot.print.controller.api.admin;

import com.bidanet.bdcms.core.bean.ApiResult;
import com.bidanet.bdcms.core.vo.Page;
import com.github.xuejike.springboot.print.controller.BaseAdminController;
import com.github.xuejike.springboot.print.entity.Compose;
import com.github.xuejike.springboot.print.service.ComposeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xuemingyu 2018/3/22
 */
@Controller
@RequestMapping("/api/admin/compose")
@ResponseBody
public class ComposeAdminController extends BaseAdminController {
    @Autowired
    private ComposeService composeService;

    @RequestMapping("/findOne")
    public ApiResult getCompose(Long id) {
        Compose compose = composeService.findOne(id);
        return ApiResult.success(compose);
    }

    @RequestMapping("/getPageData")
    public ApiResult getPageData(Compose compose, Page<Compose> page) {
        composeService.queryLike(compose, page);
        return ApiResult.success(page);
    }

    @RequestMapping("/insert")
    public ApiResult insert(Compose compose) {
        composeService.insert(compose);
        return ApiResult.success("添加成功");
    }

    @RequestMapping("/update")
    public ApiResult update(Compose compose) {
        composeService.update(compose);
        return ApiResult.success("更新成功");
    }

    @RequestMapping("/delete")
    public ApiResult delete(Long id) {
        composeService.delete(id);
        return ApiResult.success("删除成功");
    }
}
