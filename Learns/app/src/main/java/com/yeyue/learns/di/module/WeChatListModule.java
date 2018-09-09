package com.yeyue.learns.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.yeyue.learns.contract.WeChatListContract;
import com.yeyue.learns.model.WeChatListModel;


@Module
public class WeChatListModule {
    private WeChatListContract.View view;

    /**
     * 构建WeChatListModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public WeChatListModule(WeChatListContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    WeChatListContract.View provideWeChatListView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    WeChatListContract.Model provideWeChatListModel(WeChatListModel model) {
        return model;
    }
}