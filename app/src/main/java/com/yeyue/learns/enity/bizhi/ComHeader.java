package com.yeyue.learns.enity.bizhi;

import com.yeyue.learns.constant.AdapterConstant;
import com.yeyue.library.data.BaseItem;

/**
  *@describe 通用页面头部
  *@author Administrator
  *@time 2017/11/4 0004 下午 8:04
  */
public class ComHeader extends BaseItem{
    public static final int DEFAULT = 0;
    public static final int NO_LEFT_ICON = 1;
    public static final int ICON_INSET = 2;

    private int type;
    private String title;
    private int leftIcon;
    private boolean hasLeftIcon;

    @Override
    public int getItemType() {
        return AdapterConstant.ITEM_BIZHI_COMMON_HEADER;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLeftIcon() {
        return leftIcon;
    }

    public void setLeftIcon(int leftIcon) {
        this.leftIcon = leftIcon;
    }

    public boolean isHasLeftIcon() {
        return hasLeftIcon;
    }

    public void setHasLeftIcon(boolean hasLeftIcon) {
        this.hasLeftIcon = hasLeftIcon;
    }
}
