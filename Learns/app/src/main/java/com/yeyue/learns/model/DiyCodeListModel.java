package com.yeyue.learns.model;

import android.app.Application;
import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.yeyue.learns.contract.DiyCodeListContract;
import com.yeyue.learns.enity.diycode.DiyNew;
import com.yeyue.learns.enity.diycode.DiySiteList;
import com.yeyue.learns.enity.diycode.DiyTopic;
import com.yeyue.learns.enity.diycode.DiyUser;
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
public class DiyCodeListModel extends BaseModel implements DiyCodeListContract.Model {
    private Gson mGson;
    private Application mApplication;

    @Inject
    public DiyCodeListModel(IRepositoryManager repositoryManager, Gson gson, Application application) {
        super(repositoryManager);
        this.mGson = gson;
        this.mApplication = application;
    }

    @Override
    public Observable<List<BaseItem>> getTopicsList(String type, @Nullable Integer node_id, @Nullable Integer offset, @Nullable Integer limit) {
        Observable<List<BaseItem>> observable = mRepositoryManager.obtainRetrofitService(DiyCodeService.class)
                .getTopicsList(type,node_id,offset,limit).flatMap(new Function<List<DiyTopic>,ObservableSource<List<BaseItem>>>() {
                    @Override
                    public ObservableSource<List<BaseItem>> apply(@NonNull List<DiyTopic> listReply) throws Exception {
                        List<BaseItem> baseItems = new ArrayList<BaseItem>();
                        //处理分类数据
                        if(listReply!=null && listReply.size()>0){
                            baseItems.addAll(listReply);
                        }
                        return Observable.just(baseItems);
                    }
                });
        return mRepositoryManager.obtainCacheService(CommonCache.class).getListDataCache(observable,new DynamicKey("getTopicsList"+type+node_id+offset+limit),new EvictDynamicKey(false));
    }

    @Override
    public Observable<List<BaseItem>> getNewsList(@Nullable Integer node_id, @Nullable Integer offset, @Nullable Integer limit) {
        Observable<List<BaseItem>> observable = mRepositoryManager.obtainRetrofitService(DiyCodeService.class)
                .getNewsList(node_id,offset,limit).flatMap(new Function<List<DiyNew>,ObservableSource<List<BaseItem>>>() {
                    @Override
                    public ObservableSource<List<BaseItem>> apply(@NonNull List<DiyNew> listReply) throws Exception {
                        List<BaseItem> baseItems = new ArrayList<BaseItem>();
                        //处理分类数据
                        if(listReply!=null && listReply.size()>0){
                            baseItems.addAll(listReply);
                        }
                        return Observable.just(baseItems);
                    }
                });
        return mRepositoryManager.obtainCacheService(CommonCache.class).getListDataCache(observable,new DynamicKey("getNewsList"+node_id+offset+limit),new EvictDynamicKey(false));
    }

    @Override
    public Observable<List<BaseItem>> getSites() {
        return mRepositoryManager.obtainRetrofitService(DiyCodeService.class)
                .getSites().flatMap(new Function<List<DiySiteList>,ObservableSource<List<BaseItem>>>() {
                    @Override
                    public ObservableSource<List<BaseItem>> apply(@NonNull List<DiySiteList> listReply) throws Exception {
                        List<BaseItem> baseItems = new ArrayList<BaseItem>();
                        //处理分类数据
                        if(listReply!=null && listReply.size()>0){
                            for (int i=0;i<listReply.size();i++){
                                baseItems.add(listReply.get(i));
                                baseItems.addAll(baseItems.size(),listReply.get(i).getSites());
                            }
                        }
                        return Observable.just(baseItems);
                    }
                });
        //return mRepositoryManager.obtainCacheService(CommonCache.class).getListDataCache(observable,new DynamicKey("getSites"),new EvictDynamicKey(true));
    }

    @Override
    public Observable<List<BaseItem>> getUserCreateTopicList(String login_name, String order,Integer offset,Integer limit) {
        Observable<List<BaseItem>> observable = mRepositoryManager.obtainRetrofitService(DiyCodeService.class)
                .getUserCreateTopicList(login_name,order,offset,limit).flatMap(new Function<List<DiyTopic>,ObservableSource<List<BaseItem>>>() {
                    @Override
                    public ObservableSource<List<BaseItem>> apply(@NonNull List<DiyTopic> listReply) throws Exception {
                        List<BaseItem> baseItems = new ArrayList<BaseItem>();
                        //处理分类数据
                        if(listReply!=null && listReply.size()>0){
                            baseItems.addAll(listReply);
                        }
                        return Observable.just(baseItems);
                    }
                });
        return mRepositoryManager.obtainCacheService(CommonCache.class).getListDataCache(observable,new DynamicKey("getUserCreateTopicList"+login_name+order+offset+limit),new EvictDynamicKey(false));
    }

