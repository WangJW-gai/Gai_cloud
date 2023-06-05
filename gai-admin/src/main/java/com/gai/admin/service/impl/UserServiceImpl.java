package com.gai.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gai.admin.mapper.UserMapper;
import com.gai.admin.entity.User;
import com.gai.admin.service.UserService;
import com.gai.security.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

/**
 * ClassName SysUserServiceImpl
 * Description
 * Author wangJW
 * Data 2023/1/11  16:16
 * Version 1.0
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public String login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword());
        Authentication authentication;
        try {
            authentication = AuthenticationManager.class.newInstance().authenticate(authenticationToken);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (Objects.isNull(authentication)) {
            throw new RuntimeException("登陆失败");
        }
        //使用UUID 作为存入redis的key 防止用户退出后 旧的token还可以继续使用

        String uuid = UUID.randomUUID().toString();

        String jwt = JwtUtil.createJWT(uuid);

        redisTemplate.opsForSet().add(uuid, authentication.getPrincipal());

        return jwt;
    }

}
