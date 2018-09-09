package com.yeyue.learns.ui.gamersky.fragment;

import android.support.v4.app.Fragment;
import android.view.MenuItem;

import com.jess.arms.di.component.AppComponent;
import com.yeyue.learns.constant.Constant;
import com.yeyue.library.base.YePageFragment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/1/14 0014.
 */

public class GamerSkyFragment extends YePageFragment{
    private String[] titles = {"头条","关注","游戏","趣味","影视","科技","动漫","点评","产业","手游","福利"};
    private String[] nodeIds = {"0","48,42,87,89,83,84","16","32","30","19","31","6","4","33","43"};
    @Override
    public String[] getTitlse() {
        return titles;
    }

    @Override
    public ArrayList<Fragment> getFragment() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i=0;i<titles.length;i++){
            fragments.add(GamerSkyListFragment.newInstance(Constant.GAMERSKY_TYPE_LIST,nodeIds[i]));
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
    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {

    }

    @Override
    public void setData(Object o) {

    }

    @Override
    public boolean isToolbar() {
        return false;
    }
}
