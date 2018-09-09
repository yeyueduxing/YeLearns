package com.yeyue.learns.enity.diycode;

import com.yeyue.learns.constant.AdapterConstant;
import com.yeyue.library.data.BaseItem;

/**
 * Created by li.xiao on 2018-1-5.
 */

public class DiyNew extends BaseItem{

    /**
     * id : 2672
     * title : 彬姐私房菜——彬姐教你处理Android移动端崩溃
     * created_at : 2017-10-14T14:53:47.471+08:00
     * updated_at : 2017-10-14T14:53:47.471+08:00
     * user : {"id":1,"login":"jixiaohua","name":"寂小桦","avatar_url":"https://diycode.b0.upaiyun.com/user/large_avatar/2.jpg"}
     * node_name : Android
     * node_id : 1
     * last_reply_user_id : null
     * last_reply_user_login : null
     * replied_at : null
     * address : https://mp.weixin.qq.com/s/s_zHFgZUZMTDT4COtNzDtw
     * replies_count : 0
     */

    private int id;
    private String title;
    private String created_at;
    private String updated_at;
    private DiyUser user;
    private String node_name;
    private int node_id;
    private Object last_reply_user_id;
    private Object last_reply_user_login;
    private Object replied_at;
    private String address;
    private int replies_count;

    @Override
    public int getItemType() {
        return AdapterConstant.ITEM_DIY_NEW_DEFAULT;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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


    public String getNode_name() {
        return node_name;
    }

    public void setNode_name(String node_name) {
        this.node_name = node_name;
    }

    public int getNode_id() {
        return node_id;
    }

    public void setNode_id(int node_id) {
        this.node_id = node_id;
    }

    public Object getLast_reply_user_id() {
        return last_reply_user_id;
    }

    public void setLast_reply_user_id(Object last_reply_user_id) {
        this.last_reply_user_id = last_reply_user_id;
    }

    public Object getLast_reply_user_login() {
        return last_reply_user_login;
    }

    public void setLast_reply_user_login(Object last_reply_user_login) {
        this.last_reply_user_login = last_reply_user_login;
    }

    public Object getReplied_at() {
        return replied_at;
    }

    public void setReplied_at(Object replied_at) {
        this.replied_at = replied_at;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getReplies_count() {
        return replies_count;
    }

    public void setReplies_count(int replies_count) {
        this.replies_count = replies_count;
    }

    public DiyUser getUser() {
        return user;
    }

    public void setUser(DiyUser user) {
        this.user = user;
    }
}
