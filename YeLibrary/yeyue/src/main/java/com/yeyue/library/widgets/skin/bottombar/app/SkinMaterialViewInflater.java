package com.yeyue.library.widgets.skin.bottombar.app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;

import com.yeyue.library.widgets.skin.bottombar.widget.SkinMaterialBottomNavigationView;

import skin.support.app.SkinLayoutInflater;

/**
 * Created by ximsfei on 2017/1/13.
 */
public class SkinMaterialViewInflater implements SkinLayoutInflater {
    @Override
    public View createView(@NonNull Context context, final String name, @NonNull AttributeSet attrs) {
        View view = null;
        switch (name) {
            case "android.support.design.widget.BottomNavigationView":
                view = new SkinMaterialBottomNavigationView(context, attrs);
                break;

        }
        return view;
    }
}
