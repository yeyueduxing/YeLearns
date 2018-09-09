package com.yeyue.learns.enity.bizhi;

import com.yeyue.library.data.BaseItem;

import java.util.List;

import static com.yeyue.learns.constant.AdapterConstant.ITEM_HOME_GANK;


/**
 * Created by li.xiao on 2017-11-2.
 */

public class GankBean extends BaseItem{

    /**
     * _id : 59f74442421aa90fe50c01b4
     * createdAt : 2017-10-30T23:24:50.283Z
     * desc : 新海诚的动画短片来自谁的凝望
     * publishedAt : 2017-11-01T14:20:59.209Z
     * source : chrome
     * type : 休息视频
     * url : http://www.miaopai.com/show/JcgCcPco3LYy3z7eQKDei2izkff3R9DO-OPWNw__.htm
     * used : true
     * who : lxxself
     * images : ["http://img.gank.io/d1d4f7b4-9291-499a-8b20-c3c485c46119"]
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
        if(itemtype!=0){
            return itemtype;
        }
        return ITEM_HOME_GANK;
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
