package com.github.xuejike.springboot.print.entity;

import com.github.xuejike.springboot.print.entity.enumType.Status;
import com.github.xuejike.springboot.print.entity.enumType.UserType;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by xuemingyu 2018/3/23
 */
@Entity
@Table(name = "_user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;
    /**
     * 密码
     */
    @Column(name = "user_pwd")
    private String userPassword;
    /**
     * 用户类型
     */
    private UserType userType;
    /**
     * 禁用状态
     */
    private Status status;
}
