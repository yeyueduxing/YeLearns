package com.yeyue.learns.enity.bizhi;

import java.util.List;

/**
 * Created by li.xiao on 2017-12-6.
 */

public class AlbumDetail {
    /**
     * album : {"ename":"","isfeed":false,"tag":[],"id":"5a24cd3ae7bce7253c78ae3f","top":0,"type":1,"status":"online","user":{"gcid":"","name":"蛋蛋君","gender":0,"follower":2634,"avatar":"http://s.adesk.com/picasso/avatar_default.png","viptime":9.782784E8,"following":0,"isvip":false,"id":"561f6b2194e5cc423617f328"},"favs":13,"atime":1.512361274E9,"desc":" 宫主大人武功盖世，雨晨盟主法力无边这样的夸赞请不要吝惜，反套路热血武侠喜剧《拜见宫主大人》11月9日惊喜上线！","name":"【独家】拜见宫主大人","url":[],"cover":"http://img5.adesk.com/5a24cfb8e7bce7250515acd5?imageView2/3/h/240","lcover":"http://img5.adesk.com/5a24cfb8e7bce7250515acd5?imageView2/3/h/720","subname":"","sn":999}
     * wallpaper : []
     * subject : []
     */

    private BizhiAlbumBean album;
    private List<BizhiBean> wallpaper;

    public List<BizhiBean> getWallpaper() {
        return wallpaper;
    }

    public void setWallpaper(List<BizhiBean> wallpaper) {
        this.wallpaper = wallpaper;
    }

    public BizhiAlbumBean getAlbum() {
        return album;
    }

    public void setAlbum(BizhiAlbumBean album) {
        this.album = album;
    }

}
