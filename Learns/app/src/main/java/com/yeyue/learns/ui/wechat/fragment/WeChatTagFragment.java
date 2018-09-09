package com.yeyue.learns.ui.wechat.fragment;

import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.Preference;

import com.blankj.utilcode.util.ObjectUtils;
import com.jess.arms.di.component.AppComponent;
import com.yeyue.learns.R;
import com.yeyue.learns.constant.Constant;
import com.yeyue.learns.enity.wechat.WeChatTag;
import com.yeyue.learns.utils.WeChatUtils;
import com.yeyue.library.base.YeSettingFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by li.xiao on 2018-1-24.
 */

public class WeChatTagFragment extends YeSettingFragment{

    private int type;
    private List<WeChatTag> weChatTags;
    public static WeChatTagFragment newInstance() {
        WeChatTagFragment fragment = new WeChatTagFragment();
        return fragment;
    }
    public static WeChatTagFragment newInstance(int type) {
        WeChatTagFragment fragment = new WeChatTagFragment();
        fragment.type = type;
        return fragment;
    }
    @Override
    public void setupFragmentComponent(AppComponent appComponent) {

    }
    @Override
    public int inflateMenu() {
        return R.menu.wechat_tag;
    }

    @Override
    public void onItemClick(Preference preference) {
        String key = String.valueOf(preference.getTitle());
        if(ObjectUtils.isEmpty(key)){
            return;
        }
        boolean isSuccess = false;
        if(weChatTags!=null && weChatTags.size()>0) {
            for (WeChatTag tag:weChatTags){
                if(tag!=null && key.equals(tag.getTitle())){
                    if(type==Constant.WECHAT_LIVE_TAG){
                        if(tag.isCheck()){
                            tag.setCheck(false);
                            isSuccess = WeChatUtils.deleteLeftTag(tag.getTag());
                        }else{
                            isSuccess = WeChatUtils.addLeftTag(tag.getTag());
                            tag.setCheck(true);
                        }
                    }else{
                        if(tag.isCheck()){
                            tag.setCheck(false);
                            isSuccess = WeChatUtils.deleteTag(tag.getTag());
                        }else{
                            isSuccess = WeChatUtils.addTag(tag.getTag());
                            tag.setCheck(true);
                        }
                    }
                }
            }
        }
    }

    @Override
    public List<Preference> getAddPreferences() {
        weChatTags = new ArrayList<>();
        if(type== Constant.WECHAT_NEW_TAG){
            weChatTags = WeChatUtils.getWeChatTags();
        }else{
            weChatTags = WeChatUtils.getWeChatLifeTags("");
        }
        List<Preference> preferences = new ArrayList<>();
        if(weChatTags!=null && weChatTags.size()>0){
            for (WeChatTag tag:weChatTags ){
                CheckBoxPreference checkBoxPreference = new CheckBoxPreference(getActivity());
                checkBoxPreference.setTitle(tag.getTitle());
                checkBoxPreference.setDefaultValue(tag.isCheck());
                preferences.add(checkBoxPreference);
            }
        }
        return preferences;
    }

    @Override
    public int getContentViewId() {
        return 0;
    }


}
