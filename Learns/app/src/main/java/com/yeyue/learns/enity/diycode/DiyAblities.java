package com.yeyue.learns.enity.diycode;

import com.yeyue.library.data.BaseItem;

/**
 * Created by li.xiao on 2018-1-5.
 */

public class DiyAblities extends BaseItem{
    /**
     * update : false
     * destroy : false
     */

    private boolean update;
    private boolean destroy;

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public boolean isDestroy() {
        return destroy;
    }

    public void setDestroy(boolean destroy) {
        this.destroy = destroy;
    }
}
