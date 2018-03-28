package com.github.xuejike.springboot.print.entity;

/**
 * Created by xuemingyu 2018/3/27
 */

import com.github.xuejike.springboot.print.entity.enumType.TechincType;
import lombok.Data;

import javax.persistence.*;

/**
 * 加工工艺
 */
@Entity
@Table(name = "_technic")
@Data
public class Technic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    /**
     * 类型(工艺，方式，机台)
     */
    private TechincType techincType;
    /**
     * 机台id
     */
    @Column(name = "cabinet_id")
    private String cabinetId;
    /**
     * 加工方式id
     */
    @Column(name = "process_method_id")
    private String processMethodId;
    /**
     * 加工工艺id
     */
    @Column(name = "process_technogy_id")
    private String processTechnogyId;
    /**
     * 级别id(工艺=1，方式=2，机台=3)
     */
    @Column(name = "level_id")
    private Long levelId;
}
