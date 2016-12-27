package com.example.wuqi.weextest;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.adapter.IWXImgLoaderAdapter;
import com.taobao.weex.common.WXImageStrategy;
import com.taobao.weex.dom.WXImageQuality;

/**
 * Created by wuqi on 2016/12/27.
 */
public class ImageAdapter implements  IWXImgLoaderAdapter {


    public  ImageAdapter(){
    }


    @Override
    public void setImage(final String url, final ImageView view, WXImageQuality quality, WXImageStrategy strategy) {

        if (TextUtils.isEmpty(url)) {
            view.setImageBitmap(null);
            return;
        }
        String temp = url;
        if (url.startsWith("//")){
            temp = "http:" + url;
        }
        if (view.getLayoutParams().width<=0 || view.getLayoutParams().height<=0) {
            return;
        }
        Picasso.with(WXEnvironment.getApplication())
                .load(temp)
                .resize(view.getLayoutParams().width,
                        view.getLayoutParams().height).into(view);
    }
}
