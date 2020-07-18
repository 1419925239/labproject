package com.lab.controller;

import com.lab.bean.*;
import com.lab.service.*;
import com.lab.utils.CusUtile;
import com.lab.utils.POI.ExcelPoi;
import com.lab.utils.ParseExcel;
import com.lab.utils.R;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 张占恒.
 * @date 2020/2/5.
 * @time 16:53.
 */
@Controller
public class TeacherController {
    @Autowired
    UserService userService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    StudentService studentService;
    @Autowired
    ExpInfoService expInfoService;
    @Autowired
    LabInfoService labInfoService;
    @Autowired
    ScheduleService scheduleService;
    @Autowired
    ReservationService service;
    @Autowired
    ExpResultsService expResultsService;
    //学生管理
    @RequestMapping("/studentdata")
    @ResponseBody
    public R StudentDate(@RequestParam Integer page ,Integer limit){
        System.out.println(limit+"---------------"+page);
        List<UserInfo> menuList = teacherService.selectStudent(1,page,limit);
        String count = String.valueOf(teacherService.selectStudentCount(1));
        return  R.table(count,menuList);
    }
    //删除学生
    @RequestMapping("/deletestudent")
    @ResponseBody
    public R deleteStdudent(@RequestParam Map<String,Object> map){
        List<String> list = new ArrayList<>();
        for (String key:map.keySet()) {
            list.add((String) map.get(key));
        }
        String id = list.get(0);
        teacherService.deleteStudent(id);
        return R.ok();
    }
    //修改学生数据
    @RequestMapping("/updateStudent")
    @ResponseBody
    public R updateStudent(@RequestParam Map<String,Object> map){
        List<String> list = new ArrayList<>();
        for (String key:map.keySet()) {
            list.add((String) map.get(key));
        }
        User us = new User();
        us.setUserId(Integer.valueOf(list.get(0)));
        us.setUserPassword(list.get(1));
        us.setUserName(list.get(2));
        us.setUserFaculty(list.get(3));
        us.setUserCalss(list.get(4));
        us.setUserPhone(list.get(5));
        us.setUserStatus(0);
        us.setUserDelete(0);
        String re = studentService.updateUser(us);
        if ("1".equals(re)){
            return R.ok();
        }else {
            return R.error("数据修改失败！");
        }
    }
    //增加实验
    @RequestMapping("/addexp")
    @ResponseBody
    public R addexp(@RequestParam Map<String,Object> map) throws ParseException {
        List<String> list = new ArrayList<>();
        for (String key:map.keySet()) {
            list.add((String) map.get(key));
        }
        System.out.println(list);
        String pandu = expInfoService.countByName(list.get(2));
        if ("1".equals(pandu)){
            return R.error("此实验已存在！");
        }
        //插入实验
        ExpInformationWithBLOBs expInformation = new ExpInformationWithBLOBs();
        expInformation.setExpinformationFaculty(list.get(0));
        expInformation.setExpinformationType(list.get(1));
        expInformation.setExpinformationName(list.get(2));
        expInformation.setExpinformationTeacherName(list.get(3));
        expInformation.setExpinformationPurpose(list.get(4));
        expInformation.setExpinformationIns(list.get(5));
        expInformation.setExpinformationStep(list.get(6));
        expInformation.setExpinformationStatus(0);
        String p = expInfoService.insertexp(expInformation);
        if ("1".equals(p)){
            System.out.println("插入实验成功");
        }

        //根据实验室查询labid
        String labid = labInfoService.selectByNametoID(list.get(8));

        String strDate = list.get(9);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(strDate);
        //插入实验日期排表
        Schedule schedule = new Schedule();
        schedule.setScheduleDate(date);
        schedule.setLabId(Integer.valueOf(labid));
        schedule.setT1(0);
        schedule.setT2(0);
        schedule.setT3(0);
        String p1 = scheduleService.insertone(schedule);
        if ("1".equals(p1)){
            System.out.println("插入实验日期成功");
        }
        //星期
        String week = "星期"+CusUtile.getweek(list.get(9));
        //时间段
        String time = list.get(10);
        //用户的id
        String userid = list.get(11);

        //查询刚插入实验的id
        String expid = expInfoService.selectByNameToId(list.get(2));
        //判断该预约是否存在
        String yuyuebiaopanduan = expInfoService.isexit(labid,list.get(10),list.get(9));
        if( yuyuebiaopanduan != ""){
            //插入预约表
            Reservation reservation = new Reservation();
            reservation.setReserLabid(Integer.valueOf(labid));
            reservation.setReserUserId(Integer.valueOf(userid));
            reservation.setReserExpid(Integer.valueOf(expid));
            reservation.setReserType(2);
            reservation.setReserDatatime(Integer.valueOf(list.get(10)));
            reservation.setReserData(date);
            String p2 = service.inserone(reservation);
            if ("1".equals(p2)){
                System.out.println("插入预约表成功");
            }
        }else {
            return R.error("该实验室在该时间段已被占用！");
        }



      return R.ok();

    }
    //根据实验室楼查实验室名
    @RequestMapping("/selectfloorlab")
    @ResponseBody
    public R labfloorname(@RequestParam String labfloor1){
        List<LabInformation> list2 = labInfoService.selectByFloorToName(labfloor1);

        List<String>  list4 = new ArrayList<>() ;
        for (int i = 0;i<list2.size();i++){
            list4.add(list2.get(i).getLabinformationName());
        }
        return R.ok( "请求成功", list4);
    }
    //删除实验信息
    @RequestMapping("/deleteexpinfo")
    @ResponseBody
    public R expdelete(@RequestParam String resId,String schedId,String expId){

        String resdeleteinfo = service.deleteinfo(resId);
        String scheddeleteinfo = scheduleService.deleteinfo(schedId);
        String expdeleteinfo = expInfoService.deleteinfo(expId);
        if ("1".equals(resdeleteinfo)&&"1".equals(scheddeleteinfo)&&"1".equals(expdeleteinfo)){
            return R.ok();
        }else {
            return R.error("删除错误！");
        }
    }
    //查询所有实验楼
    @RequestMapping("/selectAlllabfloor1")
    @ResponseBody
    public R selectAlllabfloor1(){
        List<LabInformation> labInformation = labInfoService.selectAllLabfloor();
        return R.ok("请求成功",labInformation);
    }
    //查询所有实验室
    @RequestMapping("/selectAlllabName1")
    @ResponseBody
    public R selectAlllabName1(){
        List<LabInformation> labInformation = labInfoService.selectLabName();
        return R.ok("请求成功",labInformation);
    }
    //修改实验信息
    @RequestMapping("/updateexp1")
    @ResponseBody
    public R updateexp1(@RequestParam Map<String,Object> map) throws ParseException {
        List<String> list = new ArrayList<>();
        for (String key:map.keySet()) {
            list.add((String) map.get(key));
        }
        Subject subject = SecurityUtils.getSubject();
        User user =(User)subject.getPrincipal();

        ExpInformationWithBLOBs expInformationWithBLOBs = new ExpInformationWithBLOBs();
        expInformationWithBLOBs.setExpinformationId(Integer.valueOf(list.get(4)));
        expInformationWithBLOBs.setExpinformationName(list.get(0));

        Schedule schedule = new Schedule();
        String data = list.get(3);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(data);
        schedule.setScheduleDate(date);
        schedule.setScheduleId(Integer.valueOf(list.get(5)));

        String id = labInfoService.selectByNametoID(list.get(2));

        Reservation reservation = new Reservation();
        reservation.setReserLabid(Integer.valueOf(id));
        reservation.setReserData(date);
        reservation.setResId(Integer.valueOf(list.get(6)));
        reservation.setReserExpid(Integer.valueOf(list.get(4)));
        reservation.setReserUserId(user.getUserId());

        String expan = expInfoService.updateexp(expInformationWithBLOBs);
        String schpan = scheduleService.updateschedule(schedule);
        String respan = service.updateres(reservation);

        if("1".equals(expan)&&"1".equals(schpan)&&"1".equals(respan)){
            return R.ok();
        }else {
            return R.error("请求错误！");
        }


    }
    //通过
    @RequestMapping("/tongguo")
    @ResponseBody
    public R tongguo(@RequestParam String exid,String reid){
        if(exid != null && reid != null){
            String updateexpstatus = expInfoService.updatestatus(exid);
            if ("1".equals(updateexpstatus)){
                String updateresstatus = service.updatestatus(reid);
                if("1".equals(updateresstatus)){
                    return R.ok();
                }else {
                    return R.error("修改失败！");
                }
            }else {
                return R.error("修改失败！");
            }

        }else {
            return R.error("修改失败！");
        }

    }
    //不通过
    @RequestMapping("/butongguo")
    @ResponseBody
    public R butongguo(@RequestParam String exid,String reid){
        if(exid != null && reid != null){
            String updateexpstatus = expInfoService.updatestatus1(exid);
            if ("1".equals(updateexpstatus)){
                String updateresstatus = service.updatestatus1(reid);
                if("1".equals(updateresstatus)){
                    return R.ok();
                }else {
                    return R.error("修改失败！");
                }
            }else {
                return R.error("修改失败！");
            }

        }else {
            return R.error("修改失败！");
        }
    }
    //审核通过实验结果
    @RequestMapping("/tongguoexpr")
    @ResponseBody
    public R tongguoexpr(@RequestParam String expr){
        if (expr != null){
            Integer i = 0;
            String panduan = expResultsService.updateone(expr,i);
            if ("1".equals(panduan)){
                return R.ok();
            }else {
                return  R.error("修改失败！");
            }
        }else {
           return R.error("修改失败！");
        }
    }
    //审核不通过实验结果
    @RequestMapping("/butongguoexpr")
    @ResponseBody
    public R butongguoexpr(@RequestParam String expr){
        if(expr != null){
            Integer i =1 ;
            String panduan = expResultsService.updateone(expr,i);
            if ("1".equals(panduan)){
                return R.ok();
            }else {
              return   R.error("修改失败！");
            }
        }else {
            return R.error("修改成功！");
        }

    }


