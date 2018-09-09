package com.yeyue.library.constant;

import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.Utils;
import com.yeyue.library.R;

/**
 * @author li.xiao
 * @describe 依赖库的常量
 * @time 2017-10-28 9:59
 */
public class YeConstant {
    public class LoadSir {
        //成功
        public static final String SUCCESS = "ye_success";
        //失败
        public static final String ERROR = "ye_error";
        //数据为空
        public static final String EMPTY = "ye_empty";
        //加载中
        public static final String LOADING = "ye_loading";
        //超时
        public static final String TIMEOUT = "ye_timeout";
        //未开启网络
        public static final String NO_NETWORK = "ye_no_network";
    }

    public static final int YE_ITEM_SETTING_DEFAULT = 112201;
    public static final int YE_ITEM_SETTING_GROUP = 112202;
    public static final int ITEM_LOADTYPE_DEFAULT = 112203;

    public static final String YE_DRAWER_TAG = "ye_Drawer_main_tag";

    public class Setting {
        public static final int CUSTOM = 0;
        public static final int SWITCH = 1;
    }

    public static class ShareP {
        public static final String SPNAME = AppUtils.getAppPackageName() + "_preferences";
        public static final String RECYANIMATION = Utils.getApp().getString(R.string.YeConsKey_RecyAnimtion);
        public static final String LOADIMAGEVIEW = Utils.getApp().getString(R.string.YeConsKey_ImageView);
        public static final String NETRETRY_MAX = Utils.getApp().getString(R.string.YeConsKey_NetRetryMax);
        public static final String NETRETRY_DELAY = Utils.getApp().getString(R.string.YeConsKey_NetRetryDelay);
        public static final String LOAD_INDICATOR = Utils.getApp().getString(R.string.YeConsKey_LoadIndicator);
    }

}
