package com.example.wuqi.weextest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXRenderStrategy;
import com.taobao.weex.utils.WXFileUtils;

public class MainActivity extends AppCompatActivity implements IWXRenderListener {
    WXSDKInstance instance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instance = new WXSDKInstance(this);
        instance.registerRenderListener(this);
        instance.render("WeexApplication", WXFileUtils.loadFileContent("hello.js",this),null,null,-1,-1, WXRenderStrategy.APPEND_ASYNC);
    }

    @Override
    public void onViewCreated(WXSDKInstance instance, View view) {
        setContentView(view);
    }

    @Override
    public void onRenderSuccess(WXSDKInstance instance, int width, int height) {

    }

    @Override
    public void onRefreshSuccess(WXSDKInstance instance, int width, int height) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(instance!=null) {
            instance.onActivityResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(instance!=null){
            instance.onActivityPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(instance!=null){
            instance.onActivityStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(instance!=null){
            instance.onActivityDestroy();
        }
    }

    @Override
    public void onException(WXSDKInstance instance, String errCode, String msg) {

    }
}
