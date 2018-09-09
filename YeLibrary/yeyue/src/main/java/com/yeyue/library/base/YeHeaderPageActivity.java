package com.yeyue.library.base;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.jess.arms.mvp.IPresenter;
import com.yeyue.library.R;
import com.yeyue.library.adapter.YeAdapterViewPager;

import java.util.ArrayList;

/**
  *@describe Viewpager的顶部下拉Activity
  *@author li.xiao
  *@time 2017-9-5 9:49
  */
public abstract class YeHeaderPageActivity<P extends IPresenter> extends YeHeaderContentActivity< P> {
    protected TabLayout mTabLayout;
    protected ViewPager mViewPager;

    public abstract String[] getTitlse();
    public abstract ArrayList<Fragment> getFragment();

    @Override
    public int setContentId() {
        return R.layout.yeyue_common_page_header_content;
    }
    @Override
    public void findView() {
        super.findView();
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

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void launchActivity(Intent intent) {

    }
}
