package com.gai.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gai.admin.entity.User;

/**
 * InterfaceName SysUserService
 * Description
 * Author wangJW
 * Data 2022/12/22  16:17
 * Version 1.0
 **/
public interface UserService extends IService<User> {

    String login(User user);
}
