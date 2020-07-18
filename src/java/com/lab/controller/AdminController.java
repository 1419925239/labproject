package com.lab.controller;

import com.lab.bean.LabInformation;
import com.lab.bean.Schedule;
import com.lab.bean.User;
import com.lab.bean.UserInfo;
import com.lab.service.*;
import com.lab.utils.POI.ExcelPoi;
import com.lab.utils.ParseExcel;
import com.lab.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author 张占恒.
 * @date 2020/2/22.
 * @time 17:01.
 */
@Controller
public class AdminController {
    @Autowired
    TeacherService teacherService;
    @Autowired
    LabInfoService labInfoService;
    @Autowired
    StudentService studentService;
    @Autowired
    UserService userService;
    @Autowired
    ScheduleService scheduleService;

    //教师管理
    @RequestMapping("/Teacherdata")
    @ResponseBody
    public R StudentDate(@RequestParam Integer page ,Integer limit){
        List<UserInfo> menuList = teacherService.selectStudent(2,page,limit);
        String count = String.valueOf(teacherService.selectStudentCount(2));
        return  R.table(count,menuList);
    }
    //删除学生
    @RequestMapping("/deleteTeacher")
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
    //修改老师数据
    @RequestMapping("/updateTeacher")
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
    //修改实验室数据
    @RequestMapping("/labinfoupdate")
    @ResponseBody
    public R lablist(@RequestParam Map<String,Object> map){
        List<String> list = new ArrayList<>();
        for (String key:map.keySet()) {
            list.add((String) map.get(key));
        }
        LabInformation labInformation = new LabInformation();
        labInformation.setLabinformationId(Integer.valueOf(list.get(0)));
        labInformation.setLabinformationFloor(list.get(1));
        labInformation.setLabinformationName(list.get(2));
        labInformation.setLabinformationNum(Integer.valueOf(list.get(3)));
        labInformation.setLabinformationSykj(Integer.valueOf(list.get(4)));
        labInformation.setLabinformationDescription(list.get(5));
        String p = labInfoService.updatelab(labInformation);
        if(list.get(4).equals("0")){
            if ("1".equals(p)){
                return  R.ok();
            }else {
                return R.error("数据修改失败！");
            }
        }else {
            Schedule schedule = new Schedule();
            schedule.setLabId(Integer.valueOf(list.get(0)));
            schedule.setT3(Integer.valueOf(list.get(4)));
            schedule.setT2(Integer.valueOf(list.get(4)));
            schedule.setT1(Integer.valueOf(list.get(4)));
            String p1 = scheduleService.updateschedule(schedule);
            if ("1".equals(p)){
                return  R.ok();
            }else {
                return R.error("数据修改失败！");
            }
        }

    }
    //增加实验室
    @RequestMapping("/addlab")
    @ResponseBody
    public R labadd(@RequestParam Map<String,Object> map){
        List<String> list = new ArrayList<>();
        for (String key:map.keySet()) {
            list.add((String) map.get(key));
        }
        LabInformation labInformation = new LabInformation();
        labInformation.setLabinformationFloor(list.get(0));
        labInformation.setLabinformationName(list.get(1));
        labInformation.setLabinformationNum(Integer.valueOf(list.get(2)));
        labInformation.setLabinformationSykj(Integer.valueOf(list.get(3)));
        labInformation.setLabinformationDescription(list.get(4));
        String count = labInfoService.countname(labInformation.getLabinformationName());
        if ("1".equals(count)){
            return R.error("数据添加失败！,该实验室已存在.");
        }else{
            String p = labInfoService.addlab(labInformation);
            if ("1".equals(p)){
                return  R.ok();
            }else {
                return R.error("数据添加失败！");
            }
        }

    }

    @RequestMapping("/labdelete")
    @ResponseBody
    public R deletelab(@RequestParam String labid){
        String result =  labInfoService.deleteLab(labid);
        if ("1".equals(result)){
            return R.ok();
        }else {
            return R.error("数据删除失败！");
        }

    }
    @RequestMapping("/exportTeacherAllList")
    @ResponseBody
    public String exportCustomerList(HttpServletResponse response, String search) {
        try {
            List<User> date = userService.findAllTeacher();
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
    @RequestMapping(value = "/importTeacherdata",method = RequestMethod.POST)
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
                int i = userService.importUser(user,"老师");
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

    @RequestMapping("/addTeacher")
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
        int panduan = userService.importUser(user,"老师");
        if (panduan == 1){
            return R.ok();
        }else {
            return R.error("插入失败!");
        }
    }
}
