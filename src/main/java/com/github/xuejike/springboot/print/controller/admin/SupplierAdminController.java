package com.github.xuejike.springboot.print.controller.admin;

import com.bidanet.bdcms.core.bean.AjaxCallBack;
import com.bidanet.bdcms.core.vo.Page;
import com.bidanet.springmvc.demo.jkbuilder.JkBuilder;
import com.github.xuejike.springboot.jkfaststart.common.AjaxPage;
import com.github.xuejike.springboot.print.controller.BaseAdminController;
import com.github.xuejike.springboot.print.entity.Supplier;
import com.github.xuejike.springboot.print.service.SupplierService;
import com.github.xuejike.springboot.print.view.Supplier.EditView;
import com.github.xuejike.springboot.print.view.TableView;
import com.github.xuejike.springboot.print.view.user.AddView;
import com.github.xuejike.springboot.print.view.user.TableHeaderView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: ZHU YUHUA
 * @CreateDate: 2018/4/23 10:28
 */
@Controller
@RequestMapping("/admin/supplier")
public class SupplierAdminController extends BaseAdminController {

    @Autowired
    private SupplierService supplierService;

    @RequestMapping("/index")
    public String index(Model model){
        TableHeaderView tableHeaderView = new TableHeaderView();
        return JkBuilder.tableView(TableView.class,tableHeaderView,model,"");
    }

    @RequestMapping("/getPageData")
    @ResponseBody
    public AjaxPage getPageData(Supplier supplier, Page<Supplier> page) {
        supplierService.queryLike(supplier, page);
        return AjaxPage.success(page);
    }

    @RequestMapping("/insert")
    @ResponseBody
    public AjaxCallBack insert(AddView addView){
        Supplier supplier = new Supplier();

            BeanUtils.copyProperties(supplier,addView);
        try {
            supplierService.insert(supplier);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxCallBack.saveSuccess();
    }

    @RequestMapping("/edit")
    public String edit(Model model, Long id, EditView editView) {
        Supplier supplier = supplierService.findOne(id);
        try {
            BeanUtils.copyProperties(editView, supplier);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JkBuilder.formView(editView, model);

    }

    @RequestMapping("/update")
    @ResponseBody
    public AjaxCallBack update(EditView editView) {
        Supplier supplier = new Supplier();
        BeanUtils.copyProperties(supplier, editView);
        try {
            supplierService.update(supplier);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxCallBack.saveSuccess();
    }

    @RequestMapping("/delete")
    @ResponseBody
    public AjaxCallBack delete(Long id) {
        supplierService.delete(id);
        return AjaxCallBack.handleSuccess();
    }
}
