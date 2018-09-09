package com.yeyue.learns.ui.gamersky.activity;

import android.content.Context;
import android.content.Intent;

import com.yeyue.learns.widgets.webview.GamerSkyWebViewClient;
import com.yeyue.library.base.YeWebActivity;
import com.yeyue.library.widgets.webview.YeWebViewClient;

/**
 * Created by Administrator on 2018/1/20 0020.
 */

public class GamerSkyWebActivity extends YeWebActivity{
    @Override
    public void onInitView() {
        super.onInitView();
        yeWebView.setWebViewClient(new GamerSkyWebViewClient(this));
    }
    /**
     * 打开网页:
     *
     * @param mContext 上下文
     * @param mUrl     要加载的网页url
     * @param mTitle   title
     */
    public static void loadUrl(Context mContext, String mUrl, String mTitle) {
        Intent intent = new Intent(mContext, GamerSkyWebActivity.class);
        intent.putExtra("mUrl", mUrl);
        intent.putExtra("mTitle", mTitle);
        mContext.startActivity(intent);
    }
}
