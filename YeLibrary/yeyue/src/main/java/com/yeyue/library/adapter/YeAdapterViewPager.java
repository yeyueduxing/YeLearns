package com.yeyue.library.adapter;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by li.xiao on 2017-12-11.
 */

public class YeAdapterViewPager extends FragmentStatePagerAdapter{
    private List<Fragment> mList;
    private CharSequence[] mTitles;

    public YeAdapterViewPager(FragmentManager fragmentManager, List<Fragment> list) {
        super(fragmentManager);
        this.mList = list;
    }


    public YeAdapterViewPager(FragmentManager fragmentManager, List<Fragment> list, CharSequence[] titles) {
        super(fragmentManager);
        this.mList = list;
        this.mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (mTitles != null) {
            return mTitles[position];
        }
        return super.getPageTitle(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

}
