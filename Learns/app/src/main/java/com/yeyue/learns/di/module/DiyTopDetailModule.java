package com.yeyue.learns.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.yeyue.learns.contract.DiyTopDetailContract;
import com.yeyue.learns.model.DiyTopDetailModel;


@Module
public class DiyTopDetailModule {
    private DiyTopDetailContract.View view;

    /**
     * 构建DiyTopDetailModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public DiyTopDetailModule(DiyTopDetailContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    DiyTopDetailContract.View provideDiyTopDetailView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    DiyTopDetailContract.Model provideDiyTopDetailModel(DiyTopDetailModel model) {
        return model;
    }
}