package com.yeyue.learns.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;
import com.yeyue.learns.di.module.BizhiDetailModule;
import com.yeyue.learns.ui.bizhi.fragment.BizhiDetailFragment;

import dagger.Component;

@ActivityScope
@Component(modules = BizhiDetailModule.class, dependencies = AppComponent.class)
public interface BizhiDetailComponent {
    void inject(BizhiDetailFragment fragment);
}