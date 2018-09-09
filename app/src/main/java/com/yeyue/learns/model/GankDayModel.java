package com.yeyue.learns.model;

import android.app.Application;

import com.google.gson.Gson;
import com.haibin.calendarview.Calendar;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.yeyue.learns.contract.GankDayContract;
import com.yeyue.learns.enity.gank.GankHistory;
import com.yeyue.learns.enity.gank.GankHttpDay;
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
public class GankDayModel extends BaseModel implements GankDayContract.Model {
    private Gson mGson;
    private Application mApplication;

    @Inject
    public GankDayModel(IRepositoryManager repositoryManager, Gson gson, Application application) {
        super(repositoryManager);
        this.mGson = gson;
        this.mApplication = application;
    }

    @Override
    public Observable<List<BaseItem>> getGankIoDay(int year,int month,int day) {
        Observable<List<BaseItem>> observable = mRepositoryManager.obtainRetrofitService(GankService.class)
                .getGankIoDay(year,month,day).flatMap(new Function<GankHttpDay,ObservableSource<List<BaseItem>>>() {
                    @Override
                    public ObservableSource<List<BaseItem>> apply(@NonNull GankHttpDay listReply) throws Exception {
                        List<BaseItem> baseItems = new ArrayList<BaseItem>();
                        //处理分类数据
                        if(listReply!=null && listReply.getResults()!=null){
                            if(listReply.getResults().getAndroid()!=null && listReply.getResults().getAndroid().size()>0) {
                                baseItems.addAll(baseItems.size(),listReply.getResults().getAndroid());
                            }
                            if(listReply.getResults().getiOS()!=null && listReply.getResults().getiOS().size()>0) {
                                baseItems.addAll(baseItems.size(),listReply.getResults().getiOS());
                            }
                            if(listReply.getResults().get休息视频()!=null && listReply.getResults().get休息视频().size()>0) {
                                baseItems.addAll(baseItems.size(),listReply.getResults().get休息视频());
                            }
                            if(listReply.getResults().get拓展资源()!=null && listReply.getResults().get拓展资源().size()>0) {
                                baseItems.addAll(baseItems.size(),listReply.getResults().get拓展资源());
                            }
                            if(listReply.getResults().get瞎推荐()!=null && listReply.getResults().get瞎推荐().size()>0) {
                                baseItems.addAll(baseItems.size(),listReply.getResults().get瞎推荐());
                            }
                            if(listReply.getResults().get福利()!=null && listReply.getResults().get福利().size()>0) {
                                baseItems.addAll(baseItems.size(),listReply.getResults().get福利());
                            }
                        }
                        return Observable.just(baseItems);
                    }
                });
        return mRepositoryManager.obtainCacheService(CommonCache.class).getListDataCache(observable,new DynamicKey("getGankIoDay"+year+month+day),new EvictDynamicKey(false));
    }

    @Override
    public Observable<List<Calendar>> getGankIoHistory() {
        Observable<List<Calendar>> observable = mRepositoryManager.obtainRetrofitService(GankService.class)
                .getGankIoHistory().flatMap(new Function<GankHistory,ObservableSource<List<Calendar>>>() {
                    @Override
                    public ObservableSource<List<Calendar>> apply(@NonNull GankHistory listReply) throws Exception {
                        List<Calendar> baseItems = new ArrayList<Calendar>();
                        if(listReply!=null && listReply.getResults()!=null && listReply.getResults().size()>0){
                            for (String history:listReply.getResults()){
                                try{
                                    String[] item = history.split("-");
                                    Calendar calendar = new Calendar();
                                    calendar.setYear(Integer.parseInt(item[0]));
                                    calendar.setMonth(Integer.parseInt(item[1]));
                                    calendar.setDay(Integer.parseInt(item[2]));
                                    calendar.setSchemeColor(0xFF40db25);//如果单独标记颜色、则会使用这个颜色
                                    calendar.setScheme("数");
                                    baseItems.add(calendar);
                                }catch (Exception e){

                                }
                            }
                        }
                        return Observable.just(baseItems);
                    }
                });
        return mRepositoryManager.obtainCacheService(CommonCache.class).getCalendarDataCache(observable,new DynamicKey("getGankIoHistory"),new EvictDynamicKey(false));
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

}