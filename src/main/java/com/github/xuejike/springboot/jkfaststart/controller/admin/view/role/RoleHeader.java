package com.github.xuejike.springboot.jkfaststart.controller.admin.view.role;

import com.bidanet.springmvc.demo.jkbuilder.annotation.JkButton;
import com.bidanet.springmvc.demo.jkbuilder.annotation.JkForm;
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.JkButtonType;
import lombok.Data;

@Data
@JkForm(btns = {
      /*  @JkButton(type = JkButtonType.submit,value = "搜索"),*/
        @JkButton(value = "新增角色",type = JkButtonType.dialog,url = "/admin/role/add")
})
public class RoleHeader {
}
