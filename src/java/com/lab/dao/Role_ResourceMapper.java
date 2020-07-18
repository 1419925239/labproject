package com.lab.dao;

import com.lab.bean.Role_Resource;
import com.lab.bean.Role_ResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Role_ResourceMapper {
    long countByExample(Role_ResourceExample example);

    int deleteByExample(Role_ResourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Role_Resource record);

    int insertSelective(Role_Resource record);

    List<Role_Resource> selectByExample(Role_ResourceExample example);

    Role_Resource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Role_Resource record, @Param("example") Role_ResourceExample example);

    int updateByExample(@Param("record") Role_Resource record, @Param("example") Role_ResourceExample example);

    int updateByPrimaryKeySelective(Role_Resource record);

    int updateByPrimaryKey(Role_Resource record);
}