package com.yeyue.library.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yeyue.library.R;
import com.yeyue.library.adapter.YeSkinAdapter;
import com.yeyue.library.constant.YeSkinConstant;
import com.yeyue.library.data.YeSkinItem;
import com.yeyue.library.presenter.YeLiSkinPresenter;
import com.yeyue.library.utils.YeEventUtils;
import com.yeyue.library.utils.YeSkinUtils;

import java.util.ArrayList;
import java.util.List;

import skin.support.SkinCompatManager;

/**
  *@describe 皮肤管理器
  *@author li.xiao
  *@time 2017-12-20 17:25
  */
public abstract class YeLiSkinActivity<T,P extends YeLiSkinPresenter> extends YeRecyActivity<T,P> {
    protected int locakSkinSpan = 4;
    protected int onLineSkinSpan = 3;
    private RecyclerView yeSkinHeader;

    public abstract List<YeSkinItem> getLoaclSkin();
    @Override
    public int getContentViewId() {
        return R.layout.yeyue_activity_skin;
    }

    @Override
    public void findView() {
        super.findView();
        yeSkinHeader = (RecyclerView) findViewById(R.id.yeSkinHeader);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        yeSkinHeader.setNestedScrollingEnabled(false);
        mRecyclerView.setNestedScrollingEnabled(false);
        GridLayoutManager localManage = new GridLayoutManager(getActivity(),locakSkinSpan);
        localManage.setOrientation(LinearLayoutManager.VERTICAL);
        yeSkinHeader.setLayoutManager(localManage);
        BaseQuickAdapter adapter = new YeSkinAdapter(getLoaclSkin());
        adapter.setOnItemClickListener(this);
        yeSkinHeader.setAdapter(adapter);
    }

    @Override
    public BaseQuickAdapter<T, BaseViewHolder> getAdapter() {
        BaseQuickAdapter adapter = new YeSkinAdapter(new ArrayList());
        return adapter;
    }

    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),onLineSkinSpan);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        return gridLayoutManager;
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        if(view!=null && view.getTag()!=null){
            if(view.getTag() instanceof YeSkinItem){
                YeSkinItem item = (YeSkinItem) view.getTag();
                if(item.getItemType()==YeSkinConstant.YE_ITEM_SKIN_DEFAULT){
                    YeSkinUtils.setSkinLocal(item.getResourceName(), new SkinCompatManager.SkinLoaderListener() {
                        @Override
                        public void onStart() {

                        }

                        @Override
                        public void onSuccess() {
                            //刷新界面
                            YeEventUtils.updateSkin();
                            //int color = SkinCompatResources.getInstance().getColor(R.color.ye_color_Navigation_Base);
                            //StatusBarUtil.setColorNoTranslucent(getActivity(), color);
                        }

                        @Override
                        public void onFailed(String s) {

                        }
                    });
                    /*if(TextUtils.isEmpty(item.getResourceName())){
                        SkinCompatManager.getInstance().restoreDefaultTheme();
                        //刷新界面
                        int color = getResources().getColor(R.color.ye_color_Navigation_Base);
                        StatusBarUtil.setColorNoTranslucent(getActivity(), color);
                    }else{

                    }*/
                }else{
                    Intent intent = new Intent(getActivity(), YeSkinDetailActivity.class);
                    intent.putExtra(YeSkinConstant.YE_SKIN_INFO,item);
                    getActivity().startActivity(intent);
                }
                getAdapter().notifyDataSetChanged();
            }
        }
    }

    @Override
    public View getLoadView() {
        return mRecyclerView;
    }
}
