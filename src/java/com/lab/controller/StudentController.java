package com.lab.controller;

import com.lab.bean.*;
import com.lab.service.*;
import com.lab.utils.CusUtile;
import com.lab.utils.R;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 张占恒.
 * @date 2020/2/5.
 * @time 16:53.
 */
@Controller
public class StudentController {

    @Autowired
    StudentService studentService;
    @Autowired
    LabInfoService labInfoService;
    @Autowired
    ScheduleService scheduleService;
    @Autowired
    ExpInfoService expInfoService;
    @Autowired
    ReservationService reservationService;
    @Autowired
    UserService userService;
    @Autowired
    ExpResultsService expResultsService;
    //修改个人信息
    @RequestMapping("/updateUser")
    @ResponseBody
    public R updateUser(@RequestParam Map<String,Object> map){
        System.out.println(map);
        List<String> list = new ArrayList<>();
        for (String key:map.keySet()) {
            list.add((String) map.get(key));
        }
        System.out.println(list);
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
    //根据实验室名查出排期表
    @RequestMapping(value = "/selectBylabnameToschedu",method = RequestMethod.POST)
    @ResponseBody
    public R selectlabnameschedule(@RequestParam String labname){
        List<String> FetureDate = CusUtile.test(5);
        List<Schedule> scheduleList1 = scheduleService.selectBylabnameToschedu(labname);
        List<LabInformation> labInformationList1 = labInfoService.selectByNameToInfo(labname);
        List listinfo = new ArrayList();
        listinfo.add(FetureDate);
        listinfo.add(scheduleList1);
        listinfo.add(labInformationList1);
        System.out.println(listinfo);
        return R.ok("请求成功",listinfo);
    }

    //个人预约申请
    @RequestMapping("/sqzhaoshang")
    @ResponseBody
    public R sqzhaoshang(@RequestParam Map<String,Object> map) throws ParseException {
        List<String> list = new ArrayList<>();
        for (String key:map.keySet()) {
            list.add((String) map.get(key));
        }
        //插入实验
        ExpInformationWithBLOBs expInformationWithBLOBs = new ExpInformationWithBLOBs();
        expInformationWithBLOBs.setExpinformationFaculty(list.get(0));
        expInformationWithBLOBs.setExpinformationType(list.get(4));
        expInformationWithBLOBs.setExpinformationTeacherName(list.get(2));
        expInformationWithBLOBs.setExpinformationName(list.get(3));
        expInformationWithBLOBs.setExpinformationPurpose(list.get(5));
        expInformationWithBLOBs.setExpinformationStep(list.get(6));
        expInformationWithBLOBs.setExpinformationIns(list.get(7));
        expInformationWithBLOBs.setExpinformationStatus(1);
        //插入实验
        String panduan = expInfoService.insertexp(expInformationWithBLOBs);
        //转化日期类型
        String strDate = list.get(9);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date123 = formatter.parse(strDate);
        //查询实验室id
        String labid = labInfoService.selectByNametoID(list.get(8));

        Schedule schedule = new Schedule();
        schedule.setLabId(Integer.valueOf(labid));
        schedule.setScheduleDate(date123);
        if ("1".equals(list.get(10))){
            schedule.setT1(1);
            schedule.setT2(0);
            schedule.setT3(0);
        }else if("2".equals(list.get(10))){
            schedule.setT1(0);
            schedule.setT2(1);
            schedule.setT3(0);
        }else if("3".equals(list.get(10))){
            schedule.setT1(0);
            schedule.setT2(0);
            schedule.setT3(1);
        }
        if("1".equals(panduan)){
            String expid = expInfoService.selectByNameToId(list.get(3));
            Reservation reservation = new Reservation();
            reservation.setReserLabid(Integer.valueOf(labid));
            reservation.setReserUserId(Integer.valueOf(list.get(11)));
            reservation.setReserExpid(Integer.valueOf(expid));
            reservation.setReserType(1);
            reservation.setReserDatatime(Integer.valueOf(list.get(10)));
            reservation.setReserData(date123);
            reservation.setReserStatus(1);
            reservation.setReserCreattime(new Date());
            String pandianres = reservationService.inserone(reservation);
            String selectone = scheduleService.selectOneByDateAndLabid(labid,list.get(9));
            if(selectone != null){
                String res = scheduleService.addnum(selectone,list.get(10));
                if ("0".equals(res)){
                    return R.error("添加人数预约失败！");
                }
            }else {
                String insertone = scheduleService.insertone(schedule);
                if("1".equals(insertone)){
                    return R.ok();
                }else {
                    return R.error("插入排期表预约失败！");
                }
            }
            return R.error("预约失败！");
        }else {
            return R.error("插入实验预约失败！");
        }

    }
    //通过实验室名显示排期表格
    @RequestMapping("/viewBylabNametotable")
    @ResponseBody
    public R viewBylabNametotable(@RequestParam String shiyansh){
        Subject subject = SecurityUtils.getSubject();
        User user =(User)subject.getPrincipal();
        User usernew = userService.getUserInfoNew(user.getUserId());
        List<Exp_Res_Sch_Lab> expResSchLab1 = expInfoService.selectAll();
        for (int i=0 ;i<expResSchLab1.size();i++){
            Date time = new Date(String.valueOf(expResSchLab1.get(i).getScheduleDate()));
            String date =  new SimpleDateFormat("yyyy/MM/dd", Locale.US).format(time);
            expResSchLab1.get(i).setScheduledate(date);
            String role = userService.getUserRoleNameSet(expResSchLab1.get(i).getReserUserId());
            expResSchLab1.get(i).setRoleName(role);
        }
        String role = userService.getUserRoleNameSet(user.getUserId());
        List stringList = new ArrayList<>();
        stringList.add(role);
        stringList.add(expResSchLab1);
        stringList.add(shiyansh);
        return R.ok("请求成功",stringList);
    }
    //提交实验结果
    @RequestMapping("/tjshiyanjieguo")
    @ResponseBody
    public R tjshiyanjieguo(@RequestParam Map<String,Object> map ) throws ParseException {
        List<String> list = new ArrayList<>();
        for (String key:map.keySet()) {
            list.add((String) map.get(key));
        }
        //转化日期类型
        String strDate = list.get(6);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        Date date123 = formatter.parse(strDate);

        ExpResults expResults = new ExpResults();
        expResults.setExpresultsId(Integer.valueOf(list.get(0)));
        expResults.setExpresultsName(list.get(1));
        expResults.setExpresultsFauclty(list.get(2));
        expResults.setExpresultsCalss(list.get(3));
        expResults.setExpresultsAnalysis(list.get(4));
        expResults.setExpresultsFinish(list.get(5));
        expResults.setExpresultsRiqi(date123);
        expResults.setErpresultsShijianduan(Integer.valueOf(list.get(7)));
        expResults.setExpresultsStatus(1);
        String panduan = expResultsService.insertone(expResults);
        if ("1".equals(panduan)){
            return R.ok();
        }else {
            return R.error("提交失败！");
        }

    }
    //课堂预约
    @RequestMapping("/ketangyuyue")
    @ResponseBody
    public R ketangyuyue(@RequestParam Map<String,Object> map) throws ParseException {
        List<String> list = new ArrayList<>();
        for (String key:map.keySet()) {
            list.add((String) map.get(key));
        }
        String strDate = list.get(4);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        Date date123 = formatter.parse(strDate);
        String panduan = scheduleService.addnum(list.get(1),list.get(3));
        Reservation reservation = new Reservation();
        reservation.setReserUserId(Integer.valueOf(list.get(5)));
        reservation.setReserLabid(Integer.valueOf(list.get(2)));
        reservation.setReserExpid(Integer.valueOf(list.get(0)));
        reservation.setReserType(2);
        reservation.setReserDatatime(Integer.valueOf(list.get(3)));
        reservation.setReserData(date123);
        reservation.setReserStatus(1);
        reservation.setReserCreattime(new Date());
        String panduan1 = reservationService.inserone(reservation);
        if("1".equals(panduan)&&"1".equals(panduan1)){
            return R.ok();
        }else {
            return R.error("预约失败！");
        }

    }
    //开放预约
    @RequestMapping("/kaifangshenqing")
    @ResponseBody
    public R kaifangshenqing(@RequestParam Map<String,Object> map) throws ParseException {
        List<String> list = new ArrayList<>();
        for (String key:map.keySet()) {
            list.add((String) map.get(key));
        }
        String strDate = list.get(4);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        Date date123 = formatter.parse(strDate);
        String panduan = scheduleService.addnum(list.get(1),list.get(3));
        Reservation reservation = new Reservation();
        reservation.setReserUserId(Integer.valueOf(list.get(5)));
        reservation.setReserLabid(Integer.valueOf(list.get(2)));
        reservation.setReserExpid(Integer.valueOf(list.get(0)));
        reservation.setReserType(2);
        reservation.setReserDatatime(Integer.valueOf(list.get(3)));
        reservation.setReserData(date123);
        reservation.setReserStatus(1);
        reservation.setReserCreattime(new Date());
        String panduan1 = reservationService.inserone(reservation);
        if("1".equals(panduan)&&"1".equals(panduan1)){
            return R.ok();
        }else {
            return R.error("预约失败！");
        }
    }
    //根据实验室，实验时间，实验时间段判断当前时间段是否有课堂实验
    @RequestMapping("/panduan")
    @ResponseBody
    public R panduan(@RequestParam Map<String,Object> map){
        List<String> list = new ArrayList<>();
        for (String key:map.keySet()) {
            list.add((String) map.get(key));
        }
        String id = labInfoService.selectByNametoID(list.get(2));
        String pan = reservationService.selectcount(id,list.get(0),list.get(1));
        if (pan == null){
            return R.ok();
        }else {
            return R.error("该实验室已有课堂实验存在！");
        }
    }
}
