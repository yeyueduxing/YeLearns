package com.yeyue.learns.model;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.yeyue.learns.contract.WanListContract;
import com.yeyue.library.data.BaseItem;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

@ActivityScope
public class WanListModel extends BaseModel implements WanListContract.Model {
    private Gson mGson;
    private Application mApplication;

    @Inject
    public WanListModel(IRepositoryManager repositoryManager, Gson gson, Application application) {
        super(repositoryManager);
        this.mGson = gson;
        this.mApplication = application;
    }

    @Override
    public Observable<List<BaseItem>> getData() {
        return null;
       /* Observable<List<Calendar>> observable = mRepositoryManager.obtainRetrofitService(GankService.class)
                .getData().flatMap(new Function<List<BaseItem>, ObservableSource<List<BaseItem>>>() {
                    @Override
                    public ObservableSource<List<BaseItem>> apply(@NonNull List<BaseItem> listReply) throws Exception {
                        List<BaseItem> baseItems = new ArrayList<BaseItem>();
                        if (listReply != null && listReply.getResults() != null && listReply.getResults().size() > 0) {
                            baseItems.addAll(listReply);
                        }
                        return Observable.just(baseItems);
                    }
                });
        return mRepositoryManager.obtainCacheService(CommonCache.class).getListDataCache(observable, new DynamicKey("getData"), new EvictDynamicKey(true));
    */
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

}