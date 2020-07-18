package com.lab.service;

import com.lab.bean.User;
import com.lab.bean.UserExample;
import com.lab.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 张占恒.
 * @date 2020/2/15.
 * @time 17:29.
 */
@Service
public class StudentService {

    @Autowired
    UserMapper userMapper;
    //修改信息
    public String updateUser(User user){
        int id = user.getUserId();
        UserExample param = new UserExample();
        param.createCriteria().andUserIdEqualTo(id);
        return String.valueOf(userMapper.updateByExample(user,param));
    }
}
