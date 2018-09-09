package com.yeyue.learns.enity.bizhi;

import com.yeyue.learns.constant.AdapterConstant;
import com.yeyue.library.data.BaseItem;

import java.util.List;

/**
 * Created by li.xiao on 2017-12-5.
 */

public class BizhiAlbumBean extends BaseItem{
    /**
     * ename :
     * isfeed : false
     * tag : []
     * id : 59f83affe7bce729d56500bd
     * top : 0
     * type : 1
     * status : online
     * user : {"gcid":"d3b6f9e276432a3f0d5dbdec491e6d3e","name":"大太阳君","gender":1,
     * "follower":9037,"avatar":"http://img0.adesk
     * .com/download/5790d268742aa7480bf44d3e","viptime":9.782784E8,"following":0,
     * "isvip":false,"id":"507b922bcd29911da5b9bea8"}
     * favs : 418
     * atime : 1.509440255E9
     * desc : 甜美女神！娇中带着几分甜，柔中夹着几分媚，甜甜的感觉涌上心头。
     * name : Sugar杨晨晨
     * url : []
     * cover : http://img5.adesk.com/59f3fbfee7bce77a72eb451b?imageView2/3/h/240
     * lcover : http://img5.adesk.com/59f3fbfee7bce77a72eb451b?imageView2/3/h/720
     * subname :
     * sn : 999
     * nickname : 光点电影院
     */

    private String ename;
    private boolean isfeed;
    private String id;
    private int top;
    private int type;
    private String status;
    private UserBean user;
    private int favs;
    private String atime;
    private String desc;
    private String name;
    private String cover;
    private String lcover;
    private String subname;
    private int sn;
    private String nickname;
    private List<?> url;

    @Override
    public int getItemType() {
        return AdapterConstant.ITEM_BIZHI_ALBUM_DEFAULT;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public boolean isIsfeed() {
        return isfeed;
    }

    public void setIsfeed(boolean isfeed) {
        this.isfeed = isfeed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public int getFavs() {
        return favs;
    }

    public void setFavs(int favs) {
        this.favs = favs;
    }

    public String getAtime() {
        return atime;
    }

    public void setAtime(String atime) {
        this.atime = atime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public String getLcover() {
        return lcover;
    }

    public void setLcover(String lcover) {
        this.lcover = lcover;
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    public int getSn() {
        return sn;
    }

    public void setSn(int sn) {
        this.sn = sn;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<?> getUrl() {
        return url;
    }

    public void setUrl(List<?> url) {
        this.url = url;
    }

}