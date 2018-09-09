package com.yeyue.library.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.mvp.IPresenter;
import com.yeyue.library.R;
import com.yeyue.library.utils.ImageLoadUtils;

import cn.bingoogolapple.bgabanner.BGABanner;

/**
  *@describe 通用引导页
  *@author li.xiao
  *@time 2017-7-24 16:05
  */
public abstract class YeGuideActivity<P extends IPresenter> extends BaseUiActivity<P> implements BGABanner.Adapter<ImageView, String>, BGABanner.Delegate<ImageView, String>{
    protected BGABanner mBgabanner;
    protected AppComponent appComponent;
    protected ImageLoader mImageLoader;
    /**
     * 提供AppComponent(提供所有的单例对象)给实现类，进行Component依赖
     *
     * @param appComponent
     */
    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        this.appComponent = appComponent;
        mImageLoader = appComponent.imageLoader();
        //取消标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //取消状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    @Override
    public int getContentViewId() {
        return R.layout.yeyue_common_guide;
    }

    @Override
    public void findView() {
        mBgabanner = (BGABanner) findViewById(R.id.ye_guid_banner);
    }
    @Override
    public void initData(Bundle savedInstanceState) {
        mBgabanner.setEnterSkipViewIdAndDelegate(R.id.ye_btn_guide_enter, R.id.ye_tv_guide_skip, new BGABanner.GuideDelegate() {
            @Override
            public void onClickEnterOrSkip() {
                openAppMain();
            }
        });
        mBgabanner.setAdapter(this);
        mBgabanner.setDelegate(this);
        initBanner(mBgabanner);
    }
    public abstract void initBanner(BGABanner banner);
    public abstract void openAppMain();

    /**
     * 显示加载
     */
    @Override
    public void showLoading() {

    }

    /**
     * 隐藏加载
     */
    @Override
    public void hideLoading() {

    }

    /**
     * 显示信息
     *
     * @param message
     */
    @Override
    public void showMessage(String message) {

    }

    /**
     * 跳转activity
     *
     * @param intent
     */
    @Override
    public void launchActivity(Intent intent) {

    }

    /**
     * 杀死自己
     */
    @Override
    public void killMyself() {
        finish();
    }


    @Override
    public boolean isToolbar() {
        return false;
    }


    @Override
    public void fillBannerItem(BGABanner bgaBanner, ImageView imageView, String s, int i) {
        ImageLoadUtils.showImageView(getActivity(),imageView,s);
    }

}
