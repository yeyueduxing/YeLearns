package com.yeyue.learns.model.api;

/**
 * Created by li.xiao on 2017-11-2.
 */

public class HttpRequest<T> {
    public String msg;
    public T res;
    private int code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getRes() {
        return res;
    }

    public void setRes(T res) {
        this.res = res;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
