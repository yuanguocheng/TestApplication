package com.mumuxi.testapplication.javabase.designmodel.singletontest;

import android.content.Context;
/**
 * @author mumuxi
 * @date   2020/8/29
*/
public class AppSettings {

    private static volatile AppSettings singleton;
    private Context mContext;
    private AppSettings(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static AppSettings getInstance(Context context) {
        if (singleton == null) {
            synchronized (AppSettings.class) {
                if (singleton == null) {
                    singleton = new AppSettings(context);
                }
            }
        }
        return singleton;
    }
}