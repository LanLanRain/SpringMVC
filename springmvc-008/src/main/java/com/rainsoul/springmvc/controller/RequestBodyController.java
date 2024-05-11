package com.rainsoul.springmvc.controller;

import com.rainsoul.springmvc.bean.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URI;

@Controller
public class RequestBodyController {

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestBody String requestBodyStr){
        System.out.println(requestBodyStr);
        return "ok";
    }

    /*@RequestMapping(value = "/save2", method = RequestMethod.POST)
    @ResponseBody
    public String saveUser(@RequestBody User user){
        System.out.println(user);
        // 不是逻辑视图名称，是普通字符串，因为前端发送的请求是AJAX请求。
        return "ok";
    }*/

    @RequestMapping(value = "/save2", method = RequestMethod.POST)
    @ResponseBody
    public String saveUser(RequestEntity<User> requestEntity){
        // 获取请求方法
        HttpMethod method = requestEntity.getMethod();
        System.out.println(method);
        // 获取请求URL
        URI url = requestEntity.getUrl();
        System.out.println(url);
        // 获取请求头
        HttpHeaders headers = requestEntity.getHeaders();
        System.out.println(headers);
        // 获取请求头中的内容类型
        MediaType contentType = headers.getContentType();
        System.out.println(contentType);
        // 获取请求体
        User user = requestEntity.getBody();
        System.out.println(user);

        return "ok";
    }
}
