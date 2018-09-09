package com.yeyue.learns.enity.diycode;

import com.yeyue.library.data.BaseItem;

/**
 * Created by li.xiao on 2018-1-5.
 */

public class DiyTopContent extends BaseItem{

    /**
     * id : 1023
     * title : AndroidStudio (3.x 版本) 的输入法之坑
     * created_at : 2017-11-25T23:38:54.265+08:00
     * updated_at : 2017-11-29T13:43:41.074+08:00
     * replied_at : null
     * replies_count : 0
     * node_name : Android
     * node_id : 1
     * last_reply_user_id : null
     * last_reply_user_login : null
     * user : {"id":30,"login":"d_clock","name":"D_clock爱吃葱花","avatar_url":"https://diycode.b0.upaiyun.com/user/large_avatar/30.jpg"}
     * deleted : false
     * excellent : false
     * abilities : {"update":false,"destroy":false}
     * body : > 本文记录一下，我从AndroidStudio 2.3.3升级到3.0，再升级到3.0.1一路上遇到的输入法之坑以及解决方案。

     前些天把AndroidStudio从2.3.3升级到3.0，遇到了不少坑，其中一个巨坑就是输入中文不提示的问题。面对这个bug表示真的好捉鸡啊，所幸借助Google大法在CSDN上搜到一位老哥提供的[解决方案](http://blog.csdn.net/zhou_anzhuojinjie/article/details/78402503)。

     ![](https://diycode.b0.upaiyun.com/photo/2017/1e69a346dbe77949b8d00807a9acbd9b.png)

     看了相关一些文章说IntelliJ IDEA本身就有这个坑，解决方案就是copy替换安装目录下的jre文件就行了，上面这位老哥想到AS和IDEA是一脉相承的，于是直接照着套路试了一下，结果还真可以。就这样，就可以愉快的继续用AndroidStudio写Bug了。。。。。说错，是写代码。

     然而今天AndroidStudio给我推送稳定版本的3.0.1，下面是它的新版更新提示语

     ![](https://diycode.b0.upaiyun.com/photo/2017/cb419abea07a8f2dce24fb3dbde1e203.png)

     收到更新提示我真的好鸡冻，赶忙点了更新升级，嗯，下载，升级，重启AS，报错了。。。。。。。一个大大的弹窗提示了几种Exception，有点欲哭无泪，本来3.0是有些坑，就是用起来不怎么顺手而已，现在升级3.0.1，彻底用不了了。找了几种办法尝试都不凑效，只能重装AndroidStudio，到官网下了最新的3.0.1版本，安装完后可以正常使用了，但是输入中文又没有提示了，这让我很是尴尬。于是，我又去重新解压覆盖前面所提到的jre目录，重启AS之后，发现和刚刚升级AS重启报错的内容一样。好吧，找到坑在哪里了，为了让AS能够正常使用，只能先不覆盖jre目录。

     现在需要重新找方法让AS能够输入中文，发现翻来翻去就是那么几个覆盖jre的方案，无奈只能搜一下IntelliJ IDEA的资料，看看是否有其他套路可以借鉴

     ![](https://diycode.b0.upaiyun.com/photo/2017/ce54c253da4be00d98347a4246099c48.png)

     > https://youtrack.jetbrains.com/issue/JRE-412

     翻到上面这个帖子，国内的网友们反馈了各种case，以及一些权宜之计作为解决方法，需要的同学可以翻看。看帖子说明里，IntelliJ IDEA官方已经标记在哪个版本fix了，但是AndroidStudio什么时候fix就不知道了。

     嗯，以上就是对输入法之坑的吐槽，最后来分享一下输入法问题的处理方案：

     - **如果你还在2.3.x的环境下开发，为了避免输入法问题，建议你暂时不要升级到3.x；**
     - **如果你想从2.3.x升级使用3.x，那么不建议你使用替换jre的方式去处理输入法问题，因为操作起来比较繁琐，后面升级的时候你还得注意替换回原来的jre，否则升级后将无法正常使用AS，最简单的方式是在使用AndroidStudio的时候切换到Windows自带的中文输入法即可，相对而言，这样会方便很多，但可能就没有第三方输入法用起来那么顺手；**

     现在写Android代码，连升级个IDE都这么累。感觉要转行了都，转Python开发好？还是小程序好？貌似最近人工智能又很火啊？嗯，算了，还是回家卖水果吧！！！！！！！！！！！！！！！！！！！！！！

     ​![](https://diycode.b0.upaiyun.com/photo/2017/b924764bde9914b4fb7b2a752ecbb4ce.gif)

     * body_html : <blockquote>
     <p>本文记录一下，我从AndroidStudio 2.3.3升级到3.0，再升级到3.0.1一路上遇到的输入法之坑以及解决方案。</p>
     </blockquote>

     <p>前些天把AndroidStudio从2.3.3升级到3.0，遇到了不少坑，其中一个巨坑就是输入中文不提示的问题。面对这个bug表示真的好捉鸡啊，所幸借助Google大法在CSDN上搜到一位老哥提供的<a href="http://blog.csdn.net/zhou_anzhuojinjie/article/details/78402503" target="_blank">解决方案</a>。</p>

     <p><img src="https://diycode.b0.upaiyun.com/photo/2017/1e69a346dbe77949b8d00807a9acbd9b.png" title="" alt=""></p>

     <p>看了相关一些文章说IntelliJ IDEA本身就有这个坑，解决方案就是copy替换安装目录下的jre文件就行了，上面这位老哥想到AS和IDEA是一脉相承的，于是直接照着套路试了一下，结果还真可以。就这样，就可以愉快的继续用AndroidStudio写Bug了。。。。。说错，是写代码。</p>

     <p>然而今天AndroidStudio给我推送稳定版本的3.0.1，下面是它的新版更新提示语</p>

     <p><img src="https://diycode.b0.upaiyun.com/photo/2017/cb419abea07a8f2dce24fb3dbde1e203.png" title="" alt=""></p>

     <p>收到更新提示我真的好鸡冻，赶忙点了更新升级，嗯，下载，升级，重启AS，报错了。。。。。。。一个大大的弹窗提示了几种Exception，有点欲哭无泪，本来3.0是有些坑，就是用起来不怎么顺手而已，现在升级3.0.1，彻底用不了了。找了几种办法尝试都不凑效，只能重装AndroidStudio，到官网下了最新的3.0.1版本，安装完后可以正常使用了，但是输入中文又没有提示了，这让我很是尴尬。于是，我又去重新解压覆盖前面所提到的jre目录，重启AS之后，发现和刚刚升级AS重启报错的内容一样。好吧，找到坑在哪里了，为了让AS能够正常使用，只能先不覆盖jre目录。</p>

     <p>现在需要重新找方法让AS能够输入中文，发现翻来翻去就是那么几个覆盖jre的方案，无奈只能搜一下IntelliJ IDEA的资料，看看是否有其他套路可以借鉴</p>

     <p><img src="https://diycode.b0.upaiyun.com/photo/2017/ce54c253da4be00d98347a4246099c48.png" title="" alt=""></p>

     <blockquote>
     <p><a href="https://youtrack.jetbrains.com/issue/JRE-412" rel="nofollow" target="_blank">https://youtrack.jetbrains.com/issue/JRE-412</a></p>
     </blockquote>

     <p>翻到上面这个帖子，国内的网友们反馈了各种case，以及一些权宜之计作为解决方法，需要的同学可以翻看。看帖子说明里，IntelliJ IDEA官方已经标记在哪个版本fix了，但是AndroidStudio什么时候fix就不知道了。</p>

     <p>嗯，以上就是对输入法之坑的吐槽，最后来分享一下输入法问题的处理方案：</p>

     <ul>
     <li><strong>如果你还在2.3.x的环境下开发，为了避免输入法问题，建议你暂时不要升级到3.x；</strong></li>
     <li><strong>如果你想从2.3.x升级使用3.x，那么不建议你使用替换jre的方式去处理输入法问题，因为操作起来比较繁琐，后面升级的时候你还得注意替换回原来的jre，否则升级后将无法正常使用AS，最简单的方式是在使用AndroidStudio的时候切换到Windows自带的中文输入法即可，相对而言，这样会方便很多，但可能就没有第三方输入法用起来那么顺手；</strong></li>
     </ul>

     <p>现在写Android代码，连升级个IDE都这么累。感觉要转行了都，转Python开发好？还是小程序好？貌似最近人工智能又很火啊？嗯，算了，还是回家卖水果吧！！！！！！！！！！！！！！！！！！！！！！</p>

     <p>​<img src="https://diycode.b0.upaiyun.com/photo/2017/b924764bde9914b4fb7b2a752ecbb4ce.gif" title="" alt=""></p>
     * hits : 350
     * likes_count : 2
     * suggested_at : null
     * followed : null
     * liked : null
     * favorited : null
     */

