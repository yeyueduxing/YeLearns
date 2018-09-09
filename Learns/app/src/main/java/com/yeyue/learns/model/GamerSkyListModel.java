package com.yeyue.learns.model;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.yeyue.learns.contract.GamerSkyListContract;
import com.yeyue.learns.enity.gamersky.GameSkyParam;
import com.yeyue.learns.enity.gamersky.GamerSkyBanner;
import com.yeyue.learns.enity.gamersky.GamerSkyBean;
import com.yeyue.learns.enity.gamersky.GamerSkyHttpRequest;
import com.yeyue.learns.model.api.cache.CommonCache;
import com.yeyue.learns.model.api.service.GamerSkyService;
import com.yeyue.library.data.BannerList;
import com.yeyue.library.data.BaseBanner;
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
public class GamerSkyListModel extends BaseModel implements GamerSkyListContract.Model {
    private Gson mGson;
    private Application mApplication;

    @Inject
    public GamerSkyListModel(IRepositoryManager repositoryManager, Gson gson,
            Application application) {
        super(repositoryManager);
        this.mGson = gson;
        this.mApplication = application;
    }

    @Override
    public Observable<BannerList> getLabelJsonpAjax(String type, String nodeId, String parentNodeId, int page, int limit) {
        GameSkyParam param = new GameSkyParam();
        GameSkyParam.SkyPost post = new GameSkyParam.SkyPost();
        post.setType(type);
        post.setElementsCountPerPage(limit+"");
        post.setParentNodeId(parentNodeId);
        post.setPageIndex(page+"");
        post.setNodeIds(nodeId);
        param.setRequest(post);
        Observable<BannerList> observable = mRepositoryManager.obtainRetrofitService(GamerSkyService.class)
                .getLabelJsonpAjax(param).flatMap(new Function<GamerSkyHttpRequest,ObservableSource<BannerList>>() {
                    @Override
                    public ObservableSource<BannerList> apply(@NonNull GamerSkyHttpRequest listReply) throws Exception {
                        List<BaseItem> baseItems = new ArrayList<>();
                        BannerList bannerList = new BannerList();
                        if(listReply!=null && listReply.getResult()!=null && listReply.getResult().size()>0){
                            if(page==1){
                                List<BaseBanner> baseBanners = new ArrayList<>();
                                if(listReply.getResult().get(0)!=null && listReply.getResult().get(0).getChildElements()!=null){
                                    for (int i=0;i<listReply.getResult().get(0).getChildElements().size();i++){
                                        BaseBanner<GamerSkyBanner> banner = new BaseBanner();
                                        GamerSkyBanner skyBanner = listReply.getResult().get(0).getChildElements().get(i);
                                        banner.setBaTitle(skyBanner.getTitle());
                                        if(skyBanner.getThumbnailURLs()!=null && skyBanner.getThumbnailURLs().size()>0){
                                            banner.setBaImg(skyBanner.getThumbnailURLs().get(0));
                                        }
                                        banner.setObject(skyBanner);
                                        baseBanners.add(banner);
                                    }
                                }
                                bannerList.setBanners(baseBanners);
                            }
                            for (int i=0;i<listReply.getResult().size();i++){
                                GamerSkyBean item = listReply.getResult().get(i);
                                if(item!=null && item.getChildElements()==null){
                                    baseItems.add(item);
                                }
                            }
                            bannerList.setData(baseItems);
                        }
                        return Observable.just(bannerList);
                    }
                });
        return mRepositoryManager.obtainCacheService(CommonCache.class).getBannerList(observable,new DynamicKey("getLabelJsonpAjax"+type+nodeId+parentNodeId+page+limit),new EvictDynamicKey(false));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

}