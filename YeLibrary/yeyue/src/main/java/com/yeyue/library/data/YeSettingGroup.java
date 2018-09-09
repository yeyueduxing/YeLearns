package com.yeyue.library.data;

import com.yeyue.library.constant.YeConstant;

/**
  *@describe 设置分组布局
  *@author li.xiao
  *@time 2017-12-26 14:16
  */
public class YeSettingGroup extends BaseItem {
    private String title;
    private boolean isTop;
    @Override
    public int getItemType() {
        return YeConstant.YE_ITEM_SETTING_GROUP;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isTop() {
        return isTop;
    }

    public void setTop(boolean top) {
        isTop = top;
    }
}
