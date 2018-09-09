package com.yeyue.learns.presenter;

import android.app.Application;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.integration.AppManager;
import com.yeyue.learns.constant.Constant;
import com.yeyue.learns.contract.MovieListContract;
import com.yeyue.library.data.BaseItem;
import com.yeyue.library.presenter.YeListIPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@ActivityScope
public class MovieListPresenter extends YeListIPresenter<MovieListContract.Model, MovieListContract.View> {
    private RxErrorHandler mErrorHandler;
    private Application mApplication;
    private ImageLoader mImageLoader;
    private AppManager mAppManager;
    private List<BaseItem> mDatas;
    private int page;
    @Inject
    public MovieListPresenter(MovieListContract.Model model, MovieListContract.View rootView
            , RxErrorHandler handler, Application application
            , ImageLoader imageLoader, AppManager appManager) {
        super(model, rootView);
        this.mErrorHandler = handler;
        this.mApplication = application;
        this.mImageLoader = imageLoader;
        this.mAppManager = appManager;
        mDatas = new ArrayList<>();
        pregPage = 10;
    }

    public void getData(String type,boolean pullToRefresh) {
        if(pullToRefresh){
            page = 1;
        }else{
            page++;
        }
        int start = (page-1)*pregPage;
        getDataList(mModel.getHotPlayMovies(type,Constant.MOVIE_KEY,"上海",start,pregPage), mDatas, mRootView, mErrorHandler, pullToRefresh);
    }
    public void getMovieUsBoxRequest(String type) {
        getDataList(mModel.getMovieUsBoxRequest(type,Constant.MOVIE_KEY), mDatas, mRootView, mErrorHandler, true);
    }
    public void getMovieTypeList(String subjectId,String type, boolean pullToRefresh) {
        if("photos".equals(type)){
            setPregPage(21);
        }
        if(pullToRefresh){
            page = 1;
        }else{
            page++;
        }
        int start = (page-1)*pregPage;
        getDataList(mModel.getMoviePhotos(Constant.MOVIE_KEY,subjectId,type,start,pregPage), mDatas, mRootView, mErrorHandler, pullToRefresh);
    }
    public void getMovieSearchTag(String type,boolean pullToRefresh) {
        if(pullToRefresh){
            page = 1;
        }else{
            page++;
        }
        int start = (page-1)*pregPage;
        getDataList(mModel.getMovieSearch(type,"",Constant.MOVIE_KEY,start,pregPage), mDatas, mRootView, mErrorHandler, pullToRefresh);
    }
    public void getMovieSearchQuery(String type,boolean pullToRefresh) {
        if(pullToRefresh){
            page = 1;
        }else{
            page++;
        }
        int start = (page-1)*pregPage;
        getDataList(mModel.getMovieSearch("",type,Constant.MOVIE_KEY,start,pregPage), mDatas, mRootView, mErrorHandler, pullToRefresh);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mAppManager = null;
        this.mImageLoader = null;
        this.mApplication = null;
    }

}