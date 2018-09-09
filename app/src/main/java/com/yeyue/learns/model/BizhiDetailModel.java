package com.yeyue.learns.model;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.yeyue.learns.R;
import com.yeyue.learns.contract.BizhiDetailContract;
import com.yeyue.learns.enity.bizhi.BizhiDetailHttpRequest;
import com.yeyue.learns.enity.bizhi.ComHeader;
import com.yeyue.learns.enity.bizhi.DetailBean;
import com.yeyue.learns.model.api.cache.CommonCache;
import com.yeyue.learns.model.api.service.BizhiService;
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
public class BizhiDetailModel extends BaseModel implements BizhiDetailContract.Model {
    private Gson mGson;
    private Application mApplication;

    @Inject
    public BizhiDetailModel(IRepositoryManager repositoryManager, Gson gson, Application application) {
        super(repositoryManager);
        this.mGson = gson;
        this.mApplication = application;
    }

    @Override
    public Observable<List<BaseItem>> getDetail(String iD) {
        Observable<BizhiDetailHttpRequest> observable = mRepositoryManager.obtainCacheService(CommonCache.class).getBizhiDetailHttpRequest(mRepositoryManager.obtainRetrofitService(BizhiService.class)
                .getWalDetail(iD),new DynamicKey("getDetail"+iD),new EvictDynamicKey(false));
        return observable.flatMap(new Function<BizhiDetailHttpRequest,ObservableSource<List<BaseItem>>>() {
            @Override
            public ObservableSource<List<BaseItem>> apply(@NonNull BizhiDetailHttpRequest listReply) throws Exception {
                List<BaseItem> baseItems = new ArrayList<BaseItem>();
                if(listReply!=null && listReply.getRes()!=null){
                    //处理专辑
                    if(listReply.getRes().getAlbum()!=null && listReply.getRes().getAlbum().size()>0){
                        ComHeader comHeader = new ComHeader();
                        comHeader.setType(ComHeader.NO_LEFT_ICON);
                        comHeader.setTitle("相关");
                        baseItems.add(comHeader);
                        baseItems.addAll(baseItems.size(),listReply.getRes().getAlbum());
                    }
                    //处理热门评论
                    if(listReply.getRes().getHot()!=null && listReply.getRes().getHot().size()>0){
                        ComHeader comHeader = new ComHeader();
                        comHeader.setType(ComHeader.ICON_INSET);
                        comHeader.setLeftIcon(R.mipmap.comment_hot);
                        comHeader.setTitle("热门评论");
                        baseItems.add(comHeader);
                        baseItems.addAll(baseItems.size(),listReply.getRes().getHot());
                    }
                    //处理最新评论
                    if(listReply.getRes().getComment()!=null && listReply.getRes().getComment().size()>0){
                        ComHeader comHeader = new ComHeader();
                        comHeader.setType(ComHeader.ICON_INSET);
                        comHeader.setLeftIcon(R.mipmap.comment_new);
                        comHeader.setTitle("最新评论");
                        baseItems.add(comHeader);
                        baseItems.addAll(baseItems.size(),listReply.getRes().getComment());
                    }
                }
                if(baseItems==null || baseItems.isEmpty()){
                    baseItems = new ArrayList<BaseItem>();
                    ComHeader comHeader = new ComHeader();
                    comHeader.setType(ComHeader.ICON_INSET);
                    comHeader.setLeftIcon(R.mipmap.comment_new);
                    comHeader.setTitle("最新评论");
                    baseItems.add(comHeader);
                }
                return Observable.just(baseItems);
            }
        });
    }

    @Override
    public void follow(DetailBean detailBean, boolean isFollow) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

}