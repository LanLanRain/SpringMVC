package com.rainsoul.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    //@RequestMapping("/user/detail")
    @RequestMapping("/detail")
    public String userDetail(){
        return "user_detail";
    }

}