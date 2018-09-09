package com.yeyue.learns.ui.bizhi.adapter.convert;

import android.databinding.ViewDataBinding;

import com.chad.library.adapter.base.BaseViewHolder;
import com.yeyue.learns.BR;
import com.yeyue.learns.R;
import com.yeyue.learns.constant.AdapterConstant;
import com.yeyue.learns.enity.bizhi.BizhiAlbumBean;
import com.yeyue.learns.enity.bizhi.BizhiBean;
import com.yeyue.learns.enity.bizhi.ComHeader;
import com.yeyue.learns.enity.bizhi.CommentBean;
import com.yeyue.learns.enity.bizhi.DayRecommend;
import com.yeyue.learns.enity.bizhi.LiveBean;
import com.yeyue.learns.enity.bizhi.VerCategory;
import com.yeyue.learns.enity.bizhi.VideoBean;
import com.yeyue.learns.enity.bizhi.VideoCategory;
import com.yeyue.learns.enity.bizhi.WalCategory;
import com.yeyue.learns.utils.TimeUtils;
import com.yeyue.library.data.BaseItem;

/**
  *@describe 通用视图
  *@author li.xiao
  *@time 2017-9-25 16:27
  */
public class BizhiAdapterConvert {
    public static void convert(BaseViewHolder helper, BaseItem data,ViewDataBinding binding){
        switch (helper.getItemViewType()) {
            case AdapterConstant.ITEM_BIZHI_COMMON_HEADER:
                if(data !=null && data instanceof ComHeader){
                    ComHeader item = (ComHeader) data;
                    helper.setVisible(R.id.vLeftDefault,false);
                    helper.setVisible(R.id.ivIcon,false);
                    helper.setTextColor(R.id.tvDefault, helper.getConvertView().getContext().getResources().getColor(R.color.color_Main_Body));
                    switch (item.getType()){
                        case ComHeader.DEFAULT:
                            helper.setVisible(R.id.vLeftDefault,true);
                            break;
                        case ComHeader.ICON_INSET:
                            helper.setVisible(R.id.ivIcon,true);
                            helper.setBackgroundRes(R.id.ivIcon,item.getLeftIcon());
                            helper.setTextColor(R.id.tvDefault, helper.getConvertView().getContext().getResources().getColor(R.color.color_Hint_Word));
                            break;
                        case ComHeader.NO_LEFT_ICON:
                            break;
                    }
                    binding.setVariable(BR.title,item.getTitle());
                }
                break;
            case AdapterConstant.ITEM_BIZHI_HOMEPAGE_RECOMMEND:
            case AdapterConstant.ITEM_BIZHI_DEFAULT:
            case AdapterConstant.ITEM_BIZHI_VERTICAL_BIZHI:
                if(data !=null && data instanceof BizhiBean){
                    BizhiBean item = (BizhiBean) data;
                    binding.setVariable(BR.image,item.getThumb());
                    binding.setVariable(BR.bizhi,item);
                }
                break;
            case AdapterConstant.ITEM_BIZHI_DAY_RECOMMEND:
                if(data !=null && data instanceof DayRecommend){
                    DayRecommend item = (DayRecommend) data;
                    //根据时间戳获取月份和时间
                    String day = TimeUtils.timeFormat(item.getStime(),"dd");
                    String month = "/"+TimeUtils.timeFormat(item.getStime(),"MM")+"月";
                    binding.setVariable(BR.dayTime,day);
                    binding.setVariable(BR.month,month);
                    binding.setVariable(BR.day,item);
                }
                break;
            case AdapterConstant.ITEM_BIZHI_WALLPAPER_CATEGORY:
                if(data !=null && data instanceof WalCategory.CategoryBean){
                    WalCategory.CategoryBean item = (WalCategory.CategoryBean) data;
                    binding.setVariable(BR.category,item);
                }
                break;
            case AdapterConstant.ITEM_BIZHI_VERTICAL_CATEGORY:
                if(data !=null && data instanceof VerCategory){
                    VerCategory item = (VerCategory) data;
                    binding.setVariable(BR.category,item);
                }
                break;
            case AdapterConstant.ITEM_BIZHI_ALBUM_DEFAULT:
                if(data !=null && data instanceof BizhiAlbumBean){
                    BizhiAlbumBean item = (BizhiAlbumBean) data;
                    binding.setVariable(BR.album,item);
                }
                break;
            case AdapterConstant.ITEM_BIZHI_VIDEO_DEFAULT:
                if(data !=null && data instanceof VideoBean){
                    VideoBean item = (VideoBean) data;
                    binding.setVariable(BR.video,item);
                }
                break;
            case AdapterConstant.ITEM_BIZHI_VIDEO_CATEGORY:
                if(data !=null && data instanceof VideoCategory){
                    VideoCategory item = (VideoCategory) data;
                    binding.setVariable(BR.category,item);
                }
                break;
            case AdapterConstant.ITEM_BIZHI_BIZHI_DEATIL:
            case AdapterConstant.ITEM_BIZHI_VERTICAL_DETAIL:
                if(data !=null && data instanceof BizhiBean){
                    BizhiBean item = (BizhiBean) data;
                    binding.setVariable(BR.user,item.getUser());
                    binding.setVariable(BR.bizhi,item);
                }
                break;
            case AdapterConstant.ITEM_BIZHI_COMMENT_DEFAULT:
                if(data !=null && data instanceof CommentBean){
                    CommentBean item = (CommentBean) data;
                    item.getUser().setAtime((long) item.getAtime());
                    binding.setVariable(BR.comment,item);
                    binding.setVariable(BR.user,item.getUser());
                }
                break;
            case AdapterConstant.ITEM_BIZHI_LIVE_DEFAULT:
                if(data !=null && data instanceof LiveBean){
                    LiveBean item = (LiveBean) data;
                    binding.setVariable(BR.live,item);
                }
                break;
        }
    }
}
