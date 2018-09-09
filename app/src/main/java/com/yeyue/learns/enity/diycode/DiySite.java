package com.yeyue.learns.enity.diycode;

import com.yeyue.learns.constant.AdapterConstant;
import com.yeyue.library.data.BaseItem;

/**
 * Created by li.xiao on 2018-1-5.
 */

public class DiySite extends BaseItem{
    /**
     * name : Gratisography
     * url : http://www.gratisography.com
     * avatar_url : https://favicon.b0.upaiyun.com/ip2/www.gratisography.com.ico
     */

    private String name;
    private String url;
    private String avatar_url;

    @Override
    public int getItemType() {
        return AdapterConstant.ITEM_DIY_SITE_DEFAULT;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
