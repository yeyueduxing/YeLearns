package com.yeyue.learns.ui.main.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.jess.arms.di.component.AppComponent;
import com.yeyue.learns.constant.Constant;
import com.yeyue.learns.enity.CMFragment;
import com.yeyue.learns.ui.diycode.fragment.DiyCodeListFragment;
import com.yeyue.learns.ui.gank.fragment.GankListFragment;
import com.yeyue.library.base.YeFragmentActivity;
/**
  *@describe 通用的展示Fragment的Activity
  *@author li.xiao
  *@time 2018-1-5 15:01
  */
public class CommonFragmentActivity extends YeFragmentActivity{
    private CMFragment cmFragment;
    private int type;

    @Override
    public Fragment getFragment() {
        Fragment fragment = null;
        switch (type){
            case Constant.DIYCODE_TOPIC_NODE:
                fragment = DiyCodeListFragment.newInstance(Constant.DIYCODE_TOPIC_NODE,cmFragment.getExtend());
                break;
            case Constant.Gank_DATA_TYPE:
                fragment = GankListFragment.newInstance(Constant.Gank_DATA_TYPE,cmFragment.getExtend());
                break;
        }
        return fragment;
    }

    @Override
    public void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public void initData(Bundle bundle) {
        if(getIntent()!=null){
            if(getIntent().hasExtra(Constant.COMMON_SHOW_FRAGMENT)){
                cmFragment = (CMFragment) getIntent().getSerializableExtra(Constant.COMMON_SHOW_FRAGMENT);
            }
        }
        if(cmFragment==null){
            finish();
            return;
        }
        type = cmFragment.getType();
        super.initData(bundle);
        setTitle(cmFragment.getTitle());
    }

    @Override
    public boolean isToolbar() {
        return true;
    }
}
