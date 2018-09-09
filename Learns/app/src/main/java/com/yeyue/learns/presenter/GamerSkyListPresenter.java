package com.yeyue.learns.presenter;

import android.app.Application;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.integration.AppManager;
import com.yeyue.learns.contract.GamerSkyListContract;
import com.yeyue.library.data.BaseItem;
import com.yeyue.library.presenter.YeBannerPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@ActivityScope
public class GamerSkyListPresenter extends
        YeBannerPresenter<GamerSkyListContract.Model, GamerSkyListContract.View> {
    private RxErrorHandler mErrorHandler;
    private Application mApplication;
    private ImageLoader mImageLoader;
    private AppManager mAppManager;
    private List<BaseItem> mDatas;
    private int page;
    @Inject
    public GamerSkyListPresenter(GamerSkyListContract.Model model,
            GamerSkyListContract.View rootView
            , RxErrorHandler handler, Application application
            , ImageLoader imageLoader, AppManager appManager) {
        super(model, rootView);
        this.mErrorHandler = handler;
        this.mApplication = application;
        this.mImageLoader = imageLoader;
        this.mAppManager = appManager;
        mDatas = new ArrayList<>();
        pregPage = 14;
    }

    public void getData(String nodeId,boolean pullToRefresh) {
        if(pullToRefresh){
            page = 1;
        }else{
            page++;
        }
        getBannerList(mModel.getLabelJsonpAjax("",nodeId,"news",page,pregPage), mDatas, mRootView, mErrorHandler, pullToRefresh);
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