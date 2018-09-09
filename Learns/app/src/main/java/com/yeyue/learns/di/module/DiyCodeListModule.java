package com.yeyue.learns.di.module;

import com.jess.arms.di.scope.ActivityScope;
import com.yeyue.learns.contract.DiyCodeListContract;
import com.yeyue.learns.model.DiyCodeListModel;

import dagger.Module;
import dagger.Provides;


@Module
public class DiyCodeListModule {
    private DiyCodeListContract.View view;

    /**
     * 构建CommonListModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public DiyCodeListModule(DiyCodeListContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    DiyCodeListContract.View provideCommonListView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    DiyCodeListContract.Model provideCommonListModel(DiyCodeListModel model) {
        return model;
    }
}