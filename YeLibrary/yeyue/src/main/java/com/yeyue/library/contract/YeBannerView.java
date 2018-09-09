package com.yeyue.library.contract;

import com.yeyue.library.data.BaseBanner;

import java.util.List;

/**
 * author: xiaofeng
 * created on: 2016/9/12
 * describe:
 */
public interface YeBannerView<T> extends YeBaseRecyview<T>{
    void setBannerData(List<BaseBanner> bannerData);
}
