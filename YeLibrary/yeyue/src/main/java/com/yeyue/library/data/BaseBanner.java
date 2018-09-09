package com.yeyue.library.data;

/**
  *@describe 轮播图数据
  *@author Administrator
  *@time 2017/11/5 0005 上午 10:45
  */
public class BaseBanner<T> extends BaseItem{
    private String baImg;
    private String baTitle;
    private T object;
    public String getBaImg() {
        return baImg;
    }

    public void setBaImg(String baImg) {
        this.baImg = baImg;
    }

    public String getBaTitle() {
        return baTitle;
    }

    public void setBaTitle(String baTitle) {
        this.baTitle = baTitle;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
