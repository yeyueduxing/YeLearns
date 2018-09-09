package com.yeyue.library.contract;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import com.jess.arms.mvp.IView;

/**
 * author: xiaofeng
 * created on: 2016/9/12
 * describe:
 */
public interface YeBaseUiView extends IView {
    void initView(View mRootView);
    int getContentViewId();
    void onInitView();
    boolean isToolbar();
    int getBackgroundRes();
    void setAppContentBackground(int res);
    void setAppNavBackGround(int res);
    void setTitle(String title);
    void onNavLeftClick();
    Activity getActivity();
    View getLoadView();
    void showLoadSirView(String status);
    void onShowTransport(Context context,View view,String status);
    void onViewReload();
}
