package com.yeyue.library.widgets.drop;


import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 赛选菜单使用工具
  *@describe
  *@author li.xiao
  *@time 2017-9-18 14:51
  */
public class DropManage {
    public static void setDropDownMenu(Context context,Map<String, List<String>> datas, DropDownMenu dropView,DropMenuListener listener){
        List<String> headers = new ArrayList<>();
        List<View> views = new ArrayList<>();
        if(datas!=null && datas.size()>0){
            for(String key:datas.keySet()){
                int tab = headers.size();
                headers.add(key);
                //init age menu
                final ListView ageView = new ListView(context);
                ageView.setDividerHeight(0);
                List<String> values =  datas.get(key);
                YeListDropDownAdapter ageAdapter = new YeListDropDownAdapter(context, values);
                ageView.setAdapter(ageAdapter);
                ageView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if(listener!=null){
                            listener.onItemClick(key,values.get(position));
                        }
                        ageAdapter.setCheckItem(position);
                        dropView.setTabText(values.get(position));
                        dropView.closeMenu();
                    }
                });
                views.add(ageView);
            }
        }
        dropView.setDropDownMenu(headers,views);
    }

    public interface DropMenuListener{
        void onItemClick(String tab,String postion);
    }
}
