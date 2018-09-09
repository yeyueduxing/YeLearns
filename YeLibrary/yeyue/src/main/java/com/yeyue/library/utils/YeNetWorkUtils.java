package com.yeyue.library.utils;

import com.blankj.utilcode.util.NetworkUtils;
import com.jess.arms.utils.ArmsUtils;
import com.yeyue.library.constant.YeConstant;
import com.yeyue.library.contract.YeBannerView;
import com.yeyue.library.contract.YeBaseRecyview;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.annotations.NonNull;
import retrofit2.HttpException;

/**
  *@describe
  *@author li.xiao
  *@time 2018-1-23 9:27
  */
public class YeNetWorkUtils {
    public static void onListError(@NonNull Throwable e, YeBaseRecyview view,boolean pullToRefresh){
        if (e instanceof UnknownHostException || e instanceof SocketTimeoutException || e instanceof HttpException ||e instanceof ConnectException) {
            if(pullToRefresh){
                //判断网络是否连接
                if(!NetworkUtils.isConnected()){
                    view.showLoadSirView(YeConstant.LoadSir.NO_NETWORK);
                }else{
                    //网络异常
                    view.showLoadSirView(YeConstant.LoadSir.TIMEOUT);
                }
            }else{
                ArmsUtils.snackbarText("网络错误");
            }
        } else {
            view.showLoadSirView(YeConstant.LoadSir.ERROR);
        }
        view.onError(e.getMessage());
    }

    public static void onListBannerError(@NonNull Throwable e, YeBannerView view,boolean pullToRefresh){
        if (e instanceof UnknownHostException || e instanceof SocketTimeoutException || e instanceof HttpException ||e instanceof ConnectException) {
            if(pullToRefresh){
                //判断网络是否连接
                if(!NetworkUtils.isConnected()){
                    view.showLoadSirView(YeConstant.LoadSir.NO_NETWORK);
                }else{
                    //网络异常
                    view.showLoadSirView(YeConstant.LoadSir.TIMEOUT);
                }
            }else{
                ArmsUtils.snackbarText("网络错误");
            }
        } else {
            view.showLoadSirView(YeConstant.LoadSir.ERROR);
        }
        view.onError(e.getMessage());
    }
}
