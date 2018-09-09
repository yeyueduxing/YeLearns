package com.yeyue.library.utils;

import com.yeyue.library.data.YeSkinItem;

import org.simple.eventbus.EventBus;

/**
 * Created by li.xiao on 2018-2-8.
 */

public class YeEventUtils {
    public static void updateSkin(){
        EventBus.getDefault().post(new YeSkinItem());
    }
}
