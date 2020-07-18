package com.lab.service;

import com.lab.bean.LabInformation;
import com.lab.bean.LabInformationExample;
import com.lab.dao.LabInformationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张占恒.
 * @date 2020/2/23.
 * @time 11:33.
 */
@Service
public class LabInfoService {
    @Autowired
    LabInformationMapper labInformationMapper;
    //查询所有的实验室
    public List<LabInformation> selectAllLabInfo() {
        return labInformationMapper.selectAll();
    }
    //查询单个实验室
    public LabInformation selectonelab(int id) {
        return labInformationMapper.selectByPrimaryKey(id);
    }
    //修改实验室
    public String updatelab(LabInformation labInformation) {
        int id = labInformation.getLabinformationId();
        LabInformationExample labInformationExample = new LabInformationExample();
        labInformationExample.createCriteria().andLabinformationIdEqualTo(id);
        return String.valueOf(labInformationMapper.updateByExampleSelective(labInformation,labInformationExample));
    }
    //增加实验室
    public String addlab(LabInformation labInformation) {
        return String.valueOf(labInformationMapper.insertSelective(labInformation));
    }
    //按照实验室名统计实验室数量以方便判断
    public String countname(String labinformationName) {
        LabInformationExample labInformationExample = new LabInformationExample();
        labInformationExample.createCriteria().andLabinformationNameEqualTo(labinformationName);
        return String.valueOf(labInformationMapper.countByExample(labInformationExample));
    }
    //删除实验室
    public String deleteLab(String labid) {
        int id = Integer.parseInt(labid);
        return String.valueOf(labInformationMapper.deleteByPrimaryKey(id));
    }
    //查询所有的实验楼
    public List<LabInformation> selectAllLabfloor() {
        return labInformationMapper.selectAllFloor();
    }

    //查询楼号对应的实验室
    public List<LabInformation> selectByFloorToName(String labfloor1) {
        String expfloorname = labfloor1;
        LabInformationExample labInformationExample = new LabInformationExample();
        labInformationExample.createCriteria().andLabinformationFloorEqualTo(expfloorname);
        return labInformationMapper.selectByExample(labInformationExample);
    }
    //根据实验室查询其id
    public String selectByNametoID(String s) {
        return labInformationMapper.selectByNameToId(s);
    }
    //查询所有的实验室
    public List<LabInformation> selectLabName() {
        return labInformationMapper.selectLabName();
    }
    //根据实验名查询该实验的所有信息
    public List<LabInformation> selectByNameToInfo(String labname) {
        String Labname = labname;
        LabInformationExample labInformationExample = new LabInformationExample();
        labInformationExample.createCriteria().andLabinformationNameEqualTo(Labname);
        return labInformationMapper.selectByExample(labInformationExample);
    }
}
