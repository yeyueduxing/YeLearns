package com.yeyue.learns.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.yeyue.learns.contract.GankDayContract;
import com.yeyue.learns.model.GankDayModel;


@Module
public class GankDayModule {
    private GankDayContract.View view;

    /**
     * 构建GankDayModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public GankDayModule(GankDayContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    GankDayContract.View provideGankDayView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    GankDayContract.Model provideGankDayModel(GankDayModel model) {
        return model;
    }
}