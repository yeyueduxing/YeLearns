package com.yeyue.library.data;

import com.yeyue.library.constant.YeSkinConstant;

import java.util.List;

/**
  *@describe 皮肤属性
  *@author li.xiao
  *@time 2017-12-20 17:31
  */
public class YeSkinItem extends BaseItem{
    /**
     * id : 1569
     * createdTime : 1512526325000
     * updateTime : 1512526325000
     * name : 李宇春
     * title : 专辑购买专享
     * type : album_1
     * description : 春春金碟，智造流行。
     * coverPic : http://kwimg1.kuwo.cn/star/newvip/theme/cover/1509705844560.jpg
     * size : 705185
     * corner : no
     * resourcePath : http://kwimg4.kuwo.cn/star/newvip/theme/resource/ar/1509705884790.zip
     * resourcePath1 : null
     * size1 : null
     * platform : ar
     * version : V4
     * sortName : lyc
     * color : #ffa000
     * redirectUrl : album_1
     * createTimeStr : 2017-12-06 10:12
     * showTimeStr : 2017-11-07 10:00
     * isDelStr : 已上线
     * typeStr : 专辑
     * redirectUrlStr :
     * pageTitle :
     */

    private int id;
    private String name;
    private String title;
    private String type;
    private String description;
    private String coverPic;
    private int coverRes;
    private int size;
    private String resourcePath;
    private String resourceName;
    private String color;
    private String typeStr;
    private String sortName;
    private List<String> preViews;
    private boolean used;
    @Override
    public int getItemType() {
        if(itemtype==0){
            return YeSkinConstant.YE_ITEM_SKIN_ONLINE;
        }
        return super.getItemType();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverPic() {
        return coverPic;
    }

    public void setCoverPic(String coverPic) {
        this.coverPic = coverPic;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTypeStr() {
        return typeStr;
    }

    public void setTypeStr(String typeStr) {
        this.typeStr = typeStr;
    }

    public List<String> getPreViews() {
        return preViews;
    }

    public void setPreViews(List<String> preViews) {
        this.preViews = preViews;
    }

    public int getCoverRes() {
        return coverRes;
    }

    public void setCoverRes(int coverRes) {
        this.coverRes = coverRes;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }
}
