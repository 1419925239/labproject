package com.lab.dao;

import com.lab.bean.ExpInformation;
import com.lab.bean.ExpInformationExample;
import com.lab.bean.ExpInformationWithBLOBs;
import java.util.List;

import com.lab.bean.Exp_Res_Sch_Lab;
import org.apache.ibatis.annotations.Param;

public interface ExpInformationMapper {
    long countByExample(ExpInformationExample example);

    int deleteByExample(ExpInformationExample example);

    int deleteByPrimaryKey(Integer expinformationId);

    int insert(ExpInformationWithBLOBs record);

    int insertSelective(ExpInformationWithBLOBs record);

    List<ExpInformationWithBLOBs> selectByExampleWithBLOBs(ExpInformationExample example);

    List<ExpInformation> selectByExample(ExpInformationExample example);

    ExpInformationWithBLOBs selectByPrimaryKey(Integer expinformationId);

    int updateByExampleSelective(@Param("record") ExpInformationWithBLOBs record, @Param("example") ExpInformationExample example);

    int updateByExampleWithBLOBs(@Param("record") ExpInformationWithBLOBs record, @Param("example") ExpInformationExample example);

    int updateByExample(@Param("record") ExpInformation record, @Param("example") ExpInformationExample example);

    int updateByPrimaryKeySelective(ExpInformationWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ExpInformationWithBLOBs record);

    int updateByPrimaryKey(ExpInformation record);
    //查询实验信息
    List<Exp_Res_Sch_Lab> selectAll();

    String selectByNameToId(String s);
    //判断该实验室在该时间段是否已经被占用
    String isexit(String valueOf, String s, String s1);

    List<Exp_Res_Sch_Lab> selectAllyuyuejieg();
    //查看实验信息
    List<Exp_Res_Sch_Lab> selectAllsyxinxi();
}