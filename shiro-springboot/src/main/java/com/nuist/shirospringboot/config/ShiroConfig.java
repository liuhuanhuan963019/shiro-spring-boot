package com.nuist.shirospringboot.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author liuhuanhuan
 * @version 1.0
 * @date 2022/5/8 17:58
 * @Description
 */
@Configuration
public class ShiroConfig {
    // shiroFilterConfiguere

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 设置用户管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 添加shiro的内置过滤器
        /**
         * anon: 无需认证即可访问
         * authc: 需要认证才能访问
         * user : 拥有记住我才能访问
         * pers: 拥有对某个资源的权限才能访问
         * roles: 拥有某个觉得权限才能访问
         * */

        Map<String,String> filterMap = new LinkedHashMap<>();
//        filterMap.put("/user/add","authc");
        // 授权
        filterMap.put("/user/add","perms[user:add]");
//        filterMap.put("/user/update","perms[user:update]");
        filterMap.put("/user/*","authc");

        //授权，正常情况下未授权需要跳转到未授权页面
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        shiroFilterFactoryBean.setLoginUrl("/toLogin");

        // 为授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/noauth");

        return shiroFilterFactoryBean;
    }
    // defaultWebSecurity
    // 通过@Qualifier 是USerRealm进行绑定
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userReaml") UserRealm userReaml) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联Realm
        securityManager.setRealm(userReaml);
        return securityManager;
    }


    // 创建realm对象  需要去进行自定义，这样就可以交给spring去进行托管了
    @Bean
    public UserRealm userReaml(){
        return new UserRealm();
    }

    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }
}
