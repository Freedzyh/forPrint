package com.github.xuejike.springboot.print.entity.vo;

import com.bidanet.bdcms.core.bean.EntityToVo;
import com.github.xuejike.springboot.print.entity.User;
import com.github.xuejike.springboot.print.entity.enumType.Status;
import com.github.xuejike.springboot.print.entity.enumType.UserType;
import lombok.Data;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by xuemingyu 2018/3/26
 */
@Data
public class UserAdminVo implements EntityToVo {
    private String userName;
    private String nickName;
    private UserType userType;
    private String userTypeStr;
    private Status status;
    private String statusStr;

    @Override
    public void loadData(Object... objects) {
        User user = (User) objects[0];
        try {
            BeanUtils.copyProperties(this, user);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
