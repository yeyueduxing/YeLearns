package com.yeyue.learns.ui.diycode.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jess.arms.di.component.AppComponent;
import com.yeyue.learns.constant.Constant;
import com.yeyue.learns.contract.DiyCodeListContract;
import com.yeyue.learns.di.component.DaggerDiyCodeListComponent;
import com.yeyue.learns.di.module.DiyCodeListModule;
import com.yeyue.learns.enity.diycode.DiySite;
import com.yeyue.learns.presenter.DiyCodeListPresenter;
import com.yeyue.learns.ui.main.adapter.CommonListAdapter;
import com.yeyue.library.base.YeRecyFragment;
import com.yeyue.library.data.BaseItem;

import java.util.ArrayList;


public class DiyCodeListFragment extends YeRecyFragment<BaseItem, DiyCodeListPresenter> implements DiyCodeListContract.View<BaseItem> {
    private int type;
    private String extend;

    public static DiyCodeListFragment newInstance() {
        DiyCodeListFragment fragment = new DiyCodeListFragment();
        return fragment;
    }
    public static DiyCodeListFragment newInstance(int type) {
        DiyCodeListFragment fragment = new DiyCodeListFragment();
        fragment.type = type;
        return fragment;
    }
    public static DiyCodeListFragment newInstance(int type, String extend) {
        DiyCodeListFragment fragment = new DiyCodeListFragment();
        fragment.type = type;
        fragment.extend = extend;
        return fragment;
    }
    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
        DaggerDiyCodeListComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .diyCodeListModule(new DiyCodeListModule(this))
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
            case Constant.DIYCODE_USER_COLLECT:
            case Constant.DIYCODE_USER_COMMENT:
            case Constant.DIYCODE_USER_FANS:
            case Constant.DIYCODE_USER_FOLLOW:
            case Constant.DIYCODE_USER_MINE:
            case Constant.DIYCODE_SITE_LIST:
                isRefresh = false;
                break;
        }
        return isRefresh;
    }

    @Override
    public boolean enableMore() {
        boolean isMore = true;
        switch (type){
            case Constant.DIYCODE_SITE_LIST:
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
        BaseQuickAdapter adapter = new CommonListAdapter(new ArrayList());
        if(type==Constant.DIYCODE_SITE_LIST){
            adapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
                @Override
                public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                    int spanSize = 2;
                    if(mPresenter.getmDatas()!=null && mPresenter.getmDatas().size()>0 && mPresenter.getmDatas().size()>position){
                        BaseItem item = mPresenter.getmDatas().get(position);
                        if(item instanceof DiySite){
                            spanSize = 1;
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
        switch (type){
            case Constant.DIYCODE_SITE_LIST:
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
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }

    public void getData(boolean pullToRefresh){
        switch (type){
            case Constant.DIYCODE_TOPIC_LIST:
                mPresenter.getTopicsList(null,null,pullToRefresh);
                break;
            case Constant.DIYCODE_TOPIC_NODE:
                Integer node_id = null;
                try{
                    node_id = Integer.valueOf(extend);
                }catch (Exception e){

                }
                mPresenter.getTopicsList(null,node_id,pullToRefresh);
                break;
            case Constant.DIYCODE_NEW_LIST:
                Integer new_node_id = null;
                try{
                    new_node_id = Integer.valueOf(extend);
                }catch (Exception e){

                }
                mPresenter.getNewsList(new_node_id,pullToRefresh);
                break;
            case Constant.DIYCODE_SITE_LIST:
                mPresenter.getSites(pullToRefresh);
                break;
            case Constant.DIYCODE_USER_MINE:
                mPresenter.getUserCreateTopicList(extend,"recent",pullToRefresh);
                break;
            case Constant.DIYCODE_USER_COLLECT:
                mPresenter.getUserCollectionTopicList(extend,pullToRefresh);
                break;
            case Constant.DIYCODE_USER_COMMENT:
                mPresenter.getUserReplyTopicList(extend,"recent",pullToRefresh);
                break;
            case Constant.DIYCODE_USER_FANS:
                mPresenter.getUserFollowingList(extend,pullToRefresh);
                break;
            case Constant.DIYCODE_USER_FOLLOW:
                mPresenter.getUserFollowerList(extend,pullToRefresh);
                break;
        }
    }
}
