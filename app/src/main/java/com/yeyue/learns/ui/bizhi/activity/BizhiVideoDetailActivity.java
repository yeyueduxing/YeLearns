package com.yeyue.learns.ui.bizhi.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.blankj.utilcode.util.ToastUtils;
import com.jess.arms.di.component.AppComponent;
import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadSampleListener;
import com.liulishuo.filedownloader.FileDownloader;
import com.yeyue.learns.R;
import com.yeyue.learns.constant.Constant;
import com.yeyue.learns.contract.BizhiVideoDetailContract;
import com.yeyue.learns.di.component.DaggerBizhiVideoDetailComponent;
import com.yeyue.learns.di.module.BizhiVideoDetailModule;
import com.yeyue.learns.enity.bizhi.VideoBean;
import com.yeyue.learns.presenter.BizhiVideoDetailPresenter;
import com.yeyue.learns.utils.glide.GlideBlurformation;
import com.yeyue.library.base.BaseUiActivity;
import com.yeyue.library.utils.ImageLoadUtils;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;
import skin.support.utils.SkinFileUtils;

/**
 * @author li.xiao
 * @describe 视频壁纸详情页
 * @time 2018-1-2 16:12
 */
public class BizhiVideoDetailActivity extends BaseUiActivity<BizhiVideoDetailPresenter> implements BizhiVideoDetailContract.View {


