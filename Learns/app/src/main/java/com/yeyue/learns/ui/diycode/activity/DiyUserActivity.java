package com.yeyue.learns.ui.diycode.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.yeyue.learns.R;
import com.yeyue.learns.constant.Constant;
import com.yeyue.learns.enity.diycode.DiyUser;
import com.yeyue.learns.ui.diycode.fragment.DiyCodeListFragment;
import com.yeyue.library.base.YeHeaderPageActivity;
import com.yeyue.library.utils.ImageLoadUtils;
import com.yeyue.library.widgets.glide.YeGlideBlurformation;

import java.util.ArrayList;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by li.xiao on 2018-1-9.
 */

public class DiyUserActivity extends YeHeaderPageActivity {

    @BindView(R.id.ivBackground)
    ImageView ivBackground;
    @BindView(R.id.ivAvatar)
    CircleImageView ivAvatar;
    @BindView(R.id.tvUsername)
    TextView tvUsername;
    private DiyUser diyUser;
    private String[] titles = {"我的", "收藏",  "关注", "粉丝"};

    @Override
    public String[] getTitlse() {
        return titles;
    }

    @Override
    public ArrayList<Fragment> getFragment() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(DiyCodeListFragment.newInstance(Constant.DIYCODE_USER_MINE,diyUser.getLogin()));
        fragments.add(DiyCodeListFragment.newInstance(Constant.DIYCODE_USER_COLLECT,diyUser.getLogin()));
        fragments.add(DiyCodeListFragment.newInstance(Constant.DIYCODE_USER_FOLLOW,diyUser.getLogin()));
        fragments.add(DiyCodeListFragment.newInstance(Constant.DIYCODE_USER_FANS,diyUser.getLogin()));
        return fragments;
    }

    @Override
    public int setHeaderId() {
        return R.layout.activity_diy_user_header;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        if(getIntent()!=null && getIntent().hasExtra(Constant.DIY_USER_INFO)){
            diyUser = (DiyUser) getIntent().getSerializableExtra(Constant.DIY_USER_INFO);
        }
        if(diyUser==null){
            ToastUtils.showLong("用户不存在");
            finish();
            return;
        }
        tvUsername.setText(diyUser.getName());
        ImageLoadUtils.showImageView(getActivity(),ivAvatar,diyUser.getAvatar_url(),R.mipmap.icon_diycode,R.mipmap.icon_diycode);
        ImageLoadUtils.showImageView(getActivity(),ivBackground,diyUser.getAvatar_url(),new YeGlideBlurformation(getActivity(),20));
        setTitle(diyUser.getName());
        super.initData(savedInstanceState);
    }

    @Override
    public void killMyself() {

    }
}
