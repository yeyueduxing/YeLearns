package com.yeyue.learns.ui.diycode.fragment;

import android.support.v4.app.Fragment;
import android.view.MenuItem;

import com.jess.arms.di.component.AppComponent;
import com.yeyue.learns.constant.Constant;
import com.yeyue.library.base.YePageFragment;

import java.util.ArrayList;

/**
  *@describe DiyCode代码资讯页
  *@author li.xiao
  *@time 2018-1-5 10:55
  */
public class DiycodeFragment extends YePageFragment{
    private String[] titles = {"TOPICS","NEWS","SITE"};
    @Override
    public String[] getTitlse() {
        return titles;
    }

    @Override
    public ArrayList<Fragment> getFragment() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i=0;i<titles.length;i++){
            if(i==0){
                fragments.add(DiyCodeListFragment.newInstance(Constant.DIYCODE_TOPIC_LIST));
            }else if(i==1){
                fragments.add(DiyCodeListFragment.newInstance(Constant.DIYCODE_NEW_LIST));
            }else{
                fragments.add(DiyCodeListFragment.newInstance(Constant.DIYCODE_SITE_LIST));
            }
        }
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
