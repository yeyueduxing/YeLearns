package com.yeyue.learns.ui.wechat.fragment;

import android.support.v4.app.Fragment;
import android.view.MenuItem;

import com.jess.arms.di.component.AppComponent;
import com.yeyue.learns.R;
import com.yeyue.learns.constant.Constant;
import com.yeyue.learns.enity.wechat.WeChatTag;
import com.yeyue.learns.utils.ActivityUtils;
import com.yeyue.learns.utils.WeChatUtils;
import com.yeyue.library.base.YePageFragment;

import org.simple.eventbus.Subscriber;

import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;

/**
 * Created by li.xiao on 2018-1-12.
 */

public class WeChatPageFragment extends YePageFragment {
    private String[] titles = {"首页"};

    private int type;
    public static WeChatPageFragment newInstance(int type){
        WeChatPageFragment fragment = new WeChatPageFragment();
        fragment.type = type;
        return fragment;
    }
    @Override
    public int getContentViewId() {
        return R.layout.fragment_wechat_page;
    }

    @Override
    public String[] getTitlse() {
        List<WeChatTag> tags = new ArrayList<>();
        if(type==Constant.WECHAT_NEW_TAG){
            tags = WeChatUtils.getSelectWeChatTags();
        }else{
            tags = WeChatUtils.getSelectWeChatLifeTags("");
        }
        if (tags != null && tags.size() > 0) {
            String[] tagTitle = new String[tags.size()];
            for (int i = 0; i < tags.size(); i++) {
                tagTitle[i] = tags.get(i).getTitle();
            }
            return tagTitle;
        }
        return titles;
    }

    @Override
    public ArrayList<Fragment> getFragment() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        List<WeChatTag> tags = new ArrayList<>();
        if(type==Constant.WECHAT_NEW_TAG){
            tags = WeChatUtils.getSelectWeChatTags();
        }else{
            tags = WeChatUtils.getSelectWeChatLifeTags("");
        }
        if (tags != null && tags.size() > 0) {
            for (int i = 0; i < tags.size(); i++) {
                fragments.add(WeChatListFragment.newInstance(Constant.WECHAT_NEW_LIST, tags.get(i).getTag()));
            }
        } else {
            fragments.add(WeChatListFragment.newInstance(Constant.WECHAT_NEW_LIST,"wxnew"));
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
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {

    }

    @Override
    public void setData(Object data) {

    }
    @Subscriber
    private void updateWeChatTag(WeChatTag weChatTag) {
        reloadViewPage();
    }

    @OnClick(R.id.ivSelectTag)
    public void onViewClicked() {
        ActivityUtils.openWeChataTagActivity(getActivity(),type);
    }
}
