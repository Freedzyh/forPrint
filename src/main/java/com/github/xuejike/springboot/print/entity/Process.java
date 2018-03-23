package com.github.xuejike.springboot.print.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by xuemingyu 2018/3/22
 */
@Entity
@Table(name = "_process")
@Data
public class Process {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
