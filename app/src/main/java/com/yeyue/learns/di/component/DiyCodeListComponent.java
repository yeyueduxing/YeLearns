package com.yeyue.learns.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;
import com.yeyue.learns.di.module.DiyCodeListModule;
import com.yeyue.learns.ui.diycode.fragment.DiyCodeListFragment;

import dagger.Component;

@ActivityScope
@Component(modules = DiyCodeListModule.class, dependencies = AppComponent.class)
public interface DiyCodeListComponent {
    void inject(DiyCodeListFragment fragment);
}