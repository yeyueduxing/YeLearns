package com.yeyue.learns.enity.bizhi;

import com.yeyue.learns.constant.AdapterConstant;
import com.yeyue.library.data.BaseItem;

/**
 * Created by li.xiao on 2017-12-5.
 */

public class CommentBean extends BaseItem{
    /**
     * reply_user : {}
     * reply_meta : {}
     * content : 小乔  要努力变强
     * isup : false
     * user : {"gcid":"","follower":0,"name":"可爱的小兔子520","viptime":1.511778001E9,"following":0,"gender":1,"title":[],"isvip":false,"id":"5a1be6d1e7bce72cb17ad53b","avatar":"http://wx.qlogo.cn/mmopen/vi_32/eKAqxPMSaoguP2nrzO2pKV3LC6SkYrbevCAvWVw4T8XKEf3A5M8QcfxJJJB3OAkd8FLDIS6csHM70knqkZ9QHg/0"}
     * atime : 1.511851534E9
     * id : 5a1d060ee7bce72d3865b736
     * size : 1
     */

    private ReplyUserBean reply_user;
    private ReplyMetaBean reply_meta;
    private String content;
    private boolean isup;
    private UserBean user;
    private double atime;
    private String id;
    private int size;

    @Override
    public int getItemType() {
        return AdapterConstant.ITEM_BIZHI_COMMENT_DEFAULT;
    }

    public ReplyUserBean getReply_user() {
        return reply_user;
    }

    public void setReply_user(ReplyUserBean reply_user) {
        this.reply_user = reply_user;
    }

    public ReplyMetaBean getReply_meta() {
        return reply_meta;
    }

    public void setReply_meta(ReplyMetaBean reply_meta) {
        this.reply_meta = reply_meta;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isIsup() {
        return isup;
    }

    public void setIsup(boolean isup) {
        this.isup = isup;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public double getAtime() {
        return atime;
    }

    public void setAtime(double atime) {
        this.atime = atime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static class ReplyUserBean {
        private String gcid;
        private String name;
        private int gender;
        private int follower;
        private String avatar;
        private int viptime;
        private boolean isvip;
        private String id;

        public String getGcid() {
            return gcid;
        }

        public void setGcid(String gcid) {
            this.gcid = gcid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getFollower() {
            return follower;
        }

        public void setFollower(int follower) {
            this.follower = follower;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public int getViptime() {
            return viptime;
        }

        public void setViptime(int viptime) {
            this.viptime = viptime;
        }
        public boolean isIsvip() {
            return isvip;
        }

        public void setIsvip(boolean isvip) {
            this.isvip = isvip;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class ReplyMetaBean {
        private String parent_id;
        private String comment_id;
        private String uid;

        public String getParent_id() {
            return parent_id;
        }

        public void setParent_id(String parent_id) {
            this.parent_id = parent_id;
        }

        public String getComment_id() {
            return comment_id;
        }

        public void setComment_id(String comment_id) {
            this.comment_id = comment_id;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }
    }
}
