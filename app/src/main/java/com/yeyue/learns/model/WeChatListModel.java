package com.yeyue.learns.model;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.yeyue.learns.constant.Constant;
import com.yeyue.learns.contract.WeChatListContract;
import com.yeyue.learns.enity.wechat.WeChatHttpRequest;
import com.yeyue.learns.enity.wechat.WeChatTag;
import com.yeyue.learns.model.api.cache.CommonCache;
import com.yeyue.learns.model.api.service.WeChatService;
import com.yeyue.learns.utils.WeChatUtils;
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
public class WeChatListModel extends BaseModel implements WeChatListContract.Model {
    private Gson mGson;
    private Application mApplication;

    @Inject
    public WeChatListModel(IRepositoryManager repositoryManager, Gson gson, Application application) {
        super(repositoryManager);
        this.mGson = gson;
        this.mApplication = application;
    }
    @Override
    public Observable<List<BaseItem>> getWXTagList(int type) {
        List<BaseItem> baseItems = new ArrayList<>();
        List<WeChatTag> tags = WeChatUtils.getWeChatTags();
        if(type== Constant.WECHAT_LIVE_TAG){
            tags = WeChatUtils.getWeChatLifeTags("");
        }
        baseItems.addAll(tags);
        return Observable.just(baseItems);
    }

    @Override
    public Observable<List<BaseItem>> getWXNew(String type,String key, int num, int page, String word) {
        Observable<List<BaseItem>> observable = mRepositoryManager.obtainRetrofitService(WeChatService.class)
                .getWXNew(type,key,num,page,word).flatMap(new Function<WeChatHttpRequest,ObservableSource<List<BaseItem>>>() {
                    @Override
                    public ObservableSource<List<BaseItem>> apply(@NonNull WeChatHttpRequest listReply) throws Exception {
                        List<BaseItem> baseItems = new ArrayList<BaseItem>();
                        //处理分类数据
                        if(listReply!=null){
                            if(listReply.getNewslist()!=null && listReply.getNewslist().size()>0){
                                baseItems.addAll(listReply.getNewslist());
                            }
                        }
                        return Observable.just(baseItems);
                    }
                });
        return mRepositoryManager.obtainCacheService(CommonCache.class).getListDataCache(observable,new DynamicKey("getWXNew"+type+key+num+page+word),new EvictDynamicKey(false));
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

}