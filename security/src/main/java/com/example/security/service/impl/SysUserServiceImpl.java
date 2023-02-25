package com.example.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.security.entity.SysUser;
import com.example.security.mapper.SysUserMapper;
import com.example.security.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName SysUserServiceImpl
 * @Description
 * @Author wangJW
 * @Data 2023/1/11  16:16
 * @Version 1.0
 **/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser selectUserByName(String userName) {
        QueryWrapper<SysUser> query = new QueryWrapper<SysUser>();
        query.eq("name", userName);
        SysUser user = sysUserMapper.selectOne(query);
        if(user == null){
            return null;
        }
        Long userId = user.getId();
       /* Set<Role> roles = roleDao.findByUserId(userId);
        if(roles != null && roles.size() > 0){
            for(Role role : roles){
                Integer roleId = role.getId();
                Set<Permission> permissions = permissionDao.findByRoleId(roleId);
                if(permissions != null && permissions.size() > 0){
                    role.setPermissions(permissions);
                }
            }
            user.setRoles(roles);
        }*/
        return user;
    }
}
