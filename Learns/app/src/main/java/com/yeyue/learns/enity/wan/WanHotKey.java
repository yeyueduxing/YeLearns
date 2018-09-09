package com.yeyue.learns.enity.wan;

import com.yeyue.library.data.BaseItem;

/**
 * Created by lw on 2018/1/23.
 */

public class WanHotKey extends BaseItem{
    /**
     * id : 6
     * link :
     * name : 面试
     * order : 1
     * visible : 1
     */

    private int id;
    private String link;
    private String name;
    private int order;
    private int visible;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }
}
