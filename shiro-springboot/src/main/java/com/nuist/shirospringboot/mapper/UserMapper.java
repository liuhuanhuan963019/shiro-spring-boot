package com.nuist.shirospringboot.mapper;

import com.nuist.shirospringboot.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.Mapping;

/**
 * @author liuhuanhuan
 * @version 1.0
 * @date 2022/5/8 19:39
 * @Description
 */
@Repository
@Mapper
public interface UserMapper {

    User queryUserByName(String name);

}
