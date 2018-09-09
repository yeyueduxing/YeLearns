package com.yeyue.learns.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.yeyue.learns.contract.BannerContract;
import com.yeyue.learns.model.BannerModel;


@Module
public class BannerModule {
    private BannerContract.View view;

    /**
     * 构建BannerModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public BannerModule(BannerContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    BannerContract.View provideBannerView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    BannerContract.Model provideBannerModel(BannerModel model) {
        return model;
    }
}