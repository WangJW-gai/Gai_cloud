package com.example.security.controller;
import com.example.security.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName TestController
 * @Description
 * @Author wangJW
 * @Data 2022/10/12  14:51
 * @Version 1.0
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("hello")
    public String hello() {
        return "hello world";
    }

}
