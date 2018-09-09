package com.yeyue.learns.ui.main.adapter;

/**
 * Created by li.xiao on 2017-9-25.
 */

import com.yeyue.learns.R;
import com.yeyue.learns.constant.AdapterConstant;

import java.util.HashMap;
import java.util.Map;

/**
  *@describe Adapter映射关系，
  *@author li.xiao
  *@time 2017-9-25 16:17
  */
public class AdapterShine{
    public static Map<Integer,Integer> fetchAdapterMap(){
        Map<Integer,Integer> maps = new HashMap<>();
        /*DiyCode*/
        maps.put(AdapterConstant.ITEM_DIY_TOPIC_DEFAULT, R.layout.item_diy_topic_default);
        maps.put(AdapterConstant.ITEM_DIY_TOPIC_REPLAY, R.layout.item_diy_topic_replay);
        maps.put(AdapterConstant.ITEM_DIY_NEW_DEFAULT, R.layout.item_diy_new_default);
        maps.put(AdapterConstant.ITEM_DIY_SITE_DEFAULT, R.layout.item_diy_site_default);
        maps.put(AdapterConstant.ITEM_DIY_SITE_LIST, R.layout.item_diy_site_list);
        maps.put(AdapterConstant.ITEM_DIY_USER_DEFAULT, R.layout.item_diy_user_default);

        /*Gank*/
        maps.put(AdapterConstant.ITEM_GANK_DATA_DEFAULT, R.layout.item_gank_data_default);
        maps.put(AdapterConstant.ITEM_GANK_DATA_FULI, R.layout.item_gank_data_fuli);
        maps.put(AdapterConstant.ITEM_GANK_FULI_DEFAULT, R.layout.item_gank_fuli_default);
        maps.put(AdapterConstant.ITEM_GANK_DATA_DAY, R.layout.item_gank_data_day);

        /*WeChat*/
        maps.put(AdapterConstant.ITEM_WECHAT_DEFAULT, R.layout.item_wechat_default);
        maps.put(AdapterConstant.ITEM_WECHAT_NEW_TAG, R.layout.item_wechat_new_tag);

        /*GamerSky*/
        maps.put(AdapterConstant.ITEM_GAMERSKY_DEFAULT, R.layout.item_gamersky_default);

        /*Main*/
        maps.put(AdapterConstant.ITEM_LOADTYPE_DEFAULT, R.layout.yeyue_item_loadtype_default);

        /*Movie*/
        maps.put(AdapterConstant.ITME_MOVIE_DEFAULT, R.layout.item_movie_default);
        maps.put(AdapterConstant.ITME_MOVIE_CATE_GORY, R.layout.item_movie_cate_gory);
        maps.put(AdapterConstant.ITME_MOVIE_PERSONAL_LIST, R.layout.item_movie_recycleview);
        maps.put(AdapterConstant.ITME_MOVIE_PERSONAL_DEFAULT, R.layout.item_movie_person_default);
        maps.put(AdapterConstant.ITME_MOVIE_IMAGE_DEFAULT, R.layout.item_movie_image_default);
        maps.put(AdapterConstant.ITME_MOVIE_COMMENT_REVIEW, R.layout.item_movie_comment_review);
        maps.put(AdapterConstant.ITME_MOVIE_COMMENT_DEFAULT, R.layout.item_movie_comment_default);
        maps.put(AdapterConstant.ITME_MOVIE_BEAN_CELEBIRTY, R.layout.item_movie_bean_celebirty);
        maps.put(AdapterConstant.ITME_MOVIE_PHOTO_DEFAULT, R.layout.item_movie_photo_default);
        maps.put(AdapterConstant.ITEM_MOVIE_COUNT_DEFAULT, R.layout.item_movie_count_default);

        /*******************通用视图 END*******************/
        maps.put(AdapterConstant.ITEM_BIZHI_COMMON_HEADER, R.layout.item_bizhi_common_header);
        maps.put(AdapterConstant.ITEM_BIZHI_DEFAULT, R.layout.item_bizhi_bizhi_default);
        maps.put(AdapterConstant.ITEM_BIZHI_DAY_RECOMMEND, R.layout.item_bizhi_day_recommend);
        maps.put(AdapterConstant.ITEM_BIZHI_HOMEPAGE_RECOMMEND, R.layout.item_bizhi_home_recommend);
        maps.put(AdapterConstant.ITEM_BIZHI_WALLPAPER_CATEGORY, R.layout.item_bizhi_wallpaper_category);
        maps.put(AdapterConstant.ITEM_BIZHI_VERTICAL_BIZHI, R.layout.item_bizhi_vertical_bizhi);
        maps.put(AdapterConstant.ITEM_BIZHI_VERTICAL_CATEGORY, R.layout.item_bizhi_vertical_category);
        maps.put(AdapterConstant.ITEM_BIZHI_ALBUM_DEFAULT, R.layout.item_bizhi_album_default);
        maps.put(AdapterConstant.ITEM_BIZHI_VIDEO_DEFAULT, R.layout.item_bizhi_video_default);
        maps.put(AdapterConstant.ITEM_BIZHI_VIDEO_CATEGORY, R.layout.item_bizhi_video_category);
        maps.put(AdapterConstant.ITEM_BIZHI_BIZHI_DEATIL, R.layout.item_bizhi_detail);
        maps.put(AdapterConstant.ITEM_BIZHI_VERTICAL_DETAIL, R.layout.item_bizhi_vertical_bizhi);
        maps.put(AdapterConstant.ITEM_BIZHI_COMMENT_DEFAULT, R.layout.item_bizhi_comment_default);
        maps.put(AdapterConstant.ITEM_BIZHI_LIVE_DEFAULT, R.layout.item_bizhi_live_default);
        maps.put(AdapterConstant.ITEM_BIZHI_HOME_TAG_DEFAULT, R.layout.item_bizhi_home_tag_default);


        /*Wan*/
        maps.put(AdapterConstant.ITEM_WAN_DATA_DEFAULT, R.layout.item_wan_data_default);

        return maps;
    }
}
