package com.lab.service;

import com.lab.bean.ExpResults;
import com.lab.bean.ExpResultsExample;
import com.lab.dao.ExpResultsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张占恒.
 * @date 2020/3/6.
 * @time 16:58.
 */
@Service
public class ExpResultsService {
    @Autowired
    ExpResultsMapper expResultsMapper;
    //插入
    public String insertone(ExpResults expResults) {
        return String.valueOf(expResultsMapper.insertSelective(expResults));
    }
    //查询
    public List<ExpResults> selectAll() {
        return expResultsMapper.selectAll();
    }
    //修改
    public String updateone(String expr,Integer i) {
        int id = Integer.parseInt(expr);
        ExpResults expResults = new ExpResults();
        expResults.setExpresultsStatus(i);
        ExpResultsExample expResultsExample = new ExpResultsExample();
        expResultsExample.createCriteria().andIdEqualTo(id);
        return String.valueOf(expResultsMapper.updateByExampleSelective(expResults,expResultsExample));
    }
}
