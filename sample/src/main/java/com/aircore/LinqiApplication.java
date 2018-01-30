package com.aircore;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import cube.com.axislibrary.factory.Axis;

public class LinqiApplication extends Application {
    private static LinqiApplication instance;
    private static RequestQueue queues ;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Axis.init(this,1080,1920);//适配初始化,基准宽高
        queues = Volley.newRequestQueue(getApplicationContext());
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

    public static RequestQueue getHttpQueues() {
        return queues;
    }
}
