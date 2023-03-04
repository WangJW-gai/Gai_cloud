package com.gai.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gai.security.entity.SysUser;

/**
 * InterfaceName SysUserService
 * Description
 * Author wangJW
 * Data 2022/12/22  16:17
 * Version 1.0
 **/
public interface SysUserService extends IService<SysUser> {

    String login(SysUser user);
}
