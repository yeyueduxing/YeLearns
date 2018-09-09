package com.yeyue.learns.enity.diycode;

import com.yeyue.learns.constant.AdapterConstant;
import com.yeyue.library.data.BaseItem;

/**
 * Created by li.xiao on 2018-1-5.
 */

public class DiyTopicReply extends BaseItem{

    /**
     * id : 4266
     * body_html : <p>看着真棒呢！</p>
     * created_at : 2017-12-07T00:28:08.853+08:00
     * updated_at : 2017-12-07T00:28:08.853+08:00
     * deleted : false
     * topic_id : 1044
     * user : {"id":1,"login":"jixiaohua","name":"寂小桦","avatar_url":"https://diycode.b0.upaiyun.com/user/large_avatar/2.jpg"}
     * likes_count : 0
     * abilities : {"update":false,"destroy":false}
     */

    private int id;
    private String body_html;
    private String created_at;
    private String updated_at;
    private boolean deleted;
    private int topic_id;
    private DiyUser user;
    private int likes_count;
    private DiyAblities abilities;

    @Override
    public int getItemType() {
        return AdapterConstant.ITEM_DIY_TOPIC_REPLAY;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody_html() {
        return body_html;
    }

    public void setBody_html(String body_html) {
        this.body_html = body_html;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }

    public DiyUser getUser() {
        return user;
    }

    public void setUser(DiyUser user) {
        this.user = user;
    }

    public int getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(int likes_count) {
        this.likes_count = likes_count;
    }

    public DiyAblities getAbilities() {
        return abilities;
    }

    public void setAbilities(DiyAblities abilities) {
        this.abilities = abilities;
    }
}
