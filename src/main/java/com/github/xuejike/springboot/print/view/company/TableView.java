package com.github.xuejike.springboot.print.view.company;

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
    //银行名称
    @JkColumn(title = "公司名称")
    private String name;
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
