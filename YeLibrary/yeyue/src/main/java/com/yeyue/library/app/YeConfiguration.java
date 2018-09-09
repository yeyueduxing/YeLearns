package com.yeyue.library.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.ParseException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.jess.arms.base.BaseApplication;
import com.jess.arms.base.delegate.AppLifecycles;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.module.GlobalConfigModule;
import com.jess.arms.integration.ConfigModule;
import com.kingja.loadsir.core.LoadSir;
import com.liulishuo.filedownloader.FileDownloader;
import com.liulishuo.filedownloader.connection.FileDownloadUrlConnection;
import com.yeyue.library.base.BaseUiActivity;
import com.yeyue.library.base.YePageFragment;
import com.yeyue.library.constant.YeConstant;
import com.yeyue.library.data.YeSkinItem;
import com.yeyue.library.widgets.callback.YeEmptyCallback;
import com.yeyue.library.widgets.callback.YeErrorCallback;
import com.yeyue.library.widgets.callback.YeLoadingCallback;
import com.yeyue.library.widgets.callback.YeNoNetwordCallback;
import com.yeyue.library.widgets.callback.YeTimeoutCallback;
import com.yeyue.library.widgets.glide.YeGlideImageLoaderStrategy;
import com.yeyue.library.widgets.skin.loader.YeSkinSDCardLoader;

import org.json.JSONException;

import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.List;

import cn.bingoogolapple.swipebacklayout.BGASwipeBackHelper;
import retrofit2.HttpException;
import skin.support.SkinCompatManager;
import skin.support.app.SkinCardViewInflater;
import skin.support.constraint.app.SkinConstraintViewInflater;
import skin.support.design.app.SkinMaterialViewInflater;
import timber.log.Timber;

/**
 * app的全局配置信息在此配置,需要将此实现类声明到AndroidManifest中
 * Created by jess on 12/04/2017 17:25
 * Contact with jess.yan.effort@gmail.com
 */


public  class YeConfiguration implements ConfigModule {


    /**
     * 使用{@link GlobalConfigModule.Builder}给框架配置一些配置参数
     *
     * @param context
     * @param builder
     */
    @Override
    public void applyOptions(Context context, GlobalConfigModule.Builder builder) {
        //重构图片框架，为图片框架添加多种功能
        builder.
                imageLoaderStrategy(new YeGlideImageLoaderStrategy())
                .responseErrorListener((context1, t) -> {
                    /* 用来提供处理所有错误的监听
                       rxjava必要要使用ErrorHandleSubscriber(默认实现Subscriber的onError方法),此监听才生效 */
            Timber.tag("Catch-Error").w(t.getMessage());
            //这里不光是只能打印错误,还可以根据不同的错误作出不同的逻辑处理
            String msg = "未知错误";
            if (t instanceof UnknownHostException) {
                msg = "网络不可用";
            } else if (t instanceof SocketTimeoutException) {
                msg = "请求网络超时";
            } else if (t instanceof HttpException) {
                HttpException httpException = (HttpException) t;
                msg = convertStatusCode(httpException);
            } else if (t instanceof JsonParseException || t instanceof ParseException || t instanceof JSONException || t instanceof JsonIOException) {
                msg = "数据解析错误";
            }

            //ArmsUtils.snackbarText(msg);
        });
    }



