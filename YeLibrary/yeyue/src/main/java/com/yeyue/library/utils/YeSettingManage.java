package com.yeyue.library.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;

import com.yeyue.library.R;
import com.yeyue.library.data.BaseItem;
import com.yeyue.library.data.YeSettingGroup;
import com.yeyue.library.data.YeSettingItem;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
  *@describe 读取menu文件
  *@author li.xiao
  *@time 2017-12-26 20:24
  */
public class YeSettingManage {
    /** Menu tag name in XML. */
    public static final String XML_MENU = "menu";
    /** Group tag name in XML. */
    public static final String XML_GROUP = "group";
    /** Item tag name in XML. */
    public static final String XML_ITEM = "item";
    private Context mContext;
    public YeSettingManage(Context mContext){
        this.mContext = mContext;
    }
    public List<BaseItem> readMenu(int menuRes){
        List<BaseItem> baseItems = new ArrayList<>();
        XmlResourceParser parser = null;
        try {
            parser = mContext.getResources().getLayout(menuRes);
            AttributeSet attrs = Xml.asAttributeSet(parser);
            baseItems = parseMenu(parser, attrs);
        } catch (XmlPullParserException e) {
            throw new InflateException("Error inflating menu XML", e);
        } catch (IOException e) {
            throw new InflateException("Error inflating menu XML", e);
        } finally {
            if (parser != null) parser.close();
        }
        return baseItems;
    }
    /**
     * Called internally to fill the given menu. If a sub menu is seen, it will
     * call this recursively.
     */
    private List<BaseItem> parseMenu(XmlPullParser parser, AttributeSet attrs)
            throws XmlPullParserException, IOException {
        List<BaseItem> setLists = new ArrayList<>();
        int eventType = parser.getEventType();
        String tagName;
        boolean lookingForEndOfUnknownTag = false;
        String unknownTagName = null;
        boolean isFirstGroup = false;
        boolean isFirstItem = false;

        // This loop will skip to the menu start tag
        do {
            if (eventType == XmlPullParser.START_TAG) {
                tagName = parser.getName();
                if (tagName.equals(XML_MENU)) {
                    // Go to next tag
                    eventType = parser.next();
                    break;
                }
                throw new RuntimeException("Expecting menu, got " + tagName);
            }
            eventType = parser.next();
        } while (eventType != XmlPullParser.END_DOCUMENT);

        boolean reachedEndOfMenu = false;
        while (!reachedEndOfMenu) {
            switch (eventType) {
                case XmlPullParser.START_TAG:
                    if (lookingForEndOfUnknownTag) {
                        break;
                    }
                    tagName = parser.getName();
                    if (tagName.equals(XML_GROUP)) {
                        setLists.add(readGroup(attrs,isFirstGroup));
                        isFirstGroup = true;
                        isFirstItem = false;
                    } else if (tagName.equals(XML_ITEM)) {
                        setLists.add(readItem(attrs,isFirstItem));
                        isFirstItem = true;
                    } else {
                        lookingForEndOfUnknownTag = true;
                        unknownTagName = tagName;
                    }
                    break;

                case XmlPullParser.END_TAG:
                    tagName = parser.getName();
                    if (lookingForEndOfUnknownTag && tagName.equals(unknownTagName)) {
                        lookingForEndOfUnknownTag = false;
                        unknownTagName = null;
                    } else if (tagName.equals(XML_GROUP)) {
                    } else if (tagName.equals(XML_ITEM)) {
                    } else if (tagName.equals(XML_MENU)) {
                        reachedEndOfMenu = true;
                    }
                    break;

                case XmlPullParser.END_DOCUMENT:
                    throw new RuntimeException("Unexpected end of document");
            }

            eventType = parser.next();
        }
        return setLists;
    }

    /**
      *@describe 获取群组数据
      *@author li.xiao
      *@time 2017-12-27 9:22
      */
    private YeSettingGroup readGroup(AttributeSet attrs,boolean isTop) {
        TypedArray a = mContext.obtainStyledAttributes(attrs, R.styleable.YeSettingGroup);
        YeSettingGroup header = new YeSettingGroup();
        if(a.hasValue(R.styleable.YeSettingGroup_ye_set_group_title)){
            String title = a.getString(R.styleable.YeSettingGroup_ye_set_group_title);
            header.setTitle(title);
        }
        header.setTop(isTop);
        a.recycle();
        return header;
    }

    /**
     * Called when the parser is pointing to an item tag.
     */
    private YeSettingItem readItem(AttributeSet attrs,boolean showLine) {
        TypedArray a = mContext.obtainStyledAttributes(attrs,R.styleable.YeSettingItem);
        YeSettingItem item = new YeSettingItem();
        if(a.hasValue(R.styleable.YeSettingItem_ye_set_item_title)){
            String title = a.getString(R.styleable.YeSettingItem_ye_set_item_title);
            item.setTitle(title);
        }
        if(a.hasValue(R.styleable.YeSettingItem_ye_set_item_subTitle)){
            String subTitle = a.getString(R.styleable.YeSettingItem_ye_set_item_subTitle);
            item.setSubTitle(subTitle);
        }
        int drawable = a.getResourceId(R.styleable.YeSettingItem_ye_set_item_drawable,0);
        int arrow = a.getResourceId(R.styleable.YeSettingItem_ye_set_item_arrow,0);
        boolean checked =a.getBoolean(R.styleable.YeSettingItem_ye_set_item_checked,false);
        //是否同步本地Sp值
        boolean synchor = a.getBoolean(R.styleable.YeSettingItem_ye_set_item_synchor,true);
        String spKey = "";
        if(a.hasValue(R.styleable.YeSettingItem_ye_set_item_key)){
            spKey = a.getString(R.styleable.YeSettingItem_ye_set_item_key);
        }
        int type = a.getInt(R.styleable.YeSettingItem_ye_set_item_type,0);
        int id = a.getResourceId(R.styleable.YeSettingItem_ye_set_item_id,0);

        item.setDrawable(drawable);
        item.setArrow(arrow);
        item.setChecked(checked);
        item.setType(type);
        item.setId(id);
        item.setShowLine(showLine);
        a.recycle();
        return item;
    }
}
