package com.yeyue.learns.ui.main.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.jess.arms.di.component.AppComponent;
import com.yeyue.learns.ui.main.fragment.SettingFragment;
import com.yeyue.library.base.YeFragmentActivity;

/**
 * Created by li.xiao on 2018-1-24.
 */

public class SettingActivity extends YeFragmentActivity{
    @Override
    public Fragment getFragment() {
        return new SettingFragment();
    }

    @Override
    public void initData(Bundle bundle) {
        super.initData(bundle);
        setTitle("设置");
    }

    @Override
    public boolean isToolbar() {
        return true;
    }

    @Override
    public void setupActivityComponent(AppComponent appComponent) {

    }
}
