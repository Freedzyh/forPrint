package com.github.xuejike.springboot.print.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by xuemingyu 2018/3/22
 */
//材料信息
@Entity
@Table(name = "_materials")
@Data
public class Materials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 材料名称
     */
    private String name;
    /**
     * 规格
     */
    private String size;
    /**
     * 单位
     */
    private String unit;
    /**
     * 单价
     */
    private String price;
    /**
     * 库存数量
     */
    private String Stock;
    /**
     * 备注信息
     */
    private String message;
}
