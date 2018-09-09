/*
 * Copyright 2017 GcsSloop
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Last modified 2017-03-11 22:24:28
 *
 * GitHub:  https://github.com/GcsSloop
 * Website: http://www.gcssloop.com
 * Weibo:   http://weibo.com/GcsSloop
 */

package com.yeyue.learns.widgets;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.yeyue.library.base.BaseUiActivity;
import com.yeyue.library.base.YeWebActivity;


/**
 * 自定义 web client， 做一些不可描述的事情
 */
public class GcsMarkdownViewClient extends WebViewClient {
    public static final String URL = "url";
    private BaseUiActivity mContext;


    public GcsMarkdownViewClient(@NonNull BaseUiActivity context) {
        mContext = context;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        addImageClickListener(view);
        super.onPageFinished(view, url);
    }

    /**
     * 注入js函数监听
     * <p>
     * 原理是：循环扫描所有 img 节点，将链接提取出来，并且注入监听函数
     *
     * @param webView
     */
    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    private <Web extends WebView> void addImageClickListener(Web webView) {
        // 遍历所有签过名的图片，并添加onclick函数，函数的功能是在图片点击的时候调用本地java接口并传递url过去
        webView.loadUrl("javascript:(function(){" +
                "var objs = document.getElementsByClassName(\"gcs-img-sign\"); " +
                "for(var i=0;i<objs.length;i++)  " +
                "{" +
                "  window.listener.collectImage(objs[i].src); " +
                "  objs[i].onclick=function()  " +
                "  {  " +
                "    window.listener.onImageClicked(this.src);  " +
                "  }  " +
                "}" +
                "})()");
    }


    //--- html 链接打开方式 -----------------------------------------------------------------------

    @SuppressWarnings("deprecation")
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        // 优酷视频跳转浏览器播放
        if (url.startsWith("http://v.youku.com/")) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addCategory("android.intent.category.BROWSABLE");
            Uri content_url = Uri.parse(url);
            intent.setData(content_url);
            mContext.startActivity(intent);
            return true;

            // 电话、短信、邮箱
        } else if (url.startsWith(WebView.SCHEME_TEL) || url.startsWith("sms:") || url.startsWith(WebView.SCHEME_MAILTO)) {
            try {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                mContext.startActivity(intent);
            } catch (ActivityNotFoundException ignored) {
            }
            return true;
        }else if (url.startsWith("http")) {
            try {
                YeWebActivity.loadUrl(mContext,url,"");
            } catch (ActivityNotFoundException ignored) {
            }
            return true;
        }
        view.loadUrl(url);
        return false;
    }
}
