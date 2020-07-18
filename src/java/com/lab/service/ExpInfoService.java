package com.lab.service;

import com.lab.bean.ExpInformationExample;
import com.lab.bean.ExpInformationWithBLOBs;
import com.lab.bean.Exp_Res_Sch_Lab;
import com.lab.dao.ExpInformationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张占恒.
 * @date 2020/2/24.
 * @time 15:40.
 */
@Service
public class ExpInfoService {
    @Autowired
    ExpInformationMapper expInformationMapper;
    //查询所有关联的信息
    public List<Exp_Res_Sch_Lab> selectAll(){
        return expInformationMapper.selectAll();
    }
    //增加实验
    public String insertexp(ExpInformationWithBLOBs expInformation) {
        return String.valueOf(expInformationMapper.insertSelective(expInformation));
    }
    //判断实验是否已经存在
    public String countByName(String s) {
        String expname =s;
        ExpInformationExample example = new ExpInformationExample();
        example.createCriteria().andExpinformationNameEqualTo(expname);
        return String.valueOf(expInformationMapper.countByExample(example));
    }
    //根据实验的名字来查询此实验的id
    public String selectByNameToId(String s) {
       return expInformationMapper.selectByNameToId(s);
    }
    //删除实验信息
    public String deleteinfo(String expId) {
        return String.valueOf(expInformationMapper.deleteByPrimaryKey(Integer.valueOf(expId)));
    }
    //修改实验信息
    public String updateexp(ExpInformationWithBLOBs expInformationWithBLOBs) {
        int id = expInformationWithBLOBs.getExpinformationId();
        ExpInformationExample expInformationExample = new ExpInformationExample();
        expInformationExample.createCriteria().andExpinformationIdEqualTo(id);
        return String.valueOf(expInformationMapper.updateByExampleSelective(expInformationWithBLOBs,expInformationExample));

    }
    //修改实验状态,通过
    public String updatestatus(String exid) {
        ExpInformationWithBLOBs expInformationWithBLOBs = new ExpInformationWithBLOBs();
        expInformationWithBLOBs.setExpinformationStatus(0);
        int id = Integer.parseInt(exid);
        ExpInformationExample expInformationExample = new ExpInformationExample();
        expInformationExample.createCriteria().andExpinformationIdEqualTo(id);
        return String.valueOf(expInformationMapper.updateByExampleSelective(expInformationWithBLOBs,expInformationExample));
    }
    //修改实验状态,不通过
    public String updatestatus1(String exid) {
        ExpInformationWithBLOBs expInformationWithBLOBs = new ExpInformationWithBLOBs();
        expInformationWithBLOBs.setExpinformationStatus(1);
        int id = Integer.parseInt(exid);
        ExpInformationExample expInformationExample = new ExpInformationExample();
        expInformationExample.createCriteria().andExpinformationIdEqualTo(id);
        return String.valueOf(expInformationMapper.updateByExampleSelective(expInformationWithBLOBs,expInformationExample));
    }

    public String isexit(String valueOf, String s, String s1) {
        return expInformationMapper.isexit(valueOf,s,s1);
    }

    public List<Exp_Res_Sch_Lab> selectAllyuyuejieg() {
        return expInformationMapper.selectAllyuyuejieg();
    }
    //查询实验信息
    public List<Exp_Res_Sch_Lab> selectAllsyxinxi() {
        return  expInformationMapper.selectAllsyxinxi();
    }
}
