package com.yeyue.learns.ui.gank.fragment;

import android.support.v4.app.Fragment;
import android.view.MenuItem;

import com.jess.arms.di.component.AppComponent;
import com.yeyue.learns.constant.Constant;
import com.yeyue.learns.ui.main.fragment.BannerFragment;
import com.yeyue.library.base.YePageFragment;

import java.util.ArrayList;
/**
  *@describe 干货集中营
  *@author Administrator
  *@time 2018/1/6 0006 上午 9:51
  */
public class GankFragment extends YePageFragment{
    private String[] titles = {"干货","福利","推荐"};
    @Override
    public String[] getTitlse() {
        return titles;
    }

    @Override
    public ArrayList<Fragment> getFragment() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(BannerFragment.newInstance(Constant.GANK_DATA_LIST,""));
        fragments.add(GankListFragment.newInstance(Constant.GANK_DATA_FULI));
        fragments.add(new GankDayFragment());
        return fragments;
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void intToolBar() {

    }

    @Override
    public int getToolMenuId() {
        return 0;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {

    }

    @Override
    public boolean isToolbar() {
        return false;
    }

    @Override
    public void setData(Object data) {

    }
}
