package com.yeyue.library.utils;

import android.text.TextUtils;

import com.blankj.utilcode.util.SPUtils;
import com.yeyue.library.constant.YeSkinConstant;
import com.yeyue.library.widgets.skin.loader.YeSkinSDCardLoader;

import skin.support.SkinCompatManager;

/**
 * 皮肤可以设置本地主题皮肤
 *          设置颜色图片皮肤
 *          设置自定义颜色皮肤
 *          设置网络主题皮肤
  *@describe 皮肤管理工具
  *@author li.xiao
  *@time 2017-12-21 9:26
  */
public class YeSkinUtils {
    public static void setSkinOnLine(String skinName,SkinCompatManager.SkinLoaderListener listener){
        SPUtils.getInstance(YeSkinConstant.YE_SKIN_SP_NAME).put(YeSkinConstant.YE_SKIN_STATUS,YeSkinConstant.SKIN_STATUS.STATUS_ONLINE);
        SPUtils.getInstance(YeSkinConstant.YE_SKIN_SP_NAME).put(YeSkinConstant.YE_SKIN_ONLINE_PATH,skinName);
        SkinCompatManager.getInstance().loadSkin(skinName, listener, YeSkinSDCardLoader.YE_SKIN_LOADER_STRATEGY_SDCARD);
    }
    public static void setSkinLocal(String skinName,SkinCompatManager.SkinLoaderListener listener){
        SPUtils.getInstance(YeSkinConstant.YE_SKIN_SP_NAME).put(YeSkinConstant.YE_SKIN_STATUS,YeSkinConstant.SKIN_STATUS.STATUS_LOACAL);
        SPUtils.getInstance(YeSkinConstant.YE_SKIN_SP_NAME).put(YeSkinConstant.YE_SKIN_LOCAL_PATH,skinName);
        SkinCompatManager.getInstance().loadSkin(skinName, listener);
    }
    public static boolean isOnline(){
        if(YeSkinConstant.SKIN_STATUS.STATUS_ONLINE==SPUtils.getInstance(YeSkinConstant.YE_SKIN_SP_NAME).getInt(YeSkinConstant.YE_SKIN_STATUS,YeSkinConstant.SKIN_STATUS.STATUS_LOACAL)){
            return true;
        }
        return false;
    }
    public static boolean checkLocalSkinUsed(String skinName){
        if(TextUtils.isEmpty(skinName)){
            return false;
        }
        if(SPUtils.getInstance(YeSkinConstant.YE_SKIN_SP_NAME).getInt(YeSkinConstant.YE_SKIN_STATUS,0)!=YeSkinConstant.SKIN_STATUS.STATUS_LOACAL){
            return false;
        }
        if(skinName.equals(SPUtils.getInstance(YeSkinConstant.YE_SKIN_SP_NAME).getString(YeSkinConstant.YE_SKIN_LOCAL_PATH))){
            return true;
        }
        return false;
    }
    public static boolean checkOnlineSkinUsed(String skinName){
        SPUtils.getInstance(YeSkinConstant.YE_SKIN_SP_NAME).put(YeSkinConstant.YE_SKIN_STATUS,YeSkinConstant.SKIN_STATUS.STATUS_LOACAL);
        SPUtils.getInstance(YeSkinConstant.YE_SKIN_SP_NAME).put(YeSkinConstant.YE_SKIN_LOCAL_PATH,skinName);
        SkinCompatManager.getInstance().loadSkin(skinName, null);
        return false;
    }
}
