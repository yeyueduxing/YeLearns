package com.yeyue.learns.ui.wechat.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jess.arms.di.component.AppComponent;
import com.yeyue.learns.constant.Constant;
import com.yeyue.learns.contract.WeChatListContract;
import com.yeyue.learns.di.component.DaggerWeChatListComponent;
import com.yeyue.learns.di.module.WeChatListModule;
import com.yeyue.learns.presenter.WeChatListPresenter;
import com.yeyue.learns.ui.main.adapter.CommonListAdapter;
import com.yeyue.library.base.YeRecyFragment;
import com.yeyue.library.data.BaseItem;

import java.util.ArrayList;


public class WeChatListFragment extends YeRecyFragment<BaseItem, WeChatListPresenter> implements WeChatListContract.View<BaseItem> {

    private int type;
    private String extend;
    public static WeChatListFragment newInstance() {
        WeChatListFragment fragment = new WeChatListFragment();
        return fragment;
    }
    public static WeChatListFragment newInstance(int type) {
        WeChatListFragment fragment = new WeChatListFragment();
        fragment.type = type;
        return fragment;
    }
    public static WeChatListFragment newInstance(int type,String extend) {
        WeChatListFragment fragment = new WeChatListFragment();
        fragment.type = type;
        fragment.extend = extend;
        return fragment;
    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
        DaggerWeChatListComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .weChatListModule(new WeChatListModule(this))
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
        boolean isRefresh = true;
        switch (type){
            case Constant.WECHAT_NEW_TAG:
            case Constant.WECHAT_LIVE_TAG:
                isRefresh = false;
                break;
        }
        return isRefresh;
    }

    @Override
    public boolean enableMore() {
        boolean isMore = true;
        switch (type){
            case Constant.WECHAT_NEW_TAG:
            case Constant.WECHAT_LIVE_TAG:
                isMore = false;
                break;
        }
        return isMore;
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
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
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
            case Constant.WECHAT_NEW_LIST:
                mPresenter.getWXNew(extend,null,pullToRefresh);
                break;
            case Constant.WECHAT_NEW_TAG:
            case Constant.WECHAT_LIVE_TAG:
                mPresenter.getWXTagList(type);
                break;
        }
    }
}
