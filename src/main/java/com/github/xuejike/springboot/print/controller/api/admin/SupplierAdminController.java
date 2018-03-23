package com.github.xuejike.springboot.print.controller.api.admin;

import com.bidanet.bdcms.core.bean.ApiResult;
import com.bidanet.bdcms.core.vo.Page;
import com.bidanet.springmvc.demo.jkbuilder.JkBuilder;
import com.github.xuejike.springboot.jkfaststart.common.AjaxPage;
import com.github.xuejike.springboot.print.controller.BaseAdminController;
import com.github.xuejike.springboot.print.entity.Supplier;
import com.github.xuejike.springboot.print.service.SupplierService;
import com.github.xuejike.springboot.print.view.Supplier.TableHeaderView;
import com.github.xuejike.springboot.print.view.Supplier.TableView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xuemingyu 2018/3/21
 */
@Controller
@RequestMapping("/api/admin/supplier")
public class SupplierAdminController extends BaseAdminController {
    @Autowired
    private SupplierService supplierService;

    @RequestMapping("/index")
    public String index(Model model) {
        TableHeaderView tableHeaderView = new TableHeaderView();
        return JkBuilder.tableView(TableView.class, tableHeaderView, model, "");
    }

    @RequestMapping("/findOne")
    @ResponseBody
    public ApiResult getSupplier(Long id) {
        Supplier supplier = supplierService.findOne(id);
        return ApiResult.success(supplier);
    }

    @RequestMapping("/getPageData")
    @ResponseBody
    public ApiResult getPageData(Supplier supplier, Page<Supplier> page) {
        supplierService.queryLike(supplier, page);
        return ApiResult.success(page);
    }

    @RequestMapping("/insert")
    @ResponseBody
    public ApiResult insert(Supplier supplier) {
        supplierService.insert(supplier);

        return ApiResult.success("添加成功");
    }

    @RequestMapping("/update")
    @ResponseBody
    public ApiResult update(Supplier supplier) {
        supplierService.update(supplier);
        return ApiResult.success("修改成功");
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ApiResult delete(Long id) {
        supplierService.delete(id);
        return ApiResult.success("删除成功");
    }
}
