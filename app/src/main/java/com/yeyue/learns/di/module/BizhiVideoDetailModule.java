package com.yeyue.learns.di.module;

import com.jess.arms.di.scope.ActivityScope;
import com.yeyue.learns.contract.BizhiVideoDetailContract;
import com.yeyue.learns.model.BizhiVideoDetailModel;

import dagger.Module;
import dagger.Provides;


@Module
public class BizhiVideoDetailModule {
    private BizhiVideoDetailContract.View view;

    /**
     * 构建VideoDetailModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public BizhiVideoDetailModule(BizhiVideoDetailContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    BizhiVideoDetailContract.View provideVideoDetailView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    BizhiVideoDetailContract.Model provideVideoDetailModel(BizhiVideoDetailModel model) {
        return model;
    }
}