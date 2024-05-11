package com.rainsoul.springmvc.controller;

import com.rainsoul.springmvc.bean.User;
import com.rainsoul.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户控制器类，负责处理用户相关的HTTP请求。
 */
@Controller
public class UserController {

    // 自动注入用户服务接口，用于执行用户业务逻辑
    @Autowired
    private UserService userService;

    /**
     * 根据用户ID获取用户信息。
     *
     * @param id 用户ID，路径变量。
     * @return 返回用户信息的响应实体。如果用户存在，则返回找到的用户信息；如果用户不存在，则返回404状态码。
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getById(@PathVariable("id") Long id){
        User user = userService.getById(id); // 从服务层获取指定ID的用户信息
        if(user == null){
            // 如果用户不存在，返回404状态码
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }else{
            // 如果用户存在，返回200状态码和用户信息
            return ResponseEntity.ok(user);
        }
    }

}

