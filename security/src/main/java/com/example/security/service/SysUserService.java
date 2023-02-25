package com.example.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.security.entity.SysUser;

/**
 * @InterfaceName SysUserService
 * @Description
 * @Author wangJW
 * @Data 2022/12/22  16:17
 * @Version 1.0
 **/
public interface SysUserService extends IService<SysUser> {

    //根据用户名查询用户信息
    SysUser selectUserByName(String userName);
}
