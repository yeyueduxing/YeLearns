package com.yeyue.learns.ui.bizhi.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.jess.arms.di.component.AppComponent;
import com.yeyue.learns.R;
import com.yeyue.learns.constant.Constant;
import com.yeyue.learns.contract.BizhiUserContract;
import com.yeyue.learns.di.component.DaggerBizhiUserComponent;
import com.yeyue.learns.di.module.BizhiUserModule;
import com.yeyue.learns.enity.bizhi.UserBean;
import com.yeyue.learns.enity.bizhi.UserDetail;
import com.yeyue.learns.presenter.BizhiUserPresenter;
import com.yeyue.learns.ui.bizhi.fragment.BizhiListFragment;
import com.yeyue.library.base.YeHeaderPageActivity;
import com.yeyue.library.utils.ImageLoadUtils;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @author li.xiao
 * @describe 用户详情
 * @time 2017-12-7 14:02
 */
public class BizhiUserActivity extends YeHeaderPageActivity<BizhiUserPresenter> implements BizhiUserContract.View {

    @BindView(R.id.ivCover)
    ImageView ivCover;
    @BindView(R.id.tvNickname)
    TextView tvNickname;
    @BindView(R.id.tvDesc)
    TextView tvDesc;
    @BindView(R.id.tvRank)
    TextView tvRank;
    @BindView(R.id.tvVisit)
    TextView tvVisit;
    @BindView(R.id.tvFollowing)
    TextView tvFollowing;
    @BindView(R.id.tvFollower)
    TextView tvFollower;
    private UserBean userBean;
    private String uid;
    private String[] titles = {"壁纸", "竖屏壁纸", "专辑", "竖屏作品", "作品", "动态壁纸", "锁屏壁纸"};

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        super.setupActivityComponent(appComponent);
        DaggerBizhiUserComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .bizhiUserModule(new BizhiUserModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int setHeaderId() {
        return R.layout.activity_bizhi_user;
    }


    @Override
    public String[] getTitlse() {
        return titles;
    }

    @Override
    public ArrayList<Fragment> getFragment() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(BizhiListFragment.newInstance(Constant.BIZHI_USER_PAGE_BIZHI, uid));
        fragments.add(BizhiListFragment.newInstance(Constant.BIZHI_USER_PAGE_VERTICAL, uid));
        fragments.add(BizhiListFragment.newInstance(Constant.BIZHI_USER_PAGE_ALBUM, uid));
        fragments.add(BizhiListFragment.newInstance(Constant.BIZHI_USER_PAGE_VERTICAL_WORK, uid));
        fragments.add(BizhiListFragment.newInstance(Constant.BIZHI_USER_PAGE_WORK, uid));
        fragments.add(BizhiListFragment.newInstance(Constant.BIZHI_USER_PAGE_BIZHI, uid));
        fragments.add(BizhiListFragment.newInstance(Constant.BIZHI_USER_PAGE_BIZHI, uid));
        return fragments;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        if (getIntent() != null && getIntent().hasExtra(Constant.USER_INFO)) {
            userBean = (UserBean) getIntent().getSerializableExtra(Constant.USER_INFO);
            if (userBean != null) {
                uid = userBean.getId();
            }
        }
        super.initData(savedInstanceState);
        setTitle(userBean.getName()+"");
        mPresenter.getUser(uid);
    }

    @Override
    public void killMyself() {
        finish();
    }

    @Override
    public void initUser(UserDetail userDetail) {
        if (userDetail == null) {
            return;
        }
        ImageLoadUtils.showImageView(getActivity(),ivCover,userDetail.getAvatar());
        tvNickname.setText(userDetail.getName()+"");
        String desc = "签名：我是什么都没说的签名";
        if(!TextUtils.isEmpty(userDetail.getDesc())){
            desc = "签名:"+userDetail.getDesc();
        }
        tvDesc.setText(desc);
        tvRank.setText(userDetail.getRank()+"");
        tvVisit.setText(userDetail.getVisit()+"");
        tvFollower.setText(userDetail.getFollower()+"");
        tvFollowing.setText(userDetail.getFollowing()+"");
    }

}
