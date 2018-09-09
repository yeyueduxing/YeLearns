package com.yeyue.learns.enity.movie;

import com.yeyue.learns.constant.AdapterConstant;
import com.yeyue.library.data.BaseItem;

import java.util.List;

/**
 * Created by li.xiao on 2018-1-25.
 */

public class MovieImageList extends BaseItem{
    private List<MovieImage> list;

    @Override
    public int getItemType() {
        return AdapterConstant.ITME_MOVIE_IMAGE_LIST;
    }

    public List<MovieImage> getList() {
        return list;
    }

    public void setList(List<MovieImage> list) {
        this.list = list;
    }
}
