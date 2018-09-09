package com.yeyue.learns.model.api.service;

import com.yeyue.learns.constant.Constant;
import com.yeyue.learns.enity.diycode.DiyNew;
import com.yeyue.learns.enity.diycode.DiySiteList;
import com.yeyue.learns.enity.diycode.DiyTopContent;
import com.yeyue.learns.enity.diycode.DiyTopic;
import com.yeyue.learns.enity.diycode.DiyTopicReply;
import com.yeyue.learns.enity.diycode.DiyUser;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static me.jessyan.retrofiturlmanager.RetrofitUrlManager.DOMAIN_NAME_HEADER;

/**
 * 存放关于用户的一些api
 * Created by jess on 8/5/16 12:05
 * contact with jess.yan.effort@gmail.com
 */
public interface DiyCodeService {

    String HEADER_API_VERSION = "Accept: application/vnd.github.v3+json";


    /**
     * Diy推荐内容
     * https://diycode.cc/api/v3/topics.json?offset=20&limit=20
     * @return
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.DIYCODE})
    @GET("/api/v3/topics.json")
    Observable<List<DiyTopic>> getTopicsList(@Query("type") String type, @Query("node_id") Integer node_id,
                                             @Query("offset") Integer offset, @Query("limit") Integer limit);

    /**
     * 获取详情
     * https://diycode.cc/api/v3/topics/1023.json
     * @return
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.DIYCODE})
    @GET("/api/v3/topics/{id}.json")
    Observable<DiyTopContent> getTopicDetail(@Path("id") String id);

    /**
     * 获取 topic 回复列表
     *
     * @param id     topic 的 id
     * @param offset 偏移数值 默认 0
     * @param limit  数量极限，默认值 20，值范围 1...150
     * @return 回复列表
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.DIYCODE})
    @GET("/api/v3/topics/{id}/replies.json")
    Observable<List<DiyTopicReply>> getTopicRepliesList(@Path("id") int id, @Query("offset") Integer offset, @Query("limit") Integer limit);

    /**
     * 获取 news 列表
     *
     * https://diycode.cc/api/v3/news.json?offset=20&limit=20
     * @param node_id 如果你需要只看某个节点的，请传此参数, 如果不传 则返回全部
     * @param offset  偏移数值，默认值 0
     * @param limit   数量极限，默认值 20，值范围 1..150
     * @return news 列表
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.DIYCODE})
    @GET("/api/v3/news.json")
    Observable<List<DiyNew>> getNewsList(@Query("node_id") Integer node_id, @Query("offset") Integer offset, @Query("limit") Integer limit);


    /**
     * 用户正在关注的人列表
     *
     * @param login_name 登录用户名(非昵称)
     * @param offset     偏移数值，默认值 0
     * @param limit      数量极限，默认值 20，值范围 1..150
     * @return 用户关注的人列表
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.DIYCODE})
    @GET("/api/v3/users/{login}/following.json")
    Observable<List<DiyUser>> getUserFollowingList(@Path("login") String login_name,
                                          @Query("offset") Integer offset, @Query("limit") Integer limit);

    /**
     * 关注该用户的人列白哦
     *
     * @param login_name 登录用户名(非昵称)
     * @param offset     偏移数值，默认值 0
     * @param limit      数量极限，默认值 20，值范围 1..150
     * @return 关注该用户的人列表
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.DIYCODE})
    @GET("/api/v3/users/{login}/followers.json")
    Observable<List<DiyUser>> getUserFollowerList(@Path("login") String login_name,
                                            @Query("offset") Integer offset, @Query("limit") Integer limit);


    //--- user list --------------------------------------------------------------------------------

    /**
     * 用户收藏的话题列表
     *
     * @param login_name 登录用户名(非昵称)
     * @param offset     偏移数值，默认值 0
     * @param limit      数量极限，默认值 20，值范围 1..150
     * @return 话题列表
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.DIYCODE})
    @GET("/api/v3/users/{login}/favorites.json")
    Observable<List<DiyTopic>> getUserCollectionTopicList(@Path("login") String login_name,
                                                 @Query("offset") Integer offset, @Query("limit") Integer limit);


    /**
     * 获取用户创建的话题列表
     *
     * @param login_name 登录用户名(非昵称)
     * @param order      类型 默认 recent，可选["recent", "likes", "replies"]
     * @param offset     偏移数值，默认值 0
     * @param limit      数量极限，默认值 20，值范围 1..150
     * @return 话题列表
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.DIYCODE})
    @GET("/api/v3/users/{login}/topics.json")
    Observable<List<DiyTopic>> getUserCreateTopicList(@Path("login") String login_name, @Query("order") String order,
                                             @Query("offset") Integer offset, @Query("limit") Integer limit);


    /**
     * 用户回复过的话题列表
     *
     * @param login_name 登录用户名(非昵称)
     * @param order      类型 默认 recent，可选["recent"]
     * @param offset     偏移数值，默认值 0
     * @param limit      数量极限，默认值 20，值范围 1..150
     * @return 话题列表
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.DIYCODE})
    @GET("/api/v3/users/{login}/replies.json")
    Observable<List<DiyTopic>> getUserReplyTopicList(@Path("login") String login_name, @Query("order") String order,
                                               @Query("offset") Integer offset, @Query("limit") Integer limit);


    /**
     * 获取 酷站 列表
     * @return 列表
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.DIYCODE})
    @GET("/api/v3/sites.json")
    Observable<List<DiySiteList>> getSites();
}
