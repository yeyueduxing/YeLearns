package com.yeyue.learns.enity.bizhi;

import java.util.List;

/**
 * Created by li.xiao on 2017-12-5.
 */

public class WalDetail {
    /**
     * comment : [{"reply_user":{},"reply_meta":{},"content":"小乔  要努力变强","isup":false,"user":{"gcid":"","follower":0,"name":"可爱的小兔子520","viptime":1.511778001E9,"following":0,"gender":1,"title":[],"isvip":false,"id":"5a1be6d1e7bce72cb17ad53b","avatar":"http://wx.qlogo.cn/mmopen/vi_32/eKAqxPMSaoguP2nrzO2pKV3LC6SkYrbevCAvWVw4T8XKEf3A5M8QcfxJJJB3OAkd8FLDIS6csHM70knqkZ9QHg/0"},"atime":1.511851534E9,"id":"5a1d060ee7bce72d3865b736","size":1},{"reply_user":{},"reply_meta":{},"content":"花会枯萎，爱永不凋零。","isup":false,"user":{"gcid":"","name":"时过境已迁 ","title":[],"gender":0,"follower":0,"avatar":"http://q.qlogo.cn/qqapp/100428621/7DA385799292CB2F7BA2A40A5387A63C/40","viptime":9.782784E8,"following":[],"isvip":false,"id":"5397e32394e5cc6d8dab11a1"},"atime":1.511782573E9,"id":"5a1bf8ad31f6132662470de0","size":1},{"reply_user":{},"reply_meta":{},"content":"小乔","isup":false,"user":{"gcid":"","name":"智贤","title":[],"gender":1,"follower":0,"avatar":"http://q.qlogo.cn/qqapp/100428621/2615FA4EC174FA4691F04FF8A5A2D4FB/100","viptime":1.508077506E9,"following":0,"isvip":false,"id":"59e36fc29a1aa340320fb87b"},"atime":1.509791984E9,"id":"59fd98f031f613627b3e9615","size":2},{"reply_user":{},"reply_meta":{},"content":"小强，要努力变乔。","isup":false,"user":{"gcid":"","name":"◎时光◎","title":[],"gender":0,"follower":3,"avatar":"http://img0.adesk.com/download/5a13752b31f61332bec2f585","viptime":9.782784E8,"following":0,"isvip":false,"id":"577540e3742aa75993a121b9"},"atime":1.509777827E9,"id":"59fd61a30422085f832dd2dd","size":3},{"reply_user":{},"reply_meta":{},"content":"恋爱和战斗都要勇往直前","isup":false,"user":{"gcid":"","name":"嫦娥仙子","title":[],"gender":1,"follower":0,"avatar":"http://q.qlogo.cn/qqapp/100428621/B4DF280068503E766D837A0DD7A24363/100","viptime":1.506572375E9,"following":0,"isvip":false,"id":"59cc78570422085e9e424d67"},"atime":1.509751429E9,"id":"59fcfa8531f613623b8e04aa","size":3},{"reply_user":{},"reply_meta":{},"content":"小乔","isup":false,"user":{"gcid":"","follower":0,"name":"➹","viptime":1.502157783E9,"following":1,"gender":0,"title":[],"isvip":false,"id":"59891bd7042208073d4d32d6","avatar":"http://q.qlogo.cn/qqapp/100428621/EE969DE626A829E9DFF71AB837800275/100"},"atime":1.509467593E9,"id":"59f8a5c99a1aa3405bfe553f","size":4}]
     * album : [{"status":"online","ename":"","atime":1.461752826E9,"url":[],"user":{"gcid":"","name":"王月月月","gender":0,"follower":1864,"avatar":"http://img0.adesk.com/download/57b2d6a794e5cc040f79119d","viptime":9.782784E8,"following":0,"isvip":false,"id":"553def0894e5cc5642b1e88a"},"cover":"http://img5.adesk.com/5a13fa67e7bce742ecde88be?imageView2/3/h/240","name":"王者荣耀","tag":[],"sn":999,"id":"572093fa69401b2a9622828e","lcover":"http://img5.adesk.com/5a13fa67e7bce742ecde88be?imageView2/3/h/720","favs":33288,"type":1,"isfeed":false,"desc":"MOBA类手机游戏，原画设定精美，在手机上便能体验英雄联盟般的对战乐趣。"}]
     * hot : []
     * meta : {"more":false}
     * wallpaper : {"isfavor":false}
     * subject : []
     */

    private MetaBean meta;
    private WallpaperBean wallpaper;
    private List<CommentBean> comment;
    private List<BizhiAlbumBean> album;
    private List<CommentBean> hot;
    private List<?> subject;

    public MetaBean getMeta() {
        return meta;
    }

    public void setMeta(MetaBean meta) {
        this.meta = meta;
    }

    public WallpaperBean getWallpaper() {
        return wallpaper;
    }

    public void setWallpaper(WallpaperBean wallpaper) {
        this.wallpaper = wallpaper;
    }

    public List<CommentBean> getComment() {
        return comment;
    }

    public void setComment(List<CommentBean> comment) {
        this.comment = comment;
    }

    public List<BizhiAlbumBean> getAlbum() {
        return album;
    }

    public void setAlbum(List<BizhiAlbumBean> album) {
        this.album = album;
    }

    public List<CommentBean> getHot() {
        return hot;
    }

    public void setHot(List<CommentBean> hot) {
        this.hot = hot;
    }

    public List<?> getSubject() {
        return subject;
    }

    public void setSubject(List<?> subject) {
        this.subject = subject;
    }

    public static class MetaBean {
        /**
         * more : false
         */

        private boolean more;

        public boolean isMore() {
            return more;
        }

        public void setMore(boolean more) {
            this.more = more;
        }
    }

    public static class WallpaperBean {
        /**
         * isfavor : false
         */

        private boolean isfavor;

        public boolean isIsfavor() {
            return isfavor;
        }

        public void setIsfavor(boolean isfavor) {
            this.isfavor = isfavor;
        }
    }

}
