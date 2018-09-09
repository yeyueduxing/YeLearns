package com.yeyue.library.widgets.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.renderscript.RSRuntimeException;
import android.support.annotation.NonNull;

import com.blankj.utilcode.util.ImageUtils;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

import java.security.MessageDigest;

import jp.wasabeef.glide.transformations.internal.FastBlur;
import jp.wasabeef.glide.transformations.internal.RSBlur;

/**
 * Created by li.xiao on 2018-1-2.
 */

public class YeGlideBlurformation extends BitmapTransformation {
    private Context context;
    private float blurRadius = 20;
    public YeGlideBlurformation(Context context) {
        this.context = context;
    }
    public YeGlideBlurformation(Context context,float blurRadius) {
        this.context = context;
        this.blurRadius = blurRadius;
    }
    @Override
    protected Bitmap transform(@NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        //return BlurBitmapUtil.instance().blurBitmap(context, toTransform, blurRadius,outWidth,outHeight);
        //return blurBitmap(context,pool,toTransform,outWidth,outHeight);
        return ImageUtils.fastBlur(toTransform,0.4f,blurRadius);
    }
    @Override
    public void updateDiskCacheKey(MessageDigest messageDigest) {
    }

    public static Bitmap blurBitmap(Context mContext,BitmapPool mBitmapPool, @NonNull Bitmap source, int outWidth, int outHeight) {
        int mSampling= 4;
        int mRadius = 23;
        int width = source.getWidth();
        int height = source.getHeight();
        int scaledWidth = width / mSampling;
        int scaledHeight = height / mSampling;

        Bitmap bitmap = mBitmapPool.get(scaledWidth, scaledHeight, Bitmap.Config.ARGB_8888);
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(scaledWidth, scaledHeight, Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(bitmap);
        canvas.scale(1 / (float) mSampling, 1 / (float) mSampling);
        Paint paint = new Paint();
        paint.setFlags(Paint.FILTER_BITMAP_FLAG);
        canvas.drawBitmap(source, 0, 0, paint);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            try {
                bitmap = RSBlur.blur(mContext, bitmap, mRadius);
            } catch (RSRuntimeException e) {
                bitmap = FastBlur.blur(bitmap, mRadius, true);
            }
        } else {
            bitmap = FastBlur.blur(bitmap, mRadius, true);
        }

        return bitmap;
    }
}