    @Override
    public Observable<List<BaseItem>> getUserCollectionTopicList(String login_name, Integer offset,Integer limit) {
        Observable<List<BaseItem>> observable = mRepositoryManager.obtainRetrofitService(DiyCodeService.class)
                .getUserCollectionTopicList(login_name,offset,limit).flatMap(new Function<List<DiyTopic>,ObservableSource<List<BaseItem>>>() {
                    @Override
                    public ObservableSource<List<BaseItem>> apply(@NonNull List<DiyTopic> listReply) throws Exception {
                        List<BaseItem> baseItems = new ArrayList<BaseItem>();
                        //处理分类数据
                        if(listReply!=null && listReply.size()>0){
                            baseItems.addAll(listReply);
                        }
                        return Observable.just(baseItems);
                    }
                });
        return mRepositoryManager.obtainCacheService(CommonCache.class).getListDataCache(observable,new DynamicKey("getUserCollectionTopicList"+login_name+offset+limit),new EvictDynamicKey(false));
    }
    @Override
    public Observable<List<BaseItem>> getUserReplyTopicList(String login_name,  String order,Integer offset,Integer limit) {
        Observable<List<BaseItem>> observable = mRepositoryManager.obtainRetrofitService(DiyCodeService.class)
                .getUserReplyTopicList(login_name,order,offset,limit).flatMap(new Function<List<DiyTopic>,ObservableSource<List<BaseItem>>>() {
                    @Override
                    public ObservableSource<List<BaseItem>> apply(@NonNull List<DiyTopic> listReply) throws Exception {
                        List<BaseItem> baseItems = new ArrayList<BaseItem>();
                        //处理分类数据
                        if(listReply!=null && listReply.size()>0){
                            baseItems.addAll(listReply);
                        }
                        return Observable.just(baseItems);
                    }
                });
        return mRepositoryManager.obtainCacheService(CommonCache.class).getListDataCache(observable,new DynamicKey("getUserReplyTopicList"+login_name+order+offset+limit),new EvictDynamicKey(false));
    }

    @Override
    public Observable<List<BaseItem>> getUserFollowerList(String login_name, Integer offset,Integer limit) {
        Observable<List<BaseItem>> observable = mRepositoryManager.obtainRetrofitService(DiyCodeService.class)
                .getUserFollowerList(login_name,offset,limit).flatMap(new Function<List<DiyUser>,ObservableSource<List<BaseItem>>>() {
                    @Override
                    public ObservableSource<List<BaseItem>> apply(@NonNull List<DiyUser> listReply) throws Exception {
                        List<BaseItem> baseItems = new ArrayList<BaseItem>();
                        //处理分类数据
                        if(listReply!=null && listReply.size()>0){
                            baseItems.addAll(listReply);
                        }
                        return Observable.just(baseItems);
                    }
                });
        return mRepositoryManager.obtainCacheService(CommonCache.class).getListDataCache(observable,new DynamicKey("getUserFollowerList"+login_name+offset+limit),new EvictDynamicKey(false));
    }

    @Override
    public Observable<List<BaseItem>> getUserFollowingList(String login_name, Integer offset,Integer limit) {
        Observable<List<BaseItem>> observable = mRepositoryManager.obtainRetrofitService(DiyCodeService.class)
                .getUserFollowingList(login_name,offset,limit).flatMap(new Function<List<DiyUser>,ObservableSource<List<BaseItem>>>() {
                    @Override
                    public ObservableSource<List<BaseItem>> apply(@NonNull List<DiyUser> listReply) throws Exception {
                        List<BaseItem> baseItems = new ArrayList<BaseItem>();
                        //处理分类数据
                        if(listReply!=null && listReply.size()>0){
                            baseItems.addAll(listReply);
                        }
                        return Observable.just(baseItems);
                    }
                });
        return mRepositoryManager.obtainCacheService(CommonCache.class).getListDataCache(observable,new DynamicKey("getUserFollowingList"+login_name+offset+limit),new EvictDynamicKey(false));
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

}