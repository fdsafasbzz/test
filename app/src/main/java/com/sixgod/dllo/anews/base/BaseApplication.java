package com.sixgod.dllo.anews.base;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by dllo on 16/3/1.
 */
public class BaseApplication extends Application{

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
        context =this;
        Fresco.initialize(context);
    }

    public static Context getContext(){
        return context;
    }
}
