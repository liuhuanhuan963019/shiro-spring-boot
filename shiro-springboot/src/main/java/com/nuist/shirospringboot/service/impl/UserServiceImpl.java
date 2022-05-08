package com.nuist.shirospringboot.service.impl;

import com.nuist.shirospringboot.mapper.UserMapper;
import com.nuist.shirospringboot.pojo.User;
import com.nuist.shirospringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuhuanhuan
 * @version 1.0
 * @date 2022/5/8 19:52
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }
}
