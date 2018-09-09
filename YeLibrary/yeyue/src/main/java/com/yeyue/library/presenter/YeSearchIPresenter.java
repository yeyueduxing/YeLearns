package com.yeyue.library.presenter;

import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.mvp.IModel;
import com.yeyue.library.contract.YeSearchView;
import com.yeyue.library.utils.SPArrayUtils;

import java.util.List;


/**
 * 为了减少第三方的引入，搜索历史的保存使用Sp来保存
  *@describe 搜索实现
  *@author li.xiao
  *@time 2017-9-6 17:10
  */
public class YeSearchIPresenter<M extends IModel, V extends YeSearchView> extends BasePresenter<M, V> {

    protected String SP_NAME = "YeSearch";
    protected String SP_KEY = "search_history";
    private Boolean isInput = false;
    private Boolean hasSearch = false;   //判断是否搜索过
    private int page = 1;

    public YeSearchIPresenter(M model, V rootView) {
        super(model, rootView);
        onStart();
    }

    public Boolean getHasSearch() {
        return hasSearch;
    }

    public void setHasSearch(Boolean hasSearch) {
        this.hasSearch = hasSearch;
    }

    public void insertSearchHistory() {

    }

    public void cleanSearchHistory() {
        SPArrayUtils.cleanKey(SP_NAME,SP_KEY);
        List<String> historys = SPArrayUtils.getKeyValues(SP_NAME,SP_KEY);
        mRootView.querySearchHistorySuccess(historys);
    }

    /**
     * 获取搜索历史
     */
    public void querySearchHistory() {
        List<String> historys = SPArrayUtils.getKeyValues(SP_NAME,SP_KEY);
        mRootView.querySearchHistorySuccess(historys);
    }

    public int getPage() {
        return page;
    }

    public void initPage() {
        this.page = 1;
    }

    public void toSearchBooks(String key,boolean refresh) {
        SPArrayUtils.updateKey(key,SP_NAME,SP_KEY);
        List<String> historys = SPArrayUtils.getKeyValues(SP_NAME,SP_KEY);
        mRootView.querySearchHistorySuccess(historys);
        if(refresh){
            mRootView.refreshSearch(key);
        }
    }

    public Boolean getInput() {
        return isInput;
    }

    public void setInput(Boolean input) {
        isInput = input;
    }

}
