package com.yeyue.learns.presenter;

import android.app.Application;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.integration.AppManager;
import com.yeyue.learns.contract.MovieDetailContract;
import com.yeyue.library.data.BaseItem;
import com.yeyue.library.presenter.YeListIPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@ActivityScope
public class MovieDetailPresenter extends YeListIPresenter<MovieDetailContract.Model, MovieDetailContract.View> {
    private RxErrorHandler mErrorHandler;
    private Application mApplication;
    private ImageLoader mImageLoader;
    private AppManager mAppManager;
    private List<BaseItem> mDatas;

    @Inject
    public MovieDetailPresenter(MovieDetailContract.Model model, MovieDetailContract.View rootView
            , RxErrorHandler handler, Application application
            , ImageLoader imageLoader, AppManager appManager) {
        super(model, rootView);
        this.mErrorHandler = handler;
        this.mApplication = application;
        this.mImageLoader = imageLoader;
        this.mAppManager = appManager;
        mDatas = new ArrayList<>();
    }

    public void getMovieDetail(String subjectId,boolean pullToRefresh) {
        getDataList(mModel.getMovieDetail(subjectId,"0b2bdeda43b5688921839c8ecb20399b","北京"), mDatas, mRootView, mErrorHandler, pullToRefresh);
    }

    public void getCelebrity(String subjectId,boolean pullToRefresh) {
        getDataList(mModel.getCelebrity(subjectId,"0b2bdeda43b5688921839c8ecb20399b",mRootView), mDatas, mRootView, mErrorHandler, pullToRefresh);
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