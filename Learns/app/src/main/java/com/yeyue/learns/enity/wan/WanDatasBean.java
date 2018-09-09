package com.yeyue.learns.enity.wan;

import com.yeyue.learns.constant.AdapterConstant;
import com.yeyue.library.data.BaseItem;

/**
 * Created by li.xiao on 2018-2-26.
 */
public class WanDatasBean extends BaseItem{
    /**
     * apkLink :
     * author : guoxiaoxing
     * chapterId : 316
     * chapterName : 系统源码分析
     * collect : false
     * courseId : 13
     * desc : Android 7.0 源码分析项目一期竣工啦~细分版本：N6F26U；分支：android-7.1.1_r28；版本：Nougat
     * envelopePic : http://www.wanandroid.com/blogimgs/c88958f2-b7eb-4559-95c4-feec3c52a55e.png
     * id : 2410
     * link : http://www.wanandroid.com/blog/show/2051
     * niceDate : 5小时前
     * origin :
     * projectLink : https://github.com/guoxiaoxing/android-open-source-project-analysis
     * publishTime : 1519613090000
     * title : Android 7.0 源码分析项目一期竣工啦
     * visible : 1
     * zan : 0
     */

    private String apkLink;
    private String author;
    private int chapterId;
    private String chapterName;
    private boolean collect;
    private int courseId;
    private String desc;
    private String envelopePic;
    private int id;
    private String link;
    private String niceDate;
    private String origin;
    private String projectLink;
    private long publishTime;
    private String title;
    private int visible;
    private int zan;

    @Override
    public int getItemType() {
        return AdapterConstant.ITEM_WAN_DATA_DEFAULT;
    }

    public String getApkLink() {
        return apkLink;
    }

    public void setApkLink(String apkLink) {
        this.apkLink = apkLink;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public boolean isCollect() {
        return collect;
    }

    public void setCollect(boolean collect) {
        this.collect = collect;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getEnvelopePic() {
        return envelopePic;
    }

    public void setEnvelopePic(String envelopePic) {
        this.envelopePic = envelopePic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getNiceDate() {
        return niceDate;
    }

    public void setNiceDate(String niceDate) {
        this.niceDate = niceDate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getProjectLink() {
        return projectLink;
    }

    public void setProjectLink(String projectLink) {
        this.projectLink = projectLink;
    }

    public long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(long publishTime) {
        this.publishTime = publishTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public int getZan() {
        return zan;
    }

    public void setZan(int zan) {
        this.zan = zan;
    }
}
