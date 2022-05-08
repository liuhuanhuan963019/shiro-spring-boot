package com.nuist.shirospringboot.config;

import com.nuist.shirospringboot.pojo.User;
import com.nuist.shirospringboot.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author liuhuanhuan
 * @version 1.0
 * @date 2022/5/8 17:59
 * @Description
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=》授权doGetAuthorizationInfo方法");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        // 新增授权页面
        authorizationInfo.addStringPermission("user:add");

        // 拿到当前对象 ,然后通过对象中的授权方式进行判断

        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了-》认证doGetAuthenticationInfo");
        String name = "root";
        String password = "123456";
        UsernamePasswordToken authenticationToken1 = (UsernamePasswordToken) authenticationToken;
        if (!authenticationToken1.getUsername().equals(name)) {
            return null;   // 抛出异常
        }
//        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//        User user = userService.queryUserByName(token.getUsername());
//        if (user == null) {
//            return null;
//        }
        // 密码认证  shiro去做
        // 可以进行密码的加密，  盐值加密可以保证密码不会反破解
        return new SimpleAuthenticationInfo("",password,"");
    }
}
