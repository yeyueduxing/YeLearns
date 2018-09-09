package com.yeyue.learns.di.component;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.yeyue.learns.di.module.WanListModule;

import com.yeyue.learns.ui.wan.fragment.WanListFragment;

@ActivityScope
@Component(modules = WanListModule.class, dependencies = AppComponent.class)
public interface WanListComponent {
    void inject(WanListFragment fragment);
}