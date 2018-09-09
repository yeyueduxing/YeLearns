package com.yeyue.learns.ui.bizhi.fragment;

import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.View;

import com.jess.arms.di.component.AppComponent;
import com.yeyue.learns.R;
import com.yeyue.learns.constant.Constant;
import com.yeyue.learns.ui.main.fragment.BannerFragment;
import com.yeyue.learns.utils.ActivityUtils;
import com.yeyue.library.base.YePageFragment;

import java.util.ArrayList;

import butterknife.OnClick;

/**
 * Created by li.xiao on 2018-1-31.
 */

public class BiZhiPageFragment extends YePageFragment{
    private String[] titles = {"推荐", "分类", "最新", "专辑"};
    private int[] titleInts = {Constant.BIZHI_HOME_PAGE_RECOMMEND, Constant.BIZHI_HOME_PAGE_CATEGORY, Constant.BIZHI_HOME_PAGE_NEW, Constant.BIZHI_HOME_PAGE_ALBUM};

    private String[] videoTitles = {"推荐","娱乐","最新","热门","分类"};
    private int[] videoTitleInts = {Constant.BIZHI_VIDEO_PAGE_RECOMMEND,Constant.BIZHI_VIDEO_PAGE_YULE,Constant.BIZHI_VIDEO_PAGE_NEW,Constant.BIZHI_VIDEO_PAGE_HOT,Constant.BIZHI_VIDEO_PAGE_CATEGORY};

    private String[] verticalTitles = {"热门","最新","分类"};
    private int[] verticalTitleIns = {Constant.BIZHI_VERTICAL_PAGE_HOT, Constant.BIZHI_VERTICAL_PAGE_NEW, Constant.BIZHI_VERTICAL_PAGE_CATEGORY};
    private boolean hasChange;
    private int type;
    public static BiZhiPageFragment newInstance(int type){
        BiZhiPageFragment fragment = new BiZhiPageFragment();
        fragment.type = type;
        return fragment;
    }
    @Override
    public String[] getTitlse() {
        switch (type) {
            case Constant.BIZHI_PAGE_HOME:
                return titles;
            case Constant.BIZHI_PAGE_VERTICAL:
                return verticalTitles;
            case Constant.BIZHI_PAGE_VIDEO:
                return videoTitles;
        }
        return null;
    }

    @Override
    public int getContentViewId() {
        return R.layout.fragment_bizhi_page;
    }

    @Override
    public ArrayList<Fragment> getFragment() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        switch (type) {
            case Constant.BIZHI_PAGE_HOME:
                for (int i = 0; i < titles.length; i++) {
                    if (i == 3) {
                        fragments.add(BannerFragment.newInstance(Constant.BIZHI_BANNER_HOME_ALBUM));
                    } else {
                        fragments.add(BizhiListFragment.newInstance(titleInts[i]));
                    }
                }
                break;
            case Constant.BIZHI_PAGE_VERTICAL:
                for (int i = 0; i < verticalTitles.length; i++) {
                    fragments.add(BizhiListFragment.newInstance(verticalTitleIns[i]));
                }
                break;
            case Constant.BIZHI_PAGE_VIDEO:
                for (int i = 0; i < videoTitles.length; i++) {
                    fragments.add(BizhiListFragment.newInstance(videoTitleInts[i]));
                }
                break;
        }

        return fragments;
    }

    @Override
    public void intToolBar() {

    }

    @Override
    public int getToolMenuId() {
        return 0;
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {

    }

    @Override
    public void setData(Object o) {

    }

    @Override
    public void initView(View mRootView) {

    }

    @Override
    public void onInitView() {

    }

    @OnClick(R.id.ivSearch)
    public void onViewClicked() {
        ActivityUtils.openMovieSearchActivity(getActivity(),Constant.BIZHI_SEARCH_TYPE);
    }
}
