package com.haoren.bean;

import com.alibaba.fastjson.JSONObject;

/**
 * 网络请求基础类
 * Created by Hh on 2017/3/29.
 */

public class BaseBean extends JSONObject {

    private int code;
    private String msg;
    private Object data;

    public BaseBean(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
