package com.mumuxi.testapplication;

import android.app.Application;
import android.content.Context;

import com.mumuxi.testapplication.android.utils.LogUtil;

/**
 * Created by mumuxi on 2019/7/7
 * Describe
 */
public class MyApplication extends Application {

    public static final String TAG = MyApplication.class.getSimpleName();
    MyActivityManager mMyActivityManager;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.d(TAG, "onCreate");
        CrashHandler.getInstance().init(this);
        mMyActivityManager = new MyActivityManager();
        registerActivityLifecycleCallbacks(mMyActivityManager);
    }

    public void exit() {
        mMyActivityManager.exit();
    }
}
