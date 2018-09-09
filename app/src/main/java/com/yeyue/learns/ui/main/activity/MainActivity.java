package com.yeyue.learns.ui.main.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.view.MenuItem;
import android.view.View;

import com.jess.arms.di.component.AppComponent;
import com.yeyue.learns.R;
import com.yeyue.learns.constant.Constant;
import com.yeyue.learns.ui.bizhi.fragment.BizhiFragment;
import com.yeyue.learns.ui.diycode.fragment.DiycodeFragment;
import com.yeyue.learns.ui.gamersky.fragment.GamerSkyFragment;
import com.yeyue.learns.ui.gank.fragment.GankFragment;
import com.yeyue.learns.ui.main.fragment.BannerFragment;
import com.yeyue.learns.ui.movie.fragment.MovieFragment;
import com.yeyue.learns.ui.wechat.fragment.WeChatFragment;
import com.yeyue.learns.utils.ActivityUtils;
import com.yeyue.library.base.YeDrawerFragmentActivity;
import com.yeyue.library.base.YeWebActivity;

/**
 * Created by li.xiao on 2017-9-8.
 */

/**
 * @author li.xiao
 * @describe 应用主页
 * @time 2017-10-31 14:49
 */
public class MainActivity extends YeDrawerFragmentActivity {

    @Override
    public void setupActivityComponent(AppComponent appComponent) {

    }
    @Override
    public Fragment getFragment(int tag) {
        Fragment fragment = null;
        switch (tag){
            case R.id.nav_diycode:
                fragment = new DiycodeFragment();
                break;
            case R.id.nav_gank:
                fragment = new GankFragment();
                break;
            case R.id.nav_wechat:
                fragment = new WeChatFragment();
                break;
            case R.id.nav_gamerSky:
                fragment = new GamerSkyFragment();
                break;
            case R.id.nav_movie:
                fragment =  new MovieFragment();
                break;
            case R.id.nav_bizhi:
                fragment =  new BizhiFragment();
                break;
            case R.id.nav_wan:
                fragment =  BannerFragment.newInstance(Constant.WAN_HOME_LIST);
                break;
        }

        return fragment;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        super.initData(savedInstanceState);
        setTitle("夜月资讯");
        View headerview = mNavView.getHeaderView(0);
        if(headerview!=null){
            headerview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                    YeWebActivity.loadUrl(getActivity(),"https://github.com/yeyueduxing","夜神月");
                }
            });
        }
        mToolbar.setNavigationIcon(R.drawable.icon_nav_titlebar_menu);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    public int initDefaultTag() {
        return R.id.nav_bizhi;
    }

    @Override
    public void intToolBar() {

    }

    @Override
    public boolean isToolbar() {
        return true;
    }

    @Override
    public boolean isSlide() {
        return false;
    }

    @Override
    public int getNavHeaderViewId() {
        return R.layout.activity_main_nav_header;
    }

    @Override
    public int getNavMenuId() {
        return R.menu.activity_main_drawer;
    }

    @Override
    public boolean onNavItemSelected(MenuItem item) {
        boolean isSelect = true;
        switch (item.getItemId()){
            case R.id.nav_skin:
                isSelect = false;
                ActivityUtils.openSkinActivity(getActivity());
                break;
            case R.id.nav_setting:
                isSelect = false;
                ActivityUtils.openSettingActivity(getActivity());
                break;
            default:
                goFragment(item.getItemId());
                break;
        }
        return isSelect;
    }

}
