package com.yeyue.learns.ui.main.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.jess.arms.di.component.AppComponent;
import com.yeyue.learns.contract.SearchContract;
import com.yeyue.learns.di.component.DaggerSearchComponent;
import com.yeyue.learns.di.module.SearchModule;
import com.yeyue.learns.presenter.SearchPresenter;
import com.yeyue.library.base.YeSearchFragmentActivity;


public class SearchActivity extends YeSearchFragmentActivity<SearchPresenter> implements SearchContract.View {


    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        DaggerSearchComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .searchModule(new SearchModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        mPresenter.getSearch(true);
    }

    @Override
    public void killMyself() {
        finish();
    }

    @Override
    public Fragment getFragment(String query) {
        return null;
    }

    @Override
    public boolean isToolbar() {
        return false;
    }

    @Override
    public void refreshSearch(String query) {

    }
}
