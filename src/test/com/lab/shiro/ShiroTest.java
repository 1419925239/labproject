package com.lab.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 张占恒.
 * @date 2020/2/7.
 * @time 16:09.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ShiroTest {

    @Autowired
    private SecurityManager securityManager;

//    @Test
//    public  void  test04(){
//        String username= "张三";
//        String password = "123";
//        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
//        Subject subject = SecurityUtils.getSubject();
//        subject.login(token);
//
//        subject.isPermitted("aaa");
//    }
}
