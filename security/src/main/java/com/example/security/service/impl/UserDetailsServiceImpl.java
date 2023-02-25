package com.example.security.service.impl;

import com.example.security.entity.SysUser;
import com.example.security.service.SysUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @ClassName UserDetailsServiceImpl
 * @Description
 * @Author wangJW
 * @Data 2022/12/1  14:58
 * @Version 1.0
 **/
public class UserDetailsServiceImpl  implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    private static final Logger logger = LogManager.getLogger(UserDetailsServiceImpl.class);
    /**  * 根据用户名获取用户 - 用户的角色、权限等信息   */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = null;
        try {
            SysUser user = sysUserService.selectUserByName(username);
            Collection<GrantedAuthority> authList = getAuthorities();
            userDetails = new User(username, user.getPassword().toLowerCase(),true,true,true,true,authList);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return userDetails;
    }
    /**  * 获取用户的角色权限,为了降低实验的难度，这里去掉了根据用户名获取角色的步骤     * @param    * @return   */
    private Collection<GrantedAuthority> getAuthorities(){
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        authList.add(new SimpleGrantedAuthority("ROLE_USER"));
        authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return authList;
    }
}
