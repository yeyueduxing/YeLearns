package com.yeyue.learns.enity.movie;

import com.yeyue.learns.constant.AdapterConstant;
import com.yeyue.library.data.BaseItem;

/**
 * Created by li.xiao on 2017-9-1.
 */

public class MovieImage extends BaseItem{
    /**
     * thumb : http://img3.doubanio.com/view/photo/thumb/public/p2411789693.jpg
     * image : http://img3.doubanio.com/view/photo/photo/public/p2411789693.jpg
     * cover : http://img3.doubanio.com/view/photo/albumcover/public/p2411789693.jpg
     * alt : https://movie.douban.com/photos/photo/2411789693/
     * id : 2411789693
     * icon : http://img3.doubanio.com/view/photo/icon/public/p2411789693.jpg
     */
    /**
     * small : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2507572275.jpg
     * large : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2507572275.jpg
     * medium : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2507572275.jpg
     */

    private String small;
    private String large;
    private String medium;
    private String thumb;
    private String image;
    private String cover;
    private String alt;
    private String id;
    private String icon;
    private String subjectId;
    @Override
    public int getItemType() {
        return AdapterConstant.ITME_MOVIE_IMAGE_DEFAULT;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }
}
