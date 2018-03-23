package com.github.xuejike.springboot.print.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by xuemingyu 2018/3/22
 * 排版方式管理
 */
@Entity
@Table(name = "_cpmpose")
@Data
public class Compose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 排版方式名称
     */
    private String name;
}
