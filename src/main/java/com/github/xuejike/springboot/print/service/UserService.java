package com.github.xuejike.springboot.print.service;

import com.bidanet.bdcms.core.vo.Page;
import com.github.xuejike.springboot.print.entity.User;

/**
 * Created by xuemingyu 2018/3/23
 */
public interface UserService extends BaseService<User> {
    void queryLike(User user, Page<User> page);

    void insert(User user);

    void update(User user);

    void changeStatus(Long id);

    User login(String userName, String passWord);

    void delete(Long id);


}
