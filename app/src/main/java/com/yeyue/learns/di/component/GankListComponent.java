package com.yeyue.learns.di.component;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.yeyue.learns.di.module.GankListModule;

import com.yeyue.learns.ui.gank.fragment.GankListFragment;

@ActivityScope
@Component(modules = GankListModule.class, dependencies = AppComponent.class)
public interface GankListComponent {
    void inject(GankListFragment fragment);
}