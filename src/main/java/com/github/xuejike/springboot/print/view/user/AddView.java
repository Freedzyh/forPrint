package com.github.xuejike.springboot.print.view.user;

import com.bidanet.springmvc.demo.jkbuilder.annotation.*;
import com.bidanet.springmvc.demo.jkbuilder.annotation.ext.JkUploadFormField;
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.JkVerifyType;
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.UploadFileType;
import com.bidanet.springmvc.demo.jkbuilder.type.impl.TextFormFieldImpl;
import lombok.Data;

/**
 * Created by xuemingyu 2018/3/26
 */
@JkForm(url = "/admin/user/insert", title = "编辑")
@Data
public class AddView {
    private String id;
    @JkPlaceholder("请填写用户名")
    @JkFormField(title = "用户名:", type = TextFormFieldImpl.class)
    @JkVerify(rules = {JkVerifyType.required})
    private String userName;
    @JkPlaceholder("请填写昵称")
    @JkFormField(title = "昵称:", type = TextFormFieldImpl.class)
    @JkVerify(rules = {JkVerifyType.required})
    private String nickName;
    @JkPlaceholder("请填写密码，默认1-6")
    @JkFormField(title = "昵称:", type = TextFormFieldImpl.class)
    @JkVerify(rules = {JkVerifyType.required})
    private String userPassword;
}
