package com.github.xuejike.springboot.jkfaststart.domain;

import com.github.xuejike.springboot.jkfaststart.domain.type.Status;
import com.github.xuejike.springboot.jkfaststart.domain_ext.CreationDateTime;
import com.github.xuejike.springboot.jkfaststart.domain_ext.UpdateDateTime;
import lombok.Data;
import org.joda.time.DateTime;

import javax.persistence.*;

@Data
@Entity(name = "sys_admin_user")
public class AdminUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 用户名
     */
    @Column(unique = true)
    private String username;
    /**
     * 密码
     */
    private String pwd;
    /**
     * 昵称
     */
    private String nickName;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @Column(name = "role_id")
    private Long roleId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id",insertable = false,updatable = false)
    private AdminRole adminRole;
    /**
     * 软删除标记
     */
    @Column(name = "_delete")
    private Boolean delete;

    /**
     * 创建时间
     */
    @CreationDateTime
    private DateTime  createTime;

    /**
     * 修改时间
     */
    @UpdateDateTime
    private DateTime updateTime;
}
