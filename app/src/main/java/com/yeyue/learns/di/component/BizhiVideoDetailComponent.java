package com.yeyue.learns.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;
import com.yeyue.learns.di.module.BizhiVideoDetailModule;
import com.yeyue.learns.ui.bizhi.activity.BizhiVideoDetailActivity;

import dagger.Component;

@ActivityScope
@Component(modules = BizhiVideoDetailModule.class, dependencies = AppComponent.class)
public interface BizhiVideoDetailComponent {
    void inject(BizhiVideoDetailActivity activity);
}