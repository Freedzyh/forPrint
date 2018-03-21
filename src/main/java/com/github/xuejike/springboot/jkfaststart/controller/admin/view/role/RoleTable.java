package com.github.xuejike.springboot.jkfaststart.controller.admin.view.role;

import com.bidanet.springmvc.demo.jkbuilder.annotation.JkColumn;
import com.bidanet.springmvc.demo.jkbuilder.annotation.JkDataSource;
import com.bidanet.springmvc.demo.jkbuilder.annotation.JkTable;
import lombok.Data;

@Data
@JkTable
@JkDataSource(url = "./data")
public class RoleTable {

    private Long id;
    @JkColumn(title = "角色")
    private String name;
    @JkColumn(title = "觉得信息")
    private String info;
}
