package com.yeyue.learns.presenter;

import android.app.Application;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.integration.AppManager;
import com.jess.arms.utils.RxLifecycleUtils;
import com.yeyue.learns.contract.DiyTopDetailContract;
import com.yeyue.learns.enity.diycode.DiyTopContent;
import com.yeyue.library.data.BaseItem;
import com.yeyue.library.presenter.YeListIPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import me.jessyan.rxerrorhandler.handler.RetryWithDelay;

@ActivityScope
public class DiyTopDetailPresenter extends YeListIPresenter<DiyTopDetailContract.Model, DiyTopDetailContract.View> {
    private RxErrorHandler mErrorHandler;
    private Application mApplication;
    private ImageLoader mImageLoader;
    private AppManager mAppManager;
    private List<BaseItem> mDatas;
    private int page;
    @Inject
    public DiyTopDetailPresenter(DiyTopDetailContract.Model model, DiyTopDetailContract.View rootView
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

    public void getDetail(String id) {
        mModel.getTopicDetail(id)
                .subscribeOn(Schedulers.io())
                .retryWhen(new RetryWithDelay(1, 2))//遇到错误时重试,第一个参数为重试几次,第二个参数为重试的间隔.subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))//使用Rxlifecycle,使Disposable和Activity一起销毁
                .subscribe(new ErrorHandleSubscriber<DiyTopContent>(mErrorHandler) {
                    @Override
                    public void onError(@NonNull Throwable e) {
                        super.onError(e);
                        DiyTopContent diyTopContent=null;
                        mRootView.initDetail(diyTopContent);
                    }
                    @Override
                    public void onNext(DiyTopContent diyTopContent) {
                       mRootView.initDetail(diyTopContent);
                    }
                });
    }
    public void getTopicRepliesList(int id,boolean pullToRefresh) {
        if(pullToRefresh){
            page = 1;
        }else{
            page++;
        }
        Integer offset = (page-1)*pregPage;
        getDataList(mModel.getTopicRepliesList(id,offset,pregPage), mDatas, mRootView, mErrorHandler, pullToRefresh);
        //
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