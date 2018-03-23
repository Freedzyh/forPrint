package com.github.xuejike.springboot.print.view.Supplier;

import com.bidanet.springmvc.demo.jkbuilder.annotation.JkForm;
import com.bidanet.springmvc.demo.jkbuilder.annotation.JkFormField;
import com.bidanet.springmvc.demo.jkbuilder.annotation.JkPlaceholder;
import com.bidanet.springmvc.demo.jkbuilder.annotation.JkVerify;
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.JkVerifyType;
import com.bidanet.springmvc.demo.jkbuilder.type.impl.TextFormFieldImpl;
import lombok.Data;

/**
 * Created by xuemingyu 2018/3/21
 */
@JkForm(url = "/admin/supplier/insert", title = "编辑")
@Data
public class AddView {
    private Long id;
    @JkPlaceholder("请填写供应商名称")
    @JkFormField(title = "供应商名称:", type = TextFormFieldImpl.class)
    @JkVerify(rules = {JkVerifyType.required})
    private String name;
    @JkPlaceholder("请填写手机号码")
    @JkFormField(title = "手机号码:", type = TextFormFieldImpl.class)
    @JkVerify(rules = {JkVerifyType.required, JkVerifyType.phone})
    private String mobilePhone;
    @JkPlaceholder("请填写QQ号码")
    @JkFormField(title = "QQ号码:", type = TextFormFieldImpl.class)
    @JkVerify(rules = {JkVerifyType.required, JkVerifyType.number})
    private String qq;
    @JkPlaceholder("请填写固定电话")
    @JkFormField(title = "固定电话:", type = TextFormFieldImpl.class)
    @JkVerify(rules = {JkVerifyType.required, JkVerifyType.number})
    private String telephone;
    @JkPlaceholder("请填写地址")
    @JkFormField(title = "地址:", type = TextFormFieldImpl.class)
    @JkVerify(rules = {JkVerifyType.required})
    private String address;
    @JkPlaceholder("请填写开户行")
    @JkFormField(title = "开户行:", type = TextFormFieldImpl.class)
    @JkVerify(rules = {JkVerifyType.required})
    private String openBank;
    @JkPlaceholder("请填写银行账号")
    @JkFormField(title = "账号:", type = TextFormFieldImpl.class)
    @JkVerify(rules = {JkVerifyType.required, JkVerifyType.number})
    private String account;
    @JkPlaceholder("请填写结账方式")
    @JkFormField(title = "结账方式:", type = TextFormFieldImpl.class)
    @JkVerify(rules = {JkVerifyType.required})
    private String paymentMethod;
    @JkPlaceholder("请填写备注")
    @JkFormField(title = "备注:", type = TextFormFieldImpl.class)
    @JkVerify(rules = {JkVerifyType.required})
    private String message;
}
