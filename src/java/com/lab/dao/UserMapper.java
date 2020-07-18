package com.lab.dao;

import com.lab.bean.Menu;
import com.lab.bean.User;
import com.lab.bean.UserExample;
import java.util.List;
import java.util.Set;

import com.lab.bean.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    //查询用户角色
    Set<String> selectUserRoleNameSet(Integer userId);
    //查询学生
    List<UserInfo> selectStudent(Integer id,Integer page,Integer limit);
    //查询菜单
    List<Menu> selectMenuList(Integer id);
    //根据用户查询权限名
    Set<String> selectUserQxNameSet(Integer userId);
    //根据院系查相应的老师
    List<User> selectByFacyulyToTeacherName(String userFaculty);
    //根据用户id查询相应对应实验的人
    String selectByidToName(int id);
    //根据名字查id
    String selectByNameToId(String expinformationTeacherName, String expresultsCalss);

    List<User> findAllstudent();

    List<User> findAllTeacher();
}