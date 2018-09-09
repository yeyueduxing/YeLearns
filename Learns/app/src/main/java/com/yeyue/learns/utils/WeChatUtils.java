package com.yeyue.learns.utils;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.yeyue.learns.constant.Constant;
import com.yeyue.learns.enity.wechat.WeChatTag;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by li.xiao on 2018-1-12.
 */

public class WeChatUtils {
    public static boolean addTag(String tag){
        Set<String> tags = SPUtils.getInstance().getStringSet(Constant.SP.WECHAT_TAG,new TreeSet<>());
        if(tags!=null && tags.size()>=5){
            ToastUtils.showLong("最多选择5个分类");
            return false;
        }
        tags.add(tag);
        SPUtils.getInstance().put(Constant.SP.WECHAT_TAG,tags);
        return true;
    }
    public static boolean deleteTag(String tag){
        Set<String> tags = SPUtils.getInstance().getStringSet(Constant.SP.WECHAT_TAG,new TreeSet<>());
        tags.remove(tag);
        SPUtils.getInstance().put(Constant.SP.WECHAT_TAG,tags);
        return true;
    }
    public static List<WeChatTag> getWeChatTags(){
        String[] tags = {"social","guonei","world","huabian","tiyu","nba","football","keji","startup","apple","military","mobile","travel","health","qiwen","meinv","vr","it"};
        String[] titles = {"社会新闻","国内新闻","国际新闻","娱乐新闻","体育新闻","NBA新闻","足球新闻","科技新闻","创业新闻","苹果新闻","军事新闻","移动互联","旅游资讯","健康知识","奇闻异事","美女图片","VR科技","IT资讯"};
        Set<String> selectTags = SPUtils.getInstance().getStringSet(Constant.SP.WECHAT_TAG,new TreeSet<>());
        List<String> selectList = new ArrayList<>();
        selectList.addAll(selectTags);
        List<WeChatTag> list = new ArrayList<>();
        for (int i=0;i<tags.length;i++){
            WeChatTag item = new WeChatTag();
            item.setTitle(titles[i]);
            item.setTag(tags[i]);
            if(selectList!=null && selectList.contains(item.getTag())){
                item.setCheck(true);
            }
            list.add(item);
        }
        return list;
    }



    public static List<WeChatTag> getSelectWeChatTags(){
        List<WeChatTag> allList = getWeChatTags();
        List<WeChatTag> list = new ArrayList<>();
        if(allList!=null && allList.size()>0){
            for (int i=0;i<allList.size();i++){
                if(allList.get(i)!=null && allList.get(i).isCheck()){
                    list.add(allList.get(i));
                }
            }
        }
        return list;
    }

    public static boolean addLeftTag(String tag){
        Set<String> tags = SPUtils.getInstance().getStringSet(Constant.SP.WECHAT_LIFE_TAG,new TreeSet<>());
        if(tags!=null && tags.size()>=5){
            ToastUtils.showLong("最多选择5个分类");
            return false;
        }
        tags.add(tag);
        SPUtils.getInstance().put(Constant.SP.WECHAT_LIFE_TAG,tags);
        return true;
    }
    public static boolean deleteLeftTag(String tag){
        Set<String> tags = SPUtils.getInstance().getStringSet(Constant.SP.WECHAT_LIFE_TAG,new TreeSet<>());
        tags.remove(tag);
        SPUtils.getInstance().put(Constant.SP.WECHAT_LIFE_TAG,tags);
        return true;
    }
    public static List<WeChatTag> getWeChatLifeTags(String spName){
        String[] tags = {"txapi/caipu","txapi/dream","txapi/joke","txapi/dictum","txapi/dob","txapi/naowan","txapi/lishi","txapi/chengyu","txapi/pitlishi","txapi/wenda","txapi/cityriddle","txapi/hotword","txapi/shares","txapi/turl","txapi/cname","txapi/xiehou","txapi/rkl","txapi/godreply"};
        String[] titles = {"菜谱查询","周公解梦","雷人笑话","名言警句","生日预测","脑筋急转弯","历史的今天","成语典故","简说历史","一战到底","地名谜语","网络热词","股市术语","网址转换","网络取名","歇后语","绕口令","神回复"};
        Set<String> selectTags = SPUtils.getInstance().getStringSet(Constant.SP.WECHAT_LIFE_TAG,new TreeSet<>());
        List<String> selectList = new ArrayList<>();
        selectList.addAll(selectTags);
        List<WeChatTag> list = new ArrayList<>();
        for (int i=0;i<tags.length;i++){
            WeChatTag item = new WeChatTag();
            item.setTitle(titles[i]);
            item.setTag(tags[i]);
            if(selectList!=null && selectList.contains(item.getTag())){
                item.setCheck(true);
            }
            list.add(item);
        }
        return list;
    }


    public static List<WeChatTag> getSelectWeChatLifeTags(String spName){
        List<WeChatTag> allList = getWeChatLifeTags(spName);
        List<WeChatTag> list = new ArrayList<>();
        if(allList!=null && allList.size()>0){
            for (int i=0;i<allList.size();i++){
                if(allList.get(i)!=null && allList.get(i).isCheck()){
                    list.add(allList.get(i));
                }
            }
        }
        return list;
    }
}
