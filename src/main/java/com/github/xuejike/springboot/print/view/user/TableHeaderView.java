package com.github.xuejike.springboot.print.view.user;

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
        @JkButton(value = "清空", type = JkButtonType.reset)
})
@Data
public class TableHeaderView {
    @JkFormField(title = "用户名:", type = TextFormFieldImpl.class)
    private String userName;
    @JkFormField(title = "昵称:", type = TextFormFieldImpl.class)
    private String nickName;
}