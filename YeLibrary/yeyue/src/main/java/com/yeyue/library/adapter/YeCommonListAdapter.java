package com.yeyue.library.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wang.avi.AVLoadingIndicatorView;
import com.yeyue.library.BR;
import com.yeyue.library.R;
import com.yeyue.library.constant.YeConstant;
import com.yeyue.library.data.BaseItem;
import com.yeyue.library.data.YeLoadtype;
import com.yeyue.library.data.YeSettingGroup;
import com.yeyue.library.data.YeSettingItem;

import java.util.List;

import skin.support.content.res.SkinCompatResources;

/**
  *@describe 通用Adapter
  *@author li.xiao
  *@time 2017-10-24 17:14
  */
public class YeCommonListAdapter extends BaseMultiItemQuickAdapter<BaseItem, BaseViewHolder> {

    public YeCommonListAdapter(List data) {
        super(data);
        addItemType(YeConstant.YE_ITEM_SETTING_DEFAULT,R.layout.yeyue_item_setting_default);
        addItemType(YeConstant.YE_ITEM_SETTING_GROUP,R.layout.yeyue_item_setting_group);
        addItemType(YeConstant.ITEM_LOADTYPE_DEFAULT,R.layout.yeyue_item_loadtype_default);
    }

    @Override
    protected void convert(BaseViewHolder helper, BaseItem data) {
        helper.getConvertView().setTag(data);
        ViewDataBinding binding = (ViewDataBinding) helper.itemView.getTag(R.id.BaseQuickAdapter_databinding_support);
        switch (helper.getItemViewType()){
            case YeConstant.YE_ITEM_SETTING_DEFAULT:
                if(data!=null && data instanceof YeSettingItem){
                    YeSettingItem item = (YeSettingItem) data;
                    helper.setVisible(R.id.swChange,false);
                    switch (item.getType()){
                        case YeConstant.Setting.CUSTOM:
                            break;
                        case YeConstant.Setting.SWITCH:
                            helper.setVisible(R.id.swChange,true);
                            break;
                    }
                    helper.setVisible(R.id.ivIcon,false);
                    if(item.getDrawable()!=0){
                        helper.setVisible(R.id.ivIcon,true);
                        helper.setImageResource(R.id.ivIcon,item.getDrawable());
                    }
                    helper.setVisible(R.id.line,item.isShowLine());
                    helper.setText(R.id.tvTitle,item.getTitle());
                    helper.setVisible(R.id.tvSubTitle,false);
                    if(!TextUtils.isEmpty(item.getSubTitle())){
                        helper.setVisible(R.id.tvSubTitle,true);
                        helper.setText(R.id.tvSubTitle,item.getSubTitle());
                    }
                    binding.setVariable(BR.setting,item);
                }
                break;
            case YeConstant.YE_ITEM_SETTING_GROUP:
                if(data!=null && data instanceof YeSettingGroup){
                    YeSettingGroup item = (YeSettingGroup) data;
                    binding.setVariable(BR.group,item);
                    helper.setVisible(R.id.vDriver,item.isTop());
                    helper.setText(R.id.tvTitle,item.getTitle());
                }
                break;
            case YeConstant.ITEM_LOADTYPE_DEFAULT:
                if(data!=null && data instanceof YeLoadtype){
                    YeLoadtype item = (YeLoadtype) data;
                    AVLoadingIndicatorView avLoad = helper.getView(R.id.avLoad);
                    if(avLoad!=null){
                        avLoad.setIndicator(item.getIndicator());
                        int color = SkinCompatResources.getInstance().getColor(com.yeyue.library.R.color.ye_color_Main_Word);
                        avLoad.setIndicatorColor(color);
                    }
                    binding.setVariable(BR.Loadtype,item);
                }
                break;
        }
    }

    @Override
    protected View getItemView(int layoutResId, ViewGroup parent) {
        ViewDataBinding binding = DataBindingUtil.inflate(mLayoutInflater, layoutResId, parent, false);
        if (binding == null) {
            return super.getItemView(layoutResId, parent);
        }
        View view = binding.getRoot();
        view.setTag(R.id.BaseQuickAdapter_databinding_support, binding);
        return view;
    }
}