package com.lab.controller;

import com.lab.bean.Role;
import com.lab.bean.User;
import com.lab.service.UserService;
import com.lab.utils.R;
import com.lab.utils.TreeNode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 张占恒.
 * @date 2020/2/6.
 * @time 16:01.
 */
@Controller
public class LoginController {

    @Autowired
    UserService userService;

    /**
     * 登录
     * @param map
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public R Login(@RequestParam  Map<String,Object> map){
        System.out.println(map);
        List<String> list = new ArrayList<>();
        for (String key:map.keySet()) {
            list.add((String) map.get(key));
        }
        String name = list.get(0);
        String password = list.get(1);
       UsernamePasswordToken token = new UsernamePasswordToken(name,password);
       Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);
            return R.ok();
        }catch (UnknownAccountException e)
        {
            return R.error("账号不存在！");
        }catch (CredentialsException e){
            return R.error("密码错误!");
        }

    }

    @GetMapping("/tologin")
    public String main(){
        return "login";
    }

    @GetMapping("/success")
    public String SU(ModelMap model){
        Subject subject =SecurityUtils.getSubject();
        User user =(User)subject.getPrincipal();
        String ID = String.valueOf(user.getUserId());
        subject.getSession().getAttribute("");
        model.addAttribute("UserId",ID);
        return "index";
    }

    @RequestMapping("/logout")
    public  String logout(){
        //销毁会话
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:labproject_war_exploded/tologin";
    }

    @GetMapping("/menu")
    @ResponseBody
    public R menu(){
        Subject subject =SecurityUtils.getSubject();
        User user =(User)subject.getPrincipal();
        User usernew = userService.getUserInfoNew(user.getUserId());
        String userName = usernew.getUserName();
        List<TreeNode> treeNodeList = userService.getMenuTreeByUserId(user.getUserId());
        String role = userService.getUserRoleNameSet(user.getUserId());
        String id = String.valueOf(user.getUserId());
        return  R.ok(id,role,userName,treeNodeList);
    }
    @GetMapping("/clock")
    public String clock(){
        return "clock";
    }
}
