package com.github.xuejike.springboot.print.service.impl;

import com.bidanet.bdcms.core.vo.Page;
import com.bidanet.hibernate.lambda.core.LambdaCriteria;
import com.github.xuejike.springboot.print.dao.UserDao;
import com.github.xuejike.springboot.print.entity.User;
import com.github.xuejike.springboot.print.entity.enumType.Status;
import com.github.xuejike.springboot.print.entity.enumType.UserType;
import com.github.xuejike.springboot.print.service.UserService;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by xuemingyu 2018/3/23
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    @Autowired
    private UserDao userDao;

    public LambdaCriteria getLambda(User user) {
        LambdaCriteria<User> userLambdaCriteria = lambdaQuery.create(User.class);
        if (!Strings.isNullOrEmpty(user.getUserName())) {
            userLambdaCriteria.like(q -> {
                q.setUserName("%" + user.getUserName() + "%");
            });
        }
        return userLambdaCriteria;
    }

    @Override
    public void queryLike(User user, Page<User> page) {
        LambdaCriteria<User> lambdaCriteria = getLambda(user);
        List<User> list = lambdaCriteria.orderDesc("id").list(page.getPageCurrent(), page.getPageSize());
        Long count = lambdaCriteria.count();
        page.setList(list);
        page.setTotal(count);
    }

    public void checkUser(User user) {
        checkString(user.getUserName(), "用户名不能为空");
        checkString(user.getUserPassword(), "密码不能为空");
        checkNull(user.getStatus(), "状态");
        checkNull(user.getUserType(), "用户类型");
    }

    @Override
    public void insert(User user) {
        checkUser(user);
        user.setUserType(UserType.admin);
        user.setStatus(Status.use);
        userDao.save(user);
    }

    @Override
    public void update(User user) {
        // checkUser(user);
        User userInfo = userDao.findFirstById(user.getId());
        userInfo.setUserName(user.getUserName());
        userInfo.setUserPassword(user.getUserPassword());
        userInfo.setStatus(Status.use);
        userInfo.setUserType(UserType.admin);
        userDao.save(userInfo);
    }

    @Override
    public void changeStatus(Long id) {
        //   User user = userDao.findFirstById(id);

    }

    @Override
    public User login(String userName, String passWord) {
        return userDao.findFirstByUserNameAndUserPassword(userName, passWord);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    protected JpaRepository<User, Long> getDao() {
        return userDao;
    }

}
