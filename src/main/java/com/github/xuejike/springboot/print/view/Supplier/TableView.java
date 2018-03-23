package com.github.xuejike.springboot.print.view.Supplier;

import com.bidanet.springmvc.demo.jkbuilder.annotation.*;
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.JkButtonType;
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.JkColumnAlign;
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.JkSourceType;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by xuemingyu 2018/3/21
 */
@Data
@JkTable
@JkDataSource(type = JkSourceType.url, url = "/api/admin/supplier/getPageData")
public class TableView {
    @JkColumn(title = "编号")
    private Long id;
    @JkColumn(title = "供应商")
    private String name;
    @JkColumn(title = "手机")
    private String mobilePhone;
    @JkColumn(title = "qq号")
    private String qq;
    @JkColumn(title = "电话")
    private Long telephone;
    @JkColumn(title = "地址")
    private String address;
    @JkColumn(title = "操作", fixed = JkColumnAlign.right, width = 180)
    @JkToolBar(btns = {
            @JkButton(value = "查看详情",
                    type = JkButtonType.dialog,
                    url = "/admin/supplier/details?id={id}",
                    option = "{title:'客户详细信息',area:['1500px','90%']}"),
            @JkButton(value = "编辑",
                    type = JkButtonType.dialog,
                    url = "/admin/commodity/edit?id={id}",
                    option = "{title:'编辑',area:['1500px','90%']}"),
            @JkButton(value = "删除", type = JkButtonType.confirm,
                    option = "'确定删除此资源'"
                    , cssClass = "layui-btn-warm"
                    , url = "/admin/commodity/delete?id={id}")
    })
    private String tool;
}
