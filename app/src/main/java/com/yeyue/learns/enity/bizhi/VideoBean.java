package com.yeyue.learns.enity.bizhi;

import com.yeyue.learns.constant.AdapterConstant;
import com.yeyue.library.data.BaseItem;

/**
 * Created by li.xiao on 2017-11-7.
 */

public class VideoBean extends BaseItem{
    /**
     * set : 95504
     * shareurl : http://service.videowp.adesk.com/v1/analytics?id=594b8276e7bce75bfc2e255c&type=share
     * share : 9002
     * height : 1920
     * duration : 25
     * bit_rate : 2971165
     * tag :
     * video : http://cdn.video.picasso.dandanjiang.tv/594b8276e7bce75bfc2e255c.mp4?newver=0.88448766237&sign=5a1431c91ea963a70b265cca0690bd88&t=5a02cd2c
     * download : 72773
     * click : 616495
     * category : 5930e061e7bce72ce01371ae
     * img : http://cdn.video.picasso.dandanjiang.tv/594b8276e7bce75bfc2e255c.jpg?newver=0.468780410442&imageMogr2/thumbnail/!350x540r/gravity/Center/crop/350x540&sign=c613881157e2923a9747a97dba66f91a&t=5a02cd2c
     * clickurl : http://service.videowp.adesk.com/v1/analytics?id=594b8276e7bce75bfc2e255c&type=click
     * id : 594b8276e7bce75bfc2e255c
     * width : 1080
     * favnum : 491
     * play : 550649
     * favoriteurl : http://service.videowp.adesk.com/v1/analytics?id=594b8276e7bce75bfc2e255c&type=favorite
     * downloadurl : http://service.videowp.adesk.com/v1/analytics?id=594b8276e7bce75bfc2e255c&type=download
     * view_video : http://cdn.video.picasso.dandanjiang.tv/594b8276e7bce75bfc2e255c_view.mp4?newver=1&sign=5a4d389ae0e58b453f9f28d7d4cca5a2&t=5a02cd2c
     * atime : 2017-06-22 16:40:22.677000
     * desc :
     * name : 刘飞儿Faye-我要飞
     * viewurl : http://service.videowp.adesk.com/v1/analytics?id=594b8276e7bce75bfc2e255c&type=view
     * favorite : 7536
     * seturl : http://service.videowp.adesk.com/v1/analytics?id=594b8276e7bce75bfc2e255c&type=set
     * playurl : http://service.videowp.adesk.com/v1/analytics?id=594b8276e7bce75bfc2e255c&type=play
     * view : 1475432
     * video_time : 216
     */

    private int set;
    private String shareurl;
    private int share;
    private int height;
    private int duration;
    private int bit_rate;
    private String tag;
    private String video;
    private int download;
    private int click;
    private String category;
    private String img;
    private String clickurl;
    private String id;
    private int width;
    private int favnum;
    private int play;
    private String favoriteurl;
    private String downloadurl;
    private String view_video;
    private String atime;
    private String desc;
    private String name;
    private String viewurl;
    private int favorite;
    private String seturl;
    private String playurl;
    private int view;
    private String video_time;

    @Override
    public int getItemType() {
        return AdapterConstant.ITEM_BIZHI_VIDEO_DEFAULT;
    }

    public int getSet() {
        return set;
    }

    public void setSet(int set) {
        this.set = set;
    }

    public String getShareurl() {
        return shareurl;
    }

    public void setShareurl(String shareurl) {
        this.shareurl = shareurl;
    }

    public int getShare() {
        return share;
    }

    public void setShare(int share) {
        this.share = share;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getBit_rate() {
        return bit_rate;
    }

    public void setBit_rate(int bit_rate) {
        this.bit_rate = bit_rate;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getDownload() {
        return download;
    }

    public void setDownload(int download) {
        this.download = download;
    }

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getClickurl() {
        return clickurl;
    }

    public void setClickurl(String clickurl) {
        this.clickurl = clickurl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getFavnum() {
        return favnum;
    }

    public void setFavnum(int favnum) {
        this.favnum = favnum;
    }

    public int getPlay() {
        return play;
    }

    public void setPlay(int play) {
        this.play = play;
    }

    public String getFavoriteurl() {
        return favoriteurl;
    }

    public void setFavoriteurl(String favoriteurl) {
        this.favoriteurl = favoriteurl;
    }

    public String getDownloadurl() {
        return downloadurl;
    }

    public void setDownloadurl(String downloadurl) {
        this.downloadurl = downloadurl;
    }

    public String getView_video() {
        return view_video;
    }

    public void setView_video(String view_video) {
        this.view_video = view_video;
    }

    public String getAtime() {
        return atime;
    }

    public void setAtime(String atime) {
        this.atime = atime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getViewurl() {
        return viewurl;
    }

    public void setViewurl(String viewurl) {
        this.viewurl = viewurl;
    }

    public int getFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }

    public String getSeturl() {
        return seturl;
    }

    public void setSeturl(String seturl) {
        this.seturl = seturl;
    }

    public String getPlayurl() {
        return playurl;
    }

    public void setPlayurl(String playurl) {
        this.playurl = playurl;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public String getVideo_time() {
        return video_time;
    }

    public void setVideo_time(String video_time) {
        this.video_time = video_time;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
