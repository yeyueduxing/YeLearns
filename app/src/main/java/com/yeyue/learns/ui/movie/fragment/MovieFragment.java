package com.yeyue.learns.ui.movie.fragment;

import android.support.v4.app.Fragment;
import android.view.MenuItem;

import com.jess.arms.di.component.AppComponent;
import com.yeyue.learns.R;
import com.yeyue.learns.constant.Constant;
import com.yeyue.learns.utils.ActivityUtils;
import com.yeyue.library.base.YePageFragment;

import java.util.ArrayList;

import butterknife.OnClick;

/**
 * @author li.xiao
 * @describe 豆瓣电影
 * @time 2018-1-29 10:34
 */
public class MovieFragment extends YePageFragment {
    String[] titles = {"正在上映", "即将上映", "新片榜", "口碑榜", "Top250", "北美票房榜"};

    @Override
    public String[] getTitlse() {
        return titles;
    }

    @Override
    public int getContentViewId() {
        return R.layout.fragment_movie;
    }

    @Override
    public ArrayList<Fragment> getFragment() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(MovieListFragment.newInstance(Constant.MOVIE_LIST_DEFAULT, "in_theaters"));
        fragments.add(MovieListFragment.newInstance(Constant.MOVIE_LIST_DEFAULT, "coming_soon"));
        fragments.add(MovieListFragment.newInstance(Constant.MOVIE_LIST_DEFAULT, "new_movies"));
        fragments.add(MovieListFragment.newInstance(Constant.MOVIE_LIST_US_BOX, "weekly"));
        fragments.add(MovieListFragment.newInstance(Constant.MOVIE_LIST_DEFAULT, "top250"));
        fragments.add(MovieListFragment.newInstance(Constant.MOVIE_LIST_US_BOX, "ux_box"));
        return fragments;
    }

    @Override
    public void initData() {
        super.initData();
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
    public boolean isToolbar() {
        return false;
    }

    @Override
    public void setData(Object data) {

    }


    @OnClick(R.id.ivSearch)
    public void onViewClicked() {
        ActivityUtils.openMovieSearchActivity(getActivity(),Constant.MOVIE_SEARCH_TYPE);
    }
}
