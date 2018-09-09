package com.yeyue.library.base;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.jess.arms.di.component.AppComponent;
import com.yeyue.library.R;
import com.yeyue.library.constant.YeConstant;
import com.yeyue.library.contract.YeWebPageView;
import com.yeyue.library.widgets.webview.FullscreenHolder;
import com.yeyue.library.widgets.webview.ImageClickInterface;
import com.yeyue.library.widgets.webview.MyWebChromeClient;
import com.yeyue.library.widgets.webview.YeWebViewClient;

/**
 * @author li.xiao
 * @describe 基类weebview
 * @time 2017-7-21 15:32
 */
public class YeWebActivity extends BaseUiActivity implements YeWebPageView {
    protected WebView yeWebView;
    protected ProgressBar yeProgressBar;

    // 加载视频相关
    private MyWebChromeClient mWebChromeClient;
    // 进度条是否加载到90%
    public boolean mProgress90;
    // 网页是否加载完成
    public boolean mPageFinish;
    // 全屏时视频加载view
    FrameLayout videoFullView;
    // title
    private String mTitle;
    // 网页链接
    private String mUrl;

    @Override
    public int getContentViewId() {
        return R.layout.yeyue_common_webview;
    }

    @Override
    public void findView() {
        yeWebView = (WebView) findViewById(R.id.ye_base_webview);
        yeProgressBar = (ProgressBar) findViewById(R.id.ye_webview_progress);
        videoFullView = (FrameLayout) findViewById(R.id.ye_video_fullView);
    }

