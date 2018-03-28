package com.github.xuejike.springboot.print.controller.admin;

import com.bidanet.bdcms.core.bean.AjaxCallBack;
import com.bidanet.bdcms.core.vo.Page;
import com.bidanet.springmvc.demo.jkbuilder.JkBuilder;
import com.github.xuejike.springboot.jkfaststart.common.AjaxPage;
import com.github.xuejike.springboot.print.controller.BaseAdminController;
import com.github.xuejike.springboot.print.entity.Technology;
import com.github.xuejike.springboot.print.service.TechnologyService;
import com.github.xuejike.springboot.print.view.technology.AddView;
import com.github.xuejike.springboot.print.view.technology.EditView;
import com.github.xuejike.springboot.print.view.technology.TableHeaderView;
import com.github.xuejike.springboot.print.view.technology.TableView;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by xuemingyu 2018/3/27
 */
@Controller
@RequestMapping("/admin/technology")
public class TechnologyAdminController extends BaseAdminController {
    @Autowired
    private TechnologyService technologyService;

    @RequestMapping("/index")
    public String index(Model model) {
        TableHeaderView tableHeaderView = new TableHeaderView();
        return JkBuilder.tableView(TableView.class, tableHeaderView, model, "");
    }

    @RequestMapping("/getPageData")
    @ResponseBody
    public AjaxPage getPageData(Technology technology, Page<Technology> page) {
        technologyService.queryLike(technology, page);
        return AjaxPage.success(page);
    }

    @RequestMapping("/add")
    public String add(Model model, AddView addView) {
        return JkBuilder.formView(addView, model);
    }

    @RequestMapping("/insert")
    @ResponseBody
    public AjaxCallBack insert(AddView addView) {
        Technology technology = new Technology();
        try {
            BeanUtils.copyProperties(technology, addView);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        technologyService.insert(technology);
        return AjaxCallBack.saveSuccess();
    }

    @RequestMapping("/edit")
    public String edit(Model model, Long id, EditView editView) {
        Technology technology = technologyService.findOne(id);
        try {
            BeanUtils.copyProperties(editView, technology);
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
        Technology technology = new Technology();
        try {
            BeanUtils.copyProperties(technology, editView);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        technologyService.update(technology);
        return AjaxCallBack.saveSuccess();
    }

    @RequestMapping("/delete")
    @ResponseBody
    public AjaxCallBack delete(Long id) {
        technologyService.delete(id);
        return AjaxCallBack.handleSuccess();
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public void findAll() {
        technologyService.findAll();
    }
}
