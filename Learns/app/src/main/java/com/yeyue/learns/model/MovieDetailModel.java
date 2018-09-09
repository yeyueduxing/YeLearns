package com.yeyue.learns.model;

import android.app.Application;

import com.blankj.utilcode.util.ObjectUtils;
import com.google.gson.Gson;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.yeyue.learns.constant.AdapterConstant;
import com.yeyue.learns.contract.MovieDetailContract;
import com.yeyue.learns.enity.movie.MovieBean;
import com.yeyue.learns.enity.movie.MovieCateGory;
import com.yeyue.learns.enity.movie.MovieCelebrity;
import com.yeyue.learns.enity.movie.MovieComment;
import com.yeyue.learns.enity.movie.MovieCount;
import com.yeyue.learns.enity.movie.MovieList;
import com.yeyue.learns.enity.movie.MoviePerson;
import com.yeyue.learns.model.api.cache.CommonCache;
import com.yeyue.learns.model.api.service.MovieService;
import com.yeyue.learns.utils.StringFormatUtil;
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
public class MovieDetailModel extends BaseModel implements MovieDetailContract.Model {
    private Gson mGson;
    private Application mApplication;

    @Inject
    public MovieDetailModel(IRepositoryManager repositoryManager, Gson gson, Application application) {
        super(repositoryManager);
        this.mGson = gson;
        this.mApplication = application;
    }

    @Override
    public Observable<List<BaseItem>> getMovieDetail(String subjectId,String apikey,String city) {
        Observable<MovieBean> observable = mRepositoryManager.obtainCacheService(CommonCache.class).getMovieBean(mRepositoryManager.obtainRetrofitService(MovieService.class)
                .getMovieDetail(subjectId,apikey,city), new DynamicKey("getMovieDetail"+subjectId+apikey+city), new EvictDynamicKey(false));
        return observable.flatMap(new Function<MovieBean, ObservableSource<List<BaseItem>>>() {
            @Override
            public ObservableSource<List<BaseItem>> apply(@NonNull MovieBean listReply) throws Exception {
                List<BaseItem> baseItems = new ArrayList<BaseItem>();
                if(listReply!=null){
                    //简介
                    if(!ObjectUtils.isEmpty(listReply.getSummary())){
                        MovieCateGory cateGory = new MovieCateGory();
                        cateGory.setTitle("简介");
                        cateGory.setContent(listReply.getSummary());
                        baseItems.add(cateGory);
                    }
                    //影人
                    if(listReply.getCasts()!=null || listReply.getDirectors()!=null){
                        MovieCateGory cateGory = new MovieCateGory();
                        cateGory.setTitle("影人");
                        baseItems.add(cateGory);
                        MovieList list = new MovieList();
                        List<MoviePerson> moviePeople = new ArrayList<>();
                        if(listReply.getDirectors()!=null && listReply.getDirectors().size()>0){
                            for (int i=0;i<listReply.getDirectors().size();i++){
                                MoviePerson person = listReply.getDirectors().get(i);
                                person.setRole("导演");
                                moviePeople.add(person);
                            }
                        }
                        if(listReply.getCasts()!=null && listReply.getCasts().size()>0){
                            moviePeople.addAll(moviePeople.size(),listReply.getCasts());
                        }
                        list.setList(moviePeople);
                        baseItems.add(list);
                    }
                    //剧照
                    if(listReply.getPhotos()!=null && listReply.getPhotos().size()>0){
                        MovieCateGory cateGory = new MovieCateGory();
                        cateGory.setTitle("剧照");
                        baseItems.add(cateGory);
                        MovieList list = new MovieList();
                        for (int i=0;i<listReply.getPhotos().size();i++){
                            listReply.getPhotos().get(i).setSubjectId(subjectId);
                        }
                        list.setList(listReply.getPhotos());
                        baseItems.add(list);
                        MovieCount movieCount = new MovieCount();
                        movieCount.setContent("剧照"+listReply.getPhotos_count()+"张");
                        movieCount.setObject(listReply.getPhotos().get(0));
                        baseItems.add(movieCount);
                    }
                    //短评
                    if(listReply.getPopular_comments()!=null && listReply.getPopular_comments().size()>0){
                        MovieCateGory cateGory = new MovieCateGory();
                        cateGory.setTitle("短评");
                        baseItems.add(cateGory);
                        for (int i=0;i<listReply.getPopular_comments().size();i++){
                            MovieComment comment = listReply.getPopular_comments().get(i);
                            comment.setItemtype(AdapterConstant.ITME_MOVIE_COMMENT_DEFAULT);
                            baseItems.add(comment);
                        }
                        MovieCount movieCount = new MovieCount();
                        movieCount.setContent("短评"+listReply.getComments_count()+"条");
                        MovieComment comment = listReply.getPopular_comments().get(0);
                        comment.setItemtype(AdapterConstant.ITME_MOVIE_COMMENT_DEFAULT);
                        movieCount.setObject(comment);
                        baseItems.add(movieCount);
                    }

                    //影评
                    if(listReply.getPopular_reviews()!=null && listReply.getPopular_reviews().size()>0){
                        MovieCateGory cateGory = new MovieCateGory();
                        cateGory.setTitle("影评");
                        baseItems.add(cateGory);
                        baseItems.addAll(baseItems.size(),listReply.getPopular_reviews());
                        MovieCount movieCount = new MovieCount();
                        movieCount.setContent("影评"+listReply.getReviews_count()+"条");
                        movieCount.setObject(listReply.getPopular_reviews().get(0));
                        baseItems.add(movieCount);
                    }

                }
                return Observable.just(baseItems);
            }
        });
    }

