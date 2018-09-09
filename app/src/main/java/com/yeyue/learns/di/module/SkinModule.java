package com.yeyue.learns.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.yeyue.learns.contract.SkinContract;
import com.yeyue.learns.model.SkinModel;


@Module
public class SkinModule {
    private SkinContract.View view;

    /**
     * 构建SkinModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public SkinModule(SkinContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    SkinContract.View provideSkinView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    SkinContract.Model provideSkinModel(SkinModel model) {
        return model;
    }
}