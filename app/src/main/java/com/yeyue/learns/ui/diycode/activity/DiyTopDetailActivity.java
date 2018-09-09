package com.yeyue.learns.ui.diycode.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jess.arms.di.component.AppComponent;
import com.yeyue.learns.R;
import com.yeyue.learns.constant.Constant;
import com.yeyue.learns.contract.DiyTopDetailContract;
import com.yeyue.learns.di.component.DaggerDiyTopDetailComponent;
import com.yeyue.learns.di.module.DiyTopDetailModule;
import com.yeyue.learns.enity.diycode.DiyTopContent;
import com.yeyue.learns.enity.diycode.DiyTopic;
import com.yeyue.learns.enity.diycode.DiyUser;
import com.yeyue.learns.presenter.DiyTopDetailPresenter;
import com.yeyue.learns.ui.main.adapter.CommonListAdapter;
import com.yeyue.learns.utils.TimeUtils;
import com.yeyue.learns.widgets.GcsMarkdownViewClient;
import com.yeyue.learns.widgets.MarkdownView;
import com.yeyue.learns.widgets.WebImageListener;
import com.yeyue.library.base.YeRecyActivity;
import com.yeyue.library.data.BaseItem;
import com.yeyue.library.utils.ImageLoadUtils;
import com.yeyue.library.widgets.percent.PercentLinearLayout;
import com.yeyue.library.widgets.viewbigimage.ViewBigImageActivity;

import java.util.ArrayList;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
  *@describe DiyCode详情
  *@author li.xiao
  *@time 2018-1-5 15:50
  */
public class DiyTopDetailActivity extends YeRecyActivity<BaseItem, DiyTopDetailPresenter> implements DiyTopDetailContract.View<BaseItem> {

    @BindView(R.id.avatar)
    CircleImageView avatar;
    @BindView(R.id.username)
    TextView username;
    @BindView(R.id.point)
    TextView point;
    @BindView(R.id.node_name)
    TextView nodeName;
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.webview_container)
    FrameLayout webviewContainer;
    @BindView(R.id.collection)
    ImageView collection;
    @BindView(R.id.like)
    ImageView like;
    @BindView(R.id.panel)
    PercentLinearLayout panel;
    @BindView(R.id.reply_count)
    TextView replyCount;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.need_login)
    RelativeLayout needLogin;

    private DiyTopic diyTopic;
    private MarkdownView mMarkdownView;
    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        DaggerDiyTopDetailComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .diyTopDetailModule(new DiyTopDetailModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_diy_top_detail;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        if(getIntent()!=null){
            if(getIntent().hasExtra(Constant.DIYTOP_DETAIL)){
                diyTopic = (DiyTopic) getIntent().getSerializableExtra(Constant.DIYTOP_DETAIL);
            }
        }
        if(diyTopic!=null){
            initDetail(diyTopic);
        }
        getRecyclerView().setNestedScrollingEnabled(false);
        initMarkDown();
        setTitle("话题");
        mPresenter.getTopicRepliesList(diyTopic.getId(),true);
        mPresenter.getDetail(diyTopic.getId()+"");
    }

    @Override
    public boolean enableRefresh() {
        return false;
    }

    @Override
    public boolean enableMore() {
        return true;
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {

    }

    @Override
    public void onDataRefresh() {
        mPresenter.getTopicRepliesList(diyTopic.getId(),true);
    }

    @Override
    public void onDataLoadMore() {
        mPresenter.getTopicRepliesList(diyTopic.getId(),false);
    }

    @Override
    public BaseQuickAdapter<BaseItem, BaseViewHolder> getAdapter() {
        return new CommonListAdapter(new ArrayList());
    }

    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        return new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
    }

    @Override
    public void killMyself() {
        finish();
    }


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public boolean isToolbar() {
        return true;
    }

    @Override
    public void initMarkDown() {
        mMarkdownView = new MarkdownView(this.getApplicationContext());
        mMarkdownView.setBackgroundResource(R.color.transparent);
        mMarkdownView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        webviewContainer.addView(mMarkdownView);

        WebImageListener listener = new WebImageListener(this, ViewBigImageActivity.class);
        mMarkdownView.addJavascriptInterface(listener, "listener");
        mMarkdownView.setWebViewClient(new GcsMarkdownViewClient(this));
    }

    @Override
    public void initDetail(DiyTopContent diyTopContent) {
        if(diyTopContent==null){
            return;
        }
        DiyUser user = diyTopContent.getUser();
        username.setText(user.getLogin() + "(" + user.getName() + ")");
        time.setText( TimeUtils.computePastTime(diyTopContent.getUpdated_at()));
        title.setText(diyTopContent.getTitle());
        replyCount.setText( "共收到 " + diyTopContent.getReplies_count() + "条回复");
        ImageLoadUtils.showImageView(getActivity(),avatar,user.getAvatar_url(),R.mipmap.icon_diycode,R.mipmap.icon_diycode);
        mMarkdownView.setMarkDownText(diyTopContent.getBody());
    }

    @Override
    public void initDetail(DiyTopic diyTopic) {
        DiyUser user = diyTopic.getUser();
        username.setText(user.getLogin() + "(" + user.getName() + ")");
        time.setText( TimeUtils.computePastTime(diyTopic.getUpdated_at()));
        title.setText(diyTopic.getTitle());
        replyCount.setText( "共收到 " + diyTopic.getReplies_count() + "条回复");
        ImageLoadUtils.showImageView(getActivity(),avatar,user.getAvatar_url(),R.mipmap.icon_diycode,R.mipmap.icon_diycode);
    }

    @Override
    public View getLoadView() {
        return null;
    }
}
