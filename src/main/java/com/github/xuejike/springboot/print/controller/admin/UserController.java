package com.github.xuejike.springboot.print.controller.admin;

import com.bidanet.bdcms.core.bean.AjaxCallBack;
import com.bidanet.bdcms.core.vo.Page;
import com.bidanet.springmvc.demo.jkbuilder.JkBuilder;
import com.github.xuejike.springboot.jkfaststart.common.AjaxPage;
import com.github.xuejike.springboot.print.controller.BaseAdminController;
import com.github.xuejike.springboot.print.entity.User;
import com.github.xuejike.springboot.print.service.UserService;
import com.github.xuejike.springboot.print.view.user.AddView;
import com.github.xuejike.springboot.print.view.user.EditView;
import com.github.xuejike.springboot.print.view.user.TableHeaderView;
import com.github.xuejike.springboot.print.view.user.TableView;
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
@RequestMapping("/admin/user")
public class UserController extends BaseAdminController {
    @Autowired
    private UserService userService;

    @RequestMapping("/inidex")
    public String index(Model model) {
        TableHeaderView tableHeaderView = new TableHeaderView();
        return JkBuilder.tableView(TableView.class, tableHeaderView, model, "");
    }

    @RequestMapping("/getPageData")
    @ResponseBody
    public AjaxPage getPageData(User user, Page<User> page) {
        userService.queryLike(user, page);
        return AjaxPage.success(page);
    }

    @RequestMapping("/add")
    public String add(Model model, AddView addView) {
        return JkBuilder.formView(addView, model);
    }

    @RequestMapping("/insert")
    @ResponseBody
    public AjaxCallBack insert(AddView addView) {
        User user = new User();
        try {
            BeanUtils.copyProperties(user, addView);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        userService.insert(user);
        return AjaxCallBack.saveSuccess();
    }

    @RequestMapping("/edit")
    public String edit(Model model, Long id, EditView editView) {
        User user = userService.findOne(id);
        try {
            BeanUtils.copyProperties(editView, user);
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
        User user = new User();
        try {
            BeanUtils.copyProperties(user, editView);
        } catch (IllegalAccessException e) {

        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        userService.update(user);
        return AjaxCallBack.saveSuccess();
    }

    @RequestMapping("/changeStatus")
    @ResponseBody
    public AjaxCallBack changeStatus(Long id) {
        userService.changeStatus(id);
        return AjaxCallBack.handleSuccess();
    }

    @ResponseBody
    @RequestMapping("/delete")
    public AjaxCallBack delete(Long id) {
        userService.delete(id);
        return AjaxCallBack.handleSuccess();
    }
}
