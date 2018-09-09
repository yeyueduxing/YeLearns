package com.yeyue.learns.enity.bizhi;

import java.util.List;

public class HttpAlbumRequest<T> {

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
        private List<T> album;

        public List<T> getAlbum() {
            return album;
        }

        public void setAlbum(List<T> album) {
            this.album = album;
        }
    }
}
