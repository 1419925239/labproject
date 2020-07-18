package com.lab.utils;

import org.springframework.ui.Model;

import java.util.HashMap;

/**
 * @author 张占恒.
 * @date 2020/2/8.
 * @time 23:37.
 */
public class R extends HashMap<String, Object> {

    public static R ok() {
        R r = new R();
        r.put("code", 0);
        r.put("msg", "请求成功");
        return r;
    }

    public static R ok(Object data,Object data1,Object data2) {
        R r = new R();
        r.put("code", 0);
        r.put("msg", "请求成功");
        r.put("FetureDate",data);
        r.put("scheduleList",data1);
        r.put("labInformationList",data2);
        return r;
    }

    public static R table(String count,Object data) {
        R r = new R();
        r.put("code", 0);
        r.put("msg", "请求成功");
        r.put("data",data);
        r.put("count",count);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("code", 0);
        r.put("msg", msg);
        return r;
    }
    public static R ok(String role ,String username) {
        R r = new R();
        r.put("code",0);
        r.put("role", role);
        r.put("name", username);
        return r;
    }

    public static R ok(String msg, Object data) {
        R r = new R();
        r.put("code", 0);
        r.put("msg", msg);
        r.put("data", data);
        return r;
    }
    public static R ok(String role ,String username, Object data) {
        R r = new R();
        r.put("code",0);
        r.put("role", role);
        r.put("name", username);
        r.put("data", data);
        return r;
    }
    public static R ok(String id,String role ,String username, Object data) {
        R r = new R();
        r.put("code",0);
        r.put("id",id);
        r.put("role", role);
        r.put("name", username);
        r.put("data", data);
        return r;
    }

    public static R error(String msg) {
        R r = new R();
        r.put("code", 1);
        r.put("msg", msg);
        return r;
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

}
