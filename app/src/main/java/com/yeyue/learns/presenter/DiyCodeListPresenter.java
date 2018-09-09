package com.yeyue.learns.presenter;

import android.app.Application;
import android.support.annotation.Nullable;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.integration.AppManager;
import com.yeyue.learns.contract.DiyCodeListContract;
import com.yeyue.library.data.BaseItem;
import com.yeyue.library.presenter.YeListIPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@ActivityScope
public class DiyCodeListPresenter extends YeListIPresenter<DiyCodeListContract.Model, DiyCodeListContract.View> {
    private RxErrorHandler mErrorHandler;
    private Application mApplication;
    private ImageLoader mImageLoader;
    private AppManager mAppManager;
    private List<BaseItem> mDatas;
    private int page;

    public List<BaseItem> getmDatas() {
        return mDatas;
    }

    @Inject
    public DiyCodeListPresenter(DiyCodeListContract.Model model, DiyCodeListContract.View rootView
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

    /**
     * 获取推荐
     * @param type
     * @param node_id
     * @param pullToRefresh
     */
    public void getTopicsList(String type, @Nullable Integer node_id,boolean pullToRefresh) {
        if(pullToRefresh){
            page = 1;
        }else{
            page++;
        }
        Integer offset = (page-1)*pregPage;
        getDataList(mModel.getTopicsList(type,node_id,offset,pregPage), mDatas, mRootView, mErrorHandler, pullToRefresh);
    }

    /**
     * 获取新资讯
     * @param node_id
     * @param pullToRefresh
     */
    public void getNewsList(@Nullable Integer node_id,boolean pullToRefresh) {
        if(pullToRefresh){
            page = 1;
        }else{
            page++;
        }
        Integer offset = (page-1)*pregPage;
        getDataList(mModel.getNewsList(node_id,offset,pregPage), mDatas, mRootView, mErrorHandler, pullToRefresh);
    }

    /**
     * 获取库站
     * @param pullToRefresh
     */
    public void getSites(boolean pullToRefresh) {
        getDataList(mModel.getSites(), mDatas, mRootView, mErrorHandler, pullToRefresh);
    }

    public void getUserCreateTopicList(String login_name, String order,boolean pullToRefresh) {
        if(pullToRefresh){
            page = 1;
        }else{
            page++;
        }
        Integer offset = (page-1)*pregPage;
        getDataList(mModel.getUserCreateTopicList(login_name,order,offset,pregPage), mDatas, mRootView, mErrorHandler, pullToRefresh);
    }
    public void getUserCollectionTopicList(String login_name, boolean pullToRefresh) {
        if(pullToRefresh){
            page = 1;
        }else{
            page++;
        }
        Integer offset = (page-1)*pregPage;
        getDataList(mModel.getUserCollectionTopicList(login_name,offset,pregPage), mDatas, mRootView, mErrorHandler, pullToRefresh);
    }
    public void getUserReplyTopicList(String login_name, String order,boolean pullToRefresh) {
        if(pullToRefresh){
            page = 1;
        }else{
            page++;
        }
        Integer offset = (page-1)*pregPage;
        getDataList(mModel.getUserReplyTopicList(login_name,order,offset,pregPage), mDatas, mRootView, mErrorHandler, pullToRefresh);
    }
    public void getUserFollowerList(String login_name,boolean pullToRefresh) {
        if(pullToRefresh){
            page = 1;
        }else{
            page++;
        }
        Integer offset = (page-1)*pregPage;
        getDataList(mModel.getUserFollowerList(login_name,offset,pregPage), mDatas, mRootView, mErrorHandler, pullToRefresh);
    }
    public void getUserFollowingList(String login_name,boolean pullToRefresh) {
        if(pullToRefresh){
            page = 1;
        }else{
            page++;
        }
        Integer offset = (page-1)*pregPage;
        getDataList(mModel.getUserFollowingList(login_name,offset,pregPage), mDatas, mRootView, mErrorHandler, pullToRefresh);
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