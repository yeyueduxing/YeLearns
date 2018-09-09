package com.yeyue.learns.ui.movie.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jess.arms.di.component.AppComponent;
import com.yeyue.learns.R;
import com.yeyue.learns.constant.Constant;
import com.yeyue.learns.contract.MovieDetailContract;
import com.yeyue.learns.di.component.DaggerMovieDetailComponent;
import com.yeyue.learns.di.module.MovieDetailModule;
import com.yeyue.learns.enity.movie.MovieBean;
import com.yeyue.learns.enity.movie.MoviePerson;
import com.yeyue.learns.presenter.MovieDetailPresenter;
import com.yeyue.learns.ui.movie.adapter.MovieListAdapter;
import com.yeyue.library.base.YeHeaderRecyActivity;
import com.yeyue.library.data.BaseItem;
import com.yeyue.library.utils.ImageLoadUtils;
import com.yeyue.library.widgets.glide.YeGlideBlurformation;

import java.util.ArrayList;

import butterknife.BindView;

/**
  *@describe 影人条目
  *@author li.xiao
  *@time 2018-1-26 21:00
  */
public class MovieCelebrityActivity extends YeHeaderRecyActivity<BaseItem, MovieDetailPresenter> implements MovieDetailContract.View<BaseItem> {
    @BindView(R.id.ivBackground)
    ImageView ivBackground;
    @BindView(R.id.ivAvator)
    ImageView ivAvator;
    private MoviePerson moviePerson;

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        DaggerMovieDetailComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .movieDetailModule(new MovieDetailModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int setHeaderId() {
        return R.layout.activity_movie_celebrity_header;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        if (getIntent() != null && getIntent().hasExtra(Constant.MOVIE_PERSON)) {
            moviePerson = (MoviePerson) getIntent().getSerializableExtra(Constant.MOVIE_PERSON);
        }
        if (moviePerson != null) {
            initCelebrity(moviePerson);
            setTitle(moviePerson.getName());
            mPresenter.getCelebrity(moviePerson.getId(), true);
        }
    }

    @Override
    public boolean enableRefresh() {
        return false;
    }

    @Override
    public boolean enableMore() {
        return false;
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {

    }

    @Override
    public void onDataRefresh() {
        mPresenter.getCelebrity(moviePerson.getId(), true);
    }

    @Override
    public void onDataLoadMore() {
        mPresenter.getCelebrity(moviePerson.getId(), false);
    }

    @Override
    public BaseQuickAdapter<BaseItem, BaseViewHolder> getAdapter() {
        return new MovieListAdapter(new ArrayList());
    }

    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        return manager;
    }

    @Override
    public void killMyself() {
        finish();
    }


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void initMovie(MovieBean movieBean) {

    }

    @Override
    public void initCelebrity(MoviePerson celebrity) {
        //设置高斯模糊
        ImageLoadUtils.showImageView(getActivity(),ivBackground,celebrity.getAvatars().getLarge(),new YeGlideBlurformation(getActivity(),25));
        ImageLoadUtils.showImageView(getActivity(),ivAvator,celebrity.getAvatars().getLarge());
    }

}
