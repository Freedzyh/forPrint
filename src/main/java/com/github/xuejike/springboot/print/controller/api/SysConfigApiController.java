package com.github.xuejike.springboot.print.controller.api;

import com.bidanet.bdcms.core.bean.ApiResult;
import com.bidanet.bdcms.core.vo.Page;
import com.github.xuejike.springboot.print.controller.BaseAdminController;
import com.github.xuejike.springboot.print.entity.SysConfig;
import com.github.xuejike.springboot.print.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/admin/sysConfig")
@ResponseBody
public class SysConfigApiController extends BaseAdminController {


    @Autowired
    SysConfigService sysConfigService;


    @RequestMapping("/getPageData")
    public ApiResult getPageData(SysConfig sysConfig, Page<SysConfig> page) {
        sysConfigService.queryLike(sysConfig, page);
        return ApiResult.success(page);
    }




}
