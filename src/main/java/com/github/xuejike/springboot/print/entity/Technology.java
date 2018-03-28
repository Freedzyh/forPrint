package com.github.xuejike.springboot.print.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by xuemingyu 2018/3/26
 */
@Entity
@Table(name = "_technogy")
@Data
public class Technology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 加工工艺
     */
    @Column(name = "process_technogy")
    private String processTechnogy;
    /**
     * 加工方式
     */
    @Column(name = "process_method")
    private String processMethod;
    /**
     * 机台
     */
    private String cabinet;
}
