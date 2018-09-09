package com.yeyue.learns.ui.movie.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.jess.arms.di.component.AppComponent;
import com.yeyue.learns.constant.Constant;
import com.yeyue.learns.ui.movie.fragment.MovieListFragment;
import com.yeyue.library.base.YeFragmentActivity;
/**
  *@describe
  *@author li.xiao
  *@time 2018-1-27 13:49
  */
public class MovieFragmentActivity extends YeFragmentActivity{
    private String extend;
    private int type = Constant.MOVIE_COMMENT_DEFAULT;
    @Override
    public Fragment getFragment() {
        Fragment fragment = null;
        fragment =  MovieListFragment.newInstance(type,extend);
        return fragment;
    }

    @Override
    public void initData(Bundle bundle) {
        if(getIntent()!=null && getIntent().hasExtra(Constant.MOVIE_SUBJECT_ID)){
            if(getIntent().hasExtra(Constant.MOVIE_SUBJECT_ID)){
                extend = getIntent().getStringExtra(Constant.MOVIE_SUBJECT_ID);
            }
            if(getIntent().hasExtra(Constant.MOVIE_SUBJECT_TYPE)){
                type = getIntent().getIntExtra(Constant.MOVIE_SUBJECT_TYPE,Constant.MOVIE_COMMENT_DEFAULT);
            }
        }
        super.initData(bundle);
        switch (type){
            case Constant.MOVIE_COMMENT_DEFAULT:
                setTitle("短评");
                break;
            case Constant.MOVIE_PHOTOS_LIST:
                setTitle("剧照");
                break;
            case Constant.MOVIE_COMMENT_REVIEW:
                setTitle("影评");
                break;
        }
    }

    @Override
    public boolean isToolbar() {
        return true;
    }

    @Override
    public void setupActivityComponent(AppComponent appComponent) {

    }
}
