package com.aircore;

import android.app.Application;
import android.content.Context;

import cube.com.axislibrary.factory.Axis;

public class LinqiApplication extends Application {
    private static LinqiApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Axis.init(this,1080,1920);//适配初始化,基准宽高
    }

    /**
     * 获取context
     * @return
     */
    public static Context getInstance() {
        if (instance == null) {
            instance = new LinqiApplication();
        }
        return instance;
    }

}
