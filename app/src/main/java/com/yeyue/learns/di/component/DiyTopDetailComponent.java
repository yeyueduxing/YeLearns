package com.yeyue.learns.di.component;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.yeyue.learns.di.module.DiyTopDetailModule;

import com.yeyue.learns.ui.diycode.activity.DiyTopDetailActivity;

@ActivityScope
@Component(modules = DiyTopDetailModule.class, dependencies = AppComponent.class)
public interface DiyTopDetailComponent {
    void inject(DiyTopDetailActivity activity);
}