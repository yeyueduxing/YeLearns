package com.yeyue.learns.enity.movie;

import com.yeyue.learns.constant.AdapterConstant;
import com.yeyue.library.data.BaseItem;

import java.util.List;

/**
 * Created by li.xiao on 2018-1-25.
 */

public class MovieList<T> extends BaseItem{
    private List<T> list;

    @Override
    public int getItemType() {
        return AdapterConstant.ITME_MOVIE_PERSONAL_LIST;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
