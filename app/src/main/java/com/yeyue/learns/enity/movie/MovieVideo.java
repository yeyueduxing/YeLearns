package com.yeyue.learns.enity.movie;

import com.yeyue.library.data.BaseItem;

/**
 * Created by li.xiao on 2018-1-25.
 */
public class MovieVideo extends BaseItem{
    /**
     * source : {"literal":"qq","pic":"http://img3.doubanio.com/f/movie/38764466321ab88dfa19a1f826570367a19ce116/pics/movie/video-qq.png","name":"腾讯视频"}
     * sample_link : http://v.qq.com/x/cover/xzvr5axh7r6u524.html?ptag=douban.movie
     * video_id : xzvr5axh7r6u524
     * need_pay : false
     */

    private SourceBean source;
    private String sample_link;
    private String video_id;
    private boolean need_pay;

    public SourceBean getSource() {
        return source;
    }

    public void setSource(SourceBean source) {
        this.source = source;
    }

    public String getSample_link() {
        return sample_link;
    }

    public void setSample_link(String sample_link) {
        this.sample_link = sample_link;
    }

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public boolean isNeed_pay() {
        return need_pay;
    }

    public void setNeed_pay(boolean need_pay) {
        this.need_pay = need_pay;
    }

    public static class SourceBean extends BaseItem{
        /**
         * literal : qq
         * pic : http://img3.doubanio.com/f/movie/38764466321ab88dfa19a1f826570367a19ce116/pics/movie/video-qq.png
         * name : 腾讯视频
         */

        private String literal;
        private String pic;
        private String name;

        public String getLiteral() {
            return literal;
        }

        public void setLiteral(String literal) {
            this.literal = literal;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
