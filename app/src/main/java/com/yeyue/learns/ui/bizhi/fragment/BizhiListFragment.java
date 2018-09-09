package com.yeyue.learns.ui.bizhi.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jess.arms.di.component.AppComponent;
import com.yeyue.learns.constant.AdapterConstant;
import com.yeyue.learns.constant.Constant;
import com.yeyue.learns.contract.BizhiListContract;
import com.yeyue.learns.di.component.DaggerBizhiListComponent;
import com.yeyue.learns.di.module.BizhiListModule;
import com.yeyue.learns.enitty.BizhiHomeTag;
import com.yeyue.learns.enity.bizhi.BizhiAlbumBean;
import com.yeyue.learns.enity.bizhi.BizhiBean;
import com.yeyue.learns.enity.bizhi.ComHeader;
import com.yeyue.learns.enity.bizhi.DayRecommend;
import com.yeyue.learns.presenter.BizhiHomePresenter;
import com.yeyue.learns.ui.main.adapter.CommonListAdapter;
import com.yeyue.library.base.YeRecyFragment;
import com.yeyue.library.data.BaseItem;

import java.util.ArrayList;

/**
  *@describe 列表通用Fragment
  *@author li.xiao
  *@time 2017-12-7 14:37
  */
public class BizhiListFragment extends YeRecyFragment<BaseItem, BizhiHomePresenter> implements BizhiListContract.View<BaseItem> {

