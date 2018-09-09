package com.yeyue.library.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.blankj.utilcode.util.ObjectUtils;
import com.blankj.utilcode.util.SPUtils;
import com.jaeger.library.StatusBarUtil;
import com.jess.arms.mvp.IPresenter;
import com.yeyue.library.R;
import com.yeyue.library.constant.YeConstant;
import com.yeyue.library.data.YeSkinItem;

import org.simple.eventbus.Subscriber;

import skin.support.content.res.SkinCompatResources;

/**
  *@describe 侧滑Fragment
  *@author li.xiao
  *@time 2018-1-5 10:45
  */
public abstract class YeDrawerFragmentActivity<P extends IPresenter> extends BaseUiActivity<P> implements NavigationView.OnNavigationItemSelectedListener {
    protected String TAG_PRE = "drawer_fragment_";
    protected NavigationView mNavView;
    protected DrawerLayout mDrawerLayout;
    protected FrameLayout yeContentContainer;

    protected FragmentManager fragmentManager;
    protected FragmentTransaction fragmentTransaction;
    protected String showTag;
    public abstract Fragment getFragment(int tag);
    public abstract boolean onNavItemSelected(MenuItem item);
    public abstract int initDefaultTag();
    public abstract void intToolBar();
    public abstract int getNavHeaderViewId();
    public abstract int getNavMenuId();

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.yeyue_common_drawerlayout_base;
    }

    @Override
    public int getContentViewId() {
        return R.layout.yeyue_common_drawerlayout_fragment;
    }

    @Override
    public void findView() {
        fragmentManager = getSupportFragmentManager();
        yeContentContainer = (FrameLayout) findViewById(R.id.ye_contentContainer);
        mNavView = (NavigationView) findViewById(R.id.ye_nav_view);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.ye_drawer_layout);
    }

    public DrawerLayout getDrawerLayout() {
        return mDrawerLayout;
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

        int showTag = SPUtils.getInstance().getInt(YeConstant.YE_DRAWER_TAG,initDefaultTag());
        try{
            MenuItem item = mNavView.getMenu().findItem(showTag);
            item.setCheckable(true);//设置选项可选
            item.setChecked(true);//设置选型被选中
        }catch (Exception e){

        }
        goFragment(showTag);
        if(isToolbar()){
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            mDrawerLayout.addDrawerListener(toggle);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            toggle.syncState();
        }
        updateAppSkin(new YeSkinItem());
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        mDrawerLayout.closeDrawer(GravityCompat.START);
        if(onNavItemSelected(item)){
            item.setCheckable(true);//设置选项可选
            item.setChecked(true);//设置选型被选中
        }
        return true;
    }
    /**
     * 皮肤更新
     * @param skin
     */
    @Subscriber
    public void updateAppSkin(YeSkinItem skin) {
        if(mDrawerLayout==null){
            return;
        }
        //设置状态栏透明度
        int color = SkinCompatResources.getInstance().getColor(R.color.ye_color_Navigation_Base);
        StatusBarUtil.setColorNoTranslucentForDrawerLayout(getActivity(), mDrawerLayout, color);
    }
    public void goFragment(int tag,boolean enableSave){
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
            if(enableSave){
                SPUtils.getInstance().put(YeConstant.YE_DRAWER_TAG,tag);
            }
            fragmentTransaction.replace(R.id.ye_contentContainer,fragment,TAG_PRE+tag);
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
    public void goFragment(int tag){
        goFragment(tag,true);
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


    @Override
    public void onBackPressed() {
        if(mDrawerLayout==null){
            super.onBackPressed();
            return;
        }
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(mDrawerLayout==null){
            return super.onKeyDown(keyCode, event);
        }
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                mDrawerLayout.closeDrawer(GravityCompat.START);
            } else {
                // 不退出程序，进入后台
                moveTaskToBack(true);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
