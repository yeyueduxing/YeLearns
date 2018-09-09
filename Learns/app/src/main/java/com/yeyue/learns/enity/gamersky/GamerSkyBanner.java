package com.yeyue.learns.enity.gamersky;

import com.yeyue.library.data.BaseItem;

import java.util.List;

/**
 * Created by Administrator on 2018/1/14 0014.
 */

public class GamerSkyBanner extends BaseItem{
    /**
     * type : xinwen
     * contentType : news
     * title : 《星期一的丰满》：不能随便给巫女姐姐喝酒
     * description :
     * thumbnailURLs : ["http://imgs.gamersky.com/upimg/2018/201801151007137458.jpg"]
     * authorName : 宁静海
     * authorHeadImageURL :
     * badges : []
     * readingCount : 13227
     * commentsCount : 43
     * contentId : 1002590
     * contentURL :
     * adId : 0
     * updateTime : 1.516008195E12
     * duration :
     * sourceName : null
     * childElements : null
     */

    private String type;
    private String contentType;
    private String title;
    private String description;
    private String authorName;
    private String authorHeadImageURL;
    private int readingCount;
    private int commentsCount;
    private int contentId;
    private String contentURL;
    private int adId;
    private double updateTime;
    private String duration;
    private Object sourceName;
    private List<String> thumbnailURLs;
    private List<?> badges;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorHeadImageURL() {
        return authorHeadImageURL;
    }

    public void setAuthorHeadImageURL(String authorHeadImageURL) {
        this.authorHeadImageURL = authorHeadImageURL;
    }

    public int getReadingCount() {
        return readingCount;
    }

    public void setReadingCount(int readingCount) {
        this.readingCount = readingCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public String getContentURL() {
        return contentURL;
    }

    public void setContentURL(String contentURL) {
        this.contentURL = contentURL;
    }

    public int getAdId() {
        return adId;
    }

    public void setAdId(int adId) {
        this.adId = adId;
    }

    public double getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(double updateTime) {
        this.updateTime = updateTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Object getSourceName() {
        return sourceName;
    }

    public void setSourceName(Object sourceName) {
        this.sourceName = sourceName;
    }


    public List<String> getThumbnailURLs() {
        return thumbnailURLs;
    }

    public void setThumbnailURLs(List<String> thumbnailURLs) {
        this.thumbnailURLs = thumbnailURLs;
    }

    public List<?> getBadges() {
        return badges;
    }

    public void setBadges(List<?> badges) {
        this.badges = badges;
    }

}
