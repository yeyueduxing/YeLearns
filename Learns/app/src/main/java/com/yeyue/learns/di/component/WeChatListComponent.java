package com.yeyue.learns.di.component;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.yeyue.learns.di.module.WeChatListModule;

import com.yeyue.learns.ui.wechat.fragment.WeChatListFragment;

@ActivityScope
@Component(modules = WeChatListModule.class, dependencies = AppComponent.class)
public interface WeChatListComponent {
    void inject(WeChatListFragment fragment);
}