package com.yeyue.learns.ui.bizhi.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

import com.jess.arms.di.component.AppComponent;
import com.yeyue.learns.constant.Constant;
import com.yeyue.learns.enity.bizhi.VerCategory;
import com.yeyue.learns.enity.bizhi.VideoCategory;
import com.yeyue.learns.enity.bizhi.WalCategory;
import com.yeyue.learns.ui.bizhi.fragment.BizhiListFragment;
import com.yeyue.library.base.YePageActivity;

import java.util.ArrayList;

/**
 * Created by li.xiao on 2017-12-7.
 */

public class BizhiCategoryActivity extends YePageActivity{
    private String[] titles = {"热门","最新","专辑"};
    private String[] verTitles = {"热门","最新"};
    private String[] homeGirlTitle = {"竖屏","横屏","纯净","气质","香车","俏皮","侧颜"};
    private String[] homeAnimationTitle = {"竖屏","横屏","竖屏"};
    private WalCategory.CategoryBean categoryBean;
    private VerCategory verCategory;
    private VideoCategory videoCategory;
    private String cId;
    private int type;
    @Override
    public String[] getTitlse() {
        if(verCategory!=null){
            return verTitles;
        }else if(categoryBean!=null){
            return titles;
        }else if(videoCategory!=null){
            return titles;
        }else{
            switch (type){
                case Constant.BIZHI_HOME_TAG_GIRL:
                    return homeGirlTitle;
                case Constant.BIZHI_HOME_TAG_ANIMATION:
                    return homeAnimationTitle;
            }
        }
        return titles;
    }

    @Override
    public ArrayList<Fragment> getFragment() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        if(verCategory!=null){
            fragments.add(BizhiListFragment.newInstance(Constant.BIZHI_VERTICAL_CATEGORY_HOT,cId));
            fragments.add(BizhiListFragment.newInstance(Constant.BIZHI_VERTICAL_CATEGORY_NEW,cId));
        }else if(categoryBean!=null){
            fragments.add(BizhiListFragment.newInstance(Constant.BIZHI_WALLPAPER_CATEGORY_HOT,cId));
            fragments.add(BizhiListFragment.newInstance(Constant.BIZHI_WALLPAPER_CATEGORY_NEW,cId));
            fragments.add(BizhiListFragment.newInstance(Constant.BIZHI_WALLPAPER_CATEGORY_ALBUM,cId));
        }else if(videoCategory!=null){
            fragments.add(BizhiListFragment.newInstance(Constant.BIZHI_VIDEO_CATEGORY_HOT,cId));
            fragments.add(BizhiListFragment.newInstance(Constant.BIZHI_VIDEO_CATEGORY_NEW,cId));
        }else{
            switch (type){
                case Constant.BIZHI_HOME_TAG_GIRL:
                    fragments.add(BizhiListFragment.newInstance(Constant.BIZHI_VERTICAL_CATEGORY_NEW,"4e4d610cdf714d2966000000"));
                    fragments.add(BizhiListFragment.newInstance(Constant.BIZHI_WALLPAPER_CATEGORY_NEW,"4e4d610cdf714d2966000000"));
                    fragments.add(BizhiListFragment.newInstance(Constant.BIZHI_HOME_PAGE_ALBUM_DETAIL,"546c9c1469401b234606da56"));
                    fragments.add(BizhiListFragment.newInstance(Constant.BIZHI_HOME_PAGE_ALBUM_DETAIL,"5693671669401b7a39308888"));
                    fragments.add(BizhiListFragment.newInstance(Constant.BIZHI_HOME_PAGE_ALBUM_DETAIL,"4f688d020569797d5e000058"));
                    fragments.add(BizhiListFragment.newInstance(Constant.BIZHI_HOME_PAGE_ALBUM_DETAIL,"55d4284d69401b03a4bb5dab"));
                    fragments.add(BizhiListFragment.newInstance(Constant.BIZHI_HOME_PAGE_ALBUM_DETAIL,"552cee2469401b5a9162f492"));
                    break;
                case Constant.BIZHI_HOME_TAG_ANIMATION:
                    //动漫
                    fragments.add(BizhiListFragment.newInstance(Constant.BIZHI_VERTICAL_CATEGORY_NEW,"4e4d610cdf714d2966000003"));
                    fragments.add(BizhiListFragment.newInstance(Constant.BIZHI_WALLPAPER_CATEGORY_NEW,"4e4d610cdf714d2966000003"));
                    fragments.add(BizhiListFragment.newInstance(Constant.BIZHI_HOME_PAGE_ALBUM_DETAIL,"5790848469401b71e3554e0f"));
                    break;
            }
        }
        return fragments;
    }

    @Override
    public void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public void initData(Bundle savedInstanceState) {
        if(getIntent()!=null){
            if(getIntent().hasExtra(Constant.CATEGORY_ID)){
                categoryBean = (WalCategory.CategoryBean) getIntent().getSerializableExtra(Constant.CATEGORY_ID);
                if(categoryBean!=null){
                    cId = categoryBean.getId();
                    setTitle(categoryBean.getName()+"");
                }
            }
            if(getIntent().hasExtra(Constant.VERTICAL_CATEGORY_ID)){
                verCategory = (VerCategory) getIntent().getSerializableExtra(Constant.VERTICAL_CATEGORY_ID);
                if(verCategory!=null){
                    cId = verCategory.getId();
                    setTitle(verCategory.getName()+"");
                }
            }
            if(getIntent().hasExtra(Constant.VIDEO_CATEGORY_ID)){
                videoCategory = (VideoCategory) getIntent().getSerializableExtra(Constant.VIDEO_CATEGORY_ID);
                if(videoCategory!=null){
                    cId = videoCategory.getId();
                    setTitle(videoCategory.getName()+"");
                }
            }
            if(getIntent().hasExtra(Constant.BIZHI_PAGE_TYPE)){
                type =  getIntent().getIntExtra(Constant.BIZHI_PAGE_TYPE,Constant.BIZHI_HOME_TAG_GIRL);
                switch (type){
                    case Constant.BIZHI_HOME_TAG_GIRL:
                        setTitle("美女");
                        break;
                    case Constant.BIZHI_HOME_TAG_ANIMATION:
                        setTitle("动漫");
                        break;
                }
            }
        }
        super.initData(savedInstanceState);
    }

    @Override
    public boolean isToolbar() {
        return true;
    }

    @Override
    public void killMyself() {
        finish();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }
}
