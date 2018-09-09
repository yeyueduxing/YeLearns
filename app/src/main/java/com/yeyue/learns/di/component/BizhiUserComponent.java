package com.yeyue.learns.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;
import com.yeyue.learns.di.module.BizhiUserModule;
import com.yeyue.learns.ui.bizhi.activity.BizhiUserActivity;

import dagger.Component;

@ActivityScope
@Component(modules = BizhiUserModule.class, dependencies = AppComponent.class)
public interface BizhiUserComponent {
    void inject(BizhiUserActivity activity);
}