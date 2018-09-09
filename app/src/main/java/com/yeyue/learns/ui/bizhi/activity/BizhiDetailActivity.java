package com.yeyue.learns.ui.bizhi.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.jess.arms.di.component.AppComponent;
import com.yeyue.learns.constant.Constant;
import com.yeyue.learns.enity.bizhi.DetailBean;
import com.yeyue.learns.ui.bizhi.fragment.BizhiDetailFragment;
import com.yeyue.library.base.YeFragmentActivity;

/**
  *@describe 精选
  *@author Administrator
  *@time 2017/11/5 0005 下午 6:47
  */
public class BizhiDetailActivity extends YeFragmentActivity{
    private DetailBean detailBean;
    @Override
    public Fragment getFragment() {
        return  BizhiDetailFragment.newInstance(detailBean);
    }

    @Override
    public void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public void initData(Bundle bundle) {
        if(getIntent()!=null && getIntent().hasExtra(Constant.DETAIL_INFO)){
            if(getIntent().hasExtra(Constant.DETAIL_INFO)){
                detailBean = (DetailBean) getIntent().getSerializableExtra(Constant.DETAIL_INFO);
            }
        }
        setTitle("壁纸");
        super.initData(bundle);
    }

    @Override
    public boolean isToolbar() {
        return true;
    }
}
