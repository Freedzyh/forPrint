package com.github.xuejike.springboot.print.view.technology;

import com.bidanet.springmvc.demo.jkbuilder.annotation.JkForm;
import com.bidanet.springmvc.demo.jkbuilder.annotation.JkFormField;
import com.bidanet.springmvc.demo.jkbuilder.annotation.JkPlaceholder;
import com.bidanet.springmvc.demo.jkbuilder.annotation.JkVerify;
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.JkVerifyType;
import com.bidanet.springmvc.demo.jkbuilder.type.impl.HiddenFormFieldImpl;
import com.bidanet.springmvc.demo.jkbuilder.type.impl.TextFormFieldImpl;
import lombok.Data;

/**
 * Created by xuemingyu 2018/3/27
 */
@JkForm(url = "/admin/technology/update", title = "编辑")
@Data
public class EditView {
    @JkFormField(type = HiddenFormFieldImpl.class)
    private Long id;
    @JkPlaceholder("请填写加工工艺")
    @JkFormField(title = "加工工艺:", type = TextFormFieldImpl.class)
    @JkVerify(rules = {JkVerifyType.required})
    private String processTechnogy;
    @JkPlaceholder("请填写加工方式")
    @JkFormField(title = "加工方式:", type = TextFormFieldImpl.class)
    @JkVerify(rules = {JkVerifyType.required})
    private String processMethod;
    @JkPlaceholder("请填写机台")
    @JkFormField(title = "机台:", type = TextFormFieldImpl.class)
    @JkVerify(rules = {JkVerifyType.required})
    private String cabinet;
}
