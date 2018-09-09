package com.yeyue.learns.enity.bizhi;

import com.yeyue.library.data.BaseItem;

/**
 * Created by li.xiao on 2017-12-5.
 */

public class UserBean extends BaseItem{
    /**
     * gcid : d3b6f9e276432a3f0d5dbdec491e6d3e
     * name : 大太阳君
     * gender : 1
     * follower : 9037
     * avatar : http://img0.adesk.com/download/5790d268742aa7480bf44d3e
     * viptime : 9.782784E8
     * following : 0
     * isvip : false
     * id : 507b922bcd29911da5b9bea8
     */

    private String gcid;
    private String name;
    private int gender;
    private int follower;
    private String avatar;
    private double viptime;
    private boolean isvip;
    private String id;
    private long atime;
    public String getGcid() {
        return gcid;
    }

    public void setGcid(String gcid) {
        this.gcid = gcid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getFollower() {
        return follower;
    }

    public void setFollower(int follower) {
        this.follower = follower;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public double getViptime() {
        return viptime;
    }

    public void setViptime(double viptime) {
        this.viptime = viptime;
    }

    public boolean isIsvip() {
        return isvip;
    }

    public void setIsvip(boolean isvip) {
        this.isvip = isvip;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getAtime() {
        return atime;
    }

    public void setAtime(long atime) {
        this.atime = atime;
    }
}