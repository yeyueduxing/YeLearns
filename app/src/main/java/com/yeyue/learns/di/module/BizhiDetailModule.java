package com.yeyue.learns.di.module;

import com.jess.arms.di.scope.ActivityScope;
import com.yeyue.learns.contract.BizhiDetailContract;
import com.yeyue.learns.model.BizhiDetailModel;

import dagger.Module;
import dagger.Provides;


@Module
public class BizhiDetailModule {
    private BizhiDetailContract.View view;

    /**
     * 构建DetailModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public BizhiDetailModule(BizhiDetailContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    BizhiDetailContract.View provideDetailView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    BizhiDetailContract.Model provideDetailModel(BizhiDetailModel model) {
        return model;
    }
}