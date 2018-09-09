package com.yeyue.learns.ui.wechat.fragment;

import android.support.v4.app.Fragment;
import android.view.View;

import com.jess.arms.di.component.AppComponent;
import com.yeyue.learns.R;
import com.yeyue.learns.constant.Constant;
import com.yeyue.library.base.YeBottomBarFragment;
/**
  *@describe 微信主页
  *@author li.xiao
  *@time 2018-1-11 11:37
  */
public class WeChatFragment extends YeBottomBarFragment {

    @Override
    public Fragment getFragment(int tag) {
        Fragment fragment = null;
        switch (tag) {
            case R.id.wechat_newlist:
                fragment = WeChatListFragment.newInstance(Constant.WECHAT_NEW_LIST,"keji");
                break;
            case R.id.wechat_tag:
                fragment = WeChatPageFragment.newInstance(Constant.WECHAT_NEW_TAG);
                break;
        }
        return fragment;
    }

    @Override
    public int inflateMenu() {
        return R.menu.wechat_bottombars;
    }

    @Override
    public int defaultItem() {
        return R.id.wechat_newlist;
    }


    @Override
    public void initData() {
    }


    @Override
    public void setupFragmentComponent(AppComponent appComponent) {

    }

    @Override
    public void setData(Object data) {

    }

    @Override
    public void initView(View mRootView) {

    }

    @Override
    public void onInitView() {

    }

    @Override
    public boolean isToolbar() {
        return false;
    }

    @Override
    public void killMyself() {

    }
}