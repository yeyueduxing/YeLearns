package com.yeyue.library.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jess.arms.mvp.IPresenter;
import com.r0adkll.slidr.model.SlidrInterface;
import com.yeyue.library.R;
import com.yeyue.library.adapter.YeAdapterViewPager;

import java.util.ArrayList;

/**
 * 通用ViewPageFragment
 * @param <P>
 */
public abstract class YePageActivity<P extends IPresenter> extends BaseUiActivity<P> implements Toolbar.OnMenuItemClickListener {
    protected TabLayout mTabLayout;
    protected ViewPager mViewPager;

    public abstract String[] getTitlse();
    public abstract ArrayList<Fragment> getFragment();
    @Override
    public int getContentViewId() {
        return R.layout.yeyue_common_fragment_page;
    }


    @Override
    public void initView(View mRootView) {
        super.initView(mRootView);
        mTabLayout = (TabLayout) findViewById(R.id.ye_tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.ye_view_pager);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        if(getTitlse()==null || getTitlse().length==0){
            return;
        }
        resetViewPage();
    }
    public void resetViewPage(){
        mViewPager.setAdapter(new YeAdapterViewPager(getSupportFragmentManager(), getFragment(), getTitlse()));
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if(slidrInterface!=null){
                    if (position == 0){
                        slidrInterface.unlock();
                    }else{
                        slidrInterface.lock();
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        mViewPager.setOffscreenPageLimit(1);
        mTabLayout.setupWithViewPager(mViewPager);
        //设置Tab可以滑动
        if(getTitlse().length<=4){
            mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        }else{
            mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        }
    }
    public void reloadViewPage(){
        mViewPager.setAdapter(new YeAdapterViewPager(getSupportFragmentManager(), getFragment(), getTitlse()));
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

    @Override
    public View getLoadView() {
        return null;
    }
}
