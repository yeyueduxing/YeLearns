package com.yeyue.learns.enity.bizhi;

import com.yeyue.library.data.BaseItem;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;

/**
 * Created by li.xiao on 2017-12-18.
 */

@Entity
public class DetailBean extends BaseItem{

    @Id(autoincrement = true)
    private Long detailId;
    @Transient
    private UserBean user;
    private String id;
    private int favs;
    private int rank;
    private String cover;
    private String thumb;
    private int type;
    @Transient
    private boolean isFollow;
    @Generated(hash = 1305577806)
    public DetailBean(Long detailId, String id, int favs, int rank, String cover,
            String thumb, int type) {
        this.detailId = detailId;
        this.id = id;
        this.favs = favs;
        this.rank = rank;
        this.cover = cover;
        this.thumb = thumb;
        this.type = type;
    }

    @Generated(hash = 610650804)
    public DetailBean() {
    }
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFavs() {
        return favs;
    }

    public void setFavs(int favs) {
        this.favs = favs;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public Long getDetailId() {
        return this.detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }
}
