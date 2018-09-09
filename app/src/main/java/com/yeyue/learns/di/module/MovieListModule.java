package com.yeyue.learns.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.yeyue.learns.contract.MovieListContract;
import com.yeyue.learns.model.MovieListModel;


@Module
public class MovieListModule {
    private MovieListContract.View view;

    /**
     * 构建MovieListModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public MovieListModule(MovieListContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    MovieListContract.View provideMovieListView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    MovieListContract.Model provideMovieListModel(MovieListModel model) {
        return model;
    }
}