package com.yeyue.learns.enity.movie;

import com.yeyue.learns.constant.AdapterConstant;
import com.yeyue.library.data.BaseItem;


public class MovieCount<T> extends BaseItem {
    private String content;
    private T object;
    @Override
    public int getItemType() {
        return AdapterConstant.ITEM_MOVIE_COUNT_DEFAULT;
    }


    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}