package com.yeyue.learns.enity.movie;

import com.yeyue.learns.constant.AdapterConstant;
import com.yeyue.library.data.BaseItem;

import java.util.List;

/**
 * Created by li.xiao on 2018-1-27.
 */

public class MoviePhotoRequest {

    /**
     * count : 20
     * photos : [{"photos_count":12,"thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2406383762.jpg","icon":"https://img3.doubanio.com/view/photo/icon/public/p2406383762.jpg","author":{"uid":"122971558","avatar":"https://img3.doubanio.com/icon/u122971558-2.jpg","signature":"","alt":"https://www.douban.com/people/122971558/","id":"122971558","name":"轮子"},"created_at":"2016-12-18 20:14:19","album_id":"1638319514","cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2406383762.jpg","id":"2406383762","prev_photo":"2408074715","album_url":"https://movie.douban.com/subject/26865690/photos","comments_count":3,"image":"https://img3.doubanio.com/view/photo/photo/public/p2406383762.jpg","recs_count":1,"position":6,"alt":"https://movie.douban.com/photos/photo/2406383762/","album_title":"恐怖理发店(26865690)","next_photo":"2406383761","subject_id":"26865690","desc":""},{"photos_count":12,"thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2411789693.jpg","icon":"https://img3.doubanio.com/view/photo/icon/public/p2411789693.jpg","author":{"uid":"122971558","avatar":"https://img3.doubanio.com/icon/u122971558-2.jpg","signature":"","alt":"https://www.douban.com/people/122971558/","id":"122971558","name":"轮子"},"created_at":"2017-01-10 01:33:44","album_id":"1638319514","cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2411789693.jpg","id":"2411789693","prev_photo":"2411789702","album_url":"https://movie.douban.com/subject/26865690/photos","comments_count":2,"image":"https://img3.doubanio.com/view/photo/photo/public/p2411789693.jpg","recs_count":1,"position":2,"alt":"https://movie.douban.com/photos/photo/2411789693/","album_title":"恐怖理发店(26865690)","next_photo":"2408074732","subject_id":"26865690","desc":""},{"photos_count":12,"thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2408074732.jpg","icon":"https://img3.doubanio.com/view/photo/icon/public/p2408074732.jpg","author":{"uid":"122971558","avatar":"https://img3.doubanio.com/icon/u122971558-2.jpg","signature":"","alt":"https://www.douban.com/people/122971558/","id":"122971558","name":"轮子"},"created_at":"2016-12-25 21:55:25","album_id":"1638319514","cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2408074732.jpg","id":"2408074732","prev_photo":"2411789693","album_url":"https://movie.douban.com/subject/26865690/photos","comments_count":0,"image":"https://img3.doubanio.com/view/photo/photo/public/p2408074732.jpg","recs_count":0,"position":3,"alt":"https://movie.douban.com/photos/photo/2408074732/","album_title":"恐怖理发店(26865690)","next_photo":"2408074723","subject_id":"26865690","desc":""},{"photos_count":12,"thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2406383761.jpg","icon":"https://img3.doubanio.com/view/photo/icon/public/p2406383761.jpg","author":{"uid":"122971558","avatar":"https://img3.doubanio.com/icon/u122971558-2.jpg","signature":"","alt":"https://www.douban.com/people/122971558/","id":"122971558","name":"轮子"},"created_at":"2016-12-18 20:14:15","album_id":"1638319514","cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2406383761.jpg","id":"2406383761","prev_photo":"2406383762","album_url":"https://movie.douban.com/subject/26865690/photos","comments_count":1,"image":"https://img3.doubanio.com/view/photo/photo/public/p2406383761.jpg","recs_count":0,"position":7,"alt":"https://movie.douban.com/photos/photo/2406383761/","album_title":"恐怖理发店(26865690)","next_photo":"2406383759","subject_id":"26865690","desc":""},{"photos_count":12,"thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2395927771.jpg","icon":"https://img3.doubanio.com/view/photo/icon/public/p2395927771.jpg","author":{"uid":"137105855","avatar":"https://img3.doubanio.com/icon/u137105855-3.jpg","signature":"","alt":"https://www.douban.com/people/137105855/","id":"137105855","name":"小奇怪"},"created_at":"2016-11-08 18:47:38","album_id":"1638319514","cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2395927771.jpg","id":"2395927771","prev_photo":"2395927790","album_url":"https://movie.douban.com/subject/26865690/photos","comments_count":0,"image":"https://img3.doubanio.com/view/photo/photo/public/p2395927771.jpg","recs_count":0,"position":10,"alt":"https://movie.douban.com/photos/photo/2395927771/","album_title":"恐怖理发店(26865690)","next_photo":"2395927762","subject_id":"26865690","desc":""},{"photos_count":12,"thumb":"https://img1.doubanio.com/view/photo/thumb/public/p2411789707.jpg","icon":"https://img1.doubanio.com/view/photo/icon/public/p2411789707.jpg","author":{"uid":"122971558","avatar":"https://img3.doubanio.com/icon/u122971558-2.jpg","signature":"","alt":"https://www.douban.com/people/122971558/","id":"122971558","name":"轮子"},"created_at":"2017-01-10 01:33:50","album_id":"1638319514","cover":"https://img1.doubanio.com/view/photo/albumcover/public/p2411789707.jpg","id":"2411789707","prev_photo":"2395927762","album_url":"https://movie.douban.com/subject/26865690/photos","comments_count":0,"image":"https://img1.doubanio.com/view/photo/photo/public/p2411789707.jpg","recs_count":0,"position":0,"alt":"https://movie.douban.com/photos/photo/2411789707/","album_title":"恐怖理发店(26865690)","next_photo":"2411789702","subject_id":"26865690","desc":""},{"photos_count":12,"thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2411789702.jpg","icon":"https://img3.doubanio.com/view/photo/icon/public/p2411789702.jpg","author":{"uid":"122971558","avatar":"https://img3.doubanio.com/icon/u122971558-2.jpg","signature":"","alt":"https://www.douban.com/people/122971558/","id":"122971558","name":"轮子"},"created_at":"2017-01-10 01:33:46","album_id":"1638319514","cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2411789702.jpg","id":"2411789702","prev_photo":"2411789707","album_url":"https://movie.douban.com/subject/26865690/photos","comments_count":0,"image":"https://img3.doubanio.com/view/photo/photo/public/p2411789702.jpg","recs_count":0,"position":1,"alt":"https://movie.douban.com/photos/photo/2411789702/","album_title":"恐怖理发店(26865690)","next_photo":"2411789693","subject_id":"26865690","desc":""},{"photos_count":12,"thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2408074723.jpg","icon":"https://img3.doubanio.com/view/photo/icon/public/p2408074723.jpg","author":{"uid":"122971558","avatar":"https://img3.doubanio.com/icon/u122971558-2.jpg","signature":"","alt":"https://www.douban.com/people/122971558/","id":"122971558","name":"轮子"},"created_at":"2016-12-25 21:55:23","album_id":"1638319514","cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2408074723.jpg","id":"2408074723","prev_photo":"2408074732","album_url":"https://movie.douban.com/subject/26865690/photos","comments_count":0,"image":"https://img3.doubanio.com/view/photo/photo/public/p2408074723.jpg","recs_count":0,"position":4,"alt":"https://movie.douban.com/photos/photo/2408074723/","album_title":"恐怖理发店(26865690)","next_photo":"2408074715","subject_id":"26865690","desc":""},{"photos_count":12,"thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2408074715.jpg","icon":"https://img3.doubanio.com/view/photo/icon/public/p2408074715.jpg","author":{"uid":"122971558","avatar":"https://img3.doubanio.com/icon/u122971558-2.jpg","signature":"","alt":"https://www.douban.com/people/122971558/","id":"122971558","name":"轮子"},"created_at":"2016-12-25 21:55:20","album_id":"1638319514","cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2408074715.jpg","id":"2408074715","prev_photo":"2408074723","album_url":"https://movie.douban.com/subject/26865690/photos","comments_count":0,"image":"https://img3.doubanio.com/view/photo/photo/public/p2408074715.jpg","recs_count":0,"position":5,"alt":"https://movie.douban.com/photos/photo/2408074715/","album_title":"恐怖理发店(26865690)","next_photo":"2406383762","subject_id":"26865690","desc":""},{"photos_count":12,"thumb":"https://img1.doubanio.com/view/photo/thumb/public/p2406383759.jpg","icon":"https://img1.doubanio.com/view/photo/icon/public/p2406383759.jpg","author":{"uid":"122971558","avatar":"https://img3.doubanio.com/icon/u122971558-2.jpg","signature":"","alt":"https://www.douban.com/people/122971558/","id":"122971558","name":"轮子"},"created_at":"2016-12-18 20:14:11","album_id":"1638319514","cover":"https://img1.doubanio.com/view/photo/albumcover/public/p2406383759.jpg","id":"2406383759","prev_photo":"2406383761","album_url":"https://movie.douban.com/subject/26865690/photos","comments_count":0,"image":"https://img1.doubanio.com/view/photo/photo/public/p2406383759.jpg","recs_count":0,"position":8,"alt":"https://movie.douban.com/photos/photo/2406383759/","album_title":"恐怖理发店(26865690)","next_photo":"2395927790","subject_id":"26865690","desc":""},{"photos_count":12,"thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2395927790.jpg","icon":"https://img3.doubanio.com/view/photo/icon/public/p2395927790.jpg","author":{"uid":"137105855","avatar":"https://img3.doubanio.com/icon/u137105855-3.jpg","signature":"","alt":"https://www.douban.com/people/137105855/","id":"137105855","name":"小奇怪"},"created_at":"2016-11-08 18:47:41","album_id":"1638319514","cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2395927790.jpg","id":"2395927790","prev_photo":"2406383759","album_url":"https://movie.douban.com/subject/26865690/photos","comments_count":0,"image":"https://img3.doubanio.com/view/photo/photo/public/p2395927790.jpg","recs_count":0,"position":9,"alt":"https://movie.douban.com/photos/photo/2395927790/","album_title":"恐怖理发店(26865690)","next_photo":"2395927771","subject_id":"26865690","desc":""},{"photos_count":12,"thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2395927762.jpg","icon":"https://img3.doubanio.com/view/photo/icon/public/p2395927762.jpg","author":{"uid":"137105855","avatar":"https://img3.doubanio.com/icon/u137105855-3.jpg","signature":"","alt":"https://www.douban.com/people/137105855/","id":"137105855","name":"小奇怪"},"created_at":"2016-11-08 18:47:35","album_id":"1638319514","cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2395927762.jpg","id":"2395927762","prev_photo":"2395927771","album_url":"https://movie.douban.com/subject/26865690/photos","comments_count":4,"image":"https://img3.doubanio.com/view/photo/photo/public/p2395927762.jpg","recs_count":0,"position":11,"alt":"https://movie.douban.com/photos/photo/2395927762/","album_title":"恐怖理发店(26865690)","next_photo":"2411789707","subject_id":"26865690","desc":""},{"photos_count":15,"thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2406903891.jpg","icon":"https://img3.doubanio.com/view/photo/icon/public/p2406903891.jpg","author":{"uid":"137105855","avatar":"https://img3.doubanio.com/icon/u137105855-3.jpg","signature":"","alt":"https://www.douban.com/people/137105855/","id":"137105855","name":"小奇怪"},"created_at":"2016-12-20 17:39:33","album_id":"1635354581","cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2406903891.jpg","id":"2406903891","prev_photo":"2408478432","album_url":"https://movie.douban.com/subject/26865690/photos","comments_count":3,"image":"https://img3.doubanio.com/view/photo/photo/public/p2406903891.jpg","recs_count":0,"position":8,"alt":"https://movie.douban.com/photos/photo/2406903891/","album_title":"恐怖理发店(26865690)","next_photo":"2405295418","subject_id":"26865690","desc":""},{"photos_count":15,"thumb":"https://img1.doubanio.com/view/photo/thumb/public/p2405295418.jpg","icon":"https://img1.doubanio.com/view/photo/icon/public/p2405295418.jpg","author":{"uid":"122971558","avatar":"https://img3.doubanio.com/icon/u122971558-2.jpg","signature":"","alt":"https://www.douban.com/people/122971558/","id":"122971558","name":"轮子"},"created_at":"2016-12-14 17:56:37","album_id":"1635354581","cover":"https://img1.doubanio.com/view/photo/albumcover/public/p2405295418.jpg","id":"2405295418","prev_photo":"2406903891","album_url":"https://movie.douban.com/subject/26865690/photos","comments_count":7,"image":"https://img1.doubanio.com/view/photo/photo/public/p2405295418.jpg","recs_count":0,"position":9,"alt":"https://movie.douban.com/photos/photo/2405295418/","album_title":"恐怖理发店(26865690)","next_photo":"2403132067","subject_id":"26865690","desc":"《恐怖理发店》禁婆版海报"},{"photos_count":15,"thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2408825025.jpg","icon":"https://img3.doubanio.com/view/photo/icon/public/p2408825025.jpg","author":{"uid":"137105855","avatar":"https://img3.doubanio.com/icon/u137105855-3.jpg","signature":"","alt":"https://www.douban.com/people/137105855/","id":"137105855","name":"小奇怪"},"created_at":"2016-12-29 17:08:05","album_id":"1635354581","cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2408825025.jpg","id":"2408825025","prev_photo":"2410117022","album_url":"https://movie.douban.com/subject/26865690/photos","comments_count":0,"image":"https://img3.doubanio.com/view/photo/photo/public/p2408825025.jpg","recs_count":0,"position":5,"alt":"https://movie.douban.com/photos/photo/2408825025/","album_title":"恐怖理发店(26865690)","next_photo":"2408478447","subject_id":"26865690","desc":""},{"photos_count":15,"thumb":"https://img1.doubanio.com/view/photo/thumb/public/p2403132067.jpg","icon":"https://img1.doubanio.com/view/photo/icon/public/p2403132067.jpg","author":{"uid":"137105855","avatar":"https://img3.doubanio.com/icon/u137105855-3.jpg","signature":"","alt":"https://www.douban.com/people/137105855/","id":"137105855","name":"小奇怪"},"created_at":"2016-12-06 17:23:12","album_id":"1635354581","cover":"https://img1.doubanio.com/view/photo/albumcover/public/p2403132067.jpg","id":"2403132067","prev_photo":"2405295418","album_url":"https://movie.douban.com/subject/26865690/photos","comments_count":2,"image":"https://img1.doubanio.com/view/photo/photo/public/p2403132067.jpg","recs_count":0,"position":10,"alt":"https://movie.douban.com/photos/photo/2403132067/","album_title":"恐怖理发店(26865690)","next_photo":"2402461987","subject_id":"26865690","desc":""},{"photos_count":15,"thumb":"https://img1.doubanio.com/view/photo/thumb/public/p2402461987.jpg","icon":"https://img1.doubanio.com/view/photo/icon/public/p2402461987.jpg","author":{"uid":"122971558","avatar":"https://img3.doubanio.com/icon/u122971558-2.jpg","signature":"","alt":"https://www.douban.com/people/122971558/","id":"122971558","name":"轮子"},"created_at":"2016-12-04 01:31:03","album_id":"1635354581","cover":"https://img1.doubanio.com/view/photo/albumcover/public/p2402461987.jpg","id":"2402461987","prev_photo":"2403132067","album_url":"https://movie.douban.com/subject/26865690/photos","comments_count":1,"image":"https://img1.doubanio.com/view/photo/photo/public/p2402461987.jpg","recs_count":0,"position":11,"alt":"https://movie.douban.com/photos/photo/2402461987/","album_title":"恐怖理发店(26865690)","next_photo":"2394134208","subject_id":"26865690","desc":"《恐怖理发店》吞噬版海报"}]
     * total : 17
     * start : 0
     * subject : {"rating":{"max":10,"average":2.4,"details":{"1":70,"3":3,"2":5,"5":1,"4":0},"stars":"15","min":0},"genres":["爱情","悬疑","惊悚"],"title":"恐怖理发店","casts":[{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1403756298.69.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1403756298.69.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1403756298.69.jpg"},"name_en":"Guoer Yin","name":"殷果儿","alt":"https://movie.douban.com/celebrity/1340984/","id":"1340984"},{"avatars":{"small":"https://img1.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"https://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"https://img1.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name_en":"Qingan Ren","name":"任青安","alt":"https://movie.douban.com/celebrity/1359164/","id":"1359164"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1451209491.55.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1451209491.55.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1451209491.55.jpg"},"name_en":"SungGoo Kang","name":"姜星丘","alt":"https://movie.douban.com/celebrity/1353667/","id":"1353667"}],"durations":["89分钟"],"collect_count":642,"mainland_pubdate":"2017-01-06","has_video":true,"original_title":"恐怖理发店","subtype":"movie","directors":[{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1490348628.29.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1490348628.29.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1490348628.29.jpg"},"name_en":"Shilei Lu","name":"陆诗雷","alt":"https://movie.douban.com/celebrity/1360707/","id":"1360707"}],"pubdates":["2017-01-06(中国大陆)"],"year":"2017","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2406903891.jpg","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2406903891.jpg","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2406903891.jpg"},"alt":"https://movie.douban.com/subject/26865690/","id":"26865690"}
     */

