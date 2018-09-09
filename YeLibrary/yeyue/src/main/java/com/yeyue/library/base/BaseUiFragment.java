package com.yeyue.library.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jess.arms.base.BaseApplication;
import com.jess.arms.base.BaseFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.mvp.IPresenter;
import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;
import com.kingja.loadsir.core.Transport;
import com.yeyue.library.R;
import com.yeyue.library.constant.YeConstant;
import com.yeyue.library.contract.YeBaseUiFragmentView;

import java.lang.reflect.Field;

/**
 * Created by li.xiao on 2017-7-18.
 */

public abstract class BaseUiFragment<P extends IPresenter> extends BaseFragment<P> implements YeBaseUiFragmentView{
    public Toolbar mToolbar;
    protected LinearLayout mLlContent;
    protected View rootView;
    private LoadService loadService;
    protected BaseUiFragment baseuiFragment;
    private boolean isFirstResume = true;
    private boolean isFirstVisible = true;
    private boolean isFirstInvisible = true;
    protected boolean isPrepared = false;
    private boolean isViewCreated = false;
    private boolean isHiddenChanged = false;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baseuiFragment = this;
    }

    public int initView(Bundle savedInstanceState) {
        return R.layout.yeyue_common_ui_fragment;
    }
    @Override
    public int getContentViewId() {
        return R.layout.yeyue_common_recycleview;
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView =  inflater.inflate(initView(savedInstanceState), container, false);
        inflater.inflate(getContentViewId(), (LinearLayout) rootView.findViewById(R.id.ye_base_content), true);
        mToolbar = (Toolbar) rootView.findViewById(R.id.ye_toolbar);
        mLlContent = (LinearLayout) rootView.findViewById(R.id.ye_base_content);
        if(getBackgroundRes()!=0){
            mLlContent.setBackgroundResource(getBackgroundRes());
        }
        if(isToolbar()){
            mToolbar.setVisibility(View.VISIBLE);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onNavLeftClick();
                }
            });
        }else{
            mToolbar.setVisibility(View.GONE);
        }
        findView(rootView);
        if(getLoadView()!=null){
            loadService = LoadSir.getDefault().register(getLoadView(), new Callback.OnReloadListener() {
                @Override
                public void onReload(View v) {
                    onViewReload();
                }

            });
            showLoadSirView(YeConstant.LoadSir.LOADING);
        }
        isViewCreated = true;
        return  rootView;
    }

    @Override
    public int getBackgroundRes() {
        return 0;
    }
    @Override
    public void setAppContentBackground(int res) {
        if(mLlContent!=null && res!=0){
            mLlContent.setBackgroundResource(res);
        }
    }

    @Override
    public void setAppNavBackGround(int res) {
        if(mToolbar!=null && res!=0){
            mToolbar.setBackgroundResource(res);
        }
    }
    @Override
    public void setTitle(String title) {
        mToolbar.setTitle(title);
    }

    @Override
    public void onNavLeftClick() {

    }

    @Override
    public View getLoadView() {
        return mLlContent;
    }

    @Override
    public void onViewReload() {

    }

    @Override
    public void showLoadSirView(String status) {
        if(loadService!=null){
            if(YeConstant.LoadSir.SUCCESS.equals(status)){
                //加载完成
                loadService.showSuccess();
                return;
            }
            AppComponent appComponent = ((BaseApplication)getActivity().getApplication()).getAppComponent();
            if(appComponent.extras().containsKey(status) && appComponent.extras().get(status) instanceof Callback){
                Callback callback = (Callback) appComponent.extras().get(status);
                loadService.setCallBack(callback.getClass(), new Transport() {
                    @Override
                    public void order(Context context, View view) {
                        onShowTransport(context,view,status);
                    }
                });
                loadService.showCallback(callback.getClass());
            }
        }
    }
    /**
     * 自定义错误，加载，识别页面数据
     * @param context
     * @param view
     * @param status
     */
    @Override
    public void onShowTransport(Context context, View view, String status) {

    }

    //当没有使用ViewPage的时候，不会执行setUserVisibleHint方法，需要手动执行
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(!hidden && !isHiddenChanged){
            isHiddenChanged = true;
            initData();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        // for bug ---> java.lang.IllegalStateException: Activity has been destroyed
        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initPrepare();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isFirstResume) {
            isFirstResume = false;
            return;
        }
        if (getUserVisibleHint()) {
            onUserVisible();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (getUserVisibleHint()) {
            onUserInvisible();
        }
    }
    /***
     * 监听Fragment显示隐藏
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (isFirstVisible) {
                isFirstVisible = false;
                initPrepare();
            } else {
                onUserVisible();
            }
        } else {
            if (isFirstInvisible) {
                isFirstInvisible = false;
            } else {
                onUserInvisible();
            }
        }
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    private synchronized void initPrepare() {
        if (isPrepared) {
            initData();
        } else {
            isPrepared = true;
        }
    }
    /**
     * this method like the fragment's lifecycle method onResume()
     */
    protected  void onUserVisible(){
    }
    protected abstract void initData();

    protected void onUserInvisible(){

    }

    public void resume() {
        setUserVisibleHint(true);
    }

    public void pause() {
        setUserVisibleHint(false);
    }
}
