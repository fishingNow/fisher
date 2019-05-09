package com.homework.service.impl;

import com.homework.entity.User;
import com.homework.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ServiceImpl {

    @Resource
    private UserMapper userMapper;

    public User login(String email, String password) {
//        if (!email.equals(" ")&&!password.equals(" ")){
//            return userMapper.login(email,password);
//        }else {
//            return false;
//        }
        return userMapper.login(email, password);
    }
}
