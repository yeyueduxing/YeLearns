package com.yeyue.learns.model;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.yeyue.learns.constant.AdapterConstant;
import com.yeyue.learns.contract.BannerContract;
import com.yeyue.learns.enity.bizhi.BizhiBean;
import com.yeyue.learns.enity.bizhi.DayRecommend;
import com.yeyue.learns.enity.bizhi.HttpAlbum;
import com.yeyue.learns.enity.bizhi.WalRecommend;
import com.yeyue.learns.enity.gank.GankData;
import com.yeyue.learns.enity.gank.GankHttpRequest;
import com.yeyue.learns.enity.wan.WanArticle;
import com.yeyue.learns.enity.wan.WanBanner;
import com.yeyue.learns.enity.wan.WanDataResponse;
import com.yeyue.learns.model.api.cache.CommonCache;
import com.yeyue.learns.model.api.service.BizhiService;
import com.yeyue.learns.model.api.service.GankService;
import com.yeyue.learns.model.api.service.WanService;
import com.yeyue.library.data.BannerList;
import com.yeyue.library.data.BaseBanner;
import com.yeyue.library.data.BaseItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;

@ActivityScope
public class BannerModel extends BaseModel implements BannerContract.Model {
    private Gson mGson;
    private Application mApplication;

    @Inject
    public BannerModel(IRepositoryManager repositoryManager, Gson gson, Application application) {
        super(repositoryManager);
        this.mGson = gson;
        this.mApplication = application;
    }

    @Override
    public Observable<BannerList> getGankBanner(String type, int page, int pre_page, boolean pullToRefresh) {
        Observable<GankHttpRequest<GankData>> banner = Observable.just(new GankHttpRequest<GankData>());
        if(pullToRefresh){
            banner = mRepositoryManager.obtainRetrofitService(GankService.class)
                    .getGankIoRadom("福利",5);
        }
        Observable<GankHttpRequest<GankData>> datas = mRepositoryManager.obtainRetrofitService(GankService.class)
                .getGankIoData(type,page,pre_page);
        //合并网络请求
        Observable<BannerList> observable = Observable.zip(banner, datas, new BiFunction<GankHttpRequest<GankData>, GankHttpRequest<GankData>, BannerList>() {
            @Override
            public BannerList apply(GankHttpRequest<GankData> gankBanners, GankHttpRequest<GankData> gankDataGankHttpRequest2) throws Exception {
                BannerList bannerList = new BannerList();
                if(gankBanners!=null && gankBanners.getResults()!=null && gankBanners.getResults().size()>0){
                    List<BaseBanner> baseBanners = new ArrayList<>();
                    for (int i=0;i<gankBanners.getResults().size();i++){
                        GankData gankData = gankBanners.getResults().get(i);
                        BaseBanner baseBanner = new BaseBanner();
                        if(gankData==null){
                            continue;
                        }
                        baseBanner.setBaTitle(gankData.getDesc());
                        if("福利".equals(gankData.getType())){
                            baseBanner.setBaImg(gankData.getUrl());
                        }else if(gankData.getImages()!=null && gankData.getImages().size()>0){
                            baseBanner.setBaImg(gankData.getImages().get(0));
                        }
                        baseBanners.add(baseBanner);
                    }
                    bannerList.setBanners(baseBanners);
                }
                if(gankDataGankHttpRequest2!=null && gankDataGankHttpRequest2.getResults()!=null){
                    List<BaseItem> list = new ArrayList<>();
                    list.addAll(gankDataGankHttpRequest2.getResults());
                    bannerList.setData(list);
                }
                return bannerList;
            }
        });
        return observable;
    }


    @Override
    public Observable<BannerList> getBizhiAlbum(int limit,int start,String type) {
        Observable<BannerList> observable = mRepositoryManager.obtainRetrofitService(BizhiService.class)
                .getAlbum(limit,start,type).flatMap(new Function<HttpAlbum,ObservableSource<BannerList>>() {
                    @Override
                    public ObservableSource<BannerList> apply(@NonNull HttpAlbum listReply) throws Exception {
                        BannerList bannerList = new BannerList();
                        List<BaseItem> baseItems = new ArrayList<BaseItem>();
                        List<BaseBanner> banners = new ArrayList<BaseBanner>();
                        //处理分类数据
                        if(listReply!=null && listReply.getRes()!=null){
                            if(listReply.getRes().getBanner()!=null && listReply.getRes().getBanner().size()>0){
                                for(HttpAlbum.ResBean.BannerBean bannerBean:listReply.getRes().getBanner()){
                                    bannerBean.setBaTitle("");
                                    bannerBean.setBaImg(bannerBean.getThumb());
                                    banners.add(bannerBean);
                                }
                            }
                            if(listReply.getRes().getAlbum()!=null && listReply.getRes().getAlbum().size()>0){
                                baseItems.addAll(listReply.getRes().getAlbum());
                            }
                        }
                        if(start==0){
                            bannerList.setBanners(banners);
                        }
                        bannerList.setData(baseItems);
                        return Observable.just(bannerList);
                    }
                });
        return mRepositoryManager.obtainCacheService(CommonCache.class).getBannerList(observable,new DynamicKey("getAlbum"+limit+""+start+type),new EvictDynamicKey(false));
    }

