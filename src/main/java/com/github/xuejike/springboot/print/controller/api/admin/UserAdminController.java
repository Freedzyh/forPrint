package com.github.xuejike.springboot.print.controller.api.admin;

import com.bidanet.bdcms.core.bean.ApiResult;
import com.bidanet.bdcms.core.driver.cache.Cache;
import com.bidanet.bdcms.core.vo.Page;
import com.github.xuejike.springboot.print.controller.BaseAdminController;
import com.github.xuejike.springboot.print.driver.uc.HomeUc;
import com.github.xuejike.springboot.print.entity.User;
import com.github.xuejike.springboot.print.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xuemingyu 2018/3/23
 */
@Controller
@RequestMapping("/api/admin/user")
public class UserAdminController extends BaseAdminController {
    @Autowired
    private UserService userService;
    @Autowired
    HomeUc homeUc;
    @Autowired
    Cache cache;

    @RequestMapping("/findOne")
    @ResponseBody
    public ApiResult findOne(Long id) {
        User user = userService.findOne(id);
        return ApiResult.success(user);
    }

    @RequestMapping("/getPageData")
    @ResponseBody
    public ApiResult getPageData(User user, Page<User> page) {
        userService.queryLike(user, page);
        return ApiResult.success(page);
    }

    @RequestMapping("/insert")
    @ResponseBody
    public ApiResult insert(User user) {
        userService.insert(user);
        return ApiResult.success("添加成功");
    }

    @RequestMapping("/update")
    @ResponseBody
    public ApiResult update(User user) {
        userService.update(user);
        return ApiResult.success("修改成功");
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ApiResult delete(Long id) {
        userService.delete(id);
        return ApiResult.success("删除成功");
    }

    @RequestMapping("/login")
    @ResponseBody
    public ApiResult login(String userName, String passWord) {
        String s = homeUc.loginS(userName, passWord);
        return ApiResult.success(s);

    }
}
