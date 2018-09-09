package com.yeyue.library.constant;
/**
  *@describe 皮肤常量
  *@author li.xiao
  *@time 2017-12-21 9:30
  */
public class YeSkinConstant {
    public static final String YE_SKIN_SP_NAME = "YE_SKIN_SP_NAME";

    //皮肤设置状态，本地皮肤，自定义颜色皮肤，还是网络主题皮肤
    public static final String YE_SKIN_STATUS = "YE_SKIN_STATUS";
    //本地皮肤的名称路径
    public static final String YE_SKIN_LOCAL_PATH = "YE_SKIN_LOCAL_PATH";
    //自定义颜色皮肤的颜色值
    public static final String YE_SKIN_CUSTOM_COLOR = "YE_SKIN_CUSTOM_COLOR";
    //自定义图片皮肤的图片路径
    public static final String YE_SKIN_CUSTOM_PICTURE = "YE_SKIN_CUSTOM_PICTURE";
    //自定义网络主题皮肤的路径
    public static final String YE_SKIN_ONLINE_PATH = "YE_SKIN_ONLINE_PATH";

    public static final String YE_SKIN_INFO = "YE_SKIN_INFO";

    public static final int YE_ITEM_SKIN_DEFAULT = 112301;
    public static final int YE_ITEM_SKIN_ONLINE = 112302;
    public class SKIN_STATUS{
        //本地皮肤
        public static final int STATUS_LOACAL = 1001;
        //自定义颜色皮肤
        public static final int STATUS_CUSTOM_COLOR = 1002;
        //自定义图片皮肤
        public static final int STATUS_CUSTOM_PICTURE = 1003;
        //网络主题皮肤
        public static final int STATUS_ONLINE = 1004;
    }
}
