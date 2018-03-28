package com.github.xuejike.springboot.print.controller.api;

import com.bidanet.bdcms.core.bean.ApiResult;
import com.bidanet.bdcms.core.vo.Page;
import com.github.xuejike.springboot.print.controller.BaseAdminController;
import com.github.xuejike.springboot.print.entity.Process;
import com.github.xuejike.springboot.print.service.ProcessService;
import com.github.xuejike.springboot.print.utils.TypeBean;
import freemarker.ext.beans.HashAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuemingyu 2018/3/22
 * 后加工管理
 */
@Controller
@RequestMapping("/api/admin/process")
@ResponseBody
public class ProcessApiController extends BaseAdminController {
    @Autowired
    private ProcessService processService;

    @RequestMapping("/findOne")
    public ApiResult getProcess(Long id) {
        Process process = processService.findOne(id);
        return ApiResult.success(process);
    }

    @RequestMapping("/getPageData")
    public ApiResult getPageData(Process process, Page<Process> page) {
        processService.queryLike(process, page);
        return ApiResult.success(page);
    }

    @RequestMapping("/insert")
    public ApiResult insert(Process process) {
        processService.insert(process);
        return ApiResult.success("添加成功");
    }

    @RequestMapping("/update")
    public ApiResult update(Process process) {
        processService.update(process);
        return ApiResult.success("更新成功");
    }

    @RequestMapping("/delete")
    public ApiResult delete(Long id) {
        processService.delete(id);
        return ApiResult.success("删除成功");
    }

    @RequestMapping("/findAll")
    public ApiResult findAll() {
        List<Process> list = processService.findAll();
        List<TypeBean> typeBeans = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPid() == 0) {
                TypeBean typeBean = new TypeBean();
                typeBean.setId(list.get(i).getId());
                typeBean.setPid(list.get(i).getPid());
                typeBean.setName(list.get(i).getName());
                typeBeans.add(typeBean);
            }
        }
        for (int j = 0; j < typeBeans.size(); j++) {
            List<TypeBean> typeBeanList = new ArrayList<>();
            for (int k = 0; k < list.size(); k++) {
                if (typeBeans.get(j).getId() == list.get(k).getPid()) {
                    TypeBean typeBean = new TypeBean();
                    typeBean.setId(list.get(k).getId());
                    typeBean.setPid(list.get(k).getPid());
                    typeBean.setName(list.get(k).getName());
                    typeBeanList.add(typeBean);
                }
                typeBeans.get(j).setList(typeBeanList);
            }
        }

        return ApiResult.success(typeBeans);
    }
}