    private int count;
    private int total;
    private int start;
    private MovieBean subject;
    private List<PhotosBean> photos;
    private List<MovieComment> reviews;
    private List<MovieComment> comments;

    public List<MovieComment> getReviews() {
        return reviews;
    }

    public void setReviews(List<MovieComment> reviews) {
        this.reviews = reviews;
    }

    public List<MovieComment> getComments() {
        return comments;
    }

    public void setComments(List<MovieComment> comments) {
        this.comments = comments;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public MovieBean getSubject() {
        return subject;
    }

    public void setSubject(MovieBean subject) {
        this.subject = subject;
    }

    public List<PhotosBean> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotosBean> photos) {
        this.photos = photos;
    }

    public static class PhotosBean extends BaseItem{
        /**
         * photos_count : 12
         * thumb : https://img3.doubanio.com/view/photo/thumb/public/p2406383762.jpg
         * icon : https://img3.doubanio.com/view/photo/icon/public/p2406383762.jpg
         * author : {"uid":"122971558","avatar":"https://img3.doubanio.com/icon/u122971558-2.jpg","signature":"","alt":"https://www.douban.com/people/122971558/","id":"122971558","name":"轮子"}
         * created_at : 2016-12-18 20:14:19
         * album_id : 1638319514
         * cover : https://img3.doubanio.com/view/photo/albumcover/public/p2406383762.jpg
         * id : 2406383762
         * prev_photo : 2408074715
         * album_url : https://movie.douban.com/subject/26865690/photos
         * comments_count : 3
         * image : https://img3.doubanio.com/view/photo/photo/public/p2406383762.jpg
         * recs_count : 1
         * position : 6
         * alt : https://movie.douban.com/photos/photo/2406383762/
         * album_title : 恐怖理发店(26865690)
         * next_photo : 2406383761
         * subject_id : 26865690
         * desc :
         */

