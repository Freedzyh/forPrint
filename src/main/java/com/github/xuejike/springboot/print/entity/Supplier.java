package com.github.xuejike.springboot.print.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by xuemingyu 2018/3/21
 */
@Entity
@Table(name = "_supplier")
@Data
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 供应商名称
     */
    private String name;
    /**
     * 手机号码
     */
    @Column(name = "mobile_phone")
    private String mobilePhone;
    /**
     * QQ号码
     */
    private String qq;
    /**
     * 固定电话
     */
    private String telephone;
    /**
     * 地址
     */
    private String address;
    /**
     * 开户行
     */
    @Column(name = "open_bank")
    private String openBank;
    /**
     * 账号
     */
    private String account;
    /**
     * 结账方式
     */
    @Column(name = "payment_method")
    private String paymentMethod;
    /**
     * 备注
     */
    private String message;

}
