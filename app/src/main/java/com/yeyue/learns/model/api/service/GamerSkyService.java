package com.yeyue.learns.model.api.service;

import com.yeyue.learns.constant.Constant;
import com.yeyue.learns.enity.gamersky.GameSkyParam;
import com.yeyue.learns.enity.gamersky.GamerSkyHttpRequest;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

import static me.jessyan.retrofiturlmanager.RetrofitUrlManager.DOMAIN_NAME_HEADER;

/**
 * @author Administrator
 * @describe 游明星空
 * @time 2018/1/14 0014 上午 11:05
 */
public interface GamerSkyService {

    /**
     * 微信精选列表
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.GAMERSKY})
    @POST("http://appapi2.gamersky.com/v2/AllChannelList")
    Observable<GamerSkyHttpRequest> getLabelJsonpAjax(@Body GameSkyParam jsondata);

}
