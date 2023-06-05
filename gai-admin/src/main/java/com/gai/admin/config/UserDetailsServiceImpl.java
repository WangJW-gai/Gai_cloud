package com.gai.admin.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gai.admin.entity.User;
import com.gai.admin.mapper.MenuPermMapper;
import com.gai.admin.mapper.UserMapper;
import com.gai.security.domain.LoginUser;
import com.gai.security.domain.SysUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * ClassName UserDetailsServiceImpl
 * Description
 * Author wangJW
 * Data 2022/12/1  14:58
 * Version 1.0
 **/
@Service
public class UserDetailsServiceImpl  implements UserDetailsService {

    @Autowired
    private UserMapper UserMapper;

    @Autowired
    private MenuPermMapper menuPermMapper;

    private static final Logger logger = LogManager.getLogger(UserDetailsServiceImpl.class);
    /**  * 根据用户名获取用户 - 用户的角色、权限等信息   */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<User> query = new QueryWrapper<User>();
        query.eq("name", username);
        User user = UserMapper.selectOne(query);
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户名或密码错误");
        }
        SysUser curUser = new SysUser();
        BeanUtils.copyProperties(user,curUser);
        //TODO 根据用户查询权限信息 添加到LoginUser中
        List<String> permission = menuPermMapper.selectListByUserId(user.getId());
        return new LoginUser(curUser,permission);
    }

}
