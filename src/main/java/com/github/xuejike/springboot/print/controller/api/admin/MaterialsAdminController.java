package com.github.xuejike.springboot.print.controller.api.admin;

import com.bidanet.bdcms.core.bean.ApiResult;
import com.bidanet.bdcms.core.vo.Page;
import com.github.xuejike.springboot.print.controller.BaseAdminController;
import com.github.xuejike.springboot.print.entity.Materials;
import com.github.xuejike.springboot.print.service.MaterialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xuemingyu 2018/3/22
 */
@Controller
@RequestMapping("/api/admin/materials")
@ResponseBody
public class MaterialsAdminController extends BaseAdminController {
    @Autowired
    private MaterialsService materialsService;

    @RequestMapping("/getPageData")
    public ApiResult getPageData(Materials materials, Page<Materials> page) {
        materialsService.queryLike(materials, page);
        return ApiResult.success(page);
    }

    @RequestMapping("/findOne")
    public ApiResult getMaterials(Long id) {
        Materials materials = materialsService.findOne(id);
        return ApiResult.success(materials);
    }

    @RequestMapping("/insert")
    public ApiResult insert(Materials materials) {
        materialsService.insert(materials);
        return ApiResult.success("添加成功");
    }

    @RequestMapping("/update")
    public ApiResult update(Materials materials) {
        materialsService.update(materials);
        return ApiResult.success("更新成功");
    }

    @RequestMapping("/delete")
    public ApiResult delete(Long id) {
        materialsService.delete(id);
        return ApiResult.success("刪除成功");
    }
}