    /**
     * 使用{@link AppLifecycles}在Application的生命周期中注入一些操作
     *
     * @param context
     * @param lifecycles
     * @return
     */
    @Override
    public void injectAppLifecycle(Context context, List<AppLifecycles> lifecycles) {
        lifecycles.add(new AppLifecycles() {
            @Override
            public void attachBaseContext(Context context) {

            }

            @Override
            public void onCreate(Application application) {
                //全局配置默认状态页
                AppComponent appComponent = ((BaseApplication) application).getAppComponent();
                appComponent.extras().put(YeConstant.LoadSir.ERROR,new YeErrorCallback());
                appComponent.extras().put(YeConstant.LoadSir.EMPTY,new YeEmptyCallback());
                appComponent.extras().put(YeConstant.LoadSir.TIMEOUT,new YeTimeoutCallback());
                appComponent.extras().put(YeConstant.LoadSir.NO_NETWORK,new YeNoNetwordCallback());
                appComponent.extras().put(YeConstant.LoadSir.LOADING,new YeLoadingCallback());
                LoadSir.beginBuilder()
                        .addCallback(new YeErrorCallback())
                        .addCallback(new YeEmptyCallback())
                        .addCallback(new YeTimeoutCallback())
                        .addCallback(new YeLoadingCallback())
                        .addCallback(new YeNoNetwordCallback())
                        .commit();

                //初始化自定义换肤
                SkinCompatManager.withoutActivity(application)
                        .addInflater(new com.yeyue.library.widgets.skin.bottombar.app.SkinMaterialViewInflater())
                        .addInflater(new SkinMaterialViewInflater())    // material design
                        .addInflater(new SkinConstraintViewInflater())  // ConstraintLayout
                        .addInflater(new SkinCardViewInflater())        // CardView v7
                        .addStrategy(new YeSkinSDCardLoader())          // 自定义加载策略，指定SDCard路径
                        .setSkinStatusBarColorEnable(false)
                        .loadSkin();

                FileDownloader.setupOnApplicationOnCreate(application)
                        .connectionCreator(new FileDownloadUrlConnection
                                .Creator(new FileDownloadUrlConnection.Configuration()
                                .connectTimeout(15_000) // set connection timeout.
                                .readTimeout(15_000) // set read timeout.
                                .proxy(Proxy.NO_PROXY) // set proxy
                        ))
                        .commit();

                /**
                 * 必须在 Application 的 onCreate 方法中执行 BGASwipeBackHelper.init 来初始化滑动返回
                 * 第一个参数：应用程序上下文
                 * 第二个参数：如果发现滑动返回后立即触摸界面时应用崩溃，请把该界面里比较特殊的 View 的 class 添加到该集合中，目前在库中已经添加了 WebView 和 SurfaceView
                 */
                BGASwipeBackHelper.init(application, null);
            }

            @Override
            public void onTerminate(Application application) {

            }
        });
    }

    @Override
    public void injectActivityLifecycle(Context context, List<Application.ActivityLifecycleCallbacks> lifecycles) {
        lifecycles.add(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                //设置导航栏颜色，因为使用了换肤框架，在换肤成功后不会自动刷新导航栏颜色，需要这里手动刷新
                if(activity!=null && activity instanceof BaseUiActivity){
                    BaseUiActivity baseUiActivity = (BaseUiActivity) activity;
                    baseUiActivity.updateAppSkin(new YeSkinItem());
                }
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {
                //Timber.w(activity + " - onActivityResumed");
            }

            @Override
            public void onActivityPaused(Activity activity) {
                //Timber.w(activity + " - onActivityPaused");
                //activity隐藏的时候，回收glide内存
            }

            @Override
            public void onActivityStopped(Activity activity) {
                //Timber.w(activity + " - onActivityStopped");
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                //Timber.w(activity + " - onActivitySaveInstanceState");
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                //Timber.w(activity + " - onActivityDestroyed");
            }
        });
    }

    @Override
    public void injectFragmentLifecycle(Context context, List<FragmentManager.FragmentLifecycleCallbacks> lifecycles) {
        lifecycles.add(new FragmentManager.FragmentLifecycleCallbacks() {

            @Override
            public void onFragmentCreated(FragmentManager fm, Fragment f, Bundle savedInstanceState) {
                // 在配置变化的时候将这个 Fragment 保存下来,在 Activity 由于配置变化重建是重复利用已经创建的Fragment。
                // https://developer.android.com/reference/android/app/Fragment.html?hl=zh-cn#setRetainInstance(boolean)
                // 在 Activity 中绑定少量的 Fragment 建议这样做,如果需要绑定较多的 Fragment 不建议设置此参数,如 ViewPager 需要展示较多 Fragment
                if(!(f instanceof YePageFragment)){
                    f.setRetainInstance(true);
                }

            }

            @Override
            public void onFragmentViewCreated(FragmentManager fm, Fragment f, View v, Bundle savedInstanceState) {

            }

            @Override
            public void onFragmentDestroyed(FragmentManager fm, Fragment f) {
            }
        });
    }

    private String convertStatusCode(HttpException httpException) {
        String msg;
        if (httpException.code() == 500) {
            msg = "服务器发生错误";
        } else if (httpException.code() == 404) {
            msg = "请求地址不存在";
        } else if (httpException.code() == 403) {
            msg = "请求被服务器拒绝";
        } else if (httpException.code() == 307) {
            msg = "请求被重定向到其他页面";
        } else {
            msg = httpException.message();
        }
        return msg;
    }
}
