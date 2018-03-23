package com.github.xuejike.springboot.print.view.Supplier;

import com.bidanet.springmvc.demo.jkbuilder.annotation.JkButton;
import com.bidanet.springmvc.demo.jkbuilder.annotation.JkForm;
import com.bidanet.springmvc.demo.jkbuilder.annotation.JkFormField;
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.JkButtonType;
import com.bidanet.springmvc.demo.jkbuilder.type.impl.TextFormFieldImpl;
import lombok.Data;

/**
 * Created by xuemingyu 2018/3/21
 */
@JkForm(btns = {
        @JkButton(value = "搜索", type = JkButtonType.submit),
        @JkButton(value = "清空", type = JkButtonType.reset),
        @JkButton(value = "添加", type = JkButtonType.dialog, url = "/admin/supplier/add"),
})
@Data
public class TableHeaderView {
    @JkFormField(title = "供应商:", type = TextFormFieldImpl.class)
    private String name;
}
