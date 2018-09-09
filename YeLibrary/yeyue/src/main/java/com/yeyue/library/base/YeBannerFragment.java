package com.yeyue.library.base;

import android.view.View;
import android.widget.ImageView;

import com.yeyue.library.R;
import com.yeyue.library.contract.YeBannerView;
import com.yeyue.library.data.BaseBanner;
import com.yeyue.library.presenter.YeBannerPresenter;
import com.yeyue.library.utils.ImageLoadUtils;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;


public abstract class YeBannerFragment<T, P extends YeBannerPresenter> extends YeRecyFragment<T, P> implements YeBannerView<T>,BGABanner.Delegate<ImageView,BaseBanner> {

    private BGABanner mBGABanner;

    @Override
    public int getReHeaderView() {
        return R.layout.yeyue_fragment_banner_header;
    }

    @Override
    public void findView(View rootView) {
        super.findView(rootView);
        mBGABanner = (BGABanner)mYeHeaderView.findViewById(R.id.yeBaBizhi);
        mBGABanner.setAdapter(new BGABanner.Adapter<ImageView,BaseBanner>() {
            @Override
            public void fillBannerItem(BGABanner bgaBanner, ImageView view, BaseBanner model, int i) {
                ImageLoadUtils.showImageView(getActivity(),view,model.getBaImg());
            }
        });
        mBGABanner.setDelegate(this);
    }

    @Override
    public void setBannerData(List<BaseBanner> bannerData) {
        if(bannerData!=null){
            List<String> tips = new ArrayList<>();
            for (BaseBanner bean:bannerData){
                tips.add(bean.getBaTitle());
            }
            mBGABanner.setData(bannerData,tips);
        }
    }

}
