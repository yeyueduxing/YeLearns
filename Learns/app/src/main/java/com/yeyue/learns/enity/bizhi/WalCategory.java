package com.yeyue.learns.enity.bizhi;

import com.yeyue.learns.constant.AdapterConstant;
import com.yeyue.library.data.BaseItem;

import java.util.List;

/**
  *@describe 壁纸分类
  *@author Administrator
  *@time 2017/11/4 0004 下午 8:56
  */
public class WalCategory {
    private List<CategoryBean> category;

    public List<CategoryBean> getCategory() {
        return category;
    }
    public void setCategory(List<CategoryBean> category) {
        this.category = category;
    }

    public static class CategoryBean extends BaseItem{
        /**
         * count : 50741
         * ename : girl
         * rname : 美女
         * cover_temp : 56a964df69401b2866828acb
         * name : 美女
         * cover : http://img5.adesk
         * .com/59f6becce7bce729500bc8ed?imageMogr2/thumbnail/!640x480r/gravity/Center/crop
         * /640x480
         * rank : 1
         * filter : []
         * sn : 1
         * icover : 564d831f69401b5aed4a86ca
         * atime : 1.291266021E9
         * type : 1
         * id : 4e4d610cdf714d2966000000
         * picasso_cover : 59f6becce7bce729500bc8ed
         */

        private int count;
        private String ename;
        private String rname;
        private String cover_temp;
        private String name;
        private String cover;
        private int rank;
        private int sn;
        private String icover;
        private double atime;
        private int type;
        private String id;
        private String picasso_cover;
        private List<?> filter;

        @Override
        public int getItemType() {
            return AdapterConstant.ITEM_BIZHI_WALLPAPER_CATEGORY;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public String getRname() {
            return rname;
        }

        public void setRname(String rname) {
            this.rname = rname;
        }

        public String getCover_temp() {
            return cover_temp;
        }

        public void setCover_temp(String cover_temp) {
            this.cover_temp = cover_temp;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public int getSn() {
            return sn;
        }

        public void setSn(int sn) {
            this.sn = sn;
        }

        public String getIcover() {
            return icover;
        }

        public void setIcover(String icover) {
            this.icover = icover;
        }

        public double getAtime() {
            return atime;
        }

        public void setAtime(double atime) {
            this.atime = atime;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPicasso_cover() {
            return picasso_cover;
        }

        public void setPicasso_cover(String picasso_cover) {
            this.picasso_cover = picasso_cover;
        }

        public List<?> getFilter() {
            return filter;
        }

        public void setFilter(List<?> filter) {
            this.filter = filter;
        }
    }
}