        private int photos_count;
        private String thumb;
        private String icon;
        private MovieAuthor author;
        private String created_at;
        private String album_id;
        private String cover;
        private String id;
        private String prev_photo;
        private String album_url;
        private int comments_count;
        private String image;
        private int recs_count;
        private int position;
        private String alt;
        private String album_title;
        private String next_photo;
        private String subject_id;
        private String desc;

        @Override
        public int getItemType() {
            return AdapterConstant.ITME_MOVIE_PHOTO_DEFAULT;
        }

        public int getPhotos_count() {
            return photos_count;
        }

        public void setPhotos_count(int photos_count) {
            this.photos_count = photos_count;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
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

        public String getAlbum_id() {
            return album_id;
        }

        public void setAlbum_id(String album_id) {
            this.album_id = album_id;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPrev_photo() {
            return prev_photo;
        }

        public void setPrev_photo(String prev_photo) {
            this.prev_photo = prev_photo;
        }

        public String getAlbum_url() {
            return album_url;
        }

        public void setAlbum_url(String album_url) {
            this.album_url = album_url;
        }

        public int getComments_count() {
            return comments_count;
        }

        public void setComments_count(int comments_count) {
            this.comments_count = comments_count;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getRecs_count() {
            return recs_count;
        }

        public void setRecs_count(int recs_count) {
            this.recs_count = recs_count;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getAlbum_title() {
            return album_title;
        }

        public void setAlbum_title(String album_title) {
            this.album_title = album_title;
        }

        public String getNext_photo() {
            return next_photo;
        }

        public void setNext_photo(String next_photo) {
            this.next_photo = next_photo;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
