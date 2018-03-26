package com.github.xuejike.springboot.print.entity;

import com.github.xuejike.springboot.print.entity.enumType.SysType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "_sys_config")
@Data
public class SysConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /**
     * 系统参数类型
     */
    @Column(name = "sys_type")
    @Enumerated(EnumType.ORDINAL)
    private SysType sysType;

    /**
     * 值
     */
    private String val;




}
