package com.yeyue.library.base;


import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.blankj.utilcode.util.ObjectUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jess.arms.mvp.IPresenter;
import com.jess.arms.utils.ArmsUtils;
import com.yeyue.library.R;
import com.yeyue.library.constant.YeConstant;
import com.yeyue.library.contract.YeBaseRecyview;
import com.yeyue.library.utils.YeSpUtils;

import java.util.ArrayList;
import java.util.List;

import static com.jess.arms.utils.Preconditions.checkNotNull;

/**
 * @author li.xiao
 * @describe 列表刷新
 * @time 2017-7-12 15:35
 */
public abstract class YeRecyActivity<T, P extends IPresenter> extends BaseUiActivity<P> implements YeBaseRecyview<T>, BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.OnItemClickListener, BaseQuickAdapter.OnItemChildClickListener {
    protected  int PRELOADNUMBER = 10;
    RecyclerView mRecyclerView;
    SwipeRefreshLayout mSwipeRefreshLayout;
    private BaseQuickAdapter mAdapter;

    @Override
    public int getContentViewId() {
        return R.layout.yeyue_common_recycleview;
    }

    @Override
    public void findView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycle);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeLayout);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeLayout);
    }

    @CallSuper
    public void onInitView() {
        super.onInitView();
        mAdapter = getAdapter();
        if(getReHeaderView()!=0){
            mAdapter.addHeaderView(LayoutInflater.from(getActivity()).inflate(getReHeaderView(), null, false));
        }
        if(getReFooterView()!=0){
            mAdapter.addFooterView(LayoutInflater.from(getActivity()).inflate(getReFooterView(), null, false));
        }
        mAdapter.setOnItemClickListener(this);
        mAdapter.setOnItemChildClickListener(this);
        mSwipeRefreshLayout.setEnabled(enableRefresh());
        mAdapter.openLoadAnimation(YeSpUtils.getRecyanimationType());
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        if(enableRefresh()){
            mSwipeRefreshLayout.setOnRefreshListener(this);
        }
        if(enableMore()){
            mAdapter.setEnableLoadMore(true);
            mAdapter.setOnLoadMoreListener(this, mRecyclerView);
        }
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                /*if(newState==RecyclerView.SCROLL_STATE_IDLE){
                    //静止没有滚动
                    Glide.with(getActivity()).resumeRequests();
                }else if(newState==RecyclerView.SCROLL_STATE_DRAGGING){
                    //正在被外部拖拽,一般为用户正在用手指滚动
                    Glide.with(getActivity()).pauseRequests();
                }else if(newState==RecyclerView.SCROLL_STATE_SETTLING){
                    //自动滚动
                    Glide.with(getActivity()).pauseRequests();
                }*/
            }
        });
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(getLayoutManager());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public int getReFooterView() {
        return 0;
    }

    @Override
    public int getReHeaderView() {
        return 0;
    }

    @Override
    public void showLoading() {
       // mSwipeRefreshLayout.setRefreshing(true);
    }
    @Override
    public void startLoadMore() {

    }
    @Override
    public void hideLoading() {
        mSwipeRefreshLayout.setRefreshing(false);
    }


    @Override
    public void endLoadMore() {

    }
    @Override
    public void onRefresh() {
        mAdapter.setEnableLoadMore(false);
        onDataRefresh();
    }

    @Override
    public void onLoadMoreRequested() {
        mSwipeRefreshLayout.setEnabled(false);
        onDataLoadMore();
    }

    @Override
    public void refreshUI(List<T> data) {
        if (ObjectUtils.isNotEmpty(data)) {
            mAdapter.setNewData(data);
            mAdapter.setEnableLoadMore(true);
            if (data.size() < PRELOADNUMBER) {
                mAdapter.loadMoreEnd(true);
            }
        } else {
            //清空数据
            mAdapter.setNewData(new ArrayList());
            mAdapter.setEnableLoadMore(true);
            if (data.size() < PRELOADNUMBER) {
                mAdapter.loadMoreEnd(true);
            }
        }
        mRecyclerView.smoothScrollToPosition(0);
        hideLoading();
    }

    @Override
    public void updateUI(T data) {
        if(data!=null && mAdapter!=null && mAdapter.getData()!=null && mAdapter.getData().size()>0){
            int postion = mAdapter.getData().indexOf(data);
            if(postion>-1){
                mAdapter.setData(postion,data);
            }
        }
    }

    @Override
    public void deleteUI(T data) {
        if(data!=null && mAdapter!=null && mAdapter.getData()!=null && mAdapter.getData().size()>0){
            int postion = mAdapter.getData().indexOf(data);
            if(postion>-1){
                mAdapter.remove(postion);
            }
        }
    }

    @Override
    public void loadMore(List<T> data, boolean hasMore) {
        if (ObjectUtils.isEmpty(data)) {
            mAdapter.loadMoreEnd(true);
            hideLoading();
            return;
        }
        mAdapter.addData(data);
        if (!hasMore) {
            mAdapter.loadMoreEnd(true);
        }
        mAdapter.loadMoreComplete();
        mSwipeRefreshLayout.setEnabled(true);
    }

    @Override
    public void onError(String error) {
        hideLoading();
    }

    public RecyclerView getRecyclerView() {
        return mRecyclerView;
    }

    public BaseQuickAdapter getRecyclerAdapter() {
        return mAdapter;
    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }
    @Override
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {

    }

    @Override
    public void onViewReload() {
        showLoadSirView(YeConstant.LoadSir.LOADING);
        onDataRefresh();
    }
}
