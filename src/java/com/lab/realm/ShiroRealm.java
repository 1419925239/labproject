package com.lab.realm;

import com.lab.bean.User;
import com.lab.bean.UserExample;
import com.lab.dao.UserMapper;
import com.lab.utils.MD5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 张占恒.
 * @date 2020/2/6.
 * @time 14:38.
 */
public class ShiroRealm extends AuthorizingRealm {


    @Autowired
    UserMapper userMapper;

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        1、把AuthenticationToken转换为 UsernamePasswordToken
        UsernamePasswordToken upToken = (UsernamePasswordToken)token;
//        2、从UsernamePasswordToken 中获取username
        String username = upToken.getUsername();
        String password = new String(upToken.getPassword());
//        3、调用数据库方法，从数据库中查询username对应的用户记录

        Integer username1 = Integer.valueOf(username);
        UserExample param = new UserExample();
        param.createCriteria().andUserIdEqualTo(username1);
        List<User> list = userMapper.selectByExample(param);
//        4、若用户不存在，则可以抛出异常UnknownAccountException
            if(list.size() == 0 && list.isEmpty()){
                throw new UnknownAccountException("用户不存在！");
            }
//            取拿过来的数据
        User user = list.get(0); //数据库中的信息
//        password = user.getUserPassword();
        String password1 = user.getUserPassword();
//        5、根据用户信息的情况，决定是否需要抛出其他类型的异常
        if(!password1.equals(password)){
            throw new CredentialsException("密码错误");
        }
        if (user.getUserStatus() == 1){
            throw new DisabledAccountException("账号被禁用");
        }
        System.out.println("认证成功。。。。");

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,upToken.getCredentials(),getName());
        return info;
    }

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) principalCollection.getPrimaryPrincipal();
        System.out.println(user);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //从数据库获取当前用户的角色 通过用户名查询该用户拥有的角色名称
        Set<String> roleNameSet = userMapper.selectUserRoleNameSet(user.getUserId());
        info.addRoles(roleNameSet);
        //从数据库获取当前用户的权限 通过用户名查询该用户拥有的权限名称
        Set<String> qxNameSet = userMapper.selectUserQxNameSet(user.getUserId());
        Set<String> qxs = new HashSet<>();
        for (String name:qxNameSet){
            for(String qx :name.split(",")){
                qxs.add(qx);
            }
        }
        info.addStringPermissions(qxs);
        System.out.println("授权成功。。。。");
        return info;
    }
}
