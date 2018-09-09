package com.yeyue.learns.utils;

import android.app.Activity;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yeyue.learns.R;
import com.yeyue.learns.enity.bizhi.CommentBean;
import com.yeyue.learns.enity.bizhi.UserBean;
import com.yeyue.library.utils.ImageLoadUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

import skin.support.content.res.SkinCompatResources;

/**
  *@describe 数据绑定操作
  *@author li.xiao
  *@time 2017-10-24 15:04
  */
public class DataBindingAdapter {
    /**
     * 设置mipmap资源图片
     */
    @BindingAdapter("android:mipmapSrc")
    public static void mipmapSrc(ImageView imageView, int resouce) {
        imageView.setImageResource(resouce);
    }

    /**
     * 设置图片
     */
    @BindingAdapter("android:showImgBg")
    public static void showImgBg(ImageView imageView, String url) {
        ImageLoadUtils.showImageView(imageView.getContext(),imageView,  url, R.color.color_placeholder,R.color.color_errorPic);
    }

    /**
     * 设置图片
     */
    @BindingAdapter("android:showDayRecommend")
    public static void showDayRecommend(TextView textView, long time) {
        String showTime = "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM月");
        Date date = new Date(time/1000);
        showTime = simpleDateFormat.format(date);
        textView.setText(showTime+"");
    }
    /**
     * 设置评论
     * @param replayTextView
     * @param comment
     */
    @BindingAdapter("android:showComment")
    public static void showImgBg(TextView replayTextView, CommentBean comment) {
        if(comment.getReply_user()==null || TextUtils.isEmpty(comment.getReply_user().getName())){
            replayTextView.setText(comment.getContent());
            return;
        }
        CommentBean.ReplyUserBean reply = comment.getReply_user();
        String replyUser = "回复 "+reply.getName()+":";
        int end = replyUser.length();

        SpannableString spanableInfo = new SpannableString(replyUser+comment.getContent());
        spanableInfo.setSpan(new Clickable(replayTextView.getContext(),reply), 0, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        replayTextView.append(spanableInfo);
        //setMovementMethod()该方法必须调用，否则点击事件不响应
        replayTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
    public static class Clickable extends ClickableSpan {
        private CommentBean.ReplyUserBean user;
        private Context context;
        public Clickable(Context context,CommentBean.ReplyUserBean name) {
            super();
            this.user = name;
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            int color = SkinCompatResources.getInstance().getColor(R.color.color_Hint_Word);
            ds.setColor(color);
            ds.setUnderlineText(false);
        }

        @Override
        public void onClick(View v) {
            if(user!=null && context!=null && context instanceof Activity){
                UserBean userBean = new UserBean();
                userBean.setId(user.getId());
                ActivityUtils.openUserActivity((Activity) context,userBean);
            }
        }
    }
}
