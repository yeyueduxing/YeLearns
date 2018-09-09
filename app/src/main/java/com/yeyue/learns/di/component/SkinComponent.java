package com.yeyue.learns.di.component;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.yeyue.learns.di.module.SkinModule;

import com.yeyue.learns.ui.main.activity.SkinActivity;

@ActivityScope
@Component(modules = SkinModule.class, dependencies = AppComponent.class)
public interface SkinComponent {
    void inject(SkinActivity activity);
}