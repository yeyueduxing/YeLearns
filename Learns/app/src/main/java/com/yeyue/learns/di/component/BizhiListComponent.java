package com.yeyue.learns.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;
import com.yeyue.learns.di.module.BizhiListModule;
import com.yeyue.learns.ui.bizhi.activity.BizhiAlbumDetailActivity;
import com.yeyue.learns.ui.bizhi.fragment.BizhiListFragment;

import dagger.Component;

@ActivityScope
@Component(modules = BizhiListModule.class, dependencies = AppComponent.class)
public interface BizhiListComponent {
    void inject(BizhiListFragment fragment);
    void inject(BizhiAlbumDetailActivity fragment);
}