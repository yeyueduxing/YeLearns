package com.yeyue.learns.enity.movie;

import com.yeyue.learns.constant.AdapterConstant;
import com.yeyue.library.data.BaseItem;

/**
 * Created by li.xiao on 2018-1-25.
 */

public class MovieCateGory extends BaseItem{
    private String title;
    private String content;
    @Override
    public int getItemType() {
        return AdapterConstant.ITME_MOVIE_CATE_GORY;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
