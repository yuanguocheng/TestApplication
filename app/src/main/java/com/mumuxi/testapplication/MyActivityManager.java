package com.mumuxi.testapplication;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.mumuxi.testapplication.android.utils.LogUtil;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mumuxi
 * @date 2020/11/21
 * * 通过注册Application.ActivityLifecycleCallbacks的回调可以监听
 * * 应用本身的activity界面变化，实现对activity的控制
 */
public class MyActivityManager implements Application.ActivityLifecycleCallbacks {

    public static final String TAG = MyActivityManager.class.getSimpleName();

    List<WeakReference<Activity>> mActivityList = new ArrayList<>(10);

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        LogUtil.d(TAG, mActivityList.size() + " count =");
        mActivityList.add(new WeakReference<>(activity));
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
        if (!mActivityList.isEmpty()) {
            for (int i = 0; i < mActivityList.size(); i++) {
                if (mActivityList.get(i).get() == activity) {
                    mActivityList.remove(i);
                    break;
                }
            }
        }
    }

    public void exit() {
        if (!mActivityList.isEmpty()) {
            for (int i = 0; i < mActivityList.size(); i++) {
                mActivityList.get(i).get().finish();
            }
        }
    }
}
