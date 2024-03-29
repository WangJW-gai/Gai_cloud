package com.gai.admin.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangjw
 * @since 2022-12-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id;

    //用户昵称
    private String name;

    //头像地址
    private String headImg;

    //邮箱
    private String email;

    //手机号
    private String phone;


    //密码
    private String password;

    //注册地址ip
    private String registrationIp;

    //注册时间
    private Date ctime;

    //更新时间
    private Date utime;

    //用户状态       0  正常 1 注销
    private Boolean status;


}
