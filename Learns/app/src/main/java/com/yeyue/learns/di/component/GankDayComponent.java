package com.yeyue.learns.di.component;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.yeyue.learns.di.module.GankDayModule;

import com.yeyue.learns.ui.gank.fragment.GankDayFragment;

@ActivityScope
@Component(modules = GankDayModule.class, dependencies = AppComponent.class)
public interface GankDayComponent {
    void inject(GankDayFragment fragment);
}