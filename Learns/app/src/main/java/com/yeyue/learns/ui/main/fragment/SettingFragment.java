package com.yeyue.learns.ui.main.fragment;

import android.support.v7.preference.Preference;

import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.ObjectUtils;
import com.jess.arms.di.component.AppComponent;
import com.yeyue.learns.R;
import com.yeyue.learns.utils.ActivityUtils;
import com.yeyue.library.base.YeSettingFragment;

import java.util.ArrayList;
import java.util.List;
/**
  *@describe 设置页
  *@author li.xiao
  *@time 2018-1-24 16:07
  */
public class SettingFragment extends YeSettingFragment{
    private AppComponent appComponent;
    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
        this.appComponent = appComponent;
    }
    @Override
    public int inflateMenu() {
        return R.menu.yeyue_menu_setting;
    }

    @Override
    public void onItemClick(Preference preference) {
        if(preference!=null && !ObjectUtils.isEmpty(preference.getKey())){
            if(preference.getKey().equals(getActivity().getString(R.string.YeConsKey_LoadIndicator))){
                ActivityUtils.openLoadTypeActivty(getActivity());
            }
        }
    }

    @Override
    public List<Preference> getAddPreferences() {
        /*List<Preference> preferences = new ArrayList<>();
        Preference item = new Preference(getActivity());
        item.setTitle(R.string.YeConsTitle_CacheSize);
        item.setSummary(FileUtils.getDirSize(appComponent.cacheFile()));
        preferences.add(item);*/
        return null;
    }

    @Override
    public int getContentViewId() {
        return 0;
    }

    @Override
    public int getItemLayoutResId() {
        return R.layout.yeyue_preference_item;
    }


}
