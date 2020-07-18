package com.lab.bean;

public class ExpInformation {
    private Integer expinformationId;

    private String expinformationFaculty;

    private String expinformationType;

    private String expinformationName;

    private String expinformationTeacherName;

    private Integer expinformationStatus;

    public Integer getExpinformationId() {
        return expinformationId;
    }

    public void setExpinformationId(Integer expinformationId) {
        this.expinformationId = expinformationId;
    }

    public String getExpinformationFaculty() {
        return expinformationFaculty;
    }

    public void setExpinformationFaculty(String expinformationFaculty) {
        this.expinformationFaculty = expinformationFaculty == null ? null : expinformationFaculty.trim();
    }

    public String getExpinformationType() {
        return expinformationType;
    }

    public void setExpinformationType(String expinformationType) {
        this.expinformationType = expinformationType == null ? null : expinformationType.trim();
    }

    public String getExpinformationName() {
        return expinformationName;
    }

    public void setExpinformationName(String expinformationName) {
        this.expinformationName = expinformationName == null ? null : expinformationName.trim();
    }

    public String getExpinformationTeacherName() {
        return expinformationTeacherName;
    }

    public void setExpinformationTeacherName(String expinformationTeacherName) {
        this.expinformationTeacherName = expinformationTeacherName == null ? null : expinformationTeacherName.trim();
    }

    public Integer getExpinformationStatus() {
        return expinformationStatus;
    }

    public void setExpinformationStatus(Integer expinformationStatus) {
        this.expinformationStatus = expinformationStatus;
    }
}