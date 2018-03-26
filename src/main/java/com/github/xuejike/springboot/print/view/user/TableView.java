package com.github.xuejike.springboot.print.view.user;

import com.bidanet.springmvc.demo.jkbuilder.annotation.*;
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.JkButtonType;
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.JkColumnAlign;
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.JkSourceType;
import com.github.xuejike.springboot.print.entity.enumType.Status;
import com.github.xuejike.springboot.print.entity.enumType.UserType;
import lombok.Data;

/**
 * Created by xuemingyu 2018/3/26
 */
@Data
@JkTable
@JkDataSource(type = JkSourceType.url, url = "/admin/user/getPageData")
public class TableView {

    private Long id;
    //用户名
    @JkColumn(title = "用户名")
    private String userName;
    @JkColumn(title = "昵称")
    private String nickName;
    @JkColumn(title = "用户类型")
    private String userTypeStr;
    @JkColumn(title = "状态")
    private String statusStr;
    @JkColumn(title = "工具栏", fixed = JkColumnAlign.right, width = 180)
    @JkToolBar(btns = {
            @JkButton(value = "启用",
                    type = JkButtonType.confirm,
                    option = "'确定启用此资源'",
                    url = "/admin/user/changeStatus?id={id}",
                    ifExp = "d.status=='Status.disable'"
            ),
            @JkButton(value = "禁用",
                    type = JkButtonType.confirm,
                    option = "'确定禁用此资源'",
                    cssClass = "layui-btn-danger",
                    url = "/admin/user/changeStatus?id={id}",
                    ifExp = "d.status=='Status.use'"
            ),
            @JkButton(value = "删除", type = JkButtonType.confirm,
                    option = "'确定删除此资源'"
                    , cssClass = "layui-btn-warm"
                    , url = "/admin/user/delete?id={id}")
    })
    private String tool;
}