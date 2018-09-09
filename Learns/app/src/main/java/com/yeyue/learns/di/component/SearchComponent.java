package com.yeyue.learns.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;
import com.yeyue.learns.di.module.SearchModule;
import com.yeyue.learns.ui.main.activity.SearchActivity;
import com.yeyue.learns.ui.movie.activity.MovieSearchActivity;

import dagger.Component;

@ActivityScope
@Component(modules = SearchModule.class, dependencies = AppComponent.class)
public interface SearchComponent {
    void inject(SearchActivity activity);
    void inject(MovieSearchActivity activity);
}