package com.yeyue.learns.ui.movie.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jess.arms.di.component.AppComponent;
import com.yeyue.learns.constant.Constant;
import com.yeyue.learns.contract.MovieListContract;
import com.yeyue.learns.di.component.DaggerMovieListComponent;
import com.yeyue.learns.di.module.MovieListModule;
import com.yeyue.learns.presenter.MovieListPresenter;
import com.yeyue.learns.ui.movie.adapter.MovieListAdapter;
import com.yeyue.library.base.YeRecyFragment;
import com.yeyue.library.data.BaseItem;

import java.util.ArrayList;


public class MovieListFragment extends YeRecyFragment<BaseItem, MovieListPresenter> implements MovieListContract.View<BaseItem> {

    private int type;
    private String extend;
    public static MovieListFragment newInstance() {
        MovieListFragment fragment = new MovieListFragment();
        return fragment;
    }
    public static MovieListFragment newInstance(int type) {
        MovieListFragment fragment = new MovieListFragment();
        fragment.type = type;
        return fragment;
    }
    public static MovieListFragment newInstance(int type,String extend) {
        MovieListFragment fragment = new MovieListFragment();
        fragment.type = type;
        fragment.extend = extend;
        return fragment;
    }
    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
        DaggerMovieListComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .movieListModule(new MovieListModule(this))
                .build()
                .inject(this);
    }


    @Override
    public void initData(Bundle savedInstanceState) {
        getData(true);
    }

    @Override
    protected void initData() {

    }

    /**
     * 此方法是让外部调用使fragment做一些操作的,比如说外部的activity想让fragment对象执行一些方法,
     * 建议在有多个需要让外界调用的方法时,统一传Message,通过what字段,来区分不同的方法,在setData
     * 方法中就可以switch做不同的操作,这样就可以用统一的入口方法做不同的事
     * <p>
     * 使用此方法时请注意调用时fragment的生命周期,如果调用此setData方法时onCreate还没执行
     * setData里却调用了presenter的方法时,是会报空的,因为dagger注入是在onCreated方法中执行的,然后才创建的presenter
     * 如果要做一些初始化操作,可以不必让外部调setData,在initData中初始化就可以了
     *
     * @param data
     */

    @Override
    public void setData(Object data) {

    }

    @Override
    public boolean enableRefresh() {
        boolean isRefresh = true;
        switch (type){
            case Constant.MOVIE_LIST_SEARCH_QUERY:
            case Constant.MOVIE_LIST_SEARCH_TAG:
                isRefresh = false;
                break;
        }
        return isRefresh;
    }

    @Override
    public boolean enableMore() {
        boolean isMore = true;
        switch (type){
            case Constant.MOVIE_LIST_US_BOX:
                isMore = false;
                break;
        }
        return isMore;
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {

    }

    @Override
    public boolean isToolbar() {
        return false;
    }


    public void refreshSearch(String query){
        this.extend = query;
        if(isPrepared){
            onDataRefresh();
        }
    }
    @Override
    public void onDataRefresh() {
        getData(true);
    }

    @Override
    public void onDataLoadMore() {
        getData(false);
    }

    @Override
    public BaseQuickAdapter<BaseItem, BaseViewHolder> getAdapter() {
        return new MovieListAdapter(new ArrayList());
    }

    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        int count = 1;
        switch (type){
            case Constant.MOVIE_LIST_DEFAULT:
                break;
            case Constant.MOVIE_PHOTOS_LIST:
                count = 3;
                break;
        }
        GridLayoutManager manager = new GridLayoutManager(getActivity(),count);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        return manager;
    }

    @Override
    public void killMyself() {

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }

    public void getData(boolean pullToRefresh){
        switch (type){
            case Constant.MOVIE_LIST_DEFAULT:
                mPresenter.getData(extend,pullToRefresh);
                break;
            case Constant.MOVIE_LIST_US_BOX:
                mPresenter.getMovieUsBoxRequest(extend);
                break;
            case Constant.MOVIE_PHOTOS_LIST:
                mPresenter.getMovieTypeList(extend,"photos",pullToRefresh);
                break;
            case Constant.MOVIE_COMMENT_DEFAULT:
                mPresenter.getMovieTypeList(extend,"comments",pullToRefresh);
                break;
            case Constant.MOVIE_COMMENT_REVIEW:
                mPresenter.getMovieTypeList(extend,"reviews",pullToRefresh);
                break;
            case Constant.MOVIE_LIST_SEARCH_QUERY:
                mPresenter.getMovieSearchQuery(extend,pullToRefresh);
                break;
            case Constant.MOVIE_LIST_SEARCH_TAG:
                mPresenter.getMovieSearchTag(extend,pullToRefresh);
                break;
        }
    }
}
