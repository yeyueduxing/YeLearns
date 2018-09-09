package com.yeyue.library.contract;

import android.support.v4.app.Fragment;

import com.jess.arms.mvp.IView;

import java.util.List;

/**
 * author: xiaofeng
 * created on: 2016/9/12
 * describe:
 */
public interface YeSearchView extends IView {
    void insertSearchHistorySuccess(String searchHistoryBean);
    void querySearchHistorySuccess(List<String> datas);
    void refreshSearch(String query);
    Fragment getFragment(String query);
}
