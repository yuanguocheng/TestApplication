package com.mumuxi.testapplication.exceptiontest;

import android.content.Context;
import android.os.Process;
import android.util.Log;

import com.mumuxi.testapplication.BuildConfig;

/**
 * @author mumuxi
 * @date 2019/7/8
 * 定义CrashHandler监听应用的crash信息
 */
public class CrashHandler implements Thread.UncaughtExceptionHandler {

    private static final String TAG = CrashHandler.class.getSimpleName();

    private static CrashHandler instance;

    private Thread.UncaughtExceptionHandler mDefaultCrashHandler;

    public static final boolean DEBUG = BuildConfig.DEBUG;

    private Context mContext;

    private CrashHandler() {
    }

    public static CrashHandler getInstance() {
        if (instance == null) {
            instance = new CrashHandler();
        }
        return instance;
    }

    public void init(Context context) {
        mContext = context.getApplicationContext();
        mDefaultCrashHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);

    }


    @Override
    public void uncaughtException(Thread t, Throwable e) {

        //第一步，保存到本地或者上传服务器
        //第二步，打印异常信息
        //第三步，如果系统提供了默认的异常处理器，则交给系统去结束程序，否则自己结束程序

        if (DEBUG) {
            Log.d(TAG, "CrashHandler Handle");
            e.printStackTrace();
        }
        //todo 保存到本地或者上传服务器

        if (mDefaultCrashHandler != null) {
            Log.d(TAG, "handle by defaultCrashHandler");
            mDefaultCrashHandler.uncaughtException(t, e);
        } else {
            Log.d(TAG, "kill myself");
            Process.killProcess(Process.myPid());
        }
    }
}