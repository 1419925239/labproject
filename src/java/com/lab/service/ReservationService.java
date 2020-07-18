package com.lab.service;

import com.lab.bean.Reservation;
import com.lab.bean.ReservationExample;
import com.lab.dao.ReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 张占恒.
 * @date 2020/2/27.
 * @time 17:03.
 */
@Service
public class ReservationService {
    @Autowired
    ReservationMapper reservationMapper;
    //插入预约结果
    public String inserone(Reservation reservation) {
        return String.valueOf(reservationMapper.insertSelective(reservation));
    }

    //删除预约结果
    public String deleteinfo(String resId) {
        return String.valueOf(reservationMapper.deleteByPrimaryKey(Integer.valueOf(resId)));
    }
    //修改预约信息
    public String updateres(Reservation reservation) {
        int id = reservation.getResId();
        ReservationExample reservationExample = new ReservationExample();
        reservationExample.createCriteria().andResIdEqualTo(id);
        return String.valueOf(reservationMapper.updateByExampleSelective(reservation,reservationExample));
    }
    //修改预约状态,通过
    public String updatestatus(String reid) {
        Reservation reservation = new Reservation();
        reservation.setReserStatus(0);
        int id = Integer.parseInt(reid);
        ReservationExample reservationExample = new ReservationExample();
        reservationExample.createCriteria().andResIdEqualTo(id);
        return String.valueOf(reservationMapper.updateByExampleSelective(reservation,reservationExample));
    }
    //修改预约状态,不通过
    public String updatestatus1(String reid) {
        Reservation reservation = new Reservation();
        reservation.setReserStatus(1);
        int id = Integer.parseInt(reid);
        ReservationExample reservationExample = new ReservationExample();
        reservationExample.createCriteria().andResIdEqualTo(id);
        return String.valueOf(reservationMapper.updateByExampleSelective(reservation,reservationExample));
    }

    public String selectcount(String id, String s, String s1) {
        return reservationMapper.selectcount(id,s,s1);
    }
}
