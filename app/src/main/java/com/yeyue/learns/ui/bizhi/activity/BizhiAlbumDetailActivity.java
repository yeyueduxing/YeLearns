package com.yeyue.learns.ui.bizhi.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jess.arms.di.component.AppComponent;
import com.yeyue.learns.R;
import com.yeyue.learns.constant.Constant;
import com.yeyue.learns.contract.BizhiListContract;
import com.yeyue.learns.di.component.DaggerBizhiListComponent;
import com.yeyue.learns.di.module.BizhiListModule;
import com.yeyue.learns.enity.bizhi.BizhiAlbumBean;
import com.yeyue.learns.enity.bizhi.BizhiBean;
import com.yeyue.learns.enity.bizhi.UserBean;
import com.yeyue.learns.presenter.BizhiHomePresenter;
import com.yeyue.learns.ui.main.adapter.CommonListAdapter;
import com.yeyue.learns.utils.BindingUtils;
import com.yeyue.library.base.YeHeaderRecyActivity;
import com.yeyue.library.data.BaseItem;
import com.yeyue.library.utils.ImageLoadUtils;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @author li.xiao
 * @describe 专辑详情
 * @time 2017-12-6 15:59
 */
public class BizhiAlbumDetailActivity extends YeHeaderRecyActivity<BaseItem, BizhiHomePresenter> implements BizhiListContract.View<BaseItem> {
    @BindView(R.id.ivCover)
    ImageView ivCover;
    @BindView(R.id.tvDesc)
    TextView tvDesc;

    private BizhiAlbumBean albumBean;
    private String albumId;
    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        DaggerBizhiListComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .bizhiListModule(new BizhiListModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        if(getIntent()!=null && getIntent().hasExtra(Constant.ALBUM_INFO)){
            albumBean = (BizhiAlbumBean) getIntent().getSerializableExtra(Constant.ALBUM_INFO);
        }
        if(albumBean==null){
            return;
        }
        albumId =  albumBean.getId();
        setTitle(albumBean.getName()+"");
        initHeader();
        mPresenter.getAlbumDetail(albumId, true);
    }

    @Override
    public int setHeaderId() {
        return R.layout.activity_album_detail_header;
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        if(view!=null && view.getTag()!=null){
            if(view.getTag() instanceof BizhiBean){
                BizhiBean bizhiBean = (BizhiBean) view.getTag();
                if(bizhiBean.getUser()==null){
                    UserBean userBean = new UserBean();
                    userBean.setName("张三");
                    userBean.setAvatar("http://img0.adesk.com/download/5790d268742aa7480bf44d3e");
                    bizhiBean.setUser(userBean);
                }
                BindingUtils.oepnBizhiDetail(view,bizhiBean,0);
            }
        }
    }

    @Override
    public void onDataRefresh() {
        mPresenter.getAlbumDetail(albumId, true);
    }

    @Override
    public void onDataLoadMore() {
        mPresenter.getAlbumDetail(albumId, false);
    }

    @Override
    public boolean enableRefresh() {
        return false;
    }

    @Override
    public boolean enableMore() {
        return true;
    }

    @Override
    public BaseQuickAdapter getAdapter() {
        return new CommonListAdapter(new ArrayList());
    }

    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 3);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        return manager;
    }

    @Override
    public void killMyself() {
        finish();
    }

    @Override
    public View getLoadView() {
        return getRecyclerView();
    }

    public void initHeader(){
        tvDesc.setText(albumBean.getDesc());
        ImageLoadUtils.showImageView(getActivity(),ivCover,albumBean.getLcover());
    }
}
