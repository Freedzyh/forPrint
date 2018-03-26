package com.github.xuejike.springboot.print.view.company;

import com.bidanet.springmvc.demo.jkbuilder.annotation.JkForm;
import com.bidanet.springmvc.demo.jkbuilder.annotation.JkFormField;
import com.bidanet.springmvc.demo.jkbuilder.annotation.JkPlaceholder;
import com.bidanet.springmvc.demo.jkbuilder.annotation.JkVerify;
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.JkVerifyType;
import com.bidanet.springmvc.demo.jkbuilder.type.impl.TextFormFieldImpl;
import lombok.Data;

/**
 * Created by xuemingyu 2018/3/26
 */
@JkForm(url = "/admin/company/insert", title = "编辑")
@Data
public class AddView {
    private String id;
    @JkPlaceholder("请填写公司名称")
    @JkFormField(title = "名称:", type = TextFormFieldImpl.class)
    @JkVerify(rules = {JkVerifyType.required})
    private String name;


}