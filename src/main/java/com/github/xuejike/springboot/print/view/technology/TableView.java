package com.github.xuejike.springboot.print.view.technology;

import com.bidanet.springmvc.demo.jkbuilder.annotation.*;
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.JkButtonType;
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.JkColumnAlign;
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.JkSourceType;
import lombok.Data;

/**
 * Created by xuemingyu 2018/3/27
 */
@Data
@JkTable
@JkDataSource(type = JkSourceType.url, url = "/admin/technology/getPageData")
public class TableView {

    private Long id;

    @JkColumn(title = "加工工艺")
    private String processTechnogy;
    @JkColumn(title = "加工方式")
    private String processMethod;
    @JkColumn(title = "机台")
    private String cabinet;

    @JkColumn(title = "工具栏", fixed = JkColumnAlign.right, width = 180)
    @JkToolBar(btns = {
            @JkButton(value = "编辑",
                    type = JkButtonType.dialog,
                    url = "/admin/technology/edit?id={id}",
                    option = "{title:'编辑',area:['1500px','90%']}"),
            @JkButton(value = "删除", type = JkButtonType.confirm,
                    option = "'确定删除此资源'"
                    , cssClass = "layui-btn-warm"
                    , url = "/admin/technology/delete?id={id}")
    })
    private String tool;
}

