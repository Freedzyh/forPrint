package com.github.xuejike.springboot.print.controller.admin;

import com.bidanet.bdcms.core.bean.AjaxCallBack;
import com.bidanet.bdcms.core.vo.Page;
import com.bidanet.springmvc.demo.jkbuilder.JkBuilder;
import com.github.xuejike.springboot.jkfaststart.common.AjaxPage;
import com.github.xuejike.springboot.print.controller.BaseAdminController;
import com.github.xuejike.springboot.print.entity.Company;
import com.github.xuejike.springboot.print.service.CompanyService;
import com.github.xuejike.springboot.print.view.company.AddView;
import com.github.xuejike.springboot.print.view.company.EditView;
import com.github.xuejike.springboot.print.view.company.TableHeaderView;
import com.github.xuejike.springboot.print.view.company.TableView;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by xuemingyu 2018/3/26
 */
@Controller
@RequestMapping("/admin/company")
public class CompanyAdminController extends BaseAdminController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping("/index")
    public String index(Model model) {
        TableHeaderView tableHeaderView = new TableHeaderView();
        return JkBuilder.tableView(TableView.class, tableHeaderView, model, "");
    }

    @RequestMapping("/getPageData")
    @ResponseBody
    public AjaxPage getPageData(Company company, Page<Company> page) {
        companyService.queryLike(company, page);
        return AjaxPage.success(page);
    }

    @RequestMapping("/add")
    public String add(Model model, AddView addView) {
        return JkBuilder.formView(addView, model);
    }

    @RequestMapping("/insert")
    @ResponseBody
    public AjaxCallBack insert(AddView addView) {
        Company company = new Company();
        try {
            BeanUtils.copyProperties(company, addView);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        companyService.insert(company);
        return AjaxCallBack.saveSuccess();
    }

    @RequestMapping("/edit")
    public String edit(Model model, Long id, EditView editView) {
        Company company = companyService.findOne(id);
        try {
            BeanUtils.copyProperties(editView, company);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return JkBuilder.formView(editView, model);

    }

    @RequestMapping("/update")
    @ResponseBody
    public AjaxCallBack update(EditView editView) {
        Company company = new Company();
        try {
            BeanUtils.copyProperties(company, editView);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        companyService.update(company);
        return AjaxCallBack.saveSuccess();
    }

    @RequestMapping("/delete")
    @ResponseBody
    public AjaxCallBack delete(Long id) {
        companyService.delete(id);
        return AjaxCallBack.handleSuccess();
    }
}
