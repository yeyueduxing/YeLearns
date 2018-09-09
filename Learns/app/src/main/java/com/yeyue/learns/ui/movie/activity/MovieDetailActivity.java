package com.yeyue.learns.ui.movie.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jess.arms.di.component.AppComponent;
import com.yeyue.learns.R;
import com.yeyue.learns.constant.Constant;
import com.yeyue.learns.contract.MovieDetailContract;
import com.yeyue.learns.di.component.DaggerMovieDetailComponent;
import com.yeyue.learns.di.module.MovieDetailModule;
import com.yeyue.learns.enity.movie.MovieBean;
import com.yeyue.learns.enity.movie.MoviePerson;
import com.yeyue.learns.presenter.MovieDetailPresenter;
import com.yeyue.learns.ui.movie.adapter.MovieListAdapter;
import com.yeyue.learns.utils.StringFormatUtil;
import com.yeyue.library.base.YeHeaderRecyActivity;
import com.yeyue.library.data.BaseItem;
import com.yeyue.library.utils.ImageLoadUtils;
import com.yeyue.library.widgets.glide.YeGlideBlurformation;

import java.util.ArrayList;

import butterknife.BindView;


public class MovieDetailActivity extends YeHeaderRecyActivity<BaseItem, MovieDetailPresenter> implements MovieDetailContract.View<BaseItem> {


    @BindView(R.id.img_item_bg)
    ImageView imgItemBg;
    @BindView(R.id.iv_one_photo)
    ImageView ivOnePhoto;
    @BindView(R.id.tv_one_rating_rate)
    TextView tvOneRatingRate;
    @BindView(R.id.tv_one_rating_number)
    TextView tvOneRatingNumber;
    @BindView(R.id.tv_one_directors)
    TextView tvOneDirectors;
    @BindView(R.id.tv_one_casts)
    TextView tvOneCasts;
    @BindView(R.id.tv_one_genres)
    TextView tvOneGenres;
    @BindView(R.id.tv_one_day)
    TextView tvOneDay;
    @BindView(R.id.tv_one_city)
    TextView tvOneCity;
    @BindView(R.id.ll_one_item)
    LinearLayout llOneItem;

    private MovieBean movieBean;
    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        DaggerMovieDetailComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .movieDetailModule(new MovieDetailModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int setHeaderId() {
        return R.layout.activity_movie_detail_header;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        if(getIntent()!=null && getIntent().hasExtra(Constant.MOVIE_INFO)){
            movieBean = (MovieBean) getIntent().getSerializableExtra(Constant.MOVIE_INFO);
        }
        initMovie(movieBean);
        if(movieBean!=null){
            mPresenter.getMovieDetail(movieBean.getId(),true);
        }
    }

    @Override
    public boolean enableRefresh() {
        return false;
    }

    @Override
    public boolean enableMore() {
        return false;
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {

    }

    @Override
    public void onDataRefresh() {
        mPresenter.getMovieDetail(movieBean.getId(),true);
    }

    @Override
    public void onDataLoadMore() {
        mPresenter.getMovieDetail(movieBean.getId(),false);
    }

    @Override
    public BaseQuickAdapter<BaseItem, BaseViewHolder> getAdapter() {
        return new MovieListAdapter(new ArrayList());
    }

    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        return manager;
    }

    @Override
    public void killMyself() {
        finish();
    }


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void initMovie(MovieBean movieBean) {
        if(movieBean==null){
            return;
        }
        setTitle(movieBean.getTitle());
        //设置高斯模糊
        ImageLoadUtils.showImageView(getActivity(),imgItemBg,movieBean.getImages().getLarge(),new YeGlideBlurformation(getActivity(),25));
        ImageLoadUtils.showImageView(getActivity(),ivOnePhoto,movieBean.getImages().getLarge());
        tvOneRatingRate.setText("评分:"+movieBean.getRating().getAverage());
        tvOneRatingNumber.setText(movieBean.getCollect_count()+"人评分");
        tvOneDirectors.setText(StringFormatUtil.formatName(movieBean.getDirectors()));
        tvOneCasts.setText(StringFormatUtil.formatName(movieBean.getCasts()));
        tvOneGenres.setText("类型:"+StringFormatUtil.formatGenres(movieBean.getGenres()));
        tvOneDay.setText("上映日期：" + movieBean.getYear());
        tvOneCity.setText("制片国家/地区：" + StringFormatUtil.formatGenres(movieBean.getCountries()));
    }

    @Override
    public void initCelebrity(MoviePerson celebrity) {

    }
}
