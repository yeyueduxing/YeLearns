package com.yeyue.learns.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.yeyue.learns.contract.GamerSkyListContract;
import com.yeyue.learns.model.GamerSkyListModel;


@Module
public class GamerSkyListModule {
    private GamerSkyListContract.View view;

    /**
     * 构建GamerSkyListModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     */
    public GamerSkyListModule(GamerSkyListContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    GamerSkyListContract.View provideGamerSkyListView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    GamerSkyListContract.Model provideGamerSkyListModel(GamerSkyListModel model) {
        return model;
    }
}