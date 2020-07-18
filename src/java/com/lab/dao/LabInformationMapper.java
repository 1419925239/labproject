package com.lab.dao;

import com.lab.bean.LabInformation;
import com.lab.bean.LabInformationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LabInformationMapper {
    long countByExample(LabInformationExample example);

    int deleteByExample(LabInformationExample example);

    int deleteByPrimaryKey(Integer labinformationId);

    int insert(LabInformation record);

    int insertSelective(LabInformation record);

    List<LabInformation> selectByExample(LabInformationExample example);

    LabInformation selectByPrimaryKey(Integer labinformationId);

    int updateByExampleSelective(@Param("record") LabInformation record, @Param("example") LabInformationExample example);

    int updateByExample(@Param("record") LabInformation record, @Param("example") LabInformationExample example);

    int updateByPrimaryKeySelective(LabInformation record);

    int updateByPrimaryKey(LabInformation record);

    //查询所有的实验室信息
    List<LabInformation> selectAll();

    List<LabInformation> selectAllFloor();

    //根据实验室名查询id
    String selectByNameToId(String s);

    List<LabInformation> selectLabName();
}