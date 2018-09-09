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
import com.yeyue.library.data.YeSkinItem;
import com.yeyue.library.utils.ImageLoadUtils;

import java.util.List;

/**
 * Created by li.xiao on 2017-12-21.
 */

public class YeSkinDetailAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public YeSkinDetailAdapter(List data) {
        super(R.layout.yeyue_item_skin_detail, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.getConvertView().setTag(item);
        ImageView ivSkin = helper.getView(R.id.ivThumb);
        ImageLoadUtils.showImageView(ivSkin.getContext(),ivSkin,item);
    }

}
