package com.lab.service;

import com.lab.bean.User;
import com.lab.bean.UserInfo;
import com.lab.bean.User_RoleExample;
import com.lab.dao.UserMapper;
import com.lab.dao.User_RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张占恒.
 * @date 2020/2/22.
 * @time 11:20.
 */
@Service
public class TeacherService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    User_RoleMapper user_roleMapper;
   //查询所有学生信息
    public List<UserInfo> selectStudent(Integer id,Integer page,Integer limit){
        page = (page-1)*limit;
        return userMapper.selectStudent(id,page,limit);
    }
    //查询学生信息总条数
    public long selectStudentCount(Integer id){
        int id1 = id;
        User_RoleExample param = new User_RoleExample();
        param.createCriteria().andRoleIdEqualTo(id1);
        return user_roleMapper.countByExample(param);
    }
    //删除学生信息
    public void deleteStudent(String id) {
        int i = Integer.parseInt(id);
        userMapper.deleteByPrimaryKey(i);
    }

    public User selectOneStudent(int id) {
        return  userMapper.selectByPrimaryKey(id);
    }
    //查询单个学生信息
}
