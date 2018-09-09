package com.yeyue.learns.enity;

import com.yeyue.library.data.BaseItem;

/**
 * Created by li.xiao on 2018-1-5.
 */

public class CMFragment extends BaseItem{
    private int type;
    private String extend;
    private String title;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
