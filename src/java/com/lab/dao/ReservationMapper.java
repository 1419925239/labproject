package com.lab.dao;

import com.lab.bean.Reservation;
import com.lab.bean.ReservationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReservationMapper {
    long countByExample(ReservationExample example);

    int deleteByExample(ReservationExample example);

    int deleteByPrimaryKey(Integer resId);

    int insert(Reservation record);

    int insertSelective(Reservation record);

    List<Reservation> selectByExample(ReservationExample example);

    Reservation selectByPrimaryKey(Integer resId);

    int updateByExampleSelective(@Param("record") Reservation record, @Param("example") ReservationExample example);

    int updateByExample(@Param("record") Reservation record, @Param("example") ReservationExample example);

    int updateByPrimaryKeySelective(Reservation record);

    int updateByPrimaryKey(Reservation record);

    String selectcount(String id, String s, String s1);
}