package com.github.xuejike.springboot.print.dao;

import com.github.xuejike.springboot.jkfaststart.repository.BaseJPA;
import com.github.xuejike.springboot.print.entity.User;

import java.util.List;

/**
 * Created by xuemingyu 2018/3/23
 */
public interface UserDao extends BaseJPA<User> {
    User findFirstById(Long id);

    User findFirstByUserNameAndUserPassword(String userName, String passWord);

    User findFirstByUserName(String userName);

}
