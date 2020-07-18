package com.lab.controller;

import com.lab.bean.ExpResults;
import com.lab.bean.Exp_Res_Sch_Lab;
import com.lab.bean.LabInformation;
import com.lab.bean.User;
import com.lab.service.ExpInfoService;
import com.lab.service.ExpResultsService;
import com.lab.service.LabInfoService;
import com.lab.service.UserService;
import com.lab.utils.CusUtile;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @author 张占恒.
 * @date 2020/2/17.
 * @time 15:31.
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    LabInfoService labInfoService;
    @Autowired
    ExpInfoService expInfoService;
    @Autowired
    ExpResultsService expResultsService;
    //查询个人信息
    @RequestMapping("/5")
    public String userList(Model model){
        Subject subject = SecurityUtils.getSubject();
        User user =(User)subject.getPrincipal();
        User usernew = userService.getUserInfoNew(user.getUserId());
        String userID = String.valueOf(usernew.getUserId());
        String userpas = usernew.getUserPassword();
        String username = usernew.getUserName();
        String userclass = usernew.getUserCalss();
        String userfaculty = usernew.getUserFaculty();
        String userphone = usernew.getUserPhone();
        model.addAttribute("UserId1",userID);
        model.addAttribute("UserPassword1",userpas);
        model.addAttribute("UserName1",username);
        model.addAttribute("UserClass1",userclass);
        model.addAttribute("UserFaculty1",userfaculty);
        model.addAttribute("UserPhone1",userphone);
        return "main";
    }

    //修改个人信息
    @RequestMapping("/6")
    public String userupdate(Model model){
        Subject subject = SecurityUtils.getSubject();
        User user1 =(User)subject.getPrincipal();
        User usern = userService.getUserInfoNew(user1.getUserId());
        model.addAttribute("user2",usern);
        return "userupdate";
    }
    //教师管理
    @RequestMapping("/7")
    public String TeacherManager(){
        return "TeacherManager";
    }
    //学生管理
    @RequestMapping("/8")
    public String StudentManager(){
        return "StudentManager";
    }
    //查询实验室信息
    @RequestMapping("/9")
    public String labinfo(Model model){
        Subject subject = SecurityUtils.getSubject();
        User user1 =(User)subject.getPrincipal();
        List<LabInformation> labInformation =  labInfoService.selectAllLabInfo();
        model.addAttribute("labinfo",labInformation);
        return "LabInfo";
    }
    //修改实验室信息
    @RequestMapping("/10")
    public String infoupdate(Model model){
        Subject subject = SecurityUtils.getSubject();
        User user1 =(User)subject.getPrincipal();
        List<LabInformation> labInformation =  labInfoService.selectAllLabInfo();
        model.addAttribute("labinfo",labInformation);
        return "LabInfoUpdate";
    }
    //增加实验室信息
    @RequestMapping("/11")
    public String addlab(){
        return "LadAdd";
    }
    //删除实验室信息
    @RequestMapping("/12")
    public String labdelete(Model model){
        List<LabInformation> labInformation =  labInfoService.selectAllLabInfo();
        model.addAttribute("labinfo",labInformation);
        return "Laddelete";
    }
    //查询预约实验结果
    @RequestMapping("/13")
    public String viewexpresoult(Model model){
        Subject subject = SecurityUtils.getSubject();
        User user =(User)subject.getPrincipal();
        User usernew = userService.getUserInfoNew(user.getUserId());
        List<Exp_Res_Sch_Lab> expResSchLab = expInfoService.selectAllyuyuejieg();
        for (int i=0 ;i<expResSchLab.size();i++){
            Date time = new Date(String.valueOf(expResSchLab.get(i).getReserData()));
            String date =  new SimpleDateFormat("yyyy/MM/dd", Locale.US).format(time);
            expResSchLab.get(i).setScheduledate(date);
        }
//        expResSchLab.get(0).getScheduleDate();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String nowdate = simpleDateFormat.format(date);

        for(int i = 0;i<expResSchLab.size();i++){
            int id = expResSchLab.get(i).getReserUserId();
            String name = userService.selectByidToName(id);
            expResSchLab.get(i).setUserName(name);
        }

        model.addAttribute("nowdate",nowdate);
        model.addAttribute("user1",usernew);
        model.addAttribute("expResSchLab",expResSchLab);
        return "viewexpresoult";
    }

    //预约实验
    @RequestMapping("/17")
    public String appoint(Model model){
        Subject subject = SecurityUtils.getSubject();
        User user =(User)subject.getPrincipal();
        User usernew = userService.getUserInfoNew(user.getUserId());
        List<LabInformation> labInformation = labInfoService.selectAllLabfloor();
        List<String> Listdate = CusUtile.test(5);
        List<LabInformation> labInformationList = labInfoService.selectLabName();
        List<User> teacherName = userService.selectByFacyulyToTeacherName(usernew.getUserFaculty());
        model.addAttribute("teacherName",teacherName);
        model.addAttribute("labname",labInformationList);
        model.addAttribute("Listdate",Listdate);
        model.addAttribute("user1",usernew);
        model.addAttribute("labfloor",labInformation);
        return "appoint";
    }
    //审核预约实验
    @RequestMapping("/23")
    public String reviewlab(Model model){
        Subject subject = SecurityUtils.getSubject();
        User user =(User)subject.getPrincipal();
        User usernew = userService.getUserInfoNew(user.getUserId());
        List<Exp_Res_Sch_Lab> expResSchLab = expInfoService.selectAllyuyuejieg();
        for (int i=0 ;i<expResSchLab.size();i++){
            Date time = new Date(String.valueOf(expResSchLab.get(i).getReserData()));
            String date =  new SimpleDateFormat("yyyy/MM/dd", Locale.US).format(time);
            expResSchLab.get(i).setScheduledate(date);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String nowdate = simpleDateFormat.format(date);
        for(int i = 0;i<expResSchLab.size();i++){
            int id = expResSchLab.get(i).getReserUserId();
            String name = userService.selectByidToName(id);
            expResSchLab.get(i).setUserName(name);
        }
        model.addAttribute("nowdate",nowdate);
        model.addAttribute("user1",usernew);
        model.addAttribute("expResSchLab",expResSchLab);
        return "reviewlab";
    }
    //提交实验结果
    @RequestMapping("/22")
    public String tjexpresult(Model model){
        Subject subject = SecurityUtils.getSubject();
        User user =(User)subject.getPrincipal();
        User usernew = userService.getUserInfoNew(user.getUserId());
        List<Exp_Res_Sch_Lab> expResSchLab = expInfoService.selectAllyuyuejieg();
        for (int i=0 ;i<expResSchLab.size();i++){
            Date time = new Date(String.valueOf(expResSchLab.get(i).getReserData()));
            String date =  new SimpleDateFormat("yyyy/MM/dd", Locale.US).format(time);
            expResSchLab.get(i).setScheduledate(date);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String nowdate = simpleDateFormat.format(date);
        for(int i = 0;i<expResSchLab.size();i++){
            int id = expResSchLab.get(i).getReserUserId();
            String name = userService.selectByidToName(id);
            expResSchLab.get(i).setUserName(name);
        }
        model.addAttribute("nowdate",nowdate);
        model.addAttribute("user1",usernew);
        model.addAttribute("expResSchLab",expResSchLab);
        return "tjexpresult";
    }
    //审核实验结果
    @RequestMapping("/24")
    public String shexpresult(Model model){
        Subject subject = SecurityUtils.getSubject();
        User user =(User)subject.getPrincipal();
        User usernew = userService.getUserInfoNew(user.getUserId());
        List<ExpResults> expResultsList =  expResultsService.selectAll();
        for(int i = 0;i<expResultsList.size();i++){
            Date time = new Date(String.valueOf(expResultsList.get(i).getExpresultsRiqi()));
            String date =  new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(time);
            expResultsList.get(i).setExpresultriqi(date);
            String id = userService.selectByNameToId(expResultsList.get(i).getExpinformationTeacherName(),usernew.getUserCalss());
            if (id != null){
                expResultsList.get(i).setTeacherNameId(Integer.valueOf(id));
            }
        }
        model.addAttribute("user1",usernew);
        model.addAttribute("expResultsList",expResultsList);
        return "shexpresult";
    }
    //查看实验结果
    @RequestMapping("/25")
    public String viewexpresult(Model model){
        Subject subject = SecurityUtils.getSubject();
        User user =(User)subject.getPrincipal();
        User usernew = userService.getUserInfoNew(user.getUserId());
        List<ExpResults> expResultsList =  expResultsService.selectAll();
        for(int i = 0;i<expResultsList.size();i++){
            Date time = new Date(String.valueOf(expResultsList.get(i).getExpresultsRiqi()));
            String date =  new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(time);
            expResultsList.get(i).setExpresultriqi(date);
        }
        model.addAttribute("user1",usernew);
        model.addAttribute("expResultsList",expResultsList);
        return "viewexpresult";
    }

    //查询实验信息
    @RequestMapping("/18")
    public String expinfo(Model model){
        Subject subject = SecurityUtils.getSubject();
        User user =(User)subject.getPrincipal();
        User usernew = userService.getUserInfoNew(user.getUserId());
        List<Exp_Res_Sch_Lab> expResSchLab = expInfoService.selectAllsyxinxi();
        if(expResSchLab.size() != 0){
            for (int i=0 ;i<expResSchLab.size();i++){
                Date time = new Date(String.valueOf(expResSchLab.get(i).getReserData()));
                String date =  new SimpleDateFormat("yyyy/MM/dd", Locale.US).format(time);
                expResSchLab.get(i).setScheduledate(date);
                String role = userService.getUserRoleNameSet(expResSchLab.get(i).getReserUserId());
                expResSchLab.get(i).setRoleName(role);
            }
            String role = userService.getUserRoleNameSet(user.getUserId());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String nowdate = simpleDateFormat.format(date);
            model.addAttribute("nowdate",nowdate);
            model.addAttribute("role4",role);
            model.addAttribute("user1",usernew);
            model.addAttribute("expResSchLab",expResSchLab);
        }
        return "expinfo";
    }
    //增加实验信息
    @RequestMapping("/19")
    public String addexp(Model model){
        Subject subject = SecurityUtils.getSubject();
        User user =(User)subject.getPrincipal();
        User usernew = userService.getUserInfoNew(user.getUserId());
        List<LabInformation> labInformation = labInfoService.selectAllLabfloor();
        model.addAttribute("user1",usernew);
        model.addAttribute("labfloor",labInformation);
        return "addexp";
    }
    //修改实验信息
    @RequestMapping("/20")
    public String updateexp(Model model){
        Subject subject = SecurityUtils.getSubject();
        User user =(User)subject.getPrincipal();
        User usernew = userService.getUserInfoNew(user.getUserId());
        List<LabInformation> labInformation = labInfoService.selectAllLabfloor();
        List<Exp_Res_Sch_Lab> expResSchLab = expInfoService.selectAllsyxinxi();
        if(labInformation.size() != 0 && expResSchLab.size() != 0){
            for (int i=0 ;i<expResSchLab.size();i++){
                Date time = new Date(String.valueOf(expResSchLab.get(i).getScheduleDate()));
                String date =  new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(time);
                expResSchLab.get(i).setScheduledate(date);
            }
            expResSchLab.get(0).getScheduleDate();
            model.addAttribute("labfloor",labInformation);
            model.addAttribute("user1",usernew);
            model.addAttribute("expResSchLab",expResSchLab);
        }
        return "updateexp";
    }
    //删除实验信息
    @RequestMapping("/21")
    public String deleteexp(Model model){
        Subject subject = SecurityUtils.getSubject();
        User user =(User)subject.getPrincipal();
        User usernew = userService.getUserInfoNew(user.getUserId());
        List<Exp_Res_Sch_Lab> expResSchLab = expInfoService.selectAllsyxinxi();
        if(expResSchLab.size() != 0){
            for (int i=0 ;i<expResSchLab.size();i++){
                Date time = new Date(String.valueOf(expResSchLab.get(i).getScheduleDate()));
                String date =  new SimpleDateFormat("yyyy/MM/dd", Locale.US).format(time);
                expResSchLab.get(i).setScheduledate(date);
            }
            expResSchLab.get(0).getScheduleDate();
            model.addAttribute("user1",usernew);
            model.addAttribute("expResSchLab",expResSchLab);
        }
        return "deleteexp";
    }



}
