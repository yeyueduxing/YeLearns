package com.yeyue.library.presenter;

import android.app.Application;

import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.integration.AppManager;
import com.jess.arms.mvp.IModel;
import com.jess.arms.mvp.IView;
import com.jess.arms.utils.RxLifecycleUtils;
import com.yeyue.library.constant.YeConstant;
import com.yeyue.library.contract.YeBannerView;
import com.yeyue.library.data.BannerList;
import com.yeyue.library.data.BaseItem;
import com.yeyue.library.utils.YeSpUtils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import me.jessyan.rxerrorhandler.handler.RetryWithDelay;

public abstract class YeLiSkinPresenter<M extends IModel, V extends IView> extends YeListIPresenter<M,V> {
    private RxErrorHandler mErrorHandler;
    private Application mApplication;
    private ImageLoader mImageLoader;
    private AppManager mAppManager;
    private List<BaseItem> mDatas;

    public YeLiSkinPresenter(M model, V rootView) {
        super(model, rootView);
        onStart();
    }

    public List<BaseItem> getmDatas(){
        return mDatas;
    }
    public abstract List<BaseItem> getLocalSkin();
    public void getSkinList(Observable<BannerList> observable, List<BaseItem> mUsers, YeBannerView view, RxErrorHandler mErrorHandler, boolean pullToRefresh){
        observable
                .subscribeOn(Schedulers.io())
                .retryWhen(new RetryWithDelay(YeSpUtils.getRetryMax(), YeSpUtils.getRetryDelaySecond()))//遇到错误时重试,第一个参数为重试几次,第二个参数为重试的间隔
                .doOnSubscribe(disposable -> {
                    if (pullToRefresh)
                        view.showLoading();//显示上拉刷新的进度条
                    else
                        view.startLoadMore();//显示下拉加载更多的进度条
                }).subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterTerminate(() -> {
                    if (pullToRefresh){
                        view.hideLoading();//隐藏上拉刷新的进度条
                    }
                    else
                        view.endLoadMore();//隐藏下拉加载更多的进度条
                })
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))//使用Rxlifecycle,使Disposable和Activity一起销毁
                .subscribe(new ErrorHandleSubscriber<BannerList>(mErrorHandler) {
                    @Override
                    public void onError(@NonNull Throwable e) {
                        super.onError(e);
                        view.onError(e.getMessage());
                        view.showLoadSirView(YeConstant.LoadSir.ERROR);
                    }
                    @Override
                    public void onNext(BannerList bannerList) {
                        if(bannerList!=null){
                            if (pullToRefresh) mUsers.clear();//如果是上拉刷新则清空列表
                            if(pullToRefresh){
                                view.showLoadSirView(YeConstant.LoadSir.SUCCESS);
                                mUsers.addAll(bannerList.getData());
                                view.refreshUI(mUsers);
                            }else{
                                //mUsers.addAll(users);
                                view.loadMore(bannerList.getData(),true);
                            }
                            view.setBannerData(bannerList.getBanners());
                        }
                    }
                });
    }
}