package com.yeyue.library.base;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.StringUtils;
import com.yeyue.library.R;
import com.yeyue.library.adapter.YeSearchHistoryAdapter;
import com.yeyue.library.presenter.YeSearchIPresenter;
import com.yeyue.library.utils.StatusBarCompat;
import com.yeyue.library.widgets.flowlayout.TagFlowLayout;

import java.util.List;

/**
 * @author li.xiao
 * @describe 通用搜索界面
 * 可以展示搜索历史
 * 可以设置实时搜索（使用rxView延时搜索）
 * @time 2017-9-6 9:23
 */
public abstract class YeSearchActivity<T, P extends YeSearchIPresenter> extends YeRecyActivity<T, P>  {
    private EditText edtContent;
    private TextView tvTosearch;

    private LinearLayout llSearchHistory;
    private TextView tvSearchHistoryClean;
    private TagFlowLayout tflSearchHistory;
    private YeSearchHistoryAdapter searchHistoryAdapter;
    private Animation animHistory;
    private Animator animHistory5;


    protected String searchWord;//搜索框的文字
    protected String searchHintWord;//搜索提示问题

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.yeyue_common_search_head;
    }

    @Override
    public int getContentViewId() {
        return R.layout.yeyue_common_search;
    }

    @Override
    public boolean isToolbar() {
        return true;
    }

    @Override
    public void findView() {
        super.findView();
        edtContent = (EditText) findViewById(R.id.edt_content);
        tvTosearch = (TextView) findViewById(R.id.tv_tosearch);
        llSearchHistory = (LinearLayout) findViewById(R.id.ll_search_history);
        tvSearchHistoryClean = (TextView) findViewById(R.id.tv_search_history_clean);
        tflSearchHistory = (TagFlowLayout) findViewById(R.id.tfl_search_history);
        searchHistoryAdapter = new YeSearchHistoryAdapter();
        tflSearchHistory.setAdapter(searchHistoryAdapter);
        bindEvent();
        if(!StringUtils.isEmpty(searchHintWord)){
            edtContent.setHint(searchHintWord);
        }
    }

    @Override
    public boolean enableRefresh() {
        return false;
    }

    @Override
    public boolean enableMore() {
        return true;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        //获取搜索历史
        mPresenter.querySearchHistory();
    }

    protected void bindEvent() {

        tvSearchHistoryClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //清空
                mPresenter.cleanSearchHistory();
            }
        });
        edtContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                edtContent.setSelection(edtContent.length());
                checkTvToSearch();
                //获取搜索历史
                mPresenter.querySearchHistory();
            }
        });
        edtContent.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH || (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                    toSearch();
                    return true;
                } else
                    return false;
            }
        });
        tvTosearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mPresenter.getInput()) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        finishAfterTransition();
                    } else {
                        finish();
                    }
                } else {
                    //搜索
                    toSearch();
                }
            }
        });

        searchHistoryAdapter.setOnItemClickListener(new YeSearchHistoryAdapter.OnItemClickListener() {
            @Override
            public void itemClick(String searchHistoryBean) {
                edtContent.setText(searchHistoryBean);
                toSearch();
            }
        });

        bindKeyBoardEvent();

    }

    //开始搜索
    private void toSearch() {
        if (edtContent.getText().toString().trim().length() > 0) {
            final String key = edtContent.getText().toString().trim();
            searchWord = key;
            mPresenter.setHasSearch(true);
            closeKeyBoard();
            //执行搜索请求
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mPresenter.initPage();
                    mPresenter.toSearchBooks(key,true);
                    //开始刷新
                    //TODO
                }
            }, 300);
        } else {
            //YoYo.with(Techniques.Shake).playOn(flSearchContent);
            //TODO
        }
    }

    private void bindKeyBoardEvent() {
        llSearchHistory.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Rect r = new Rect();
                llSearchHistory.getWindowVisibleDisplayFrame(r);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) llSearchHistory.getLayoutParams();

                int height = llSearchHistory.getContext().getResources().getDisplayMetrics().heightPixels;
                int diff = height - r.bottom;
                if (diff != 0 && Math.abs(diff) != StatusBarCompat.getStatusBarHeight(getActivity())) {
                    if (layoutParams.bottomMargin != diff) {
                        layoutParams.setMargins(0, 0, 0, Math.abs(diff));
                        llSearchHistory.setLayoutParams(layoutParams);
                        //打开输入
                        if (llSearchHistory.getVisibility() != View.VISIBLE)
                            openOrCloseHistory(true);
                    }
                } else {
                    if (layoutParams.bottomMargin != 0) {
                        if (!mPresenter.getHasSearch()) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                finishAfterTransition();
                            } else {
                                finish();
                            }
                        } else {
                            layoutParams.setMargins(0, 0, 0, 0);
                            llSearchHistory.setLayoutParams(layoutParams);
                            //关闭输入
                            if (llSearchHistory.getVisibility() == View.VISIBLE)
                                openOrCloseHistory(false);
                        }
                    }
                }
            }
        });

        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        openKeyBoard();
                    }
                }, 100);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else
                    getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    private void checkTvToSearch() {
        if (llSearchHistory.getVisibility() == View.VISIBLE) {
            tvTosearch.setText("搜索");
            mPresenter.setInput(true);
        } else {
            tvTosearch.setText("返回");
            mPresenter.setInput(false);
        }
    }

    private void openOrCloseHistory(Boolean open) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (null != animHistory5) {
                animHistory5.cancel();
            }
            if (open) {
                animHistory5 = ViewAnimationUtils.createCircularReveal(
                        llSearchHistory,
                        0, 0, 0,
                        (float) Math.hypot(llSearchHistory.getWidth(), llSearchHistory.getHeight()));
                animHistory5.setInterpolator(new AccelerateDecelerateInterpolator());
                animHistory5.setDuration(700);
                animHistory5.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        llSearchHistory.setVisibility(View.VISIBLE);
                        edtContent.setCursorVisible(true);
                        checkTvToSearch();
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        if (mSwipeRefreshLayout.getVisibility() != View.VISIBLE)
                            mSwipeRefreshLayout.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                animHistory5.start();
            } else {
                animHistory5 = ViewAnimationUtils.createCircularReveal(
                        llSearchHistory,
                        0, 0, (float) Math.hypot(llSearchHistory.getHeight(), llSearchHistory.getHeight()),
                        0);
                animHistory5.setInterpolator(new AccelerateDecelerateInterpolator());
                animHistory5.setDuration(300);
                animHistory5.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        llSearchHistory.setVisibility(View.GONE);
                        edtContent.setCursorVisible(false);
                        checkTvToSearch();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                animHistory5.start();
            }
        } else {
            if (null != animHistory) {
                animHistory.cancel();
            }
            if (open) {
                animHistory = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
                animHistory.setInterpolator(new AccelerateDecelerateInterpolator());
                animHistory.setDuration(700);
                animHistory.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        llSearchHistory.setVisibility(View.VISIBLE);
                        edtContent.setCursorVisible(true);
                        checkTvToSearch();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        if (mSwipeRefreshLayout.getVisibility() != View.VISIBLE)
                            mSwipeRefreshLayout.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                llSearchHistory.startAnimation(animHistory);
            } else {
                animHistory = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
                animHistory.setInterpolator(new AccelerateDecelerateInterpolator());
                animHistory.setDuration(300);
                animHistory.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        llSearchHistory.setVisibility(View.GONE);
                        edtContent.setCursorVisible(false);
                        checkTvToSearch();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                llSearchHistory.startAnimation(animHistory);
            }
        }
    }

    private void closeKeyBoard() {
        InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edtContent.getWindowToken(), 0);
    }

    private void openKeyBoard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        edtContent.requestFocus();
        imm.showSoftInput(edtContent, InputMethodManager.RESULT_UNCHANGED_SHOWN);
    }

    public void insertSearchHistorySuccess(String searchHistoryBean) {
        //搜索历史插入或者修改成功
         mPresenter.querySearchHistory();
    }

    public void querySearchHistorySuccess(List<String> datas) {
        searchHistoryAdapter.replaceAll(datas);
        if (searchHistoryAdapter.getDataSize() > 0) {
            tvSearchHistoryClean.setVisibility(View.VISIBLE);
        } else {
            tvSearchHistoryClean.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
