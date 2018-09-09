package com.yeyue.library.base;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.blankj.utilcode.util.ObjectUtils;
import com.jess.arms.mvp.IPresenter;
import com.yeyue.library.R;

/**
 * 通用应用底部导航栏主页
 * @param <P>
 */
public abstract class YeBottomBarFragment<P extends IPresenter> extends BaseUiFragment<P> implements BottomNavigationView.OnNavigationItemSelectedListener {
    protected String TAG_PRE = "bottom_bar_";
    protected FrameLayout yeContentContainer;
    protected BottomNavigationView yeBootomBar;

    protected FragmentManager fragmentManager;
    protected FragmentTransaction fragmentTransaction;
    protected String showTag;
    public abstract Fragment getFragment(int tag);
    public abstract int inflateMenu();
    public abstract int defaultItem();
    @Override
    public int getContentViewId() {
        return R.layout.yeyue_common_bottombar;
    }

    @Override
    public void findView(View rootView) {
        fragmentManager = getChildFragmentManager();
        yeContentContainer = (FrameLayout) rootView.findViewById(R.id.ye_contentContainer);
        yeBootomBar = (BottomNavigationView) rootView.findViewById(R.id.ye_bottomBar);
        if(inflateMenu()!=0){
            yeBootomBar.inflateMenu(inflateMenu());
        }
        yeBootomBar.setOnNavigationItemSelectedListener(this);
        if(defaultItem()!=0){
            yeBootomBar.setSelectedItemId(defaultItem());
        }
    }

    @Override
    public boolean  onNavigationItemSelected(@NonNull MenuItem item) {
        item.setChecked(true);
        goFragment(item.getItemId());
        return false;
    }

    public void goFragment(int tag){
        fragmentTransaction = fragmentManager.beginTransaction();
        if(!ObjectUtils.isEmpty(showTag)){
            Fragment showFragment = fragmentManager.findFragmentByTag(showTag);
            if(showFragment!=null){
                fragmentTransaction.hide(showFragment);
            }
        }
        Fragment  fragment = fragmentManager.findFragmentByTag(TAG_PRE+tag);
        if(fragment==null){
            fragment = getFragment(tag);
            if(fragment==null){
                showTag = null;
                return;
            }
            fragmentTransaction.add(R.id.ye_contentContainer,fragment,TAG_PRE+tag);
        }else{
            fragmentTransaction.show(fragment);
        }
        showTag = TAG_PRE+tag;
        fragmentTransaction.commit();
        if(fragment instanceof BaseUiFragment){
            BaseUiFragment uiFragment = (BaseUiFragment) fragment;
            uiFragment.resume();
        }
    }

    /**
     * 显示加载
     */
    @Override
    public void showLoading() {

    }

    /**
     * 隐藏加载
     */
    @Override
    public void hideLoading() {

    }

    /**
     * 显示信息
     *
     * @param message
     */
    @Override
    public void showMessage(String message) {

    }

    /**
     * 跳转activity
     *
     * @param intent
     */
    @Override
    public void launchActivity(Intent intent) {

    }

    @Override
    public boolean isToolbar() {
        return false;
    }

    @Override
    public View getLoadView() {
        return null;
    }
}
