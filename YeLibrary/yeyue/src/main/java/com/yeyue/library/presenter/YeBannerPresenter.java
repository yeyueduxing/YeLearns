package com.yeyue.library.presenter;

import com.jess.arms.mvp.IModel;
import com.jess.arms.utils.RxLifecycleUtils;
import com.yeyue.library.constant.YeConstant;
import com.yeyue.library.contract.YeBannerView;
import com.yeyue.library.data.BannerList;
import com.yeyue.library.data.BaseItem;
import com.yeyue.library.utils.YeNetWorkUtils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import me.jessyan.rxerrorhandler.handler.RetryWithDelay;


/**
 * 为了减少第三方的引入，搜索历史的保存使用Sp来保存
  *@describe 搜索实现
  *@author li.xiao
  *@time 2017-9-6 17:10
  */
public class YeBannerPresenter<M extends IModel, V extends YeBannerView> extends YeListIPresenter<M, V> {

    public YeBannerPresenter(M model, V rootView) {
        super(model, rootView);
        onStart();
    }
    public  void getBannerList(Observable<BannerList> observable, List<BaseItem> mUsers, YeBannerView view, RxErrorHandler mErrorHandler, boolean pullToRefresh){
        observable
                .subscribeOn(Schedulers.io())
                .retryWhen(new RetryWithDelay(1, 2))//遇到错误时重试,第一个参数为重试几次,第二个参数为重试的间隔
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
                        YeNetWorkUtils.onListBannerError(e,view,pullToRefresh);
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
