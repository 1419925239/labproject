package com.lab.bean;

import java.util.Date;

public class ExpResults {
    private Integer id;

    private Integer expresultsId;

    private String expresultsName;

    private String expresultsFauclty;

    private String expresultsCalss;

    private String expresultsAnalysis;

    private String expresultsFinish;

    private Date expresultsRiqi;
    private String expresultriqi;

    private Integer erpresultsShijianduan;

    private Integer expresultsStatus;

    private String expinformationTeacherName;

    private String expinformationName;
    private Integer teacherNameId;

    public Integer getTeacherNameId() {
        return teacherNameId;
    }

    public void setTeacherNameId(Integer teacherNameId) {
        this.teacherNameId = teacherNameId;
    }

    public String getExpresultriqi() {
        return expresultriqi;
    }

    public void setExpresultriqi(String expresultriqi) {
        this.expresultriqi = expresultriqi;
    }

    public String getExpinformationName() {
        return expinformationName;
    }

    public void setExpinformationName(String expinformationName) {
        this.expinformationName = expinformationName;
    }

    public String getExpinformationTeacherName() {
        return expinformationTeacherName;
    }

    public void setExpinformationTeacherName(String expinformationTeacherName) {
        this.expinformationTeacherName = expinformationTeacherName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExpresultsId() {
        return expresultsId;
    }

    public void setExpresultsId(Integer expresultsId) {
        this.expresultsId = expresultsId;
    }

    public String getExpresultsName() {
        return expresultsName;
    }

    public void setExpresultsName(String expresultsName) {
        this.expresultsName = expresultsName == null ? null : expresultsName.trim();
    }

    public String getExpresultsFauclty() {
        return expresultsFauclty;
    }

    public void setExpresultsFauclty(String expresultsFauclty) {
        this.expresultsFauclty = expresultsFauclty == null ? null : expresultsFauclty.trim();
    }

    public String getExpresultsCalss() {
        return expresultsCalss;
    }

    public void setExpresultsCalss(String expresultsCalss) {
        this.expresultsCalss = expresultsCalss == null ? null : expresultsCalss.trim();
    }

    public String getExpresultsAnalysis() {
        return expresultsAnalysis;
    }

    public void setExpresultsAnalysis(String expresultsAnalysis) {
        this.expresultsAnalysis = expresultsAnalysis == null ? null : expresultsAnalysis.trim();
    }

    public String getExpresultsFinish() {
        return expresultsFinish;
    }

    public void setExpresultsFinish(String expresultsFinish) {
        this.expresultsFinish = expresultsFinish == null ? null : expresultsFinish.trim();
    }

    public Date getExpresultsRiqi() {
        return expresultsRiqi;
    }

    public void setExpresultsRiqi(Date expresultsRiqi) {
        this.expresultsRiqi = expresultsRiqi;
    }

    public Integer getErpresultsShijianduan() {
        return erpresultsShijianduan;
    }

    public void setErpresultsShijianduan(Integer erpresultsShijianduan) {
        this.erpresultsShijianduan = erpresultsShijianduan;
    }

    public Integer getExpresultsStatus() {
        return expresultsStatus;
    }

    public void setExpresultsStatus(Integer expresultsStatus) {
        this.expresultsStatus = expresultsStatus;
    }
}