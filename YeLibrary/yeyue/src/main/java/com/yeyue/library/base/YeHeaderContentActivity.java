package com.yeyue.library.base;


import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ScreenUtils;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.mvp.IPresenter;
import com.yeyue.library.R;
import com.yeyue.library.utils.StatusBarCompat;

import skin.support.content.res.SkinCompatResources;

/**
  *@describe 普通头部页面
  *@author li.xiao
  *@time 2017-9-5 9:49
  */
public abstract class YeHeaderContentActivity<P extends IPresenter> extends BaseUiActivity< P> {
    private FrameLayout mRecycleHeader;
    private FrameLayout mHeaderContent;
    private AppBarLayout mActionBar;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private CollapsingToolbarLayout yeCollapsingToolbarLayout;
    private TextView mYeToolbarTitle;
    private Toolbar yeHeaderToolbar;
    private boolean isSetBackGround;
    private boolean hasWindowFocus;
    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
    }

    @Override
    public int getContentViewId() {
        return R.layout.yeyue_common_content_header;
    }

    @Override
    public void findView() {
        super.findView();
        mActionBar = (AppBarLayout) findViewById(R.id.ye_appbar);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeLayout);
        mYeToolbarTitle = (TextView) findViewById(R.id.ye_toolbar_title);
        yeCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.yeCollapsingToolbarLayout);
        yeHeaderToolbar= (Toolbar) findViewById(R.id.yeHeaderToolbar);

        yeHeaderToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mActionBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayouts, int verticalOffset) {
                float alpha = Math.abs(verticalOffset * 1.0f) / appBarLayouts.getTotalScrollRange();
                yeHeaderToolbar.setAlpha(alpha);
                mRecycleHeader.setAlpha(1-alpha);
            }
        });
        mSwipeRefreshLayout.setEnabled(false);
        //StatusBarUtil.setTranslucent(this);
        StatusBarCompat.translucentStatusBar(this);
        int barHeight = StatusBarCompat.getStatusBarHeight(this);
        if(barHeight>0){
            CollapsingToolbarLayout.LayoutParams toolHeaderParams = (CollapsingToolbarLayout.LayoutParams) yeHeaderToolbar.getLayoutParams();
            toolHeaderParams.height = toolHeaderParams.height+barHeight;
            yeHeaderToolbar.setLayoutParams(toolHeaderParams);
            yeHeaderToolbar.setPadding(0,barHeight,0,0);
        }
        //当需要显示顶部导航栏的时候，设置状态栏颜色
        int color = SkinCompatResources.getInstance().getColor(R.color.ye_color_Navigation_Base);
        yeHeaderToolbar.setBackgroundColor(color);
    }

    @Override
    public void setTitle(String title) {
        super.setTitle("");
        yeHeaderToolbar.setTitle(title);
    }

    @Override
    public void initView(View mRootView) {
        super.initView(mRootView);
        mRecycleHeader = (FrameLayout) findViewById(R.id.ye_recycle_header);
        if (setHeaderId() != 0) {
            mRecycleHeader.addView(LayoutInflater.from(getActivity()).inflate(setHeaderId(), mRecycleHeader, false));
        }
        mHeaderContent = (FrameLayout) findViewById(R.id.ye_header_content);
        if (setContentId() != 0) {
            mHeaderContent.addView(LayoutInflater.from(getActivity()).inflate(setContentId(), mHeaderContent, false));
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus && !hasWindowFocus && mHeaderContent!=null && mHeaderContent.getChildAt(0)!=null && yeHeaderToolbar!=null){
            hasWindowFocus = true;
            int scHeight = ScreenUtils.getScreenHeight()-yeHeaderToolbar.getHeight();
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, scHeight);
            mHeaderContent.getChildAt(0).setLayoutParams(params);
        }
    }

    //设置头部视图
    public abstract int setHeaderId();
    //设置内容视图
    public abstract int setContentId();

    @Override
    public boolean isToolbar() {
        return false;
    }

    @Override
    public boolean isStatusBar() {
        return false;
    }

    @Override
    public View getLoadView() {
        return null;
    }
}
