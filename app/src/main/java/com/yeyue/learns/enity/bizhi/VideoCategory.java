package com.yeyue.learns.enity.bizhi;

import com.yeyue.learns.constant.AdapterConstant;
import com.yeyue.library.data.BaseItem;

/**
  *@describe 壁纸分类
  *@author Administrator
  *@time 2017/11/4 0004 下午 8:56
  */
public class VideoCategory extends BaseItem{
    /**
     * name : 动漫新番
     * img : http://cdn.video.picasso.dandanjiang.tv/category/5930e065e7bce72ce01371b1.jpg?newver=0.586839705053&sign=e0002d167f17c037a13e55b8ef197cda&t=5a0420a8
     * clickurl : http://service.videowp.adesk.com/v1/analytics?id=5930e065e7bce72ce01371b1&type=categoryclick
     * cover : http://cdn.video.picasso.dandanjiang.tv/category/5930e065e7bce72ce01371b1.jpg?newver=0.586839705053&sign=e0002d167f17c037a13e55b8ef197cda&t=5a0420a8
     * type : 31
     * id : 5930e065e7bce72ce01371b1
     */

    private String name;
    private String img;
    private String clickurl;
    private String cover;
    private int type;
    private String id;

    @Override
    public int getItemType() {
        return AdapterConstant.ITEM_BIZHI_VIDEO_CATEGORY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