    @Override
    public Observable<List<BaseItem>> getCelebrity(String subjectId,String apikey,MovieDetailContract.View view) {
        Observable<MovieCelebrity> observable = mRepositoryManager.obtainCacheService(CommonCache.class).getMovieCelebrity(mRepositoryManager.obtainRetrofitService(MovieService.class)
                .getCelebrity(subjectId,apikey), new DynamicKey("getCelebrity"+subjectId+apikey), new EvictDynamicKey(false));
        return observable.flatMap(new Function<MovieCelebrity, ObservableSource<List<BaseItem>>>() {
            @Override
            public ObservableSource<List<BaseItem>> apply(@NonNull MovieCelebrity listReply) throws Exception {
                List<BaseItem> baseItems = new ArrayList<BaseItem>();
                if(listReply!=null){
                    //个人简介
                    MovieCateGory userInfo = new MovieCateGory();
                    userInfo.setTitle("个人简介");
                    StringBuilder content = new StringBuilder();
                    content.append("姓名  "+listReply.getName()+"\n");
                    if(!ObjectUtils.isEmpty(listReply.getName_en())){
                        content.append("英文名  "+listReply.getName_en()+"\n");
                    }
                    if(!ObjectUtils.isEmpty(listReply.getGender())){
                        content.append("性别  "+listReply.getGender()+"\n");
                    }
                    if(!ObjectUtils.isEmpty(listReply.getBirthday())){
                        content.append("出生日期  "+listReply.getBirthday()+"\n");
                    }
                    if(!ObjectUtils.isEmpty(listReply.getBorn_place())){
                        content.append("出生地  "+listReply.getBorn_place()+"\n");
                    }
                    if(!ObjectUtils.isEmpty(listReply.getConstellation())){
                        content.append("星座  "+listReply.getConstellation()+"\n");
                    }
                    content.append("职业  "+ StringFormatUtil.formatGenres(listReply.getProfessions())+"\n");
                    if(!ObjectUtils.isEmpty(listReply.getSummary())){
                        content.append("\n"+listReply.getSummary());
                    }
                    userInfo.setContent(content.toString());
                    baseItems.add(userInfo);
                    //作品
                    if(listReply.getWorks()!=null && listReply.getWorks().size()>0){
                        MovieCateGory cateGory = new MovieCateGory();
                        cateGory.setTitle("代表作品");
                        baseItems.add(cateGory);
                        MovieList<MovieBean> list = new MovieList<>();
                        List<MovieBean> beans = new ArrayList<>();
                        for (int i=0;i<listReply.getWorks().size();i++){
                            if(listReply.getWorks().get(i)!=null && listReply.getWorks().get(i).getSubject()!=null){
                                MovieBean movieBean = listReply.getWorks().get(i).getSubject();
                                movieBean.setItemtype(AdapterConstant.ITME_MOVIE_BEAN_CELEBIRTY);
                                beans.add(movieBean);
                            }
                        }
                        list.setList(beans);
                        baseItems.add(list);
                    }
                    //剧照
                    if(listReply.getPhotos()!=null && listReply.getPhotos().size()>0){
                        MovieCateGory cateGory = new MovieCateGory();
                        cateGory.setTitle("影人照片");
                        baseItems.add(cateGory);
                        MovieList list = new MovieList();
                        list.setList(listReply.getPhotos());
                        baseItems.add(list);
                    }
                }
                return Observable.just(baseItems);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

}