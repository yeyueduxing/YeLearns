package com.yeyue.learns.utils;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.yeyue.learns.enity.gamersky.GameSkyHtml;
import com.yeyue.learns.enity.gamersky.GamerSkyBean;
import com.yeyue.library.data.BaseItem;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/14 0014.
 */

public class GamerSkyUtils {
    /**
     * 讲游明星空的网页转换为数据
     * @param html
     * @return
     */
    public static List<BaseItem> htmlToBean(String html){
        List<BaseItem> baseItems = new ArrayList<>();
        if(!TextUtils.isEmpty(html)){
            //进行编码转换
            html = html.substring(1);
            html = html.substring(0,html.length()-2);
            Gson gson = new Gson();
            GameSkyHtml gameSkyHtml = gson.fromJson(html,GameSkyHtml.class);
            if(gameSkyHtml !=null){
                Document doc = Jsoup.parseBodyFragment(gameSkyHtml.getBody());
                Elements links = doc.getElementsByTag("li");
                for (Element link : links) {
                    GamerSkyBean item = new GamerSkyBean();
                    String thumb = link.getElementsByClass("pe_u_thumb").attr("src");
                    String title = link.getElementsByClass("pe_u_thumb").attr("alt");
                    String desc = link.getElementsByClass("txt").text();
                    String time = link.getElementsByClass("time").text();
                    String comment = link.getElementsByClass("pls cy_comment").text();
                    String url = link.getElementsByClass("img").first().getElementsByTag("a").attr("href");
                    /*item.setComment(comment);
                    item.setThumb(thumb);
                    item.setTime(time);
                    item.setTitle(title);
                    item.setDesc(desc);
                    item.setUrl(url);*/
                    baseItems.add(item);
                }
            }
        }
        return baseItems;
    }
}
