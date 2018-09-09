package com.yeyue.learns.ui.gank.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jess.arms.di.component.AppComponent;
import com.yeyue.learns.constant.Constant;
import com.yeyue.learns.contract.GankListContract;
import com.yeyue.learns.di.component.DaggerGankListComponent;
import com.yeyue.learns.di.module.GankListModule;
import com.yeyue.learns.presenter.GankListPresenter;
import com.yeyue.learns.ui.main.adapter.CommonListAdapter;
import com.yeyue.library.base.YeRecyFragment;
import com.yeyue.library.data.BaseItem;

import java.util.ArrayList;

/**
  *@describe 干货通用列表Fragment
  *@author Administrator
  *@time 2018/1/6 0006 上午 11:33
  */
public class GankListFragment extends YeRecyFragment<BaseItem, GankListPresenter> implements
        GankListContract.View<BaseItem> {

    private int type;
    private String extend;
    public static GankListFragment newInstance() {
        GankListFragment fragment = new GankListFragment();
        return fragment;
    }
    public static GankListFragment newInstance(int type) {
        GankListFragment fragment = new GankListFragment();
        fragment.type = type;
        return fragment;
    }
    public static GankListFragment newInstance(int type,String extend) {
        GankListFragment fragment = new GankListFragment();
        fragment.type = type;
        fragment.extend = extend;
        return fragment;
    }
    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
        DaggerGankListComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .gankListModule(new GankListModule(this))
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
     *
     * 使用此方法时请注意调用时fragment的生命周期,如果调用此setData方法时onCreate还没执行
     * setData里却调用了presenter的方法时,是会报空的,因为dagger注入是在onCreated方法中执行的,然后才创建的presenter
     * 如果要做一些初始化操作,可以不必让外部调setData,在initData中初始化就可以了
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
        return new CommonListAdapter(new ArrayList());
    }

    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        int count = 1;
        switch (type){
            case Constant.GANK_DATA_FULI:
                count = 2;
                break;
        }
        GridLayoutManager manager = new GridLayoutManager(getActivity(),count);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        return manager;
    }

    @Override
    public void killMyself() {

    }

    @Override
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {

    }

    public void getData(boolean pullToRefresh){
        switch (type){
            case Constant.GANK_DATA_LIST:
                mPresenter.getGankIoData("all",pullToRefresh);
                break;
            case Constant.GANK_DATA_FULI:
                mPresenter.getGankIoData("福利",pullToRefresh);
                break;
            case Constant.Gank_DATA_TYPE:
                mPresenter.getGankIoData(extend,pullToRefresh);
                break;
        }
    }
}
