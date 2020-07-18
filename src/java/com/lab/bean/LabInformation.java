package com.lab.bean;

public class LabInformation {
    private Integer labinformationId;

    private String labinformationFloor;

    private Integer labinformationNum;

    private Integer labinformationSykj;

    private String labinformationName;

    private String labinformationDescription;

    public Integer getLabinformationId() {
        return labinformationId;
    }

    public void setLabinformationId(Integer labinformationId) {
        this.labinformationId = labinformationId;
    }

    public String getLabinformationFloor() {
        return labinformationFloor;
    }

    public void setLabinformationFloor(String labinformationFloor) {
        this.labinformationFloor = labinformationFloor == null ? null : labinformationFloor.trim();
    }

    public Integer getLabinformationNum() {
        return labinformationNum;
    }

    public void setLabinformationNum(Integer labinformationNum) {
        this.labinformationNum = labinformationNum;
    }

    public Integer getLabinformationSykj() {
        return labinformationSykj;
    }

    public void setLabinformationSykj(Integer labinformationSykj) {
        this.labinformationSykj = labinformationSykj;
    }

    public String getLabinformationName() {
        return labinformationName;
    }

    public void setLabinformationName(String labinformationName) {
        this.labinformationName = labinformationName == null ? null : labinformationName.trim();
    }

    public String getLabinformationDescription() {
        return labinformationDescription;
    }

    public void setLabinformationDescription(String labinformationDescription) {
        this.labinformationDescription = labinformationDescription == null ? null : labinformationDescription.trim();
    }
}