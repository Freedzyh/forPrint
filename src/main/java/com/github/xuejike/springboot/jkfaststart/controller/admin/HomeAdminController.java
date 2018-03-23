package com.github.xuejike.springboot.jkfaststart.controller.admin;

import com.github.xuejike.springboot.jkfaststart.JkConfig;
import com.github.xuejike.springboot.jkfaststart.common.QueryDslTool;
import com.github.xuejike.springboot.jkfaststart.common.ShiroUtils;
import lombok.extern.log4j.Log4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 后台主页
 *
 * @author xuejike
 */
@RequestMapping(JkConfig.ADMIN_PATH)
@Controller
@Log4j
public class HomeAdminController {
    @Autowired
    QueryDslTool queryDslTool;


    @RequestMapping({"/", "/index"})
    public void index(Model model) {
        String nickName = ShiroUtils.getLoginUser().getNickName();
        model.addAttribute("nickName", nickName);
    }


    @RequestMapping(value = "/public/login", method = RequestMethod.GET)
    public void login() {

    }

    @RequestMapping(value = "/public/login", method = RequestMethod.POST)
    public void loginPost(@ModelAttribute("username") String username,
                          @ModelAttribute("pwd") String pwd, Model model,
                          ServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, pwd);
        try {
//            WebUtils.getSavedRequest()

            subject.login(token);

        } catch (Exception ex) {
            model.addAttribute("msg", ex.getMessage());
//            ex.printStackTrace();
        }


    }

    @RequestMapping(value = "/public/logout")
    public String loginError(HttpSession session) {
        SecurityUtils.getSubject().logout();
        return "redirect:../index";
//        Session session1 = SecurityUtils.getSubject().getSession();

//        return "login";
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String error(Exception ex) {
        ex.printStackTrace();
        return "error";
    }
}
