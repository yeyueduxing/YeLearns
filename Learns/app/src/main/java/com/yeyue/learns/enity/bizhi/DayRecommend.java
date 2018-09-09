package com.yeyue.learns.enity.bizhi;

import com.yeyue.library.data.BaseItem;

import java.util.List;

/**
 * Created by Administrator on 2017/11/4 0004.
 */

public class DayRecommend extends BaseItem{
    /**
     * items : [{"notice":"1、【新增】首页新增美女、动漫，更丰富的图片资源。\r\n2、【优化】新版本更流畅，快来更新体验吧。","code":177,"force":[],"name":"5.7.7","title":"有新版本，快来更新吧","url":"http://s.adesk.com/apk/Androidesk-release-androidesk.apk","_id":"599d563fe7bce729500bb926","fnotice":"","atime":1.503483455E9,"id":"599d563fe7bce729500bb926"}]
     * type : 14
     * title : 版本更新
     * stime : 1.509724981E12
     * hometype : chosen
     */

    private int type;
    private String title;
    private long stime;
    private String hometype;
    private List<BizhiBean> items;
    private boolean hasMore;
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

    public long getStime() {
        return stime;
    }

    public void setStime(long stime) {
        this.stime = stime;
    }

    public String getHometype() {
        return hometype;
    }

    public void setHometype(String hometype) {
        this.hometype = hometype;
    }

    public List<BizhiBean> getItems() {
        return items;
    }

    public void setItems(List<BizhiBean> items) {
        this.items = items;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }
}
