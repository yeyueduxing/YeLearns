package com.yeyue.library.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yeyue.library.BR;
import com.yeyue.library.R;
import com.yeyue.library.constant.YeSkinConstant;
import com.yeyue.library.data.YeSkinItem;
import com.yeyue.library.utils.ImageLoadUtils;
import com.yeyue.library.utils.YeSkinUtils;

import java.util.List;

/**
 * Created by li.xiao on 2017-12-21.
 */

public class YeSkinAdapter extends BaseQuickAdapter<YeSkinItem, BaseViewHolder> {
    public YeSkinAdapter(List<YeSkinItem> data) {
        super(R.layout.yeyue_item_skin_default, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, YeSkinItem item) {
        helper.getConvertView().setTag(item);
        ViewDataBinding binding = (ViewDataBinding) helper.itemView.getTag(R.id.BaseQuickAdapter_databinding_support);
        ImageView ivSkin = helper.getView(R.id.ivThumb);
        helper.setVisible(R.id.ivSelect,item.isUsed());
        if(item.getItemType()== YeSkinConstant.YE_ITEM_SKIN_DEFAULT){
            ivSkin.setImageResource(item.getCoverRes());
            item.setUsed(YeSkinUtils.checkLocalSkinUsed(item.getResourcePath()));
        }else{
            ImageLoadUtils.showImageView(ivSkin.getContext(),ivSkin,item.getCoverPic());
        }
        helper.setText(R.id.tvName,item.getName());
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
