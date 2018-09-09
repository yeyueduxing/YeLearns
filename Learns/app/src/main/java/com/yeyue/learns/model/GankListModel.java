package com.yeyue.learns.model;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.yeyue.learns.constant.AdapterConstant;
import com.yeyue.learns.contract.GankListContract;
import com.yeyue.learns.enity.gank.GankData;
import com.yeyue.learns.enity.gank.GankHttpRequest;
import com.yeyue.learns.model.api.cache.CommonCache;
import com.yeyue.learns.model.api.service.GankService;
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
public class GankListModel extends BaseModel implements GankListContract.Model {
    private Gson mGson;
    private Application mApplication;

    @Inject
    public GankListModel(IRepositoryManager repositoryManager, Gson gson, Application application) {
        super(repositoryManager);
        this.mGson = gson;
        this.mApplication = application;
    }

    @Override
    public Observable<List<BaseItem>> getGankIoData(String type,int page,int pre_page) {
        Observable<List<BaseItem>> observable =  mRepositoryManager.obtainRetrofitService(GankService.class)
                .getGankIoData(type,page,pre_page).flatMap(new Function<GankHttpRequest<GankData>,ObservableSource<List<BaseItem>>>() {
                    @Override
                    public ObservableSource<List<BaseItem>> apply(@NonNull GankHttpRequest<GankData> listReply) throws Exception {
                        List<BaseItem> baseItems = new ArrayList<BaseItem>();
                        //处理分类数据
                        if(listReply!=null){
                            if(listReply.getResults()!=null && listReply.getResults().size()>0){
                                for (int i=0;i<listReply.getResults().size();i++){
                                    GankData gankData  = listReply.getResults().get(i);
                                    if(gankData!=null){
                                        if("福利".equals(gankData.getType())){
                                            //如果获取的是福利列表
                                            if("福利".equals(type)){
                                                gankData.setItemtype(AdapterConstant.ITEM_GANK_FULI_DEFAULT);
                                            }else{
                                                gankData.setItemtype(AdapterConstant.ITEM_GANK_DATA_FULI);
                                            }
                                        }
                                        baseItems.add(gankData);
                                    }
                                }
                            }
                        }
                        return Observable.just(baseItems);
                    }
                });
        return mRepositoryManager.obtainCacheService(CommonCache.class).getListDataCache(observable,new DynamicKey("getGankIoData"+type+page+pre_page),new EvictDynamicKey(false));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

}