package com.yeyue.library.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;

import com.jess.arms.mvp.IPresenter;
import com.yeyue.library.R;

/**
 * 单个Fragment的Activity
 * @param <P>
 */
public abstract class YeFragmentActivity<P extends IPresenter> extends BaseUiActivity<P>  {
    protected FrameLayout yeContentContainer;

    protected FragmentManager fragmentManager;
    protected FragmentTransaction fragmentTransaction;
    public abstract Fragment getFragment();
    @Override
    public int getContentViewId() {
        return R.layout.yeyue_common_fragment_activity;
    }

    @Override
    public void findView() {
        fragmentManager = getSupportFragmentManager();
        yeContentContainer = (FrameLayout) findViewById(R.id.ye_contentContainer);
    }

    @Override
    public void initData(Bundle bundle) {
        initFragment();
    }

    public void initFragment(){
        fragmentTransaction = fragmentManager.beginTransaction();
        Fragment  fragment = getFragment();
        fragmentTransaction.add(R.id.ye_contentContainer,fragment);
        fragmentTransaction.commit();
        if(fragment instanceof BaseUiFragment){
            BaseUiFragment uiFragment = (BaseUiFragment) fragment;
            uiFragment.resume();
        }
    }

    /**
     * 显示加载
     */
    @Override
    public void showLoading() {

    }

    /**
     * 隐藏加载
     */
    @Override
    public void hideLoading() {

    }

    /**
     * 显示信息
     *
     * @param message
     */
    @Override
    public void showMessage(String message) {

    }

    /**
     * 跳转activity
     *
     * @param intent
     */
    @Override
    public void launchActivity(Intent intent) {

    }

    /**
     * 杀死自己
     */
    @Override
    public void killMyself() {
        finish();
    }


    @Override
    public boolean isToolbar() {
        return false;
    }

    @Override
    public View getLoadView() {
        return null;
    }
}
