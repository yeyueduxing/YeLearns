package com.yeyue.library.data;

import java.util.List;

/**
 * Created by Administrator on 2017/11/5 0005.
 */

public class BannerList {
    private List<BaseBanner> mBanners;
    private List<BaseItem> data;

    public List<BaseBanner> getBanners() {
        return mBanners;
    }

    public void setBanners(List<BaseBanner> banners) {
        mBanners = banners;
    }

    public List<BaseItem> getData() {
        return data;
    }

    public void setData(List<BaseItem> data) {
        this.data = data;
    }
}
