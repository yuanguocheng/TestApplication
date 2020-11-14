package com.mumuxi.testapplication;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import com.mumuxi.testapplication.exceptiontest.CrashHandler;
import com.mumuxi.testapplication.android.utils.LogUtil;

/**
 * Created by mumuxi on 2019/7/7
 * Describe
 */
public class MyApplication extends Application implements Application.ActivityLifecycleCallbacks {

    public static final String TAG = MyApplication.class.getSimpleName();

    @Override
    protected void attachBaseContext(Context base) {
        //Debug.startMethodTracing("counttime");
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.d(TAG, "onCreate");
        CrashHandler.getInstance().init(this);
    }

    /**
     * 通过注册Application.ActivityLifecycleCallbacks的回调可以监听
     * 应用本身的activity界面变化，实现对activity的控制
     *
     * @param activity
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
