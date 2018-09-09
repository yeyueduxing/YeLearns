package com.yeyue.library.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jess.arms.di.component.AppComponent;
import com.yeyue.library.adapter.YeCommonListAdapter;
import com.yeyue.library.base.YeRecyActivity;
import com.yeyue.library.data.BaseItem;
import com.yeyue.library.data.YeLoadtype;
import com.yeyue.library.utils.YeSpUtils;

import java.util.ArrayList;
import java.util.List;

import static com.yeyue.library.widgets.callback.YeLoadingCallback.INDICATORS;

/**
 * Created by li.xiao on 2018-1-24.
 */

public class YeLoadIndicatorActivty extends YeRecyActivity {

    @Override
    public void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        YeSpUtils.setLoadViewIndicator(position);
        ToastUtils.showLong("选择成功");
        finish();
    }


    @Override
    public void initData(Bundle savedInstanceState) {
        setTitle("加载动画");
        List<BaseItem> baseItems = new ArrayList<>();
        for (int i = 0; i < INDICATORS.length; i++) {
            YeLoadtype loadtype = new YeLoadtype();
            loadtype.setIndicator(INDICATORS[i]);
            baseItems.add(loadtype);
        }
        refreshUI(baseItems);
    }

    @Override
    public boolean isToolbar() {
        return true;
    }

    @Override
    public void onDataRefresh() {

    }

    @Override
    public void onDataLoadMore() {

    }

    @Override
    public boolean enableRefresh() {
        return false;
    }

    @Override
    public boolean enableMore() {
        return false;
    }

    @Override
    public View getLoadView() {
        return null;
    }

    @Override
    public BaseQuickAdapter getAdapter() {
        return new YeCommonListAdapter(new ArrayList());
    }

    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 4);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        return gridLayoutManager;
    }

    @Override
    public void killMyself() {

    }
}
