package com.github.xuejike.springboot.print.view.company;

import com.bidanet.springmvc.demo.jkbuilder.annotation.JkButton;
import com.bidanet.springmvc.demo.jkbuilder.annotation.JkForm;
import com.bidanet.springmvc.demo.jkbuilder.annotation.JkFormField;
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.JkButtonType;
import com.bidanet.springmvc.demo.jkbuilder.type.impl.TextFormFieldImpl;
import lombok.Data;

/**
 * Created by xuemingyu 2018/3/26
 */
@JkForm(btns = {
        @JkButton(value = "搜索", type = JkButtonType.submit),
        @JkButton(value = "清空", type = JkButtonType.reset),
        @JkButton(value = "添加",
                type = JkButtonType.dialog, url = "/admin/company/add")
})
@Data
public class TableHeaderView {
    @JkFormField(title = "公司名称:", type = TextFormFieldImpl.class)
    private String name;
}