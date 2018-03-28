package com.github.xuejike.springboot.print.controller.api;

import com.bidanet.bdcms.core.bean.ApiResult;
import com.bidanet.bdcms.core.vo.Page;
import com.github.xuejike.springboot.print.controller.BaseAdminController;
import com.github.xuejike.springboot.print.entity.Technic;
import com.github.xuejike.springboot.print.entity.enumType.TechincType;
import com.github.xuejike.springboot.print.service.TechnicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by xuemingyu 2018/3/27
 */
@Controller
@ResponseBody
@RequestMapping("/api/public/technic")
public class TechnicApiController extends BaseAdminController {
    @Autowired
    private TechnicService technicService;

    /***
     * f分页查询
     * @param technic
     * @param page
     * @return
     */
    @RequestMapping("/getPageData")
    public ApiResult getPageData(Technic technic, Page<Technic> page) {
        technicService.queryLike(technic, page);
        return ApiResult.success(page);
    }

    /***
     * 查询单个数据
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    public ApiResult findOne(Long id) {
        Technic technic = technicService.findOne(id);
        //System.out.println(TechincType.cabinet.ordinal());
        return ApiResult.success(technic);
    }

    /**
     * 查询所有工艺的list 数据
     *
     * @return
     */
    @RequestMapping("/findByTechincTypeProcessTechnogy")
    public ApiResult findByTechincTypeProcessTechnogy() {
        List<Technic> list = technicService.findByParentIdsAndTechnicType(TechincType.processTechnogy);
        return ApiResult.success(list);
    }

    /**
     * 根据父节点的数据条件查询下一级数据list
     *
     * @param id
     * @return
     */
    @RequestMapping("/findByTechincTypeAndId")
    public ApiResult findByTechincTypeAndId(String id) {

        List<Technic> list = technicService.findByTechincTypeAndId(id);
        return ApiResult.success(list);
    }

    @RequestMapping("/findCabinetByCabinetId")
    public ApiResult findCabinetByCabinetId(String cabinetId) {
        List<Technic> list = technicService.findCabinetByCabinetId(cabinetId);
        return ApiResult.success(list);
    }

}
