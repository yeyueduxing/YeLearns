package com.yeyue.library.presenter;

import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.mvp.IModel;
import com.jess.arms.mvp.IView;
import com.jess.arms.utils.RxLifecycleUtils;
import com.yeyue.library.constant.YeConstant;
import com.yeyue.library.contract.YeBaseRecyview;
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
 * Created by li.xiao on 2017-7-19.
 */

public abstract class YeListIPresenter<M extends IModel, V extends IView> extends BasePresenter<M, V>{
    protected int pregPage = 10;
    public YeListIPresenter(M model, V rootView) {
        this.mModel = model;
        this.mRootView = rootView;
        onStart();
    }

    public void setPregPage(int pregPage) {
        this.pregPage = pregPage;
    }

    public <T extends BaseItem> void getDataList(Observable<List<T>> observable, List<BaseItem> mUsers, YeBaseRecyview view, RxErrorHandler mErrorHandler, boolean pullToRefresh){
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
                .subscribe(new ErrorHandleSubscriber<List<T>>(mErrorHandler) {
                    @Override
                    public void onError(@NonNull Throwable e) {
                        super.onError(e);
                        YeNetWorkUtils.onListError(e,view,pullToRefresh);
                    }
                    @Override
                    public void onNext(List<T> users) {
                        if (pullToRefresh) mUsers.clear();//如果是上拉刷新则清空列表
                        if(pullToRefresh){
                            view.showLoadSirView(YeConstant.LoadSir.SUCCESS);
                            mUsers.addAll(users);
                            view.refreshUI(mUsers);
                            if(users==null || users.isEmpty()){
                                view.showLoadSirView(YeConstant.LoadSir.EMPTY);
                            }
                        }else{
                            //mUsers.addAll(users);
                            boolean hasMore = true;
                            if(users==null || users.size()<pregPage){
                                hasMore = false;
                            }
                            view.loadMore(users,hasMore);
                        }
                    }
                });
    }
}
