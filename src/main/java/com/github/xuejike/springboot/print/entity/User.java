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
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;
    /**
     * 密码
     */
    @Column(name = "user_pwd")
    private String userPassword = "123456";
    /**
     * 用户类型
     */
    private UserType userType = UserType.admin;
    /**
     * 禁用状态
     */
    private Status status = Status.use;
    /**
     * 公司id
     */
    @Column(name = "company_id")
    private Long companyId;
}
