package com.yeyue.library.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.blankj.utilcode.util.ObjectUtils;
import com.jess.arms.mvp.IPresenter;
import com.yeyue.library.R;

/**
 *@describe 底部侧滑页面
 *@author li.xiao
 *@time 2017-10-31 14:51
 */
public abstract class YeDrawerBottomActivity<P extends IPresenter> extends BaseUiActivity<P> implements BottomNavigationView.OnNavigationItemSelectedListener,NavigationView.OnNavigationItemSelectedListener {
    protected String TAG_PRE = "bottom_bar_";
    protected BottomNavigationView yeBootomBar;
    protected NavigationView mNavView;
    protected DrawerLayout mDrawerLayout;
    protected FrameLayout yeContentContainer;

    protected FragmentManager fragmentManager;
    protected FragmentTransaction fragmentTransaction;
    protected String showTag;
    public abstract Fragment getFragment(int tag);
    public abstract void intToolBar();
    public abstract int getNavHeaderViewId();
    public abstract int getNavMenuId();
    public abstract int inflateMenu();
    public abstract int defaultItem();

    @Override
    public int getContentViewId() {
        return R.layout.yeyue_common_drawerlayout_bottom;
    }

    @Override
    public void findView() {
        fragmentManager = getSupportFragmentManager();
        yeContentContainer = (FrameLayout) findViewById(R.id.ye_contentContainer);
        yeBootomBar = (BottomNavigationView) findViewById(R.id.ye_bottomBar);
        mNavView = (NavigationView) findViewById(R.id.ye_nav_view);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.ye_drawer_layout);
    }
    @Override
    public void initData(Bundle savedInstanceState) {
        intToolBar();
        if(getNavHeaderViewId()!=0){
            mNavView.inflateHeaderView(getNavHeaderViewId());
        }
        if(getNavMenuId()!=0){
            mNavView.inflateMenu(getNavMenuId());
        }
        mNavView.setNavigationItemSelectedListener(this);
        yeBootomBar.setOnNavigationItemSelectedListener(this);
        if(inflateMenu()!=0){
            yeBootomBar.inflateMenu(inflateMenu());
        }
        if(defaultItem()!=0){
            yeBootomBar.setSelectedItemId(defaultItem());
        }
    }

    @Override
    public boolean  onNavigationItemSelected(@NonNull MenuItem item) {
        goFragment(item.getItemId());
        return false;
    }

    public void goFragment(int tag){
        fragmentTransaction = fragmentManager.beginTransaction();
        if(!ObjectUtils.isEmpty(showTag)){
            Fragment showFragment = fragmentManager.findFragmentByTag(showTag);
            if(showFragment!=null){
                fragmentTransaction.hide(showFragment);
            }
        }
        Fragment  fragment = fragmentManager.findFragmentByTag(TAG_PRE+tag);
        if(fragment==null){
            fragment = getFragment(tag);
            if(fragment==null){
                showTag = null;
                return;
            }
            fragmentTransaction.add(R.id.ye_contentContainer,fragment,TAG_PRE+tag);
        }else{
            fragmentTransaction.show(fragment);
        }
        showTag = TAG_PRE+tag;
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
    public View getLoadView() {
        return null;
    }

    @Override
    public boolean isToolbar() {
        return false;
    }


}
