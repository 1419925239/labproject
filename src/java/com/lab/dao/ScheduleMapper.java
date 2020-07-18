package com.lab.dao;

import com.lab.bean.Schedule;
import com.lab.bean.ScheduleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScheduleMapper {
    long countByExample(ScheduleExample example);

    int deleteByExample(ScheduleExample example);

    int deleteByPrimaryKey(Integer scheduleId);

    int insert(Schedule record);

    int insertSelective(Schedule record);

    List<Schedule> selectByExample(ScheduleExample example);

    Schedule selectByPrimaryKey(Integer scheduleId);

    int updateByExampleSelective(@Param("record") Schedule record, @Param("example") ScheduleExample example);

    int updateByExample(@Param("record") Schedule record, @Param("example") ScheduleExample example);

    int updateByPrimaryKeySelective(Schedule record);

    int updateByPrimaryKey(Schedule record);

    List<Schedule> selectBylabnameToschedu(String labname);

    String selectOneByDateAndLabid(String labid, String s);
}