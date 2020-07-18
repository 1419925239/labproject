package com.lab.service;

import com.lab.bean.Menu;
import com.lab.bean.Role;
import com.lab.bean.User;
import com.lab.bean.User_Role;
import com.lab.dao.UserMapper;
import com.lab.dao.User_RoleMapper;
import com.lab.utils.TreeNode;
import com.lab.utils.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张占恒.
 * @date 2020/2/7.
 * @time 15:26.
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    User_RoleMapper user_roleMapper;

    //查询用户角色
    public String getUserRoleNameSet(Integer id){
        return String.valueOf(userMapper.selectUserRoleNameSet(id));
    }
    //查询菜单
    public List<TreeNode> getMenuTreeByUserId(Integer id) {
        // 查询用户拥有的菜单资源
        List<Menu> menuList = userMapper.selectMenuList(id);
        if(menuList.isEmpty()){
            return new ArrayList<>();
        }

        // 存储父id是0的节点的id
        List<Integer> nodeIds = new ArrayList<>();
        List<TreeNode> treeNodeList = new ArrayList<>();
        for (Menu menu : menuList) {
            TreeNode treeNode = new TreeNode();
            treeNode.setId(menu.getResId());
            treeNode.setName(menu.getResName());
            treeNode.setParentId(menu.getParentId());
            treeNodeList.add(treeNode);
            if(treeNode.getParentId() == 0) {
                nodeIds.add(treeNode.getId());
            }
        }
        TreeUtil treeUtil = new TreeUtil(treeNodeList);
        List<TreeNode> treeNodeData = new ArrayList<>();
        for (Integer nodeId : nodeIds) {
            treeNodeData.add(treeUtil.generateTree(nodeId));
        }
        return treeNodeData;
    }

    //查询用户信息
    public String getUserInfo(Integer valueOf) {
        return String.valueOf(userMapper.selectByPrimaryKey(valueOf));
    }
    //查询最新用户信息
    public User getUserInfoNew(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }
    //根据学院查询相应的老师
    public List<User> selectByFacyulyToTeacherName(String userFaculty) {
        return userMapper.selectByFacyulyToTeacherName(userFaculty);
    }
    //通过id查询预约实验相应的人的名字
    public String selectByidToName(int id) {
        return userMapper.selectByidToName(id);
    }

    public String selectByNameToId(String expinformationTeacherName, String expresultsCalss) {
        return userMapper.selectByNameToId(expinformationTeacherName,expresultsCalss);
    }
    //导入excel表格
    public int importUser(User user1, String role) {
        if("学生".equals(role)){

            int j = userMapper.insertSelective(user1);
            if( j == 1){
                User_Role user_role = new User_Role();
                user_role.setUserId(user1.getUserId());
                user_role.setRoleId(1);
                int i = user_roleMapper.insertSelective(user_role);
                if (i == 1){
                    return 1;
                }
            }else {
                return 0;
            }

        }else if("老师".equals(role)){
            int j = userMapper.insertSelective(user1);
            if( j == 1){
                User_Role user_role = new User_Role();
                user_role.setUserId(user1.getUserId());
                user_role.setRoleId(2);
                int i = user_roleMapper.insertSelective(user_role);
                if (i == 1){
                    return 1;
                }
            }else {
                return 0;
            }



        }
        return 0;
    }

    //查找所有的学生数据
    public  List<User> findAllstudent() {
        return userMapper.findAllstudent();
    }
    //插入学生数据
    public void insertSelective(User user) {
        userMapper.insertSelective(user);
        User_Role user_role = new User_Role();
        user_role.setUserId(user.getUserId());
        user_role.setRoleId(1);
        user_roleMapper.insertSelective(user_role);

    }
    //查找所有老师的数据
    public List<User> findAllTeacher() {
        return userMapper.findAllTeacher();
    }
    //插入一条数据
    public String insertoneUser(User user) {
        int i = userMapper.insertSelective(user);
        if(i == 1){
            User_Role user_role = new User_Role();
            user_role.setUserId(user.getUserId());
            user_role.setRoleId(1);
            int j = user_roleMapper.insertSelective(user_role);
            if(j == 1){
                return "1";
            }else {
                return "0";
            }
        }else {
            return "0";
        }

    }
}
