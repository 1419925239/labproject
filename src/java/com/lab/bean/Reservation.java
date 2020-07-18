package com.lab.bean;

import java.util.Date;

public class Reservation {
    private Integer resId;

    private Integer reserLabid;

    private Integer reserUserId;

    private Integer reserExpid;

    private Integer reserType;

    private Integer weekday;

    private Integer reserDatatime;

    private Date reserData;

    private Date reserCreattime;

    private Date reserModifytime;

    private Integer reserStatus;

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public Integer getReserLabid() {
        return reserLabid;
    }

    public void setReserLabid(Integer reserLabid) {
        this.reserLabid = reserLabid;
    }

    public Integer getReserUserId() {
        return reserUserId;
    }

    public void setReserUserId(Integer reserUserId) {
        this.reserUserId = reserUserId;
    }

    public Integer getReserExpid() {
        return reserExpid;
    }

    public void setReserExpid(Integer reserExpid) {
        this.reserExpid = reserExpid;
    }

    public Integer getReserType() {
        return reserType;
    }

    public void setReserType(Integer reserType) {
        this.reserType = reserType;
    }

    public Integer getWeekday() {
        return weekday;
    }

    public void setWeekday(Integer weekday) {
        this.weekday = weekday;
    }

    public Integer getReserDatatime() {
        return reserDatatime;
    }

    public void setReserDatatime(Integer reserDatatime) {
        this.reserDatatime = reserDatatime;
    }

    public Date getReserData() {
        return reserData;
    }

    public void setReserData(Date reserData) {
        this.reserData = reserData;
    }

    public Date getReserCreattime() {
        return reserCreattime;
    }

    public void setReserCreattime(Date reserCreattime) {
        this.reserCreattime = reserCreattime;
    }

    public Date getReserModifytime() {
        return reserModifytime;
    }

    public void setReserModifytime(Date reserModifytime) {
        this.reserModifytime = reserModifytime;
    }

    public Integer getReserStatus() {
        return reserStatus;
    }

    public void setReserStatus(Integer reserStatus) {
        this.reserStatus = reserStatus;
    }
}