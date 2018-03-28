package com.github.xuejike.springboot.print.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by xuemingyu 2018/3/28
 */
@Entity
@Table(name = "_order_detail")
@Data
public class OrderDetail {
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 订单id
     */
    @Column(name = "order_id")
    private Long orderId;
    /**
     * 部件
     */
    private String component;
    /**
     * 规格
     */
    private String size;
    /**
     * 数量
     */
    private Long count;
    /**
     * 单位
     */
    private String unit;
    /**
     * 辅助值
     */
    @Column(name = "auxfun_value")
    private String auxfunValue;
    /**
     * 辅助单位
     */
    @Column(name = "auxfun_unit")
    private String auxfunUnit;
    /**
     * 材质型号
     */
    private String type;
    /**
     * 加工工艺
     */
    @Column(name = "process_technology")
    private String processTechnology;
}
