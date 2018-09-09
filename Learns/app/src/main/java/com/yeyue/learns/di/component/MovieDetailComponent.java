package com.yeyue.learns.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;
import com.yeyue.learns.di.module.MovieDetailModule;
import com.yeyue.learns.ui.movie.activity.MovieCelebrityActivity;
import com.yeyue.learns.ui.movie.activity.MovieDetailActivity;

import dagger.Component;

@ActivityScope
@Component(modules = MovieDetailModule.class, dependencies = AppComponent.class)
public interface MovieDetailComponent {
    void inject(MovieDetailActivity activity);
    void inject(MovieCelebrityActivity activity);
}