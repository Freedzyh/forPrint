package com.github.xuejike.springboot.jkfaststart.controller.admin.view.user;

import com.bidanet.springmvc.demo.jkbuilder.annotation.JkDataSource;
import com.bidanet.springmvc.demo.jkbuilder.annotation.JkForm;
import com.bidanet.springmvc.demo.jkbuilder.annotation.JkTitle;
import com.bidanet.springmvc.demo.jkbuilder.annotation.JkVerify;
import com.bidanet.springmvc.demo.jkbuilder.annotation.ext.JkSelectFormField;
import com.bidanet.springmvc.demo.jkbuilder.annotation.ext.JkTextFormField;
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.JkSourceType;
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.JkVerifyType;
import com.github.xuejike.springboot.jkfaststart.controller.datasource.RoleDataSource;
import lombok.Data;

/**
 *
 * @author xuejike
 * @version $Id: AdminUs.java, v 0.1 2018-01-13 13:47:49 xuejike Exp $$
 */
@Data
@JkForm(url = "./add_save")
public class AddAdminUser {



    @JkTitle("用户名")
    @JkTextFormField
    @JkVerify(rules = {JkVerifyType.required})
    private String username;

    @JkTitle("密码")
    @JkTextFormField
    @JkVerify(rules = {JkVerifyType.required})
    private String pwd;

    @JkTitle("昵称")
    @JkTextFormField
    @JkVerify(rules = {JkVerifyType.required})
    private String nickName;


    @JkTitle("角色")
    @JkSelectFormField
    @JkDataSource(type = JkSourceType.beanClass,beanCls = RoleDataSource.class)
    @JkVerify(rules = {JkVerifyType.required})
    private Long roleId;

//    @JkTitle("自定义")
//    @JkTplFormField("#diy")
//    private String tpl;

}
