package com.yeyue.learns.enity.bizhi;

import com.yeyue.learns.constant.AdapterConstant;
import com.yeyue.library.data.BaseItem;

/**
  *@describe 壁纸分类
  *@author Administrator
  *@time 2017/11/4 0004 下午 8:56
  */
public class VerCategory extends BaseItem{
    /**
     * ename : girl
     * atime : 1.291266021E9
     * name : 美女
     * cover : http://img0.adesk.com/download/57e7155894e5cc60a375f653
     * sn : 1
     * nimgs : 0
     * uid : null
     * type : 1
     * id : 4e4d610cdf714d2966000000
     * desc :
     */

    private String ename;
    private double atime;
    private String name;
    private String cover;
    private int sn;
    private int nimgs;
    private Object uid;
    private int type;
    private String id;
    private String desc;

    @Override
    public int getItemType() {
        return AdapterConstant.ITEM_BIZHI_VERTICAL_CATEGORY;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public double getAtime() {
        return atime;
    }

    public void setAtime(double atime) {
        this.atime = atime;
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

    public int getSn() {
        return sn;
    }

    public void setSn(int sn) {
        this.sn = sn;
    }

    public int getNimgs() {
        return nimgs;
    }

    public void setNimgs(int nimgs) {
        this.nimgs = nimgs;
    }

    public Object getUid() {
        return uid;
    }

    public void setUid(Object uid) {
        this.uid = uid;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