    @Override
    public Observable<BannerList> getBizhiWalRecommend(int limit,int start) {
        Observable<WalRecommend> observable = mRepositoryManager.obtainCacheService(CommonCache.class).getWalRecommend(mRepositoryManager.obtainRetrofitService(BizhiService.class)
                .getWalRecommend(limit,start,1),new DynamicKey("getBizhiWalRecommend"+limit+""+start),new EvictDynamicKey(false));
        return observable .flatMap(new Function<WalRecommend,ObservableSource<BannerList>>() {
                    @Override
                    public ObservableSource<BannerList> apply(@NonNull WalRecommend listReply) throws Exception {
                        BannerList bannerList = new BannerList();
                        List<BaseItem> baseItems = new ArrayList<BaseItem>();
                        List<BaseBanner> banners = new ArrayList<BaseBanner>();
                        //处理分类数据
                        if(listReply!=null && listReply.getRes()!=null){
                            if(listReply.getRes().getBanner()!=null && listReply.getRes().getBanner().size()>0){
                                for(HttpAlbum.ResBean.BannerBean bannerBean:listReply.getRes().getBanner()){
                                    bannerBean.setBaTitle("");
                                    bannerBean.setBaImg(bannerBean.getThumb());
                                    banners.add(bannerBean);
                                }
                            }
                            if(listReply.getRes().getRecommend()!=null && listReply.getRes().getRecommend().size()>0){
                                //获取小编推荐
                                for (int i=0;i<listReply.getRes().getRecommend().size();i++){
                                    DayRecommend homepageBean = listReply.getRes().getRecommend().get(i);
                                    //添加每日精选头部视图
                                    homepageBean.setItemtype(AdapterConstant.ITEM_BIZHI_DAY_RECOMMEND);
                                    baseItems.add(homepageBean);
                                    if(homepageBean.getItems()!=null && homepageBean.getType()!=14){
                                        for (BizhiBean itemsBean:homepageBean.getItems()){
                                            itemsBean.setItemtype(AdapterConstant.ITEM_BIZHI_DEFAULT);
                                            baseItems.add(itemsBean);
                                        }
                                    }
                                }
                                //baseItems.addAll(listReply.getRes().getRecommend());
                            }
                        }
                        if(start==0){
                            bannerList.setBanners(banners);
                        }
                        bannerList.setData(baseItems);
                        return Observable.just(bannerList);
                    }
                });
    }


    @Override
    public Observable<BannerList> getWanBanner(int page) {
        Observable<WanDataResponse<WanArticle>> datas = mRepositoryManager.obtainRetrofitService(WanService.class)
                .getHomeArticles(page);
        Observable<WanDataResponse<List<WanBanner>>> banner = mRepositoryManager.obtainRetrofitService(WanService.class)
                .getHomeBanners();
        //合并网络请求
        Observable<BannerList> observable = Observable.zip(datas,banner, new BiFunction<WanDataResponse<WanArticle>, WanDataResponse<List<WanBanner>>, BannerList>() {
            @Override
            public BannerList apply(WanDataResponse<WanArticle> wanDatas, WanDataResponse<List<WanBanner>> gankBanners) throws Exception {
                BannerList bannerList = new BannerList();
                if(gankBanners!=null && gankBanners.getData()!=null && gankBanners.getData().size()>0){
                    List<BaseBanner> baseBanners = new ArrayList<>();
                    for (int i=0;i<gankBanners.getData().size();i++){
                        WanBanner gankData = gankBanners.getData().get(i);
                        BaseBanner baseBanner = new BaseBanner();
                        if(gankData==null){
                            continue;
                        }
                        baseBanner.setBaTitle(gankData.getTitle());
                        baseBanner.setBaImg(gankData.getImagePath());
                        baseBanner.setObject(gankData);
                        baseBanners.add(baseBanner);
                    }
                    bannerList.setBanners(baseBanners);
                }
                if(wanDatas!=null && wanDatas.getData()!=null && wanDatas.getData().getDatas()!=null){
                    List<BaseItem> list = new ArrayList<>();
                    list.addAll(wanDatas.getData().getDatas());
                    bannerList.setData(list);
                }
                return bannerList;
            }
        });
        return observable;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

}