package com.yeyue.learns.enity.gank;

import com.yeyue.library.data.BaseItem;

import java.util.List;

/**
 * Created by Administrator on 2018/1/6 0006.
 */

public class GankHttpRequest<T> extends BaseItem{

    private boolean error;
    private List<T> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}
