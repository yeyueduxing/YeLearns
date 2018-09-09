package com.yeyue.learns.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.yeyue.learns.contract.WanListContract;
import com.yeyue.learns.model.WanListModel;


@Module
public class WanListModule {
    private WanListContract.View view;

    /**
     * 构建WanListModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public WanListModule(WanListContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    WanListContract.View provideWanListView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    WanListContract.Model provideWanListModel(WanListModel model) {
        return model;
    }
}