package com.yeyue.learns.ui.main.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jess.arms.di.component.AppComponent;
import com.yeyue.learns.constant.Constant;
import com.yeyue.learns.contract.BannerContract;
import com.yeyue.learns.di.component.DaggerBannerComponent;
import com.yeyue.learns.di.module.BannerModule;
import com.yeyue.learns.enity.bizhi.BizhiBean;
import com.yeyue.learns.enity.bizhi.ComHeader;
import com.yeyue.learns.enity.bizhi.DayRecommend;
import com.yeyue.learns.presenter.BannerPresenter;
import com.yeyue.learns.ui.main.adapter.CommonListAdapter;
import com.yeyue.library.base.YeBannerFragment;
import com.yeyue.library.data.BaseBanner;
import com.yeyue.library.data.BaseItem;
import com.yeyue.library.widgets.viewbigimage.ViewBigImageActivity;

import java.util.ArrayList;

import cn.bingoogolapple.bgabanner.BGABanner;

/**
  *@describe 轮播图的fragment
  *@author li.xiao
  *@time 2018-1-11 10:20
  */
public class BannerFragment extends YeBannerFragment<BaseItem, BannerPresenter> implements BannerContract.View<BaseItem> {

    private int type;
    private String extend;
    public static BannerFragment newInstance() {
        BannerFragment fragment = new BannerFragment();
        return fragment;
    }
    public static BannerFragment newInstance(int type) {
        BannerFragment fragment = new BannerFragment();
        fragment.type = type;
        return fragment;
    }
    public static BannerFragment newInstance(int type,String extend) {
        BannerFragment fragment = new BannerFragment();
        fragment.type = type;
        fragment.extend = extend;
        return fragment;
    }
    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
        DaggerBannerComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .bannerModule(new BannerModule(this))
                .build()
                .inject(this);
    }


    @Override
    public void initData(Bundle savedInstanceState) {
        getData(true);
    }

    @Override
    protected void initData() {

    }

    /**
     * 此方法是让外部调用使fragment做一些操作的,比如说外部的activity想让fragment对象执行一些方法,
     * 建议在有多个需要让外界调用的方法时,统一传Message,通过what字段,来区分不同的方法,在setData
     * 方法中就可以switch做不同的操作,这样就可以用统一的入口方法做不同的事
     * <p>
     * 使用此方法时请注意调用时fragment的生命周期,如果调用此setData方法时onCreate还没执行
     * setData里却调用了presenter的方法时,是会报空的,因为dagger注入是在onCreated方法中执行的,然后才创建的presenter
     * 如果要做一些初始化操作,可以不必让外部调setData,在initData中初始化就可以了
     *
     * @param data
     */

    @Override
    public void setData(Object data) {

    }

    @Override
    public boolean enableRefresh() {
        return true;
    }

    @Override
    public boolean enableMore() {
        return true;
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {

    }

    @Override
    public boolean isToolbar() {
        return false;
    }

    @Override
    public void onDataRefresh() {
        getData(true);
    }

    @Override
    public void onDataLoadMore() {
        getData(false);
    }

    @Override
    public BaseQuickAdapter<BaseItem, BaseViewHolder> getAdapter() {
        BaseQuickAdapter adapter =  new CommonListAdapter(new ArrayList());
        //设置跨行跨列
        if(type==Constant.BIZHI_BANNER_DAY_RECOMMEND){
            adapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
                @Override
                public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                    int spanSize = 6;
                    if(mPresenter.getmDatas()!=null && mPresenter.getmDatas().size()>0 && mPresenter.getmDatas().size()>position){
                        BaseItem item = mPresenter.getmDatas().get(position);
                        if(item instanceof ComHeader){
                            spanSize = 6;
                        }else if(item instanceof BizhiBean){
                            spanSize = 2;
                        }else if(item instanceof DayRecommend){
                            spanSize = 6;
                        }
                    }
                    return spanSize;
                }
            });
        }
        return adapter;
    }

    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        int count = 1;
        if (type == Constant.BIZHI_BANNER_DAY_RECOMMEND) {
            count = 6;
        }
        GridLayoutManager manager = new GridLayoutManager(getActivity(),count);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        return manager;
    }

    @Override
    public void killMyself() {

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }
    public void getData(boolean pullToRefresh){
        switch (type){
            case Constant.GANK_DATA_LIST:
                mPresenter.getGankBanner("all",pullToRefresh);
                break;
            case Constant.BIZHI_BANNER_HOME_ALBUM:
                mPresenter.getBizhiAlbum(pullToRefresh);
                break;
            case Constant.BIZHI_BANNER_DAY_RECOMMEND:
                mPresenter.getBizhiWalRecommend(pullToRefresh);
                break;
            case Constant.WAN_HOME_LIST:
                mPresenter.getWanBanner(pullToRefresh);
                break;
        }
    }

    @Override
    public void onBannerItemClick(BGABanner banner, ImageView itemView, BaseBanner model, int position) {
        if(model!=null){
            ViewBigImageActivity.openImageSingleActivity(getActivity(),model.getBaImg());
        }
    }
}
