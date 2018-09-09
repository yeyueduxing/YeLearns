package com.yeyue.learns.model;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.yeyue.learns.constant.AdapterConstant;
import com.yeyue.learns.contract.MovieListContract;
import com.yeyue.learns.enity.movie.MovieBean;
import com.yeyue.learns.enity.movie.MovieComment;
import com.yeyue.learns.enity.movie.MovieHttpRequest;
import com.yeyue.learns.enity.movie.MoviePhotoRequest;
import com.yeyue.learns.enity.movie.MovieUsBoxRequest;
import com.yeyue.learns.model.api.cache.CommonCache;
import com.yeyue.learns.model.api.service.MovieService;
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
public class MovieListModel extends BaseModel implements MovieListContract.Model {
    private Gson mGson;
    private Application mApplication;

    @Inject
    public MovieListModel(IRepositoryManager repositoryManager, Gson gson, Application application) {
        super(repositoryManager);
        this.mGson = gson;
        this.mApplication = application;
    }

    @Override
    public Observable<List<BaseItem>> getHotPlayMovies(String type,String apikey, String city, int start,int count) {
        Observable<List<BaseItem>> observable = mRepositoryManager.obtainRetrofitService(MovieService.class)
                .getHotPlayMovies(type,apikey,city,start,count).flatMap(new Function<MovieHttpRequest, ObservableSource<List<BaseItem>>>() {
                    @Override
                    public ObservableSource<List<BaseItem>> apply(@NonNull MovieHttpRequest listReply) throws Exception {
                        List<BaseItem> baseItems = new ArrayList<BaseItem>();
                        if (listReply != null && listReply.getSubjects() != null && listReply.getSubjects().size() > 0) {
                            baseItems.addAll(listReply.getSubjects());
                        }
                        return Observable.just(baseItems);
                    }
                });
        return mRepositoryManager.obtainCacheService(CommonCache.class).getListDataCache(observable, new DynamicKey("getHotPlayMovies"+type+apikey+city+start+count), new EvictDynamicKey(false));
    }

    @Override
    public Observable<List<BaseItem>> getMovieUsBoxRequest(String type,String apikey) {
        Observable<MovieUsBoxRequest> observable = mRepositoryManager.obtainCacheService(CommonCache.class).getMovieUsBoxRequest(mRepositoryManager.obtainRetrofitService(MovieService.class)
                .getUsBox(type,apikey), new DynamicKey("getMovieTypeList"+apikey), new EvictDynamicKey(false));
        return observable.flatMap(new Function<MovieUsBoxRequest, ObservableSource<List<BaseItem>>>() {
            @Override
            public ObservableSource<List<BaseItem>> apply(@NonNull MovieUsBoxRequest listReply) throws Exception {
                List<BaseItem> baseItems = new ArrayList<BaseItem>();
                if(listReply!=null){
                    if (listReply.getSubjects() != null && listReply.getSubjects().size() > 0) {
                        for (int i=0;i<listReply.getSubjects().size();i++){
                            MovieBean subject = listReply.getSubjects().get(i).getSubject();
                            baseItems.add(subject);
                        }
                    }
                }
                return Observable.just(baseItems);
            }
        });
    }

    @Override
    public Observable<List<BaseItem>> getMoviePhotos(String apikey, String id,String type, int start,int count) {
        Observable<MoviePhotoRequest> observable = mRepositoryManager.obtainCacheService(CommonCache.class).getMoviePhotoRequest(mRepositoryManager.obtainRetrofitService(MovieService.class)
                .getMoviePhotos(id,type,apikey,start,count), new DynamicKey("getMovieTypeList"+apikey+id+type+start+count), new EvictDynamicKey(false));

       return observable.flatMap(new Function<MoviePhotoRequest, ObservableSource<List<BaseItem>>>() {
                    @Override
                    public ObservableSource<List<BaseItem>> apply(@NonNull MoviePhotoRequest listReply) throws Exception {
                        List<BaseItem> baseItems = new ArrayList<BaseItem>();
                        if(listReply!=null){
                            if (listReply.getPhotos() != null && listReply.getPhotos().size() > 0) {
                                baseItems.addAll(listReply.getPhotos());
                            }
                            if (listReply.getReviews() != null && listReply.getReviews().size() > 0) {
                                baseItems.addAll(listReply.getReviews());
                            }
                            if (listReply.getComments() != null && listReply.getComments().size() > 0) {
                                for (int i=0;i<listReply.getComments().size();i++){
                                    MovieComment comment = listReply.getComments().get(i);
                                    comment.setItemtype(AdapterConstant.ITME_MOVIE_COMMENT_DEFAULT);
                                    baseItems.add(comment);
                                }
                            }
                        }
                        return Observable.just(baseItems);
                    }
                });
    }
    @Override
    public Observable<List<BaseItem>> getMovieSearch(String tag,String q,String apikey,int start,int count) {
        Observable<List<BaseItem>> observable = mRepositoryManager.obtainRetrofitService(MovieService.class)
                .getMovieSearch(tag,q,apikey,start,count).flatMap(new Function<MovieHttpRequest, ObservableSource<List<BaseItem>>>() {
                    @Override
                    public ObservableSource<List<BaseItem>> apply(@NonNull MovieHttpRequest listReply) throws Exception {
                        List<BaseItem> baseItems = new ArrayList<BaseItem>();
                        if (listReply != null && listReply.getSubjects() != null && listReply.getSubjects().size() > 0) {
                            baseItems.addAll(listReply.getSubjects());
                        }
                        return Observable.just(baseItems);
                    }
                });
        return mRepositoryManager.obtainCacheService(CommonCache.class).getListDataCache(observable, new DynamicKey("getMovieSearch"+q+apikey+tag+start+count), new EvictDynamicKey(false));
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

}