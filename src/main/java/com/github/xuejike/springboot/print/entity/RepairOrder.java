package com.github.xuejike.springboot.print.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by xuemingyu 2018/3/22
 * 转工单
 */
@Entity
@Table(name = "_repair_order")
@Data
public class RepairOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //todo 主料
    /**
     * 主料名称
     */
    @Column(name = "mian_name")
    private String mainName;
    /**
     * 主料来源
     */
    @Column(name = "main_source")
    private String mainSource;
    /**
     * 预估数量
     */
    @Column(name = "estimate_count")
    private String estimateCount;
    /**
     * 订纸尺寸
     */
    @Column(name = "paper_size")
        private String paperSize;
    /**
     * 开数
     */
    @Column(name = "open_count")
    private String openCount;
    /**
     * 印刷数量
     */
    @Column(name = "main_count")
    private String mainCount;

    //todo 辅料
    /**
     * 辅料工序
     */
    @Column(name = "assist_process")
    private String assistProcess;
    /**
     * 版式
     */
    @Column(name = "assist_format")
    private String assistFormat;
    /**
     * 尺寸
     */
    @Column(name = "assist_size")
    private String assistSize;
    /**
     * 数量
     */
    @Column(name = "assist_count")
    private String assistCount;
    /**
     * 辅料来源
     */
    @Column(name = "assist_source")
    private String assistSource;
    /**
     * 接收人签字
     */
    @Column(name = "receiver_sign")
    private String receiverSign;

    //todo 加工
    /**
     * 加工工序
     */
    @Column(name = " production_process")
    private String productionProcess;
    /**
     * 工艺要求
     */
    @Column(name = "producction_require")
    private String productionRequire;
    /**
     * 印数
     */
    @Column(name = "print_count")
    private String printCount;
    /**
     * 放数
     */
    @Column(name = "release_count")
    private String releaseCount;
    /**
     * 机台
     */
    private String cabinet;
    /**
     * 机长签字
     */
    @Column(name = "captain_sign")
    private String captainSign;
}
