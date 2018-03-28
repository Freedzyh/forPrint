package com.github.xuejike.springboot.print.view.technology;

import com.bidanet.springmvc.demo.jkbuilder.annotation.JkButton;
import com.bidanet.springmvc.demo.jkbuilder.annotation.JkForm;
import com.bidanet.springmvc.demo.jkbuilder.annotation.JkFormField;
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.JkButtonType;
import com.bidanet.springmvc.demo.jkbuilder.type.impl.TextFormFieldImpl;
import lombok.Data;

/**
 * Created by xuemingyu 2018/3/27
 */
@JkForm(btns = {
        @JkButton(value = "搜索", type = JkButtonType.submit),
        @JkButton(value = "清空", type = JkButtonType.reset),
        @JkButton(value = "添加",
                type = JkButtonType.dialog, url = "/admin/technology/add")
})
@Data
public class TableHeaderView {
    @JkFormField(title = "加工工艺:", type = TextFormFieldImpl.class)
    private String processTechnogy;
}
