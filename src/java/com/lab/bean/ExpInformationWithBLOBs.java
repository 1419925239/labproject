package com.lab.bean;

public class ExpInformationWithBLOBs extends ExpInformation {
    private String expinformationPurpose;

    private String expinformationIns;

    private String expinformationStep;

    public String getExpinformationPurpose() {
        return expinformationPurpose;
    }

    public void setExpinformationPurpose(String expinformationPurpose) {
        this.expinformationPurpose = expinformationPurpose == null ? null : expinformationPurpose.trim();
    }

    public String getExpinformationIns() {
        return expinformationIns;
    }

    public void setExpinformationIns(String expinformationIns) {
        this.expinformationIns = expinformationIns == null ? null : expinformationIns.trim();
    }

    public String getExpinformationStep() {
        return expinformationStep;
    }

    public void setExpinformationStep(String expinformationStep) {
        this.expinformationStep = expinformationStep == null ? null : expinformationStep.trim();
    }
}