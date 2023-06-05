package com.gai.admin.controller;

import com.gai.admin.service.UserService;
import com.gai.admin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName TestController
 * Description
 * Author wangJW
 * Data 2022/10/12  14:51
 * Version 1.0
 **/
@RestController
@RequestMapping("/admin/acl/user")
public class TestController {
    @Autowired
    private UserService UserService;

    @PostMapping ("login")
    public String hello(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        return UserService.login(user);
    }

}
