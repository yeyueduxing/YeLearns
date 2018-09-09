package com.yeyue.learns.enity.bizhi;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
  *@describe 用户详情页
  *@author li.xiao
  *@time 2017-12-7 10:46
  */
public class UserDetail {
    /**
     * migrated : true
     * super : false
     * is_follow : false
     * rank : 1049
     * follower : 4450
     * open : {}
     * id : 5965cd0be7bce7312ef79fbf
     * title : []
     * viptime : 1.499843851E9
     * visit : 192839
     * score : {"score":1049,"level":"LV.8"}
     * snlimit : 100w+
     * avatar : http://img0.adesk.com/download/59cf77ec0422085f6f76f58d
     * isvip : false
     * auth : adesk
     * medal : [{"desc":"累积在安卓壁纸内下载了1个广告APP","icon":"http://s.adesk.com/achieve/medal/pengchangwang.png?v=2","name":"捧场王","id":"56415a6b2d74c81c782af609"}]
     * desc :
     * name : 一念夕雾
     * artist : false
     * gender : 1
     * sn : 0
     * following : 0
     */

    private boolean migrated;
    @SerializedName("super")
    private boolean superX;
    private boolean is_follow;
    private int rank;
    private int follower;
    private OpenBean open;
    private String id;
    private double viptime;
    private int visit;
    private ScoreBean score;
    private String snlimit;
    private String avatar;
    private boolean isvip;
    private String auth;
    private String desc;
    private String name;
    private boolean artist;
    private String gender;
    private int sn;
    private int following;
    private List<?> title;
    private List<MedalBean> medal;

    public boolean isMigrated() {
        return migrated;
    }

    public void setMigrated(boolean migrated) {
        this.migrated = migrated;
    }

    public boolean isSuperX() {
        return superX;
    }

    public void setSuperX(boolean superX) {
        this.superX = superX;
    }

    public boolean isIs_follow() {
        return is_follow;
    }

    public void setIs_follow(boolean is_follow) {
        this.is_follow = is_follow;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getFollower() {
        return follower;
    }

    public void setFollower(int follower) {
        this.follower = follower;
    }

    public OpenBean getOpen() {
        return open;
    }

    public void setOpen(OpenBean open) {
        this.open = open;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getViptime() {
        return viptime;
    }

    public void setViptime(double viptime) {
        this.viptime = viptime;
    }

    public int getVisit() {
        return visit;
    }

    public void setVisit(int visit) {
        this.visit = visit;
    }

    public ScoreBean getScore() {
        return score;
    }

    public void setScore(ScoreBean score) {
        this.score = score;
    }

    public String getSnlimit() {
        return snlimit;
    }

    public void setSnlimit(String snlimit) {
        this.snlimit = snlimit;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isIsvip() {
        return isvip;
    }

    public void setIsvip(boolean isvip) {
        this.isvip = isvip;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isArtist() {
        return artist;
    }

    public void setArtist(boolean artist) {
        this.artist = artist;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSn() {
        return sn;
    }

    public void setSn(int sn) {
        this.sn = sn;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public List<?> getTitle() {
        return title;
    }

    public void setTitle(List<?> title) {
        this.title = title;
    }

    public List<MedalBean> getMedal() {
        return medal;
    }

    public void setMedal(List<MedalBean> medal) {
        this.medal = medal;
    }

    public static class OpenBean {
    }

    public static class ScoreBean {
        /**
         * score : 1049
         * level : LV.8
         */

        private int score;
        private String level;

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }
    }

    public static class MedalBean {
        /**
         * desc : 累积在安卓壁纸内下载了1个广告APP
         * icon : http://s.adesk.com/achieve/medal/pengchangwang.png?v=2
         * name : 捧场王
         * id : 56415a6b2d74c81c782af609
         */

        private String desc;
        private String icon;
        private String name;
        private String id;

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
