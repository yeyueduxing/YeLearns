package com.yeyue.learns.enity.movie;

/**
 * Created by li.xiao on 2018-1-25.
 */
public class MovieTrailer {
    /**
     * medium : http://img3.doubanio.com/img/trailer/medium/2395934439.jpg?
     * title : 预告片：正式版 (中文字幕)
     * subject_id : 26865690
     * alt : https://movie.douban.com/trailer/206905/
     * small : http://img3.doubanio.com/img/trailer/small/2395934439.jpg?
     * resource_url : http://vt1.doubanio.com/201801251609/f2cd87f982918f00b758907107341fd6/view/movie/M/302060905.mp4
     * id : 206905
     */

    private String medium;
    private String title;
    private String subject_id;
    private String alt;
    private String small;
    private String resource_url;
    private String id;

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getResource_url() {
        return resource_url;
    }

    public void setResource_url(String resource_url) {
        this.resource_url = resource_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
