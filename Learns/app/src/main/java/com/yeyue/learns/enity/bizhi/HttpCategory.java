package com.yeyue.learns.enity.bizhi;

import java.util.List;

/**
  *@describe 壁纸分类
  *@author Administrator
  *@time 2017/11/4 0004 下午 8:56
  */
public class HttpCategory<T> {
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
        private List<T> category;

        public List<T> getCategory() {
            return category;
        }

        public void setCategory(List<T> category) {
            this.category = category;
        }

    }
}
