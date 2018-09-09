package com.yeyue.learns.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;
import com.yeyue.learns.di.module.MovieListModule;
import com.yeyue.learns.ui.movie.fragment.MovieListFragment;

import dagger.Component;

@ActivityScope
@Component(modules = MovieListModule.class, dependencies = AppComponent.class)
public interface MovieListComponent {
    void inject(MovieListFragment fragment);
}