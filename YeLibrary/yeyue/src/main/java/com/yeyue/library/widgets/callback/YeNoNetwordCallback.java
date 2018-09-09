package com.yeyue.library.widgets.callback;

import android.content.Context;
import android.view.View;

import com.blankj.utilcode.util.NetworkUtils;
import com.kingja.loadsir.callback.Callback;
import com.yeyue.library.R;

/**
 * @author li.xiao
 * @describe 网络未连接
 * @time 2018-1-23 11:25
 */
public class YeNoNetwordCallback extends Callback {
    private OnReloadListener reloadListener;

    @Override
    public Callback setCallback(View view, Context context, OnReloadListener onReloadListener) {
        reloadListener = onReloadListener;
        return super.setCallback(view, context, onReloadListener);
    }

    @Override
    protected int onCreateView() {
        return R.layout.yeyue_callback_no_network;
    }

    @Override
    protected void onViewCreate(Context context, View view) {
        super.onViewCreate(context, view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (reloadListener != null) {
                    reloadListener.onReload(v);
                }
            }
        });
        if(view.findViewById(R.id.btSetting)!=null){
            view.findViewById(R.id.btSetting).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NetworkUtils.openWirelessSettings();
                }
            });
        }
        if(view.findViewById(R.id.btRefresh)!=null){
            view.findViewById(R.id.btRefresh).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (reloadListener != null) {
                        reloadListener.onReload(v);
                    }
                }
            });
        }
    }
}
