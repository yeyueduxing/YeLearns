package com.yeyue.library.data;

import com.yeyue.library.constant.YeConstant;

/**
  *@describe 设置详情
  *@author li.xiao
  *@time 2017-12-26 14:23
  */
public class YeSettingItem extends BaseItem {

    private int id;
    private int type;
    private boolean showLine;
    private String title;//标题文字
    private String subTitle;//副标题文字
    private int drawable;//控件ItemView的Icon资源
    private int arrow;//箭头的资源文件
    private boolean checked;//控件初始时是否是选中状态，作用于开关选项和单选选项

    @Override
    public int getItemType() {
        return YeConstant.YE_ITEM_SETTING_DEFAULT;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public int getArrow() {
        return arrow;
    }

    public void setArrow(int arrow) {
        this.arrow = arrow;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isShowLine() {
        return showLine;
    }

    public void setShowLine(boolean showLine) {
        this.showLine = showLine;
    }
}
