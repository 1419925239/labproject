package com.lab.bean;

import java.util.Date;

/**
 * @author 张占恒.
 * @date 2020/2/25.
 * @time 17:03.
 */
public class Lab_Schedule extends  ExpInformationWithBLOBs  {
    private Integer scheduleId;

    private Integer labId;

    private Date scheduleDate;

    private Integer t1;
    private Integer t1_free;

    private Integer t2;
    private Integer t2_free;

    private Integer t3;
    private Integer t3_free;

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Integer getLabId() {
        return labId;
    }

    public void setLabId(Integer labId) {
        this.labId = labId;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public Integer getT1() {
        return t1;
    }

    public void setT1(Integer t1) {
        this.t1 = t1;
    }

    public Integer getT2() {
        return t2;
    }

    public void setT2(Integer t2) {
        this.t2 = t2;
    }

    public Integer getT3() {
        return t3;
    }

    public void setT3(Integer t3) {
        this.t3 = t3;
    }

    public Integer getT1_free() {
        return t1_free;
    }

    public void setT1_free(Integer t1_free) {
        this.t1_free = t1_free;
    }

    public Integer getT2_free() {
        return t2_free;
    }

    public void setT2_free(Integer t2_free) {
        this.t2_free = t2_free;
    }

    public Integer getT3_free() {
        return t3_free;
    }

    public void setT3_free(Integer t3_free) {
        this.t3_free = t3_free;
    }

    public Lab_Schedule(Integer scheduleId, Integer labId, Date scheduleDate, Integer t1, Integer t1_free, Integer t2, Integer t2_free, Integer t3, Integer t3_free) {
        this.scheduleId = scheduleId;
        this.labId = labId;
        this.scheduleDate = scheduleDate;
        this.t1 = t1;
        this.t1_free = t1_free;
        this.t2 = t2;
        this.t2_free = t2_free;
        this.t3 = t3;
        this.t3_free = t3_free;
    }
}