    @Override
    public void onInitView() {
        super.onInitView();
        mToolbar.setOverflowIcon(ContextCompat.getDrawable(this, R.drawable.ye_actionbar_more));
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId()==R.id.ye_actionbar_share){
                    String shareText = mWebChromeClient.getTitle() + mUrl + "（分享自"+ AppUtils.getAppName()+"）";
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_SUBJECT, "分享");
                    intent.putExtra(Intent.EXTRA_TEXT, shareText);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getActivity().startActivity(
                            Intent.createChooser(intent, "分享"));
                }else if(item.getItemId()==R.id.ye_actionbar_cope){
                    // 得到剪贴板管理器
                    ClipboardManager cmb = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                    cmb.setText(mUrl.trim());
                    ToastUtils.showLong("复制成功");
                }else if(item.getItemId()==R.id.ye_actionbar_open){
                    Uri issuesUrl = Uri.parse(mUrl);
                    Intent intent = new Intent(Intent.ACTION_VIEW, issuesUrl);
                    getActivity().startActivity(intent);
                }
                return false;
            }
        });
        //初始化网页数据
        initWebView(yeWebView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ye_webview_menu, menu);
        return true;
    }

    @Override
    public boolean isToolbar() {
        return true;
    }

    /**
     * 提供AppComponent(提供所有的单例对象)给实现类，进行Component依赖
     *
     * @param appComponent
     */
    @Override
    public void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public void initData(Bundle savedInstanceState) {
        getIntentData();
        startProgress();
        yeWebView.loadUrl(mUrl);
    }

    private void getIntentData() {
        if (getIntent() != null) {
            mTitle = getIntent().getStringExtra("mTitle");
            mUrl = getIntent().getStringExtra("mUrl");
        }
        setTitle(mTitle);
    }

    /**
     * 可继承该方法，设置页面
     * @param webView
     */
    public void initWebView(WebView webView) {
        webView.setWebViewClient(new WebViewClient() {
            @SuppressWarnings("deprecation")
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        WebSettings settings = webView.getSettings();
        // 1、设置WebView是否支持使用屏幕控件或手势进行缩放，默认是true，支持缩放。
        settings.setSupportZoom(true);
        // 2、设置WebView是否通过手势触发播放媒体，默认是true，需要手势触发。
        settings.setMediaPlaybackRequiresUserGesture(true);
        // 3、设置WebView是否使用其内置的变焦机制，该机制集合屏幕缩放控件使用，默认是false，不使用内置变焦机制。
        settings.setBuiltInZoomControls(false);
        // 4、设置WebView使用内置缩放机制时，是否展现在屏幕缩放控件上，默认true，展现在控件上。
        settings.setDisplayZoomControls(false);
        // 5、设置在WebView内部是否允许访问文件，默认允许访问。
        settings.setAllowFileAccess(true);
        // 6、是否允许在WebView中访问内容URL(Content Url)，默认允许。内容Url访问允许WebView从安装在系统中的内容提供者载入内容。
        settings.setAllowContentAccess(true);
        // 7、设置WebView是否使用预览模式加载界面。
        settings.setLoadWithOverviewMode(true);
        // 8、设置WebView是否保存表单数据，默认true，保存数据。
        settings.setSaveFormData(true);
        // 9、设置WebView中加载页面字体变焦百分比，默认100，整型数。
        settings.setTextZoom(100);
        // 10、设置WebView访问第三方Cookies策略，参考CookieManager提供的方法：setShouldAcceptThirdPartyCookies。
        // settings.setAcceptThirdPartyCookies(false);
        // 11、设置WebView是否使用viewport，当该属性被设置为false时，加载页面的宽度总是适应WebView控件宽度；
        // 当被设置为true，当前页面包含viewport属性标签，在标签中指定宽度值生效，如果页面不包含viewport标签，
        // 无法提供一个宽度值，这个时候该方法将被使用。
        settings.setUseWideViewPort(false);
        // 12、设置WebView是否支持多屏窗口，参考WebChromeClient#onCreateWindow，默认false，不支持。
        settings.setSupportMultipleWindows(false);
        // 13、设置WebView底层的布局算法，参考LayoutAlgorithm#NARROW_COLUMNS，将会重新生成WebView布局。
        // settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        // 14、设置WebView标准字体库字体，默认字体“sans-serif”。
        settings.setStandardFontFamily("sans-serif");
        // 15、设置WebView固定的字体库字体，默认“monospace”。
        settings.setFixedFontFamily("monospace");
        // 16、设置WebView Sans SeriFontFamily字体库字体，默认“sans-serif”。
        settings.setSansSerifFontFamily("sans-serif");
        // 17、设置WebView seri FontFamily字体库字体，默认“sans-serif”。
        settings.setSerifFontFamily("sans-serif");
        // 18、设置WebView字体库字体，默认“cursive”。
        settings.setCursiveFontFamily("cursive");
        // 19、设置WebView字体库字体，默认“fantasy”。
        settings.setFantasyFontFamily("fantasy");
        // 20、设置WebView字体最小值，默认值8，取值1到72。
        settings.setMinimumFontSize(8);
        // 21、设置WebView逻辑上最小字体值，默认值8，取值1到72。
        settings.setMinimumLogicalFontSize(8);
        // 22、设置WebView默认值字体值，默认值16，取值1到72。
        settings.setDefaultFontSize(16);
        // 23、设置WebView默认固定的字体值，默认值16，取值1到72。
        settings.setDefaultFixedFontSize(16);
        // 24、设置WebView是否加载图片资源，默认true，自动加载图片。
        if(Build.VERSION.SDK_INT >= 19) {
            webView.getSettings().setLoadsImagesAutomatically(true);
        } else {
            webView.getSettings().setLoadsImagesAutomatically(false);
        }
        // 25、设置WebView是否以http、https方式访问从网络加载图片资源，默认false。
        settings.setBlockNetworkImage(false);
        // 26、设置WebView是否从网络加载资源，Application需要设置访问网络权限，否则报异常。
        settings.setBlockNetworkLoads(false);
        // 27、设置WebView是否允许执行JavaScript脚本，默认false，不允许。
        settings.setJavaScriptEnabled(true);
        // 28、设置WebView运行中的脚本可以是否访问任何原始起点内容，默认true。
        settings.setAllowUniversalAccessFromFileURLs(true);
        // 29、设置WebView运行中的一个文件方案被允许访问其他文件方案中的内容，默认值true。
        settings.setAllowFileAccessFromFileURLs(true);
        // 30、设置WebView保存地理位置信息数据路径，指定的路径Application具备写入权限。
        // settings.setGeolocationDatabasePath(String path);
        // 31、设置Application缓存API是否开启，默认false，设置有效的缓存路径参考setAppCachePath(String path)方法。
        settings.setAppCacheEnabled(true);
        // 32、设置当前Application缓存文件路径，Application Cache API能够开启需要指定Application具备写入权限的路径。
        // settings.setAppCachePath(String appCachePath);
        // 33、设置是否开启数据库存储API权限，默认false，未开启，可以参考setDatabasePath(String path)。
        settings.setDatabaseEnabled(true);
        // 34、设置是否开启DOM存储API权限，默认false，未开启，设置为true，WebView能够使用DOM storage API。
        settings.setDomStorageEnabled(true);
        // 35、设置是否开启定位功能，默认true，开启定位。
        settings.setGeolocationEnabled(true);
        // 36、设置脚本是否允许自动打开弹窗，默认false，不允许。
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        // 37、设置WebView加载页面文本内容的编码，默认“UTF-8”。
        settings.setDefaultTextEncodingName("UTF-8");
        // 38、设置WebView代理字符串，如果String为null或为空，将使用系统默认值。
        // settings.setUserAgentString(String ua);
        // 39、设置WebView是否需要设置一个节点获取焦点当被回调的时候，默认true。
        settings.setNeedInitialFocus(true);
        // 40、重写缓存被使用到的方法，该方法基于Navigation Type，加载普通的页面，将会检查缓存同时重新验证是否需要加载，
        // 如果不需要重新加载，将直接从缓存读取数据，
        // 允许客户端通过指定LOAD_DEFAULT、LOAD_CACHE_ELSE_NETWORK、LOAD_NO_CACHE、LOAD_CACHE_ONLY其中之一重写该行为方法，
        // 默认值LOAD_DEFAULT。
        // settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        // 41、设置当一个安全站点企图加载来自一个不安全站点资源时WebView的行为，
        // android.os.Build.VERSION_CODES.KITKAT默认为MIXED_CONTENT_ALWAYS_ALLOW，
        // android.os.Build.VERSION_CODES#LOLLIPOP默认为MIXED_CONTENT_NEVER_ALLOW，
        // 取值其中之一：MIXED_CONTENT_NEVER_ALLOW、MIXED_CONTENT_ALWAYS_ALLOW、MIXED_CONTENT_COMPATIBILITY_MODE。
        // settings.setMixedContentMode(WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE);

        //Android 5.0上Webview默认不允许加载Http与Https混合内容：
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //两者都可以
            settings.setMixedContentMode(settings.getMixedContentMode());
            //mWebView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        mWebChromeClient = new MyWebChromeClient(this);
        webView.setWebChromeClient(mWebChromeClient);
        // 与js交互
        webView.addJavascriptInterface(new ImageClickInterface(this), "injectedObject");
        webView.setWebViewClient(new YeWebViewClient(this));
    }

    public void setWebviewTitle(String title){
        setTitle(title);
    }

    @Override
    public void hindProgressBar() {
        yeProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void startProgress() {
        yeProgressBar.setVisibility(View.VISIBLE);
        startProgress90();
    }

    @Override
    public void showWebView() {
        yeWebView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hindWebView() {
        yeWebView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void fullViewAddView(View view) {
        FrameLayout decor = (FrameLayout) getWindow().getDecorView();
        videoFullView = new FullscreenHolder(getActivity());
        videoFullView.addView(view);
        decor.addView(videoFullView);
    }

    @Override
    public void showVideoFullView() {
        videoFullView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hindVideoFullView() {
        videoFullView.setVisibility(View.GONE);
    }

    @Override
    public void progressChanged(int newProgress) {
        if (mProgress90) {
            int progress = newProgress * 10;
            if (progress > 900) {
                yeProgressBar.setProgress(progress);
                if (progress == 1000) {
                    yeProgressBar.setVisibility(View.GONE);
                    showLoadSirView(YeConstant.LoadSir.SUCCESS);
                }
            }
        }
    }

    @Override
    public void addImageClickListener() {
        // 这段js函数的功能就是，遍历所有的img节点，并添加onclick函数，函数的功能是在图片点击的时候调用本地java接口并传递url过去
        // 如要点击一张图片在弹出的页面查看所有的图片集合,则获取的值应该是个图片数组
        yeWebView.loadUrl("javascript:(function(){" +
                "var objs = document.getElementsByTagName(\"img\");" +
                "for(var i=0;i<objs.length;i++)" +
                "{" +
                //  "objs[i].onclick=function(){alert(this.getAttribute(\"has_link\"));}" +
                "objs[i].onclick=function(){window.injectedObject.imageClick(this.getAttribute(\"src\"),this.getAttribute(\"has_link\"));}" +
                "}" +
                "})()");

        // 遍历所有的a节点,将节点里的属性传递过去(属性自定义,用于页面跳转)
        yeWebView.loadUrl("javascript:(function(){" +
                "var objs =document.getElementsByTagName(\"a\");" +
                "for(var i=0;i<objs.length;i++)" +
                "{" +
                "objs[i].onclick=function(){" +
                "window.injectedObject.textClick(this.getAttribute(\"type\"),this.getAttribute(\"item_pk\"));}" +
                "}" +
                "})()");
    }

    /**
     * 进度条 假装加载到90%
     */
    public void startProgress90() {
        for (int i = 0; i < 900; i++) {
            final int progress = i + 1;
            yeProgressBar.postDelayed(new Runnable() {
                @Override
                public void run() {
                    yeProgressBar.setProgress(progress);
                    if (progress == 900) {
                        mProgress90 = true;
                        if (mPageFinish) {
                            startProgress90to100();
                        }
                    }
                }
            }, (i + 1) * 2);
        }
    }

    /**
     * 进度条 加载到100%
     */
    public void startProgress90to100() {
        for (int i = 900; i <= 1000; i++) {
            final int progress = i + 1;
            yeProgressBar.postDelayed(new Runnable() {
                @Override
                public void run() {
                    yeProgressBar.setProgress(progress);
                    if (progress == 1000) {
                        yeProgressBar.setVisibility(View.GONE);
                    }
                }
            }, (i + 1) * 2);
        }
    }


    public FrameLayout getVideoFullView() {
        return videoFullView;
    }

    /**
     * 全屏时按返加键执行退出全屏方法
     */
    public void hideCustomView() {
        mWebChromeClient.onHideCustomView();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    /**
     * 上传图片之后的回调
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == MyWebChromeClient.FILECHOOSER_RESULTCODE) {
            mWebChromeClient.mUploadMessage(intent, resultCode);
        } else if (requestCode == MyWebChromeClient.FILECHOOSER_RESULTCODE_FOR_ANDROID_5) {
            mWebChromeClient.mUploadMessageForAndroid5(intent, resultCode);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //全屏播放退出全屏
            if (mWebChromeClient.inCustomView()) {
                hideCustomView();
                return true;
                //返回网页上一页
            } else if (yeWebView.canGoBack()) {
                yeWebView.goBack();
                return true;
                //退出网页
            } else {
                yeWebView.loadUrl("about:blank");
                finish();
            }
        }
        return false;
    }

    @Override
    protected void onPause() {
        super.onPause();
        yeWebView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        yeWebView.onResume();
        // 支付宝网页版在打开文章详情之后,无法点击按钮下一步
        yeWebView.resumeTimers();
        // 设置为横屏
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        videoFullView.removeAllViews();
        if (yeWebView != null) {
            ViewGroup parent = (ViewGroup) yeWebView.getParent();
            if (parent != null) {
                parent.removeView(yeWebView);
            }
            yeWebView.removeAllViews();
            yeWebView.loadUrl("about:blank");
            yeWebView.stopLoading();
            yeWebView.setWebChromeClient(null);
            yeWebView.setWebViewClient(null);
            yeWebView.destroy();
            yeWebView = null;
        }
    }

    /**
     * 打开网页:
     *
     * @param mContext 上下文
     * @param mUrl     要加载的网页url
     * @param mTitle   title
     */
    public static void loadUrl(Context mContext, String mUrl, String mTitle) {
        Intent intent = new Intent(mContext, YeWebActivity.class);
        intent.putExtra("mUrl", mUrl);
        intent.putExtra("mTitle", mTitle);
        mContext.startActivity(intent);
    }

    /**
     * 显示加载
     */
    @Override
    public void showLoading() {

    }

    /**
     * 隐藏加载
     */
    @Override
    public void hideLoading() {

    }

    /**
     * 显示信息
     *
     * @param message
     */
    @Override
    public void showMessage(String message) {

    }

    /**
     * 跳转activity
     *
     * @param intent
     */
    @Override
    public void launchActivity(Intent intent) {

    }

    @Override
    public View getLoadView() {
        return null;
    }

    /**
     * 杀死自己
     */
    @Override
    public void killMyself() {

    }
}
