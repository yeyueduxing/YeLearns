package com.yeyue.learns.ui.movie.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.jess.arms.di.component.AppComponent;
import com.yeyue.learns.constant.Constant;
import com.yeyue.learns.contract.SearchContract;
import com.yeyue.learns.di.component.DaggerSearchComponent;
import com.yeyue.learns.di.module.SearchModule;
import com.yeyue.learns.presenter.SearchPresenter;
import com.yeyue.learns.ui.bizhi.fragment.BizhiSearchPageFragment;
import com.yeyue.learns.ui.movie.fragment.MovieListFragment;
import com.yeyue.library.base.YeSearchFragmentActivity;

/**
 * Created by li.xiao on 2018-1-29.
 */

public class MovieSearchActivity extends YeSearchFragmentActivity<SearchPresenter> implements SearchContract.View{
    private Fragment fragment;

    private int type;
    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        DaggerSearchComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .searchModule(new SearchModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        if(getIntent()!=null && getIntent().hasExtra(Constant.SEARCH_TYPE)){
            type = getIntent().getIntExtra(Constant.SEARCH_TYPE,Constant.MOVIE_SEARCH_TYPE);
        }
        super.initData(savedInstanceState);
    }

    @Override
    public void refreshSearch(String query) {
        if(fragment!=null){
            if(fragment instanceof MovieListFragment){
                MovieListFragment movieListFragment = (MovieListFragment) fragment;
                movieListFragment.refreshSearch(query);
            }else if(fragment instanceof BizhiSearchPageFragment){
                BizhiSearchPageFragment movieListFragment = (BizhiSearchPageFragment) fragment;
                movieListFragment.refreshSearch(query);
            }
        }
    }

    @Override
    public Fragment getFragment(String query) {
        if(fragment==null){
            switch (type){
                case Constant.MOVIE_SEARCH_TYPE:
                    fragment = MovieListFragment.newInstance(Constant.MOVIE_LIST_SEARCH_QUERY,query);
                    break;
                case Constant.BIZHI_SEARCH_TYPE:
                    fragment = BizhiSearchPageFragment.newInstance(query);
                    break;
            }
        }
        return fragment;
    }

}
