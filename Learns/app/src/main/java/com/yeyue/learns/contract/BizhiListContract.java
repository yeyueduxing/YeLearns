package com.yeyue.learns.contract;

import com.jess.arms.mvp.IModel;
import com.yeyue.library.contract.YeBaseRecyview;
import com.yeyue.library.data.BaseItem;

import java.util.List;

import io.reactivex.Observable;

public interface BizhiListContract {
    interface View<T> extends YeBaseRecyview<T> {

    }

    interface Model extends IModel {
        Observable<List<BaseItem>> getHomepage(int limint, int start);
        Observable<List<BaseItem>> getWalCategory();
        Observable<List<BaseItem>> getWalNew(int limit, int start, String order);
        Observable<List<BaseItem>> getVerticalBizhi(int limit, int start, String order);
        Observable<List<BaseItem>> getVerCategory();
        Observable<List<BaseItem>> getVideoRecommend(String type, int limit, int start, String order);
        Observable<List<BaseItem>> getVideoCategoryDetail(String cateId, int limit, int start, String order);
        Observable<List<BaseItem>> getVideoCategory();
        Observable<List<BaseItem>> getAlubmDetail(String albumId,int limit,int start,String order);
        Observable<List<BaseItem>> getWalCategoryList(String cId, int limit, int skip, String order);
        Observable<List<BaseItem>> getWalCategoryAlbum(String cId, int limit, int skip, String order);
        Observable<List<BaseItem>> getVerCategoryList(String cId, int limit, int skip, String order);
        Observable<List<BaseItem>> getUserWallPaper(String uid,int limit,int skip,String order,String action);
        Observable<List<BaseItem>> getUserVertical(String uid,int limit,int skip,String order,String action);
        Observable<List<BaseItem>> getUserAlbum(String uid,int limit,int skip,String order);
        Observable<List<BaseItem>> getSearchAll(String query,int limit,int skip);
        Observable<List<BaseItem>> getSearchTag(String tag,String query,int limit,int skip);
    }
}