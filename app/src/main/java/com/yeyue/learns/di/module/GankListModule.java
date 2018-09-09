package com.yeyue.learns.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.yeyue.learns.contract.GankListContract;
import com.yeyue.learns.model.GankListModel;


@Module
public class GankListModule {
    private GankListContract.View view;

    /**
     * 构建GankListModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     */
    public GankListModule(GankListContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    GankListContract.View provideGankListView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    GankListContract.Model provideGankListModel(GankListModel model) {
        return model;
    }
}