    @RequestMapping("/exportUserAllList")
    @ResponseBody
    public String exportCustomerList(HttpServletResponse response, String search) {
        try {
            List<User> date = userService.findAllstudent();
            //customService.getCustomList();
            String[] titles = { "学号/工号", "姓名", "班级", "学院","手机号" };
            String filename = "学生表";
            //打印信息
            Iterator<User> iterator=date.iterator();
            while (iterator.hasNext())
            {
                User user=(User)iterator.next();
                System.out.println(user.getUserId()+" "+user.getUserName());
            }
            ExcelPoi.exportObject(response, date, titles, filename);
        } catch (Exception e) {

        }
        return "";
    }

    @RequestMapping(value = "/importstudentdata",method = RequestMethod.POST)
    public R importstudentdata(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 转型为MultipartHttpRequest：
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        // 获得文件：
        MultipartFile file = multipartRequest.getFile("file");

        System.out.println(file);
        User user=new User();
        InputStream inputStream=null;
        try {
            //输入流
            inputStream = file.getInputStream();
            //原始文件名
            String originalFilename = file.getOriginalFilename();
            //文件后缀
            String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            ParseExcel parser = new ParseExcel();
            //第二行开始读取
            int startRow = 1;
            List<String[]> resultList = parser.parseExcel(inputStream, suffix, startRow);
            int count=0;
            for(String[] ss : resultList){
                user=new User();
                user.setUserId(Integer.valueOf(ss[0]));
                user.setUserName(ss[1]);
                user.setUserPassword(ss[0]);
                user.setUserCalss(ss[2]);
                user.setUserFaculty(ss[3]);
                user.setUserPhone(ss[4]);
                //导入学生信息进入数据库
                int i = userService.importUser(user,"学生");
                if(i==1){
                    count++;
                }
            }
            if(count==resultList.size()){
                //全部数据导入成功
                return R.ok("数据已全部导入成功!");
            }else {
                return R.error("出现异常,仅部分数据导入成功!");
            }

        } catch (IOException e) {
            e.printStackTrace();
            return R.error("导入失败!请稍后再试!");
        } finally {
            //关闭流
            inputStream.close();
        }
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public R addUser(@RequestParam Map<String,Object> map){
        List<String> list = new ArrayList<>();
        for (String key:map.keySet()) {
            list.add((String) map.get(key));
        }
        User user = new User();
        user.setUserId(Integer.valueOf(list.get(0)));
        user.setUserPassword(list.get(1));
        user.setUserName(list.get(2));
        user.setUserFaculty(list.get(3));
        user.setUserCalss(list.get(4));
        user.setUserPhone(list.get(5));
        String panduan = userService.insertoneUser(user);
        if ("1".equals(panduan)){
            return R.ok();
        }else {
            return R.error("插入失败!");
        }
    }


    }
