package com.yeyue.learns.di.component;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.yeyue.learns.di.module.GamerSkyListModule;

import com.yeyue.learns.ui.gamersky.fragment.GamerSkyListFragment;

@ActivityScope
@Component(modules = GamerSkyListModule.class, dependencies = AppComponent.class)
public interface GamerSkyListComponent {
    void inject(GamerSkyListFragment fragment);
}