package com.yeyue.learns.enity.bizhi;

import java.util.List;

/**
 * Created by li.xiao on 2017-12-14.
 */

public class HotSearch {
    private List<KeywordBean> keyword;

    public List<KeywordBean> getKeyword() {
        return keyword;
    }

    public void setKeyword(List<KeywordBean> keyword) {
        this.keyword = keyword;
    }

    public static class KeywordBean {
        /**
         * items : ["黑白","手绘","黄子韬","古风","kiss","水母","情侣壁纸","足球","旅行","守望先锋"]
         * atime : 1.402991036E9
         * _id : 539ff1bc69401b0b5eda736f
         */

        private double atime;
        private String _id;
        private List<String> items;

        public double getAtime() {
            return atime;
        }

        public void setAtime(double atime) {
            this.atime = atime;
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public List<String> getItems() {
            return items;
        }

        public void setItems(List<String> items) {
            this.items = items;
        }
    }
}
