package com.yeyue.learns.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;
import com.yeyue.learns.di.module.BannerModule;
import com.yeyue.learns.ui.main.fragment.BannerFragment;

import dagger.Component;

@ActivityScope
@Component(modules = BannerModule.class, dependencies = AppComponent.class)
public interface BannerComponent {
    void inject(BannerFragment fragment);
}