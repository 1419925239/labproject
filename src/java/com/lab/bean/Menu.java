package com.lab.bean;

/**
 * @author 张占恒.
 * @date 2020/2/12.
 * @time 16:08.
 */
public class Menu {

    private Integer resId;

    private Integer parentId;

    private String resName;

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }
}
