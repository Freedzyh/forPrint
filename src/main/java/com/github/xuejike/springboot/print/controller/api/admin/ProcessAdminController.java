package com.github.xuejike.springboot.print.controller.api.admin;

import com.bidanet.bdcms.core.bean.ApiResult;
import com.bidanet.bdcms.core.vo.Page;
import com.github.xuejike.springboot.print.controller.BaseAdminController;
import com.github.xuejike.springboot.print.entity.Process;
import com.github.xuejike.springboot.print.service.ProcessService;
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
public class ProcessAdminController extends BaseAdminController {
    @Autowired
    private ProcessService processService;

    @RequestMapping("/findOne")
    @ResponseBody
    public ApiResult getProcess(Long id) {
        Process process = processService.findOne(id);
        return ApiResult.success(process);
    }

    @RequestMapping("/getPageData")
    @ResponseBody
    public ApiResult getPageData(Process process, Page<Process> page) {
        processService.queryLike(process, page);
        return ApiResult.success(page);
    }

    @RequestMapping("/insert")
    @ResponseBody
    public ApiResult insert(Process process) {
        processService.insert(process);
        return ApiResult.success("添加成功");
    }

    @RequestMapping("/update")
    @ResponseBody
    public ApiResult update(Process process) {
        processService.update(process);
        return ApiResult.success("更新成功");
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ApiResult delete(Long id) {
        processService.delete(id);
        return ApiResult.success("删除成功");
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public ApiResult findAll() {
      /*  List<Process> list = processService.findAll();
        Map<String, List<Process>> map = new HashMap<>();
        List<Process> pList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPid() == 0) {
                pList.add(list.get(i));
                list.remove(i);
            }
        }
        for (int j = 0; j < pList.size(); j++) {
            for (int i = 0; i < list.size(); i++) {

            }
        }*/
        return null;
    }
}