    private int id;
    private String title;
    private String created_at;
    private String updated_at;
    private Object replied_at;
    private int replies_count;
    private String node_name;
    private int node_id;
    private Object last_reply_user_id;
    private Object last_reply_user_login;
    private DiyUser user;
    private boolean deleted;
    private boolean excellent;
    private DiyAblities abilities;
    private String body;
    private String body_html;
    private int hits;
    private int likes_count;
    private Object suggested_at;
    private Object followed;
    private Object liked;
    private Object favorited;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public Object getReplied_at() {
        return replied_at;
    }

    public void setReplied_at(Object replied_at) {
        this.replied_at = replied_at;
    }

    public int getReplies_count() {
        return replies_count;
    }

    public void setReplies_count(int replies_count) {
        this.replies_count = replies_count;
    }

    public String getNode_name() {
        return node_name;
    }

    public void setNode_name(String node_name) {
        this.node_name = node_name;
    }

    public int getNode_id() {
        return node_id;
    }

    public void setNode_id(int node_id) {
        this.node_id = node_id;
    }

    public Object getLast_reply_user_id() {
        return last_reply_user_id;
    }

    public void setLast_reply_user_id(Object last_reply_user_id) {
        this.last_reply_user_id = last_reply_user_id;
    }

    public Object getLast_reply_user_login() {
        return last_reply_user_login;
    }

    public void setLast_reply_user_login(Object last_reply_user_login) {
        this.last_reply_user_login = last_reply_user_login;
    }

    public DiyUser getUser() {
        return user;
    }

    public void setUser(DiyUser user) {
        this.user = user;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isExcellent() {
        return excellent;
    }

    public void setExcellent(boolean excellent) {
        this.excellent = excellent;
    }

    public DiyAblities getAbilities() {
        return abilities;
    }

    public void setAbilities(DiyAblities abilities) {
        this.abilities = abilities;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody_html() {
        return body_html;
    }

    public void setBody_html(String body_html) {
        this.body_html = body_html;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(int likes_count) {
        this.likes_count = likes_count;
    }

    public Object getSuggested_at() {
        return suggested_at;
    }

    public void setSuggested_at(Object suggested_at) {
        this.suggested_at = suggested_at;
    }

    public Object getFollowed() {
        return followed;
    }

    public void setFollowed(Object followed) {
        this.followed = followed;
    }

    public Object getLiked() {
        return liked;
    }

    public void setLiked(Object liked) {
        this.liked = liked;
    }

    public Object getFavorited() {
        return favorited;
    }

    public void setFavorited(Object favorited) {
        this.favorited = favorited;
    }
}
