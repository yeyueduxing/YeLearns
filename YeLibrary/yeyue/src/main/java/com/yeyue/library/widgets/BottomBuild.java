package com.yeyue.library.widgets;

import android.graphics.Typeface;
import android.support.annotation.ColorInt;

/**
  *@describe 底部通用配置
  *@author li.xiao
  *@time 2017-7-31 15:26
  */
public class BottomBuild {
    public float inActiveTabAlpha;
    public float activeTabAlpha;
    public int inActiveTabColor;
    public int activeTabColor;
    public int barColorWhenSelected;
    public int badgeBackgroundColor;
    public boolean hidesBadgeWhenSelected = true;
    public int titleTextAppearance;
    public Typeface titleTypeFace;

    public BottomBuild() {
    }

    public BottomBuild inActiveTabAlpha(float alpha) {
        this.inActiveTabAlpha = alpha;
        return this;
    }

    public BottomBuild activeTabAlpha(float alpha) {
        this.activeTabAlpha = alpha;
        return this;
    }

    public BottomBuild inActiveTabColor(@ColorInt int color) {
        this.inActiveTabColor = color;
        return this;
    }

    public BottomBuild activeTabColor(@ColorInt int color) {
        this.activeTabColor = color;
        return this;
    }

    public BottomBuild barColorWhenSelected(@ColorInt int color) {
        this.barColorWhenSelected = color;
        return this;
    }

    public BottomBuild badgeBackgroundColor(@ColorInt int color) {
        this.badgeBackgroundColor = color;
        return this;
    }

    public BottomBuild hideBadgeWhenSelected(boolean hide) {
        this.hidesBadgeWhenSelected = hide;
        return this;
    }

    public BottomBuild titleTextAppearance(int titleTextAppearance) {
        this.titleTextAppearance = titleTextAppearance;
        return this;
    }

    public BottomBuild titleTypeFace(Typeface titleTypeFace) {
        this.titleTypeFace = titleTypeFace;
        return this;
    }

}
