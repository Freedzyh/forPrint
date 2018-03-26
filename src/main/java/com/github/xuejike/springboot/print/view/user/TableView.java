package com.github.xuejike.springboot.print.view.user;

import com.bidanet.springmvc.demo.jkbuilder.annotation.*;
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.JkButtonType;
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.JkColumnAlign;
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.JkSourceType;
import lombok.Data;

/**
 * Created by xuemingyu 2018/3/26
 */
@Data
@JkTable
@JkDataSource(type = JkSourceType.url, url = "/admin/company/getPageData")
public class TableView {

    private Long id;
    //用户名
    @JkColumn(title = "用户名")
    private String userName;
    @JkColumn(title = "昵称")
    private String nickName;
    @JkColumn(title = "用户类型")
    private String userType;
    @JkColumn(title = "工具栏", fixed = JkColumnAlign.right, width = 180)
    @JkToolBar(btns = {
            @JkButton(value = "编辑",
                    type = JkButtonType.dialog,
                    url = "/admin/company/edit?id={id}",
                    option = "{title:'编辑',area:['1500px','90%']}"),
            @JkButton(value = "删除", type = JkButtonType.confirm,
                    option = "'确定删除此资源'"
                    , cssClass = "layui-btn-warm"
                    , url = "/admin/company/delete?id={id}")
    })
    private String tool;
}