package com.nuist.shirospringboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liuhuanhuan
 * @version 1.0
 * @date 2022/5/8 19:37
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;

    private String name;

    private String pwd;
}
