package com.github.xuejike.springboot.jkfaststart.controller.admin.view.user;

import com.bidanet.springmvc.demo.jkbuilder.annotation.*;
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.JkButtonType;
import lombok.Data;

/**
 *
 * @author xuejike
 * @version $Id: AdminUs.java, v 0.1 2018-01-10 19:40:14 xuejike Exp $$
 */
@Data
@JkTable
@JkDataSource(url = "./data")
public class AdminUserTable {

  
    private Long id;

    @JkColumn(title = "用户名")
    private String username;


    @JkColumn(title = "昵称")
    private String nickName;

    @JkColumn(title = "状态")
    private String status;

    @JkColumn(title = "角色")
    private String role;


    @JkColumn(title = "注册时间")
    private String createTime;

    @JkColumn(title = "修改时间")
    private String updateTime;

    @JkColumn(title = "操作")
    @JkToolBar(btns = {
            @JkButton(value = "编辑",type = JkButtonType.dialog,url = "/admin/admin/edit?id={id}")
    })
    private String tool;

}
