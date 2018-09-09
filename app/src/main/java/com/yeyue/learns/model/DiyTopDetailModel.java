package com.yeyue.learns.model;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.yeyue.learns.contract.DiyTopDetailContract;
import com.yeyue.learns.enity.diycode.DiyTopContent;
import com.yeyue.learns.enity.diycode.DiyTopicReply;
import com.yeyue.learns.model.api.cache.CommonCache;
import com.yeyue.learns.model.api.service.DiyCodeService;
import com.yeyue.library.data.BaseItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;

@ActivityScope
public class DiyTopDetailModel extends BaseModel implements DiyTopDetailContract.Model {
    private Gson mGson;
    private Application mApplication;

    @Inject
    public DiyTopDetailModel(IRepositoryManager repositoryManager, Gson gson, Application application) {
        super(repositoryManager);
        this.mGson = gson;
        this.mApplication = application;
    }

    @Override
    public Observable<DiyTopContent> getTopicDetail(String id) {
        Observable<DiyTopContent> observable = mRepositoryManager.obtainRetrofitService(DiyCodeService.class)
                .getTopicDetail(id);
        return mRepositoryManager.obtainCacheService(CommonCache.class).getDiyTopContent(observable,new DynamicKey("getTopicDetail"+id),new EvictDynamicKey(false));
    }

    @Override
    public Observable<List<BaseItem>> getTopicRepliesList(int id,Integer offset,Integer limit) {
        Observable<List<BaseItem>> observable = mRepositoryManager.obtainRetrofitService(DiyCodeService.class)
                .getTopicRepliesList(id,offset,limit).flatMap(new Function<List<DiyTopicReply>,ObservableSource<List<BaseItem>>>() {
            @Override
            public ObservableSource<List<BaseItem>> apply(@NonNull List<DiyTopicReply> listReply) throws Exception {
                List<BaseItem> baseItems = new ArrayList<BaseItem>();
                //处理分类数据
                if(listReply!=null && listReply.size()>0){
                    baseItems.addAll(listReply);
                }
                return Observable.just(baseItems);
            }
        });
        return mRepositoryManager.obtainCacheService(CommonCache.class).getListDataCache(observable,new DynamicKey("getTopicRepliesList"+id+offset+limit),new EvictDynamicKey(false));
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

}