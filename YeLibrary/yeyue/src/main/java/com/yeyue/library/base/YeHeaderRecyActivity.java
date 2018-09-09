package com.yeyue.library.base;


import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.mvp.IPresenter;
import com.yeyue.library.R;
import com.yeyue.library.utils.StatusBarCompat;

import skin.support.content.res.SkinCompatResources;

/**
 * @author li.xiao
 * @describe 列表刷新
 * @time 2017-7-12 15:35
 */
public abstract class YeHeaderRecyActivity<T, P extends IPresenter> extends YeRecyActivity<T, P> {
    private FrameLayout mRecycleHeader;
    private AppBarLayout mActionBar;
    private TextView mYeToolbarTitle;
    private Toolbar yeHeaderToolbar;
    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
    }

    @Override
    public int getContentViewId() {
        return R.layout.yeyue_common_recycleview_header;
    }

    @Override
    public void findView() {
        super.findView();
        mRecyclerView.setNestedScrollingEnabled(false);
        mActionBar = (AppBarLayout) findViewById(R.id.ye_appbar);
        mYeToolbarTitle = (TextView) findViewById(R.id.ye_toolbar_title);
        yeHeaderToolbar= (Toolbar) findViewById(R.id.yeHeaderToolbar);
        yeHeaderToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                killMyself();
            }
        });
        mActionBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayouts, int verticalOffset) {
                if (verticalOffset == 0 && enableRefresh()) {
                    //设置状态为可下拉
                    mSwipeRefreshLayout.setEnabled(true);
                } else {
                    mSwipeRefreshLayout.setEnabled(false);
                }
                float alpha = Math.abs(verticalOffset * 1.0f) / appBarLayouts.getTotalScrollRange();
                yeHeaderToolbar.setAlpha(alpha);
                mRecycleHeader.setAlpha(1-alpha);
            }
        });
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
            mRecycleHeader.addView(LayoutInflater.from(getActivity()).inflate(setHeaderId(), null, false));
        }
    }

    public int setHeaderId() {
        return 0;
    }
    @Override
    public boolean isStatusBar() {
        return false;
    }
    @Override
    public boolean isToolbar() {
        return false;
    }
}
