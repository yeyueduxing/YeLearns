package com.yeyue.library.data;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.io.Serializable;

/**
  *@describe 所以实体类的基类，所有实体类都继承该基类，混淆和数据展示更加方便
  *@author li.xiao
  *@time 2017-7-18 14:22
  */
public abstract class BaseItem implements Serializable, Cloneable,MultiItemEntity {
    protected int itemtype;
    public int getItemType(){
        return itemtype;
    }

    public void setItemtype(int itemtype) {
        this.itemtype = itemtype;
    }
}
