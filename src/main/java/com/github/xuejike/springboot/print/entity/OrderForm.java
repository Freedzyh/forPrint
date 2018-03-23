package com.github.xuejike.springboot.print.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by xuemingyu 2018/3/22
 * 订单管理
 */
@Entity
@Table(name = "_order_form")
@Data
public class OrderForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 客户名称(公司)
     */
    @Column(name = "company_name ")
    private String companyName;
    /**
     * 人员(姓名)
     */
    private String name;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 地址
     */
    private String address;
    /**
     * 任务(是否打印彩色)
     */
    private String task;
    /**
     * 取送
     */
    @Column(name = "get_or_send")
    private String getOrSend;
    /**
     * 交付时间
     */
    @Column(name = " delivery_time")
    private String deliveryTime;
    /**
     * 规格
     */
    private String size;
    /**
     * 每份页数
     */
    @Column(name = "page_count")
    private String pageCount;
    /**
     * 数量
     */
    private String count;
    /**
     * 加工工艺
     */
    private String technology;
    /**
     * 备注
     */
    private String message;

}
