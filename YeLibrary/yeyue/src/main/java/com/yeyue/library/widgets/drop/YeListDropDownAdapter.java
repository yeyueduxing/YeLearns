package com.yeyue.library.widgets.drop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yeyue.library.R;

import java.util.List;

public class YeListDropDownAdapter extends BaseAdapter {

    private Context context;
    private List<String> list;
    private int checkItemPosition = 0;
    private int viewResource = -1;
    public void setCheckItem(int position) {
        checkItemPosition = position;
        notifyDataSetChanged();
    }

    public YeListDropDownAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }
    public YeListDropDownAdapter(Context context, List<String> list, int viewResource) {
        this.context = context;
        this.list = list;
        this.viewResource = viewResource;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView != null) {
            viewHolder = (ViewHolder) convertView.getTag();
        } else {
            if(viewResource!=-1){
                convertView = LayoutInflater.from(context).inflate(viewResource, null);
            }else{
                convertView = LayoutInflater.from(context).inflate(R.layout.yeyue_widget_drop_down_menu_list, null);
            }
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        fillValue(position, viewHolder);
        return convertView;
    }

    private void fillValue(int position, ViewHolder viewHolder) {
        viewHolder.mText.setText(list.get(position));
        if (checkItemPosition != -1) {
            if (checkItemPosition == position) {
                viewHolder.mText.setSelected(true);
            } else {
                viewHolder.mText.setSelected(false);
            }
        }
    }

    static class ViewHolder {
        TextView mText;
        ViewHolder(View view) {
            mText = (TextView) view.findViewById(R.id.text);
        }
    }
}
