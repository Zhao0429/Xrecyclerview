package com.example.administrator.myapplication.view;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by ARP on 2018/5/4.
 */

public class MyApp extends Application {
    private static MyApp mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance=this;
        Fresco.initialize(this);


    }
    public static MyApp getInstance(){
        return mInstance;
    };

}
