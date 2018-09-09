package com.yeyue.learns.ui.main.adapter;

import android.databinding.ViewDataBinding;

import com.chad.library.adapter.base.BaseViewHolder;
import com.yeyue.learns.R;
import com.yeyue.learns.ui.bizhi.adapter.convert.BizhiAdapterConvert;
import com.yeyue.learns.ui.main.adapter.convert.CommonAdapterConvert;
import com.yeyue.library.adapter.YeCommonListAdapter;
import com.yeyue.library.data.BaseItem;

import java.util.List;
import java.util.Map;
/**
  *@describe 通用Adapter
  *@author li.xiao
  *@time 2017-10-24 17:14
  */
public class CommonListAdapter extends YeCommonListAdapter {

    public CommonListAdapter(List data) {
        super(data);
        Map<Integer,Integer> maps = AdapterShine.fetchAdapterMap();
        for (Integer type:maps.keySet()){
            addItemType(type,maps.get(type));
        }
    }

    @Override
    protected void convert(BaseViewHolder helper, BaseItem data) {
        super.convert(helper,data);
        ViewDataBinding binding = (ViewDataBinding) helper.itemView.getTag(R.id.BaseQuickAdapter_databinding_support);
        CommonAdapterConvert.convert(helper,data,binding);
        BizhiAdapterConvert.convert(helper,data,binding);
    }
}