package com.yeyue.learns.ui.bizhi.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.jess.arms.di.component.AppComponent;
import com.yeyue.learns.R;
import com.yeyue.learns.constant.Constant;
import com.yeyue.library.base.YeBottomBarFragment;

/**
 * Created by li.xiao on 2018-1-31.
 */

public class BizhiFragment extends YeBottomBarFragment{

    @Override
    public Fragment getFragment(int tag) {
        Fragment fragment = null;
        switch (tag) {
            case R.id.tab_home:
                fragment =  BiZhiPageFragment.newInstance(Constant.BIZHI_PAGE_HOME);
                break;
            case R.id.tab_vertical:
                fragment = BiZhiPageFragment.newInstance(Constant.BIZHI_PAGE_VERTICAL);
                break;
            case R.id.tab_video:
                fragment = BiZhiPageFragment.newInstance(Constant.BIZHI_PAGE_VIDEO);
                break;
        }
        return fragment;
    }

    @Override
    public int inflateMenu() {
        return R.menu.bizhi_tabs;
    }

    @Override
    public int defaultItem() {
        return R.id.tab_home;
    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {

    }

    @Override
    public boolean isToolbar() {
        return false;
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public void setData(Object data) {

    }


    @Override
    public void initData() {
    }
    @Override
    public void initView(View mRootView) {

    }

    @Override
    public void onInitView() {

    }

    @Override
    public void killMyself() {

    }
}
