package com.yeyue.library.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.yeyue.library.R;
import com.yeyue.library.widgets.flowlayout.FlowLayout;
import com.yeyue.library.widgets.flowlayout.TagAdapter;

import java.util.ArrayList;

public class YeSearchHistoryAdapter extends TagAdapter<String> {
    public YeSearchHistoryAdapter() {
        super(new ArrayList<String>());
    }

    public interface OnItemClickListener {
        public void itemClick(String searchHistoryBean);
    }

    private YeSearchHistoryAdapter.OnItemClickListener onItemClickListener;

    public OnItemClickListener getListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    @Override
    public View getView(FlowLayout parent, int position, final String searchHistoryBean) {
        TextView tv = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.yeyue_adapter_searchhistory_item,
                parent, false);
        tv.setText(searchHistoryBean);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != onItemClickListener) {
                    onItemClickListener.itemClick(searchHistoryBean);
                }
            }
        });
        return tv;
    }

    public String getItemData(int position) {
        return mTagDatas.get(position);
    }

    public int getDataSize() {
        return mTagDatas.size();
    }
}
