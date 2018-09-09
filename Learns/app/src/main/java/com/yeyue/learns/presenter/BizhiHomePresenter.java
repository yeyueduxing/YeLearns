package com.yeyue.learns.presenter;

import android.app.Application;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.integration.AppManager;
import com.yeyue.learns.contract.BizhiListContract;
import com.yeyue.library.data.BaseItem;
import com.yeyue.library.presenter.YeListIPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@ActivityScope
public class BizhiHomePresenter extends YeListIPresenter<BizhiListContract.Model, BizhiListContract.View> {
    private RxErrorHandler mErrorHandler;
    private Application mApplication;
    private ImageLoader mImageLoader;
    private AppManager mAppManager;
    private List<BaseItem> mDatas;
    private int page = 1;
    @Inject
    public BizhiHomePresenter(BizhiListContract.Model model, BizhiListContract.View rootView
            , RxErrorHandler handler, Application application
            , ImageLoader imageLoader, AppManager appManager) {
        super(model, rootView);
        this.mErrorHandler = handler;
        this.mApplication = application;
        this.mImageLoader = imageLoader;
        this.mAppManager = appManager;
        mDatas = new ArrayList<>();
        pregPage = 30;
    }

    public List<BaseItem> getmDatas() {
        return mDatas;
    }
    public void getHome(boolean pullToRefresh) {
        if(pullToRefresh){
            page = 1;
        }else{
            page++;
        }
        int start = (page-1)*pregPage;
        getDataList(mModel.getHomepage(pregPage,start), mDatas, mRootView, mErrorHandler, pullToRefresh);
    }
    public void getCategory(boolean pullToRefresh) {
        getDataList(mModel.getWalCategory(), mDatas, mRootView, mErrorHandler, pullToRefresh);
    }
    public void getWalNew(boolean pullToRefresh) {
        if(pullToRefresh){
            page = 1;
        }else{
            page++;
        }
        int start = (page-1)*pregPage;
        getDataList(mModel.getWalNew(pregPage,start,"new"), mDatas, mRootView, mErrorHandler, pullToRefresh);
    }

    /**
     * 竖屏热门
     * @param pullToRefresh
     */
    public void getVerticalHot(String type,boolean pullToRefresh) {
        if(pullToRefresh){
            page = 1;
        }else{
            page++;
        }
        int start = (page-1)*pregPage;
        getDataList(mModel.getVerticalBizhi(pregPage,start,type), mDatas, mRootView, mErrorHandler, pullToRefresh);
    }
    public void getVerCategory(boolean pullToRefresh) {
        getDataList(mModel.getVerCategory(), mDatas, mRootView, mErrorHandler, pullToRefresh);
    }
    public void getVideoRecommend(String type,String order,boolean pullToRefresh) {
        if(pullToRefresh){
            page = 1;
        }else{
            page++;
        }
        int start = (page-1)*pregPage;
        getDataList(mModel.getVideoRecommend(type,pregPage,start,order), mDatas, mRootView, mErrorHandler, pullToRefresh);
    }

    public void getVideoCategoryDetail(String cateId,String order,boolean pullToRefresh) {
        if(pullToRefresh){
            page = 1;
        }else{
            page++;
        }
        int start = (page-1)*pregPage;
        getDataList(mModel.getVideoCategoryDetail(cateId,pregPage,start,order), mDatas, mRootView, mErrorHandler, pullToRefresh);
    }

    public void getVideoCategory(boolean pullToRefresh) {
        getDataList(mModel.getVideoCategory(), mDatas, mRootView, mErrorHandler, pullToRefresh);
    }

    /**
     * 获取专辑详情
     * @param albumId
     * @param pullToRefresh
     */
    public void getAlbumDetail(String albumId,boolean pullToRefresh) {
        setPregPage(30);
        if(pullToRefresh){
            page = 1;
        }else{
            page++;
        }
        int start = (page-1)*pregPage;
        getDataList(mModel.getAlubmDetail(albumId,pregPage,start,"new"), mDatas, mRootView, mErrorHandler, pullToRefresh);
    }

    public void getWalCategoryList(String cId,String order,boolean pullToRefresh) {
        if(pullToRefresh){
            page = 1;
        }else{
            page++;
        }
        int start = (page-1)*pregPage;
        getDataList(mModel.getWalCategoryList(cId,pregPage,start,order), mDatas, mRootView, mErrorHandler, pullToRefresh);
    }
    public void getWalCategoryAlbum(String cId,String order,boolean pullToRefresh) {
        if(pullToRefresh){
            page = 1;
        }else{
            page++;
        }
        int start = (page-1)*pregPage;
        getDataList(mModel.getWalCategoryAlbum(cId,pregPage,start,order), mDatas, mRootView, mErrorHandler, pullToRefresh);
    }

    public void getVerCategoryList(String cId,String order,boolean pullToRefresh) {
        if(pullToRefresh){
            page = 1;
        }else{
            page++;
        }
        int start = (page-1)*pregPage;
        getDataList(mModel.getVerCategoryList(cId,pregPage,start,order), mDatas, mRootView, mErrorHandler, pullToRefresh);
    }


    public void getUserWallPaper(String uid,String order,String action,boolean pullToRefresh) {
        if(pullToRefresh){
            page = 1;
        }else{
            page++;
        }
        int start = (page-1)*pregPage;
        getDataList(mModel.getUserWallPaper(uid,pregPage,start,order,action), mDatas, mRootView, mErrorHandler, pullToRefresh);
    }

    public void getUserVertical(String uid,String order,String action,boolean pullToRefresh) {
        if(pullToRefresh){
            page = 1;
        }else{
            page++;
        }
        int start = (page-1)*pregPage;
        getDataList(mModel.getUserVertical(uid,pregPage,start,order,action), mDatas, mRootView, mErrorHandler, pullToRefresh);
    }
    public void getUserAlbum(String uid,String order,boolean pullToRefresh) {
        pregPage = 10;
        if(pullToRefresh){
            page = 1;
        }else{
            page++;
        }
        int start = (page-1)*pregPage;
        getDataList(mModel.getUserAlbum(uid,pregPage,start,order), mDatas, mRootView, mErrorHandler, pullToRefresh);
    }

    public void getSearchList(String query,boolean pullToRefresh) {
        getDataList(mModel.getSearchAll(query,pregPage,0), mDatas, mRootView, mErrorHandler, pullToRefresh);
    }

    public void getSearchTag(String tag,String query,boolean pullToRefresh) {
        pregPage = 30;
        if(pullToRefresh){
            page = 1;
        }else{
            page++;
        }
        int start = (page-1)*pregPage;
        getDataList(mModel.getSearchTag(tag,query,pregPage,start), mDatas, mRootView, mErrorHandler, pullToRefresh);
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