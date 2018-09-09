package com.yeyue.learns.enity.diycode;

import com.yeyue.learns.constant.AdapterConstant;
import com.yeyue.library.data.BaseItem;

/**
 * Created by li.xiao on 2018-1-5.
 */

public class DiyUser extends BaseItem{
    /**
     * id : 30
     * login : d_clock
     * name : D_clock爱吃葱花
     * avatar_url : https://diycode.b0.upaiyun.com/user/large_avatar/30.jpg
     */

    private int id;
    private String login;
    private String name;
    private String avatar_url;

    @Override
    public int getItemType() {
        return AdapterConstant.ITEM_DIY_USER_DEFAULT;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

}
