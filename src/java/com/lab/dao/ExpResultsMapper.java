package com.lab.dao;

import com.lab.bean.ExpResults;
import com.lab.bean.ExpResultsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpResultsMapper {
    long countByExample(ExpResultsExample example);

    int deleteByExample(ExpResultsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExpResults record);

    int insertSelective(ExpResults record);

    List<ExpResults> selectByExample(ExpResultsExample example);

    ExpResults selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExpResults record, @Param("example") ExpResultsExample example);

    int updateByExample(@Param("record") ExpResults record, @Param("example") ExpResultsExample example);

    int updateByPrimaryKeySelective(ExpResults record);

    int updateByPrimaryKey(ExpResults record);

    //查询所有实验结果
    List<ExpResults> selectAll();
}