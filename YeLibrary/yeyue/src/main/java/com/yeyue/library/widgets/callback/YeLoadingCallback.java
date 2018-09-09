package com.yeyue.library.widgets.callback;

import android.content.Context;
import android.view.View;

import com.kingja.loadsir.callback.Callback;
import com.wang.avi.AVLoadingIndicatorView;
import com.yeyue.library.R;
import com.yeyue.library.utils.YeSpUtils;

import skin.support.content.res.SkinCompatResources;


/**
 * Description:TODO
 * Create Time:2017/9/4 10:22
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */

public class YeLoadingCallback extends Callback {
    private AVLoadingIndicatorView avLoad;
    private boolean hasSet = false;
    @Override
    protected int onCreateView() {
        return R.layout.yeyue_callback_loading;
    }

    @Override
    protected void onViewCreate(Context context, View view) {
        super.onViewCreate(context, view);
        if(view!=null && view.findViewById(R.id.avLoad)!=null){
            avLoad = (AVLoadingIndicatorView)view.findViewById(R.id.avLoad);
            if(!hasSet){
                hasSet = true;
                avLoad.setIndicator(INDICATORS[YeSpUtils.getLoadViewIndicator()]);
            }
            int color = SkinCompatResources.getInstance().getColor(R.color.ye_color_Main_Word);
            avLoad.setIndicatorColor(color);
        }
    }

    /**
     * 加载的类型
     */
    public static final String[] INDICATORS=new String[]{
            "BallPulseIndicator",
            "BallGridPulseIndicator",
            "BallClipRotateIndicator",
            "BallClipRotatePulseIndicator",
            "SquareSpinIndicator",
            "BallClipRotateMultipleIndicator",
            "BallPulseRiseIndicator",
            "BallRotateIndicator",
            "CubeTransitionIndicator",
            "BallZigZagIndicator",
            "BallZigZagDeflectIndicator",
            "BallTrianglePathIndicator",
            "BallScaleIndicator",
            "LineScaleIndicator",
            "LineScalePartyIndicator",
            "BallScaleMultipleIndicator",
            "BallPulseSyncIndicator",
            "BallBeatIndicator",
            "LineScalePulseOutIndicator",
            "LineScalePulseOutRapidIndicator",
            "BallScaleRippleIndicator",
            "BallScaleRippleMultipleIndicator",
            "BallSpinFadeLoaderIndicator",
            "LineSpinFadeLoaderIndicator",
            "TriangleSkewSpinIndicator",
            "PacmanIndicator",
            "BallGridBeatIndicator",
            "SemiCircleSpinIndicator",
            "com.wang.avi.sample.MyCustomIndicator"
    };
}
