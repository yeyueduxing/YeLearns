package com.yeyue.library.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import com.jess.arms.base.AdapterViewPager;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.mvp.IPresenter;
import com.yeyue.library.R;

import java.util.ArrayList;

/**
 * 通用应用侧滑主页和多分类主页
 * @param <P>
 */
public abstract class YeDrawerLayActivity<P extends IPresenter> extends BaseUiActivity<P> implements Toolbar.OnMenuItemClickListener,NavigationView.OnNavigationItemSelectedListener {
    protected TabLayout mTabLayout;
    protected ViewPager mViewPager;
    protected NavigationView mNavView;
    protected DrawerLayout mDrawerLayout;
    protected Toolbar mMaintoolbar;

    public abstract String[] getTitlse();
    public abstract ArrayList<Fragment> getFragment();
    public abstract void intToolBar();
    public abstract int getNavHeaderViewId();
    public abstract int getNavMenuId();
    public abstract int getToolMenuId();
    @Override
    public int getContentViewId() {
        return R.layout.yeyue_common_drawerlayout;
    }

    @Override
    public void findView() {
         mTabLayout = (TabLayout) findViewById(R.id.ye_tab_layout);
         mViewPager = (ViewPager) findViewById(R.id.ye_view_pager);
         mNavView = (NavigationView) findViewById(R.id.ye_nav_view);
         mDrawerLayout = (DrawerLayout) findViewById(R.id.ye_drawer_layout);
         mMaintoolbar= (Toolbar) findViewById(R.id.ye_nav_toolbar);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        //获取数据
        if(getToolMenuId()!=0){
            mMaintoolbar.inflateMenu(getToolMenuId());
            mMaintoolbar.setOnMenuItemClickListener(this);
        }
        intToolBar();
        //setSupportActionBar(mMaintoolbar);

        mViewPager.setAdapter(new AdapterViewPager(getSupportFragmentManager(), getFragment(), getTitlse()));
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        mViewPager.setOffscreenPageLimit(2);
        mTabLayout.setupWithViewPager(mViewPager);
        //设置Tab可以滑动
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mMaintoolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        if(getNavHeaderViewId()!=0){
            mNavView.inflateHeaderView(getNavHeaderViewId());
        }
        if(getNavMenuId()!=0){
            mNavView.inflateMenu(getNavMenuId());
        }
        mNavView.setNavigationItemSelectedListener(this);

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

    }


    @Override
    public boolean isToolbar() {
        return false;
    }

    /**
     * 提供AppComponent(提供所有的单例对象)给实现类，进行Component依赖
     *
     * @param appComponent
     */
    @Override
    public void setupActivityComponent(AppComponent appComponent) {

    }

}
