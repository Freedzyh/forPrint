package com.github.xuejike.springboot.print.driver.uc;

import com.github.xuejike.springboot.print.entity.User;
import com.github.xuejike.springboot.print.exception.NoLoginException;

/**
 * Created by xuemingyu 2018/3/23
 */
public interface HomeUc {
    String loginS(String userName, String passWord);

    String loginS(String token);

    void updateUser(String token, User login);

    void updateUser(Long uid, User user);

    void logout();

    User getUser() throws NoLoginException;

    boolean checkLogin();

    Long getUserUid();

    String getToken();
}
