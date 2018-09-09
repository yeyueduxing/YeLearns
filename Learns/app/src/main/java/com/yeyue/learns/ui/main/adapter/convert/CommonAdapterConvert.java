package com.yeyue.learns.ui.main.adapter.convert;

import android.databinding.ViewDataBinding;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.yeyue.learns.BR;
import com.yeyue.learns.R;
import com.yeyue.learns.constant.AdapterConstant;
import com.yeyue.learns.enity.diycode.DiyNew;
import com.yeyue.learns.enity.diycode.DiySite;
import com.yeyue.learns.enity.diycode.DiySiteList;
import com.yeyue.learns.enity.diycode.DiyTopic;
import com.yeyue.learns.enity.diycode.DiyTopicReply;
import com.yeyue.learns.enity.diycode.DiyUser;
import com.yeyue.learns.enity.gamersky.GamerSkyBean;
import com.yeyue.learns.enity.gank.GankData;
import com.yeyue.learns.enity.wan.WanDatasBean;
import com.yeyue.learns.enity.wechat.WeChat;
import com.yeyue.learns.enity.wechat.WeChatTag;
import com.yeyue.learns.utils.HtmlUtil;
import com.yeyue.library.data.BaseItem;
import com.yeyue.library.utils.ImageLoadUtils;

/**
  *@describe 通用视图
  *@author li.xiao
  *@time 2017-9-25 16:27
  */
public class CommonAdapterConvert {
    public static void convert(BaseViewHolder helper, BaseItem data,ViewDataBinding binding){
        switch (helper.getItemViewType()) {
            case AdapterConstant.ITEM_DIY_TOPIC_DEFAULT:
                if(data!=null && data instanceof DiyTopic){
                    DiyTopic item = (DiyTopic) data;
                    binding.setVariable(BR.topic,item);
                }
                break;
            case AdapterConstant.ITEM_DIY_TOPIC_REPLAY:
                if(data!=null && data instanceof DiyTopicReply){
                    DiyTopicReply item = (DiyTopicReply) data;
                    TextView content = helper.getView(R.id.tvContent);
                    binding.setVariable(BR.replay,item);
                    // TODO 评论区代码问题
                    content.setText(Html.fromHtml(HtmlUtil.removeP(item.getBody_html()), null, null));
                }
                break;
            case AdapterConstant.ITEM_DIY_NEW_DEFAULT:
                if(data!=null && data instanceof DiyNew){
                    DiyNew item = (DiyNew) data;
                    binding.setVariable(BR.news,item);
                }
                break;
            case AdapterConstant.ITEM_DIY_SITE_DEFAULT:
                if(data!=null && data instanceof DiySite){
                    DiySite item = (DiySite) data;
                    binding.setVariable(BR.site,item);
                }
                break;
            case AdapterConstant.ITEM_DIY_SITE_LIST:
                if(data!=null && data instanceof DiySiteList){
                    DiySiteList item = (DiySiteList) data;
                    binding.setVariable(BR.sites,item);
                }
                break;
            case AdapterConstant.ITEM_GANK_DATA_DEFAULT:
                if(data!=null && data instanceof GankData){
                    GankData item = (GankData) data;
                    helper.setVisible(R.id.iv_android_pic,false);
                    if(item.getImages()!=null && item.getImages().size()>0){
                        String image = item.getImages().get(0);
                        helper.setVisible(R.id.iv_android_pic,true);
                        ImageView ivPic = helper.getView(R.id.iv_android_pic);
                        ImageLoadUtils.showImageView(ivPic.getContext(),ivPic,image,R.color.color_placeholder,R.color.color_errorPic);
                    }
                    binding.setVariable(BR.gankdata,item);
                }
                break;
            case AdapterConstant.ITEM_GANK_FULI_DEFAULT:
            case AdapterConstant.ITEM_GANK_DATA_FULI:
                if(data!=null && data instanceof GankData){
                    GankData item = (GankData) data;
                    binding.setVariable(BR.gankdata,item);
                }
                break;
            case AdapterConstant.ITEM_DIY_USER_DEFAULT:
                if(data!=null && data instanceof DiyUser){
                    DiyUser item = (DiyUser) data;
                    binding.setVariable(BR.user,item);
                }
                break;
            case AdapterConstant.ITEM_WECHAT_DEFAULT:
                if(data!=null && data instanceof WeChat){
                    WeChat item = (WeChat) data;
                    binding.setVariable(BR.wechat,item);
                }
                break;
            case AdapterConstant.ITEM_WECHAT_NEW_TAG:
                if(data!=null && data instanceof WeChatTag){
                    WeChatTag item = (WeChatTag) data;
                    binding.setVariable(BR.wechattag,item);
                }
                break;
            case AdapterConstant.ITEM_GAMERSKY_DEFAULT:
                if(data!=null && data instanceof GamerSkyBean){
                    GamerSkyBean item = (GamerSkyBean) data;
                    if(item.getThumbnailURLs()!=null && item.getThumbnailURLs().size()>0){
                        item.setThumb(item.getThumbnailURLs().get(0));
                    }
                    binding.setVariable(BR.gamer,item);
                }
                break;
            case AdapterConstant.ITEM_WAN_DATA_DEFAULT:
                if(data!=null && data instanceof WanDatasBean){
                    WanDatasBean item = (WanDatasBean) data;
                    binding.setVariable(BR.wandata,item);
                }
                break;
        }
    }
}
