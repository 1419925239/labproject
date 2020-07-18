package com.lab.service;

import com.lab.bean.Schedule;
import com.lab.bean.ScheduleExample;
import com.lab.dao.ScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张占恒.
 * @date 2020/2/27.
 * @time 16:25.
 */
@Service
public class ScheduleService {
    @Autowired
    ScheduleMapper scheduleMapper;
    //插入排期时间
    public String insertone(Schedule schedule) {
        return String.valueOf(scheduleMapper.insertSelective(schedule));
    }
    //删除排期时间
    public String deleteinfo(String schedId) {
        return String.valueOf(scheduleMapper.deleteByPrimaryKey(Integer.valueOf(schedId)));
    }
    //根据实验室名字查询排期表
    public List<Schedule> selectBylabnameToschedu(String labname) {
        return scheduleMapper.selectBylabnameToschedu(labname);
    }
    //修改排期时间
    public String updateschedule(Schedule schedule) {
        int id = schedule.getScheduleId();
        ScheduleExample scheduleExample = new ScheduleExample();
        scheduleExample.createCriteria().andScheduleIdEqualTo(id);
        return String.valueOf(scheduleMapper.updateByExampleSelective(schedule,scheduleExample));
    }

    public String selectOneByDateAndLabid(String labid, String s) {
        return scheduleMapper.selectOneByDateAndLabid(labid,s);
    }

    public String addnum(String selectone, String s) {
        Schedule schedule = scheduleMapper.selectByPrimaryKey(Integer.valueOf(selectone));
        int num1= schedule.getT1();
        int num2 = schedule.getT2();
        int num3 = schedule.getT3();
        if ("1".equals(s)){
            int num4 = num1 +1;
            schedule.setT1(num4);
            int id = Integer.parseInt(selectone);
            ScheduleExample scheduleExample = new ScheduleExample();
            scheduleExample.createCriteria().andScheduleIdEqualTo(id);
            int resoult = scheduleMapper.updateByExampleSelective(schedule,scheduleExample);
            if(resoult != 1){
                return "0";
            }
        }else if("2".equals(s)){
            int num5 = num2 +1;
            schedule.setT2(num5);
            int id = Integer.parseInt(selectone);
            ScheduleExample scheduleExample = new ScheduleExample();
            scheduleExample.createCriteria().andScheduleIdEqualTo(id);
            int resoult = scheduleMapper.updateByExampleSelective(schedule,scheduleExample);
            if(resoult != 1){
                return "0";
            }
        }else if("3".equals(s)){
            int num6 = num3 +1;
            schedule.setT3(num6);
            int id = Integer.parseInt(selectone);
            ScheduleExample scheduleExample = new ScheduleExample();
            scheduleExample.createCriteria().andScheduleIdEqualTo(id);
            int resoult = scheduleMapper.updateByExampleSelective(schedule,scheduleExample);
            if(resoult != 1){
                return "0";
            }
        }
        return "1";
    }
}
