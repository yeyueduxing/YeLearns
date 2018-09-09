package com.yeyue.learns.enity.bizhi;

import java.util.List;

public class HttpWallpaper<T> {

    private String msg;
    private ResBean<T> res;
    private int code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResBean getRes() {
        return res;
    }

    public void setRes(ResBean res) {
        this.res = res;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class ResBean<T> {
        private List<T> wallpaper;

        public List<T> getWallpaper() {
            return wallpaper;
        }

    }
}
