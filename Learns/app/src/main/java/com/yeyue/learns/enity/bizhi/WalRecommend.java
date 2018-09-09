package com.yeyue.learns.enity.bizhi;

import java.util.List;

/**
 * Created by Administrator on 2017/11/5 0005.
 */

public class WalRecommend {

    private String msg;
    private ResBean res;
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

    public static class ResBean {
        private List<HttpAlbum.ResBean.BannerBean> banner;
        private List<DayRecommend> recommend;

        public List<HttpAlbum.ResBean.BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<HttpAlbum.ResBean.BannerBean> banner) {
            this.banner = banner;
        }

        public List<DayRecommend> getRecommend() {
            return recommend;
        }

        public void setRecommend(List<DayRecommend> recommend) {
            this.recommend = recommend;
        }
    }
}
