package com.yeyue.library.data;

import com.yeyue.library.constant.YeConstant;


public class YeLoadtype extends BaseItem {
    private String indicator;
    @Override
    public int getItemType() {
        return YeConstant.ITEM_LOADTYPE_DEFAULT;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }
}