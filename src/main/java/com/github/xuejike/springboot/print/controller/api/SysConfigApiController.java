package com.github.xuejike.springboot.print.controller.api;

import com.bidanet.bdcms.core.bean.ApiResult;
import com.bidanet.bdcms.core.bean.EntityToVo;
import com.bidanet.bdcms.core.common.EntityTool;
import com.bidanet.bdcms.core.vo.Page;
import com.github.xuejike.springboot.print.controller.BaseAdminController;
import com.github.xuejike.springboot.print.entity.SysConfig;
import com.github.xuejike.springboot.print.entity.vo.SysConfigVo;
import com.github.xuejike.springboot.print.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/admin/sysConfig")
@ResponseBody
public class SysConfigApiController extends BaseAdminController {


    @Autowired
    SysConfigService sysConfigService;

    @RequestMapping("/getTypeList")
    public ApiResult getTypeList() {

        List<Object> list = sysConfigService.getList();

        return ApiResult.success(list);
    }




    @RequestMapping("/getPageData")
    public ApiResult getPageData(SysConfig sysConfig, Page<SysConfig> page) {
        sysConfigService.queryLike(sysConfig, page);

        Page<EntityToVo> entityToVoPage = new EntityTool().getPageEntityToVo(SysConfigVo.class,page);

        return ApiResult.success(entityToVoPage);
    }

    @RequestMapping("/update")
    public ApiResult update(SysConfig sysConfig) {
        sysConfigService.update(sysConfig);
        return ApiResult.success("修改成功");
    }

    @RequestMapping("/delete")
    public ApiResult delete(Long id) {
        sysConfigService.delete(id);
        return ApiResult.success("删除成功");
    }

    @RequestMapping("/getSysConfig")
    public ApiResult getSysConfig(Long id) {
        SysConfig sysConfig = sysConfigService.findOne(id);

        EntityToVo entityToVo = new EntityTool().createEntityToVo(SysConfigVo.class,sysConfig);

        return ApiResult.success(entityToVo);
    }



}
