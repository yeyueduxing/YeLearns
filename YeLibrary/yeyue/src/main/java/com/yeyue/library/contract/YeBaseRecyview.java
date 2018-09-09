package com.yeyue.library.contract;

import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * author: xiaofeng
 * created on: 2016/9/12
 * describe:
 */
public interface YeBaseRecyview<T> extends YeBaseUiView{
    void refreshUI(List<T> data);
    void updateUI(T data);
    void deleteUI(T data);
    void onError(String error);

    void loadMore(List<T> data, boolean hasMore);
    void onDataRefresh();

    void onDataLoadMore();
    void startLoadMore();
    void endLoadMore();
    int getReHeaderView();
    int getReFooterView();
    boolean enableRefresh();
    boolean enableMore();
    BaseQuickAdapter<T, BaseViewHolder> getAdapter();

    RecyclerView.LayoutManager getLayoutManager();
}
