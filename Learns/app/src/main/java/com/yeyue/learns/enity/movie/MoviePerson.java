package com.yeyue.learns.enity.movie;

import com.yeyue.learns.constant.AdapterConstant;
import com.yeyue.library.data.BaseItem;

/**
 * Created by li.xiao on 2018-1-25.
 */

public class MoviePerson extends BaseItem {

    /**
     * avatars : {"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1359895311.0.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1359895311.0.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1359895311.0.jpg"}
     * name_en : Ziyi Zhang
     * name : 章子怡
     * alt : https://movie.douban.com/celebrity/1041014/
     * id : 1041014
     */

    private MovieImage avatars;
    private String name_en;
    private String name;
    private String alt;
    private String id;
    private String role = "演员";
    public int getItemType() {
        return AdapterConstant.ITME_MOVIE_PERSONAL_DEFAULT;
    }
    public MovieImage getAvatars() {
        return avatars;
    }

    public void setAvatars(MovieImage avatars) {
        this.avatars = avatars;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
