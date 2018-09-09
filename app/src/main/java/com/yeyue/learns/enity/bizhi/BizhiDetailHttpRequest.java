package com.yeyue.learns.enity.bizhi;

/**
 * Created by li.xiao on 2017-11-2.
 */

public class BizhiDetailHttpRequest {
    public String msg;
    public WalDetail res;
    private int code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public WalDetail getRes() {
        return res;
    }

    public void setRes(WalDetail res) {
        this.res = res;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
