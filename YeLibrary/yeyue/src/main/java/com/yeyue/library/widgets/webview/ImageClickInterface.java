package com.yeyue.library.widgets.webview;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.yeyue.library.widgets.viewbigimage.ViewBigImageActivity;

/**
 * Created by jingbin on 2016/11/17.
 * js通信接口
 */
public class ImageClickInterface {
    private Activity context;

    public ImageClickInterface(Activity context) {
        this.context = context;
    }

    @JavascriptInterface
    public void imageClick(String imgUrl, String hasLink) {
        ViewBigImageActivity.openImageSingleActivity(context,imgUrl);
    }

    @JavascriptInterface
    public void textClick(String type, String item_pk) {
        if (!TextUtils.isEmpty(type) && !TextUtils.isEmpty(item_pk)) {
            Toast.makeText(context, "----点击了文字", Toast.LENGTH_SHORT).show();
        }
    }
}
