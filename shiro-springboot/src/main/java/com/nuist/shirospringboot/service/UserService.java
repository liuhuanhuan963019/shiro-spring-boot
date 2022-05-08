package com.nuist.shirospringboot.service;

import com.nuist.shirospringboot.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author liuhuanhuan
 * @version 1.0
 * @date 2022/5/8 19:52
 * @Description
 */
public interface UserService {

    public User queryUserByName(String name);
}
