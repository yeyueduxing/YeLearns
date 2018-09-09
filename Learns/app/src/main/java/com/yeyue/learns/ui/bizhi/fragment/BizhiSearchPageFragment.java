package com.yeyue.learns.ui.bizhi.fragment;

import android.support.v4.app.Fragment;
import android.view.MenuItem;

import com.jess.arms.di.component.AppComponent;
import com.yeyue.learns.constant.Constant;
import com.yeyue.library.base.BaseUiActivity;
import com.yeyue.library.base.YePageFragment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/4 0004.
 */

public class BizhiSearchPageFragment extends YePageFragment {
    private String[] titles = {"壁纸", "竖屏壁纸", "动态壁纸","锁屏"};
    private int[] titleInts = { Constant.BIZHI_SEARCH_PAGE_BIZHI, Constant.BIZHI_SEARCH_PAGE_VERTICAL, Constant.BIZHI_SEARCH_PAGE_VIDEO, Constant.BIZHI_SEARCH_PAGE_LOCK};
    private String query;

    private ArrayList<Fragment> fragments;
    public static BizhiSearchPageFragment newInstance(String query) {
        BizhiSearchPageFragment fragment = new BizhiSearchPageFragment();
        fragment.query = query;
        return fragment;
    }

    @Override
    public String[] getTitlse() {
        return titles;
    }

    public void refreshSearch(String query){
        if(fragments!=null && fragments.size()>0){
            for (Fragment fragment:fragments){
                if(fragment!=null && fragment instanceof BizhiListFragment){
                    BizhiListFragment searchListFragment = (BizhiListFragment) fragment;
                    searchListFragment.refreshSearch(query);
                }
            }
        }
    }
    @Override
    public ArrayList<Fragment> getFragment() {
        fragments = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            fragments.add(BizhiListFragment.newInstance(titleInts[i],query));
        }
        return fragments;
    }

    @Override
    public void intToolBar() {

    }

    @Override
    public void onPageSelected(int position) {
        super.onPageSelected(position);
        if(getActivity()!=null && getActivity() instanceof BaseUiActivity){
            BaseUiActivity baseUiActivity = (BaseUiActivity) getActivity();
            if(baseUiActivity.getSlidrInterface()!=null){
                if (position == 0){
                    baseUiActivity.getSlidrInterface().unlock();
                }else{
                    baseUiActivity.getSlidrInterface().lock();
                }
            }
        }

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

}
