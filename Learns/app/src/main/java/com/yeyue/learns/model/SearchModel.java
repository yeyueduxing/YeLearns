package com.yeyue.learns.model;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.yeyue.learns.contract.SearchContract;
import com.yeyue.library.data.BaseItem;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

@ActivityScope
public class SearchModel extends BaseModel implements SearchContract.Model {
    private Gson mGson;
    private Application mApplication;

    @Inject
    public SearchModel(IRepositoryManager repositoryManager, Gson gson, Application application) {
        super(repositoryManager);
        this.mGson = gson;
        this.mApplication = application;
    }

    @Override
    public Observable<List<BaseItem>> getSearch() {
        /*Observable<List<BaseItem>> datas = mRepositoryManager.obtainRetrofitService(UserService.class)
                .getSearch();*/
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

}