package com.yeyue.learns.enity.wechat;

import android.text.TextUtils;

import com.yeyue.learns.constant.AdapterConstant;
import com.yeyue.library.data.BaseItem;

/**
 * Created by li.xiao on 2018-1-12.
 */

public class WeChatTag extends BaseItem{
    private String title;
    private String pic;
    private String tag;
    private String desc;
    private boolean isCheck;
    @Override
    public int getItemType() {
        return AdapterConstant.ITEM_WECHAT_NEW_TAG;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null || !(obj instanceof WeChatTag)){
            return false;
        }
        if(!TextUtils.isEmpty(tag) && tag.equals(((WeChatTag) obj).tag)){
            return true;
        }
        return super.equals(obj);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }
}
