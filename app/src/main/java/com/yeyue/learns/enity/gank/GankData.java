package com.yeyue.learns.enity.gank;

import com.yeyue.learns.constant.AdapterConstant;
import com.yeyue.library.data.BaseItem;

import java.util.List;

/**
 * Created by Administrator on 2018/1/6 0006.
 */

public class GankData extends BaseItem{
    /**
     * _id : 5a07b7fe421aa90fe7253624
     * createdAt : 2017-11-12T10:54:54.391Z
     * desc : 应用模块化和懒加载在 Instagram 中的实现
     * publishedAt : 2018-01-04T13:45:57.211Z
     * source : chrome
     * type : Android
     * url : https://github.com/Instagram/ig-lazy-module-loader
     * used : true
     * who : vincgao
     * images : ["http://img.gank.io/7b82e6e5-4557-4e6c-9aa8-db86ffe25160"]
     */

    private String _id;
    private String createdAt;
    private String desc;
    private String publishedAt;
    private String source;
    private String type;
    private String url;
    private boolean used;
    private String who;
    private List<String> images;

    @Override
    public int getItemType() {
        if(itemtype==0){
            return AdapterConstant.ITEM_GANK_DATA_DEFAULT;
        }
        return itemtype;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
