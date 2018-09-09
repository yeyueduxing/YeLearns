package com.yeyue.learns.ui.movie.adapter.convert;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.yeyue.learns.BR;
import com.yeyue.learns.R;
import com.yeyue.learns.constant.AdapterConstant;
import com.yeyue.learns.enity.movie.MovieBean;
import com.yeyue.learns.enity.movie.MovieCateGory;
import com.yeyue.learns.enity.movie.MovieComment;
import com.yeyue.learns.enity.movie.MovieCount;
import com.yeyue.learns.enity.movie.MovieImage;
import com.yeyue.learns.enity.movie.MoviePerson;
import com.yeyue.learns.enity.movie.MovieList;
import com.yeyue.learns.enity.movie.MoviePhotoRequest;
import com.yeyue.learns.ui.movie.adapter.MovieListAdapter;
import com.yeyue.library.data.BaseItem;

/**
  *@describe 通用视图
  *@author li.xiao
  *@time 2017-9-25 16:27
  */
public class MovieAdapterConvert {
    public static void convert(BaseViewHolder helper, BaseItem data,ViewDataBinding binding){
        switch (helper.getItemViewType()) {
            case AdapterConstant.ITME_MOVIE_DEFAULT:
                if(data!=null && data instanceof MovieBean){
                    MovieBean item = (MovieBean) data;
                    binding.setVariable(BR.movie,item);
                }
                break;
            case AdapterConstant.ITME_MOVIE_PERSONAL_LIST:
                if(data!=null && data instanceof MovieList){
                    MovieList item = (MovieList) data;
                    //横向演员列表
                    RecyclerView recyclerView = helper.getView(R.id.rvList);
                    recyclerView.setNestedScrollingEnabled(false);
                    LinearLayoutManager manager = new LinearLayoutManager(recyclerView.getContext());
                    manager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    recyclerView.setLayoutManager(manager);
                    MovieListAdapter adapter = new MovieListAdapter(item.getList());
                    recyclerView.setAdapter(adapter);
                }
                break;
            case AdapterConstant.ITME_MOVIE_PERSONAL_DEFAULT:
                if(data!=null && data instanceof MoviePerson){
                    MoviePerson item = (MoviePerson) data;
                    binding.setVariable(BR.person,item);
                }
                break;
            case AdapterConstant.ITME_MOVIE_IMAGE_DEFAULT:
                if(data!=null && data instanceof MovieImage){
                    MovieImage item = (MovieImage) data;
                    binding.setVariable(BR.image,item);
                }
                break;
            case AdapterConstant.ITME_MOVIE_CATE_GORY:
                if(data!=null && data instanceof MovieCateGory){
                    MovieCateGory item = (MovieCateGory) data;
                    binding.setVariable(BR.cate,item);
                }
                break;
            case AdapterConstant.ITME_MOVIE_COMMENT_REVIEW:
                if(data!=null && data instanceof MovieComment){
                    MovieComment item = (MovieComment) data;
                    binding.setVariable(BR.commentReview,item);
                }
                break;
            case AdapterConstant.ITME_MOVIE_COMMENT_DEFAULT:
                if(data!=null && data instanceof MovieComment){
                    MovieComment item = (MovieComment) data;
                    binding.setVariable(BR.commentDefault,item);
                }
                break;
            case AdapterConstant.ITME_MOVIE_BEAN_CELEBIRTY:
                if(data!=null && data instanceof MovieBean){
                    MovieBean item = (MovieBean) data;
                    binding.setVariable(BR.beanCelebrity,item);
                }
                break;
            case AdapterConstant.ITME_MOVIE_PHOTO_DEFAULT:
                if(data!=null && data instanceof MoviePhotoRequest.PhotosBean){
                    MoviePhotoRequest.PhotosBean item = (MoviePhotoRequest.PhotosBean) data;
                    binding.setVariable(BR.photo,item);
                }
                break;
            case AdapterConstant.ITEM_MOVIE_COUNT_DEFAULT:
                if(data!=null && data instanceof MovieCount){
                    MovieCount item = (MovieCount) data;
                    binding.setVariable(BR.MovieCount,item);
                }
                break;
        }
    }
}
