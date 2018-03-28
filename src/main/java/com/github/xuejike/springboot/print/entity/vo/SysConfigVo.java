package com.github.xuejike.springboot.print.entity.vo;

import com.bidanet.bdcms.core.bean.EntityToVo;
import com.github.xuejike.springboot.print.entity.SysConfig;
import com.github.xuejike.springboot.print.entity.enumType.SysType;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class SysConfigVo implements EntityToVo{

    private Long id;


    /**
     * 系统参数类型
     */
    private SysType sysType;

    private String sysTypeStr;

    /**
     * 值
     */
    private String val;

    @Override
    public void loadData(Object... objects) {
        SysConfig sysConfig = (SysConfig) objects[0];
        BeanUtils.copyProperties(sysConfig,this);

        if(sysConfig.getSysType() != null){
            this.setSysTypeStr(sysConfig.getSysType().cn());
        }

    }
}