    @BindView(R.id.background_imgv)
    ImageView backgroundImgv;
    @BindView(R.id.back_imgv)
    ImageView backImgv;
    @BindView(R.id.setting_imgv)
    ImageView settingImgv;
    @BindView(R.id.voice_imagev)
    ImageView voiceImagev;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.detail_top_rl)
    RelativeLayout detailTopRl;
    @BindView(R.id.detail_videoview)
    VideoView detailVideoview;
    @BindView(R.id.videoImg)
    ImageView videoImg;
    @BindView(R.id.lw_progress_tv)
    TextView lwProgressTv;
    @BindView(R.id.lw_progress)
    RelativeLayout lwProgress;
    @BindView(R.id.videoPauseImg)
    ImageView videoPauseImg;
    @BindView(R.id.videoFrameLayout)
    RelativeLayout videoFrameLayout;
    @BindView(R.id.set_rl)
    RelativeLayout setRl;

    private MediaPlayer mPlayer;
    private boolean isDownload;
    private boolean isPlay;
    private VideoBean videoBean;
    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        //取消标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //取消状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        DaggerBizhiVideoDetailComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .bizhiVideoDetailModule(new BizhiVideoDetailModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        if(getIntent()!=null && getIntent().hasExtra(Constant.VIDEO_DETAIL_INFO)){
            videoBean = (VideoBean) getIntent().getSerializableExtra(Constant.VIDEO_DETAIL_INFO);
        }
        if(videoBean==null){
            finish();
            return;
        }
        initView(videoBean);
        this.detailVideoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mp) {
                mPlayer = mp;
                mp.setVolume(0.0f, 0.0f);
            }
        });
        this.detailVideoview.setOnErrorListener(new MyOnErrorListener());
        this.detailVideoview.setOnCompletionListener(new MyOnCompletionListener());
        setAppContentBackground(R.color.transparent);
    }

    class MyOnCompletionListener implements MediaPlayer.OnCompletionListener {
        MyOnCompletionListener() {
        }

        public void onCompletion(MediaPlayer mp) {
            if (mp != null) {
                mp.start();
                mp.setLooping(true);
            }
        }
    }

    class MyOnErrorListener implements MediaPlayer.OnErrorListener {
        MyOnErrorListener() {
        }

        public boolean onError(MediaPlayer mp, int what, int extra) {
            videoImg.setVisibility(View.VISIBLE);
            return true;
        }
    }
    @Override
    public int getContentViewId() {
        return R.layout.activity_video_detail;
    }

    @Override
    public boolean isToolbar() {
        return false;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void launchActivity(Intent intent) {

    }

    @Override
    public void killMyself() {

    }

    @Override
    public void playVideo() {
        String fileName = videoBean.getId()+".mp4";
        File file = new File(SkinFileUtils.getSkinDir(getActivity())+"/"+fileName);
        try {
            if (this.detailVideoview != null && detailVideoview.getVisibility() == View.VISIBLE) {
                detailVideoview.start();
                lwProgress.setVisibility(View.GONE);
                videoImg.setVisibility(View.GONE);
                videoPauseImg.setVisibility(View.GONE);
            } else if (file.exists() && !detailVideoview.isPlaying()) {
                lwProgress.setVisibility(View.GONE);
                videoImg.setVisibility(View.GONE);
                videoPauseImg.setVisibility(View.GONE);
                detailVideoview.setVisibility(View.VISIBLE);
                detailVideoview.setVideoPath(file.getAbsolutePath());
                detailVideoview.requestFocus();
                detailVideoview.start();
            }
            isPlay = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(lwProgress!=null){
            lwProgress.setVisibility(View.GONE);
        }
    }

    @Override
    public void stopPlay() {
        if (this.detailVideoview != null) {
            this.detailVideoview.pause();
            this.lwProgress.setVisibility(View.GONE);
        }
        videoPauseImg.setVisibility(View.VISIBLE);
        isPlay = false;
    }

    @Override
    public void initView(VideoBean videoBean) {
        //初始化界面
        ImageLoadUtils.showImageView(getActivity(),videoImg,videoBean.getImg(),R.color.white,R.color.color_errorPic);
        ImageLoadUtils.showImageView(getActivity(), backgroundImgv, videoBean.getImg(),R.color.white,R.color.color_errorPic, new GlideBlurformation(getActivity()));
        titleTv.setText(videoBean.getName()+"");
    }

    @Override
    public void downLoad() {
        String fileName = videoBean.getId()+".mp4";
        FileDownloader.getImpl().create(videoBean.getView_video())
                .setPath(SkinFileUtils.getSkinDir(getActivity())+"/"+fileName)
                .setCallbackProgressTimes(300)
                .setMinIntervalUpdateSpeed(400)
                .setListener(new FileDownloadSampleListener() {

                    @Override
                    protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                        super.pending(task, soFarBytes, totalBytes);
                    }

                    @Override
                    protected void started(BaseDownloadTask task) {
                        super.started(task);
                        lwProgress.setVisibility(View.VISIBLE);
                        videoPauseImg.setVisibility(View.GONE);
                    }

                    @Override
                    protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                        super.progress(task, soFarBytes, totalBytes);
                        int progress = (int) (((float)soFarBytes/(float) totalBytes)*100);
                        lwProgressTv.setText("进度"+progress+"%");
                    }

                    @Override
                    protected void error(BaseDownloadTask task, Throwable e) {
                        super.error(task, e);
                        ToastUtils.showLong("下载失败"+e.getMessage());
                        stopPlay();
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
                        isDownload = true;
                        playVideo();
                    }

                    @Override
                    protected void warn(BaseDownloadTask task) {
                        super.warn(task);
                    }
                }).start();
    }

    @Override
    public void clickVideo() {
        if(isPlay){
            stopPlay();
        }else{
            if(isDownload){
                playVideo();
            }else{
                downLoad();
            }
        }
    }

    @OnClick({R.id.back_imgv, R.id.detail_top_rl, R.id.detail_videoview, R.id.videoImg, R.id.lw_progress_tv, R.id.lw_progress, R.id.videoPauseImg, R.id.videoFrameLayout, R.id.set_rl})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_imgv:
                break;
            case R.id.detail_top_rl:
                break;
            case R.id.detail_videoview:
                break;
            case R.id.videoImg:
                clickVideo();
                break;
            case R.id.lw_progress_tv:
                break;
            case R.id.lw_progress:
                break;
            case R.id.videoPauseImg:
                clickVideo();
                break;
            case R.id.videoFrameLayout:
                clickVideo();
                break;
            case R.id.set_rl:
                break;
        }
    }

    @Override
    public View getLoadView() {
        return null;
    }
}
