package com.yeyue.learns.enity.movie;

import com.yeyue.library.data.BaseItem;

/**
 * Created by li.xiao on 2017-8-1.
 */

public class MovieAuthor extends BaseItem{

    /**
     * uid : 123404248
     * avatar : https://img3.doubanio.com/icon/u123404248-3.jpg
     * signature :
     * alt : https://www.douban.com/people/123404248/
     * id : 123404248
     * name : 世界奇妙物语
     */

    private String uid;
    private String avatar;
    private String signature;
    private String alt;
    private String id;
    private String name;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
