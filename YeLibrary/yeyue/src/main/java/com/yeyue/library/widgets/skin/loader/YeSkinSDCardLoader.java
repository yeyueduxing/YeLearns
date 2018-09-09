package com.yeyue.library.widgets.skin.loader;

import android.content.Context;

import java.io.File;

import skin.support.load.SkinSDCardLoader;
import skin.support.utils.SkinFileUtils;

/**
 * Created by li.xiao on 2017-12-21.
 */

public class YeSkinSDCardLoader extends SkinSDCardLoader {
    public static final int YE_SKIN_LOADER_STRATEGY_SDCARD = Integer.MAX_VALUE;

    @Override
    protected String getSkinPath(Context context, String skinName) {
        return new File(SkinFileUtils.getSkinDir(context), skinName).getAbsolutePath();
    }

    @Override
    public int getType() {
        return YE_SKIN_LOADER_STRATEGY_SDCARD;
    }
}