    private int type;
    private String extend;
    public static BizhiListFragment newInstance(int type) {
        BizhiListFragment fragment = new BizhiListFragment();
        fragment.type = type;
        return fragment;
    }
    public static BizhiListFragment newInstance(int type, String extend) {
        BizhiListFragment fragment = new BizhiListFragment();
        fragment.type = type;
        fragment.extend = extend;
        return fragment;
    }
    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
        DaggerBizhiListComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .bizhiListModule(new BizhiListModule(this))
                .build()
                .inject(this);
    }


    @Override
    public void initData() {
        getData(true);
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
    public void refreshSearch(String query){
        this.extend = query;
        if(isPrepared){
            onDataRefresh();
        }
    }
    @Override
    public boolean enableRefresh() {
        if(type== Constant.BIZHI_HOME_PAGE_CATEGORY){
            return false;
        }
        return true;
    }

    @Override
    public boolean enableMore() {
        boolean enable = false;
        switch (type){
            case Constant.BIZHI_HOME_PAGE_NEW:
            case Constant.BIZHI_HOME_PAGE_RECOMMEND:
            case Constant.BIZHI_WALLPAPER_CATEGORY_ALBUM:
            case Constant.BIZHI_WALLPAPER_CATEGORY_HOT:
            case Constant.BIZHI_WALLPAPER_CATEGORY_NEW:
            case Constant.BIZHI_VERTICAL_CATEGORY_HOT:
            case Constant.BIZHI_VERTICAL_CATEGORY_NEW:
            case Constant.BIZHI_VIDEO_CATEGORY_HOT:
            case Constant.BIZHI_VIDEO_CATEGORY_NEW:
            case Constant.BIZHI_HOME_PAGE_ALBUM_DETAIL:
                enable = true;
                break;
        }
        return enable;
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
        switch (type){
            case Constant.BIZHI_SEARCH_PAGE_BIZHI:
            case Constant.BIZHI_SEARCH_PAGE_VERTICAL:
            case Constant.BIZHI_SEARCH_PAGE_VIDEO:
            case Constant.BIZHI_SEARCH_PAGE_LOCK:
                adapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                        int spanSize = 2;
                        if(mPresenter.getmDatas()!=null && mPresenter.getmDatas().size()>0 && mPresenter.getmDatas().size()>position){
                            BaseItem item = mPresenter.getmDatas().get(position);
                            if(item instanceof BizhiAlbumBean){
                                spanSize = 6;
                            }if(item instanceof DayRecommend){
                                spanSize = 6;
                            }
                        }
                        return spanSize;
                    }
                });
                break;
            case Constant.BIZHI_HOME_PAGE_RECOMMEND:
                adapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                        int spanSize = 2;
                        if(mPresenter.getmDatas()!=null && mPresenter.getmDatas().size()>0 && mPresenter.getmDatas().size()>position){
                            BaseItem item = mPresenter.getmDatas().get(position);
                            if(item instanceof ComHeader){
                                spanSize = 6;
                            }else if(item instanceof BizhiBean){
                                BizhiBean bizhiBean = (BizhiBean) item;
                                if(bizhiBean.getItemType()== AdapterConstant.ITEM_BIZHI_HOMEPAGE_RECOMMEND){
                                    spanSize = 3;
                                }
                            }else if(item instanceof DayRecommend){
                                spanSize = 6;
                            }else if(item instanceof BizhiHomeTag){
                                spanSize = 6;
                            }
                        }
                        return spanSize;
                    }
                });
                break;
        }

        return adapter;
    }

    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        int count = 6;
        switch (type){
            case Constant.BIZHI_HOME_PAGE_CATEGORY:
            case Constant.BIZHI_VIDEO_PAGE_CATEGORY:
                count = 2;
                break;
            case Constant.BIZHI_VIDEO_PAGE_RECOMMEND:
            case Constant.BIZHI_VIDEO_PAGE_HOT:
            case Constant.BIZHI_VIDEO_PAGE_NEW:
            case Constant.BIZHI_VIDEO_PAGE_YULE:
            case Constant.BIZHI_VIDEO_CATEGORY_HOT:
            case Constant.BIZHI_VIDEO_CATEGORY_NEW:
            case Constant.BIZHI_HOME_PAGE_NEW:
            case Constant.BIZHI_WALLPAPER_CATEGORY_HOT:
            case Constant.BIZHI_WALLPAPER_CATEGORY_NEW:
            case Constant.BIZHI_VERTICAL_CATEGORY_HOT:
            case Constant.BIZHI_VERTICAL_CATEGORY_NEW:
            case Constant.BIZHI_VERTICAL_PAGE_HOT:
            case Constant.BIZHI_VERTICAL_PAGE_NEW:
            case Constant.BIZHI_USER_PAGE_BIZHI:
            case Constant.BIZHI_USER_PAGE_VERTICAL:
            case Constant.BIZHI_USER_PAGE_VERTICAL_WORK:
            case Constant.BIZHI_USER_PAGE_WORK:
            case Constant.BIZHI_VERTICAL_PAGE_CATEGORY:
            case Constant.BIZHI_HOME_PAGE_ALBUM_DETAIL:
                count = 3;
                break;
            case Constant.BIZHI_WALLPAPER_CATEGORY_ALBUM:
            case Constant.BIZHI_USER_PAGE_ALBUM:
                count = 1;
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
            case Constant.BIZHI_HOME_PAGE_CATEGORY:
                //主页壁纸分类
                mPresenter.getCategory(pullToRefresh);
                break;
            case Constant.BIZHI_HOME_PAGE_NEW:
                //主页最新
                mPresenter.getWalNew(pullToRefresh);
                break;
            case Constant.BIZHI_HOME_PAGE_RECOMMEND:
                //主页推荐
                mPresenter.getHome(pullToRefresh);
                break;
            case Constant.BIZHI_VIDEO_PAGE_RECOMMEND:
                //视频壁纸推荐
                mPresenter.getVideoRecommend("featured","hot",pullToRefresh);
                break;
            case Constant.BIZHI_VIDEO_PAGE_YULE:
                //视频壁纸娱乐
                mPresenter.getVideoCategoryDetail("59b25abbe7bce76bc834198a","new",pullToRefresh);
                break;
            case Constant.BIZHI_VIDEO_CATEGORY_HOT:
                //视频壁纸娱乐
                mPresenter.getVideoCategoryDetail(extend,"hot",pullToRefresh);
                break;
            case Constant.BIZHI_VIDEO_CATEGORY_NEW:
                //视频壁纸娱乐
                mPresenter.getVideoCategoryDetail(extend,"new",pullToRefresh);
                break;
            case Constant.BIZHI_VIDEO_PAGE_NEW:
                //视频壁纸推荐
                mPresenter.getVideoRecommend("videowp","new",pullToRefresh);
                break;
            case Constant.BIZHI_VIDEO_PAGE_HOT:
                //视频壁纸热门
                mPresenter.getVideoRecommend("videowp","hot",pullToRefresh);
                break;
            case Constant.BIZHI_VIDEO_PAGE_CATEGORY:
                //视频壁纸分类
                mPresenter.getVideoCategory(pullToRefresh);
                break;
            case Constant.BIZHI_WALLPAPER_CATEGORY_HOT:
                //分类热门
                mPresenter.getWalCategoryList(extend,"hot",pullToRefresh);
                break;
            case Constant.BIZHI_WALLPAPER_CATEGORY_NEW:
                //分类最新
                mPresenter.getWalCategoryList(extend,"new",pullToRefresh);
                break;
            case Constant.BIZHI_WALLPAPER_CATEGORY_ALBUM:
                //分类专辑
                mPresenter.getWalCategoryAlbum(extend,"new",pullToRefresh);
                break;
            case Constant.BIZHI_VERTICAL_CATEGORY_HOT:
                //竖屏分类热门
                mPresenter.getVerCategoryList(extend,"hot",pullToRefresh);
                break;
            case Constant.BIZHI_VERTICAL_CATEGORY_NEW:
                //竖屏分类最新
                mPresenter.getVerCategoryList(extend,"new",pullToRefresh);
                break;
            case Constant.BIZHI_VERTICAL_PAGE_HOT:
                mPresenter.getVerticalHot("hot",pullToRefresh);
                break;
            case Constant.BIZHI_VERTICAL_PAGE_NEW:
                mPresenter.getVerticalHot("new",pullToRefresh);
                break;
            case Constant.BIZHI_VERTICAL_PAGE_CATEGORY:
                mPresenter.getVerCategory(pullToRefresh);
                break;
            case Constant.BIZHI_USER_PAGE_BIZHI:
                mPresenter.getUserWallPaper(extend,"new",null,pullToRefresh);
                break;
            case Constant.BIZHI_USER_PAGE_WORK:
                mPresenter.getUserWallPaper(extend,"new","upload",pullToRefresh);
                break;
            case Constant.BIZHI_USER_PAGE_ALBUM:
                mPresenter.getUserAlbum(extend,"new",pullToRefresh);
                break;
            case Constant.BIZHI_USER_PAGE_VERTICAL:
                mPresenter.getUserVertical(extend,"new","upload",pullToRefresh);
                break;
            case Constant.BIZHI_USER_PAGE_VERTICAL_WORK:
                mPresenter.getUserVertical(extend,"new","upload",pullToRefresh);
                break;
            case Constant.BIZHI_SEARCH_PAGE_ALL:
                mPresenter.getSearchList(extend,pullToRefresh);
                break;
            case Constant.BIZHI_SEARCH_PAGE_BIZHI:
                mPresenter.getSearchTag("wallpaper",extend,pullToRefresh);
                break;
            case Constant.BIZHI_SEARCH_PAGE_VERTICAL:
                mPresenter.getSearchTag("vertical",extend,pullToRefresh);
                break;
            case Constant.BIZHI_SEARCH_PAGE_VIDEO:
                mPresenter.getSearchTag("live",extend,pullToRefresh);
                break;
            case Constant.BIZHI_SEARCH_PAGE_LOCK:
                mPresenter.getSearchTag("lock",extend,pullToRefresh);
                break;
            case Constant.BIZHI_HOME_PAGE_ALBUM_DETAIL:
                mPresenter.getAlbumDetail(extend,pullToRefresh);
                break;
            default:
                mPresenter.getVideoRecommend("videowp","hot",pullToRefresh);
                break;
        }

    }
}
