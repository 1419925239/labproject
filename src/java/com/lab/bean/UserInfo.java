package com.lab.bean;

/**
 * @author 张占恒.
 * @date 2020/2/22.
 * @time 10:51.
 */
public class UserInfo {
    private Integer userId;

    private String userName;

    private String userPassword;

    private String userCalss;

    private String userFaculty;

    private String userPhone;

    private Integer userStatus;

    private Integer userDelete;

    private String roleName;

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
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserCalss() {
        return userCalss;
    }

    public void setUserCalss(String userCalss) {
        this.userCalss = userCalss;
    }

    public String getUserFaculty() {
        return userFaculty;
    }

    public void setUserFaculty(String userFaculty) {
        this.userFaculty = userFaculty;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
