package com.lab.test;

/**
 * @author 张占恒.
 * @date 2020/2/4.
 * @time 11:12.
 */


import com.lab.dao.*;
import com.lab.utils.CusUtile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 测试dao层的工作
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class MapperTest {

    @Autowired
    UserMapper userMapper;
    @Autowired
    User_RoleMapper user_roleMapper;
    @Autowired
    LabInformationMapper labInformationMapper;
    @Autowired
    ExpInformationMapper expInformationMapper;
    @Autowired
    ScheduleMapper scheduleMapper;
    @Autowired
    ExpResultsMapper expResultsMapper;

//    批量进行的sql语句
//    @Autowired
//    SqlSession sqlSession;
    /**
     * 测试user、teacher、admin、
     */
    @Test
    public void testCRUD() {




    }
}
