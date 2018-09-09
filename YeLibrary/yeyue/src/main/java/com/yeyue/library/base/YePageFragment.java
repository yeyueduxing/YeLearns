package com.yeyue.library.base;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jess.arms.mvp.IPresenter;
import com.yeyue.library.R;
import com.yeyue.library.adapter.YeAdapterViewPager;

import java.util.ArrayList;

/**
 * 通用ViewPageFragment
 * @param <P>
 */
public abstract class YePageFragment<P extends IPresenter> extends BaseUiFragment<P> implements Toolbar.OnMenuItemClickListener,ViewPager.OnPageChangeListener {
    protected TabLayout mTabLayout;
    protected ViewPager mViewPager;
    protected Toolbar mMaintoolbar;

    public abstract String[] getTitlse();
    public abstract ArrayList<Fragment> getFragment();
    public abstract void intToolBar();
    public abstract int getToolMenuId();
    @Override
    public int getContentViewId() {
        return R.layout.yeyue_common_fragment_page;
    }

    @Override
    public void findView(View rootView) {
         mTabLayout = (TabLayout) rootView.findViewById(R.id.ye_tab_layout);
         mViewPager = (ViewPager) rootView.findViewById(R.id.ye_view_pager);
         mMaintoolbar= (Toolbar) rootView.findViewById(R.id.ye_nav_toolbar);
    }

    @Override
    public void initData() {
        //获取数据
        if(getToolMenuId()!=0){
            mMaintoolbar.inflateMenu(getToolMenuId());
            mMaintoolbar.setOnMenuItemClickListener(this);
        }
        intToolBar();

        mViewPager.setAdapter(new YeAdapterViewPager(getChildFragmentManager(), getFragment(), getTitlse()));
        mViewPager.addOnPageChangeListener(this);
        mViewPager.setOffscreenPageLimit(2);
        mTabLayout.setupWithViewPager(mViewPager);
        //设置Tab可以滑动
        if(getTitlse().length<=4){
            mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        }else{
            mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        }
    }
    public void reloadViewPage(){
        mViewPager.setAdapter(new YeAdapterViewPager(getChildFragmentManager(), getFragment(), getTitlse()));
        //设置Tab可以滑动
        if(getTitlse().length<=4){
            mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        }else{
            mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
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

    }

    @Override
    public void initView(View mRootView) {

    }

    @Override
    public void onInitView() {

    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
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
