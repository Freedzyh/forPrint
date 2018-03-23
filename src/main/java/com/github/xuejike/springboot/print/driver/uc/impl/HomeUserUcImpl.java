package com.github.xuejike.springboot.print.driver.uc.impl;

import com.bidanet.bdcms.core.common.SpringWebTool;
import com.bidanet.bdcms.core.driver.cache.Cache;
import com.github.xuejike.springboot.print.driver.uc.HomeUc;
import com.github.xuejike.springboot.print.entity.User;
import com.github.xuejike.springboot.print.exception.NoLoginException;
import com.github.xuejike.springboot.print.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import java.util.UUID;

/**
 * Created by xuemingyu 2018/3/23
 */
@Service
public class HomeUserUcImpl implements HomeUc {
    public static String tokenTag = "homeToken";
    public static String userRoleTag = "uc.role.uid_";
    public static String userInfoTag = "uc.info.uid_";

    @Autowired
    UserService userService;
    @Autowired
    Cache cache;

    @Override
    public String loginS(String userName, String passWord) {
        String token = "uc." + UUID.randomUUID().toString();
        User loginUser = userService.login(userName, passWord);

        updateUser(token, loginUser);

        Cookie cookie = new Cookie(tokenTag, token);
        cookie.setMaxAge(1000 * 60 * 60 * 1000);
        cookie.setPath("/");
        SpringWebTool.getResponse().addCookie(cookie);
        SpringWebTool.getSession().setAttribute(tokenTag, token);
        return token;
    }

    @Override
    public String loginS(String token) {
        String uid = cache.get(token);
        User loginUser = userService.findOne(Long.valueOf(uid));
        updateUser(token, loginUser);

        Cookie cookie = new Cookie(tokenTag, token);
        cookie.setMaxAge(1000 * 60 * 60 * 1000);
        cookie.setPath("/");
        SpringWebTool.getResponse().addCookie(cookie);
        SpringWebTool.getSession().setAttribute(tokenTag, token);
        return token;
    }

    @Override
    public void updateUser(String token, User login) {
        cache.set(token, login.getId());
        cache.set(userInfoTag + login.getId() + token, login);

        SpringWebTool.getSession().setAttribute(tokenTag, token);
    }

    @Override
    public void updateUser(Long uid, User user) {
        cache.set(userInfoTag + uid + getToken(), user);
    }

    @Override
    public void logout() {
        cache.delete(getToken());
    }

    @Override
    public User getUser() {
        if (!checkLogin()) {
            try {
                throw new NoLoginException();
            } catch (NoLoginException e) {
                e.printStackTrace();
            }
        }
        String uid = cache.get(getToken());
        User user = cache.get(userInfoTag + uid + getToken(), User.class);
        return user;
    }

    @Override
    public boolean checkLogin() {
        String token = getToken();
        if (token == null) {
            return false;
        }
        String s = cache.get(token);
        return s != null;
    }

    @Override
    public Long getUserUid() {
        Long uid = getUser().getId();
        return uid;
    }

    @Override
    public String getToken() {
        Object attribute = SpringWebTool.getSession().getAttribute(tokenTag);
        if (attribute != null) {
            return (String) attribute;
        }
        Cookie[] cookies = SpringWebTool.getRequest().getCookies();
        if (cookies != null) {
            for (Cookie c :
                    cookies) {
                if (tokenTag.equals(c.getName()) && c.getValue() != null) {
                    return c.getValue();
                }
            }
        }

        String parameter = SpringWebTool.getRequest().getParameter(tokenTag);

        return parameter;
    }
}

