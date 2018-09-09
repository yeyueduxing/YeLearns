package com.yeyue.learns.enity.bizhi;

import java.util.List;

/**
 * Created by li.xiao on 2017-12-15.
 */

public class SearchTags {

    private int type;
    private String title;
    private List<BizhiAlbumBean> album;
    private List<BizhiBean> wallpaper;
    private List<RingBean> ring;
    private List<LiveBean> live;
    private List<BizhiBean> vertical;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<BizhiAlbumBean> getAlbum() {
        return album;
    }

    public void setAlbum(List<BizhiAlbumBean> album) {
        this.album = album;
    }

    public List<BizhiBean> getWallpaper() {
        return wallpaper;
    }

    public void setWallpaper(List<BizhiBean> wallpaper) {
        this.wallpaper = wallpaper;
    }

    public List<RingBean> getRing() {
        return ring;
    }

    public void setRing(List<RingBean> ring) {
        this.ring = ring;
    }

    public List<LiveBean> getLive() {
        return live;
    }

    public void setLive(List<LiveBean> live) {
        this.live = live;
    }

    public List<BizhiBean> getVertical() {
        return vertical;
    }

    public void setVertical(List<BizhiBean> vertical) {
        this.vertical = vertical;
    }
}
