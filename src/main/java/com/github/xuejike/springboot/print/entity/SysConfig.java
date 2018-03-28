package com.github.xuejike.springboot.print.entity;

import com.github.xuejike.springboot.print.entity.enumType.SysType;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "_sys_config")
@Data
@Where(clause = "is_delete=0")
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

    /**
     * 是否删除
     */
    @Column(name = "is_delete")
    private boolean isDelete = false;




}
