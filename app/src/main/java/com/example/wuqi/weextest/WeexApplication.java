package com.example.wuqi.weextest;

import android.app.Application;

import com.taobao.weex.InitConfig;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKEngine;

import java.util.zip.Inflater;

/**
 * Created by wuqi on 2016/12/27.
 */
public class WeexApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        InitConfig config = new InitConfig.Builder().setImgAdapter(new ImageAdapter()).build();
        WXSDKEngine.initialize(this,config);
    }
}
