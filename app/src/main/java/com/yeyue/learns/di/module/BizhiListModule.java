package com.yeyue.learns.di.module;

import com.jess.arms.di.scope.ActivityScope;
import com.yeyue.learns.contract.BizhiListContract;
import com.yeyue.learns.model.BizhiHomeModel;

import dagger.Module;
import dagger.Provides;


@Module
public class BizhiListModule {
    private BizhiListContract.View view;

    /**
     * 构建HomeModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public BizhiListModule(BizhiListContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    BizhiListContract.View provideHomeView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    BizhiListContract.Model provideHomeModel(BizhiHomeModel model) {
        return model;
    }
}