package com.lab.bean;

import com.lab.utils.POI.ExcelTitle;

public class User {
    @ExcelTitle(title = "学号/工号")
    private Integer userId;
    @ExcelTitle(title = "姓名")
    private String userName;
    @ExcelTitle(title = "密码")
    private String userPassword;

    private String salt;
    @ExcelTitle(title = "班级")
    private String userCalss;
    @ExcelTitle(title = "学院")
    private String userFaculty;
    @ExcelTitle(title = "手机号")
    private String userPhone;

    private Integer userStatus;

    private Integer userDelete;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getUserCalss() {
        return userCalss;
    }

    public void setUserCalss(String userCalss) {
        this.userCalss = userCalss == null ? null : userCalss.trim();
    }

    public String getUserFaculty() {
        return userFaculty;
    }

    public void setUserFaculty(String userFaculty) {
        this.userFaculty = userFaculty == null ? null : userFaculty.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getUserDelete() {
        return userDelete;
    }

    public void setUserDelete(Integer userDelete) {
        this.userDelete = userDelete;
    }

    public User() {
    }

    public User(Integer userId, String userName, String userPassword, String salt, String userCalss, String userFaculty, String userPhone, Integer userStatus, Integer userDelete) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.salt = salt;
        this.userCalss = userCalss;
        this.userFaculty = userFaculty;
        this.userPhone = userPhone;
        this.userStatus = userStatus;
        this.userDelete = userDelete;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", salt='" + salt + '\'' +
                ", userCalss='" + userCalss + '\'' +
                ", userFaculty='" + userFaculty + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userStatus=" + userStatus +
                ", userDelete=" + userDelete +
                '}';
    }
}