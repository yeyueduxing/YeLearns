package com.yeyue.learns.enity.movie;

import com.yeyue.learns.constant.AdapterConstant;
import com.yeyue.library.data.BaseItem;

/**
 * Created by li.xiao on 2018-1-25.
 */

public class MovieComment extends BaseItem{

    /**
     * rating : {"max":5,"value":1,"min":0}
     * useful_count : 37
     * author : {"uid":"123404248","avatar":"https://img3.doubanio.com/icon/u123404248-3.jpg","signature":"","alt":"https://www.douban.com/people/123404248/","id":"123404248","name":"世界奇妙物语"}
     * created_at : 2017-01-19 21:46:33
     * title : 国产恐怖片，注定成烂片？
     * updated_at : 2017-04-12 15:52:33
     * share_url : https://m.douban.com/movie/review/8301338
     * summary : 这一系列国产恐怖片太多，现在总结下国产电影拍摄门槛为什么这么低…… 1.找个导演，内地导演优先考虑(省钱)。 2.去网上热搜榜（也是经纪公司）上挑几个网红明星（省钱）。网红明星就像木偶一样被装扮上了。 3.去...
     * content : 这一系列国产恐怖片太多，现在总结下国产电影拍摄门槛为什么这么低……
     * 1.找个导演，内地导演优先考虑(省钱)。
     * 2.去网上热搜榜（也是经纪公司）上挑几个网红明星（省钱）。网红明星就像木偶一样被装扮上了。
     * 3.去影视学院和北漂南漂找上其他演员龙套（省钱）。
     * 4.租个摄制组，拍摄场地，演出服。（如上）
     * 5.找二三线编剧（如上）或自己操刀花上一星期把剧本凑到一部电影时长（参考网上剧本的对话）
     * 6.拍完，就剪辑成89分钟左右的电影长度。
     * 7.打包给营销公司，目标是各样马凳占领各搜索微博等阵地(电影蹭热度)。内容主题只要不反动不犯罪随便换，一小时出现在页面前3条。
     * 8.全国各地影院排档期上映了（电影院排片多于鸿毛，分成不少）。
     * 一路过来的只要遵循国家法律制度，避开行业不成文的禁区基本绿灯通过。哪怕是伦理道德，逻辑规律。不触犯法律要求也是可以放低的，导演就是上帝。
     * <p>
     * 最后总结：如果算是创作的话，除了原著用了脑力，搭上劳力，主要靠资源配置，就可以公放收钱了。
     * <p>
     * ps:国产恐怖片的组成：15%的创作+65%的钱+20%的劳力=作品
     * useless_count : 1
     * comments_count : 2
     * alt : https://movie.douban.com/review/8301338/
     * id : 8301338
     * subject_id : 26865690
     */

    private RatingBeanX rating;
    private int useful_count;
    private MovieAuthor author;
    private String created_at;
    private String title;
    private String updated_at;
    private String share_url;
    private String summary;
    private String content;
    private int useless_count;
    private int comments_count;
    private String alt;
    private String id;
    private String subject_id;

    @Override
    public int getItemType() {
        if(itemtype==0){
            return AdapterConstant.ITME_MOVIE_COMMENT_REVIEW;
        }
        return super.getItemType();
    }

    public RatingBeanX getRating() {
        return rating;
    }

    public void setRating(RatingBeanX rating) {
        this.rating = rating;
    }

    public int getUseful_count() {
        return useful_count;
    }

    public void setUseful_count(int useful_count) {
        this.useful_count = useful_count;
    }

    public MovieAuthor getAuthor() {
        return author;
    }

    public void setAuthor(MovieAuthor author) {
        this.author = author;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUseless_count() {
        return useless_count;
    }

    public void setUseless_count(int useless_count) {
        this.useless_count = useless_count;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
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

    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public static class RatingBeanX extends BaseItem{
        /**
         * max : 5
         * value : 1.0
         * min : 0
         */

        private int max;
        private float value;
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public float getValue() {
            return value;
        }

        public void setValue(float value) {
            this.value = value;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }

}
