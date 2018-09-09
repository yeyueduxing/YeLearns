package com.yeyue.library.base;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jess.arms.di.component.AppComponent;
import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadSampleListener;
import com.liulishuo.filedownloader.FileDownloader;
import com.yeyue.library.R;
import com.yeyue.library.adapter.YeSkinDetailAdapter;
import com.yeyue.library.constant.YeConstant;
import com.yeyue.library.constant.YeSkinConstant;
import com.yeyue.library.data.YeSkinItem;
import com.yeyue.library.utils.ImageLoadUtils;
import com.yeyue.library.utils.YeEventUtils;
import com.yeyue.library.utils.YeSkinUtils;

import java.util.ArrayList;
import java.util.List;

import skin.support.SkinCompatManager;
import skin.support.utils.SkinFileUtils;

/**
  *@describe 网络皮肤详情页
  *@author li.xiao
  *@time 2017-12-21 14:46
  */
public class YeSkinDetailActivity extends YeRecyActivity {
    public YeSkinItem yeSkinItem;
    private ImageView ivThumb;
    private  TextView tvTitle;
    private TextView tvSize;
    private TextView tvDesc;
    private Button btDownload;
    private ProgressBar pbDownload;
    private String skinName = "start.skin";
    @Override
    public void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public int getContentViewId() {
        return R.layout.yeyue_common_skin_activity;
    }

    @Override
    public void findView() {
        super.findView();
        ivThumb = (ImageView)findViewById(R.id.ivThumb);
        tvTitle = (TextView)findViewById(R.id.tvTitle);
        tvSize = (TextView)findViewById(R.id.tvSize);
        tvDesc = (TextView)findViewById(R.id.tvDesc);
        btDownload = (Button)findViewById(R.id.btDownload);
        pbDownload = (ProgressBar)findViewById(R.id.pbDownload);
        btDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileDownloader.getImpl().create(yeSkinItem.getResourcePath())
                        .setPath(SkinFileUtils.getSkinDir(getActivity())+"/"+skinName)
                        .setCallbackProgressTimes(300)
                        .setMinIntervalUpdateSpeed(400)
                        .setListener(new FileDownloadSampleListener() {

                            @Override
                            protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                                super.pending(task, soFarBytes, totalBytes);
                                btDownload.setText("等待下载....");
                            }

                            @Override
                            protected void started(BaseDownloadTask task) {
                                super.started(task);
                                btDownload.setVisibility(View.GONE);
                                pbDownload.setVisibility(View.VISIBLE);
                            }

                            @Override
                            protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                                super.progress(task, soFarBytes, totalBytes);
                                int progress = (int) (((float)soFarBytes/(float) totalBytes)*100);
                                pbDownload.setProgress(progress);
                            }

                            @Override
                            protected void error(BaseDownloadTask task, Throwable e) {
                                super.error(task, e);
                                ToastUtils.showLong("下载失败"+e.getMessage());
                                btDownload.setText("下载");
                                btDownload.setVisibility(View.VISIBLE);
                                pbDownload.setVisibility(View.GONE);
                            }

                            @Override
                            protected void connected(BaseDownloadTask task, String etag, boolean isContinue, int soFarBytes, int totalBytes) {
                                super.connected(task, etag, isContinue, soFarBytes, totalBytes);
                            }

                            @Override
                            protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                                super.paused(task, soFarBytes, totalBytes);
                            }

                            @Override
                            protected void completed(BaseDownloadTask task) {
                                super.completed(task);
                                ToastUtils.showLong("下载成功");
                                YeSkinUtils.setSkinOnLine(skinName, new SkinCompatManager.SkinLoaderListener() {
                                    @Override
                                    public void onStart() {

                                    }

                                    @Override
                                    public void onSuccess() {
                                        //刷新界面
                                        YeEventUtils.updateSkin();
                                        //int color = SkinCompatResources.getInstance().getColor(R.color.ye_color_Navigation_Base);
                                        //StatusBarUtil.setColorNoTranslucent(getActivity(), color);
                                    }

                                    @Override
                                    public void onFailed(String s) {

                                    }
                                });
                                btDownload.setText("应用中");
                                btDownload.setVisibility(View.VISIBLE);
                                pbDownload.setVisibility(View.GONE);
                            }

                            @Override
                            protected void warn(BaseDownloadTask task) {
                                super.warn(task);
                            }
                        }).start();
            }
        });
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }


    @Override
    public void initData(Bundle savedInstanceState) {
        if (getIntent() != null && getIntent().hasExtra(YeSkinConstant.YE_SKIN_INFO)) {
            yeSkinItem = (YeSkinItem) getIntent().getSerializableExtra(YeSkinConstant.YE_SKIN_INFO);
        }
        setTitle("换肤");
        if(yeSkinItem!=null){
            showLoadSirView(YeConstant.LoadSir.SUCCESS);
            if (yeSkinItem.getPreViews() != null && yeSkinItem.getPreViews().size() > 0) {
                refreshUI(yeSkinItem.getPreViews());
            }else{
                List<String> images = new ArrayList<>();
                images.add(yeSkinItem.getCoverPic());
                images.add(yeSkinItem.getCoverPic());
                images.add(yeSkinItem.getCoverPic());
                refreshUI(images);
            }
            ImageLoadUtils.showImageView(getActivity(),ivThumb,yeSkinItem.getCoverPic());
            tvTitle.setText(yeSkinItem.getName()+"");
            tvSize.setText(yeSkinItem.getSize()+"");
            tvDesc.setText(yeSkinItem.getDescription()+"");
            setTitle(yeSkinItem.getName());
            skinName = yeSkinItem.getSortName()+".skin";
        }else{
            showLoadSirView(YeConstant.LoadSir.ERROR);
        }

    }

    @Override
    public boolean isToolbar() {
        return true;
    }

    @Override
    public void onDataRefresh() {

    }

    @Override
    public void onDataLoadMore() {

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
    public BaseQuickAdapter getAdapter() {
        return new YeSkinDetailAdapter(new ArrayList());
    }

    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        return manager;
    }

    @Override
    public void killMyself() {
        finish();
    }

}
