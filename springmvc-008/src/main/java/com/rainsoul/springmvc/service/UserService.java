package com.rainsoul.springmvc.service;

import com.rainsoul.springmvc.bean.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    public User getById(Long id) {
        if(id == 1){
            return new User(111L, "zhangsan", "13234");
        }
        return null;
    }
}
