package com.nuist.shirospringboot.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liuhuanhuan
 * @version 1.0
 * @date 2022/5/8 17:52
 * @Description
 */
@Controller
public class Mycontrollrt
{
    @RequestMapping({"/","/index"})
    public String toIndex(Model model) {
        model.addAttribute("msg","hello shiro");
        return "index";
    }

    @RequestMapping("/user/add")
    public String add() {
        return "user/add";
    }
    @RequestMapping("/user/update")
    public String update() {
        return "user/update";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/login")
    public String login(String username,String password,Model model) {
        // 获取当前用户
        Subject subject = SecurityUtils.getSubject();
        // 封装当前用户
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        try {
            subject.login(usernamePasswordToken); // 执行登录的方法，有异常进行处理
            return "index";
        } catch (UnknownAccountException e){
            model.addAttribute("msg","用户名错误");
            return "login";
        } catch (IncorrectCredentialsException e) { // 密码不存在
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }

    @RequestMapping("/noauth")
    @ResponseBody
    public String noauth() {
        return "未经过授权无法进行访问";
    }
}
