package com.mumuxi.testapplication.jetpack.lifecycle;

import com.mumuxi.testapplication.android.utils.LogUtil;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

/**
 * @author mumuxi
 * @version 2022/3/17
 */
public class BasePresenter implements DefaultLifecycleObserver {

    public static final String TAG = BasePresenter.class.getSimpleName();

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        LogUtil.d(TAG,"onCreate");
    }

    @Override
    public void onStart(@NonNull LifecycleOwner owner) {
        LogUtil.d(TAG,"onStart");
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        LogUtil.d(TAG,"onResume");
    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {
        LogUtil.d(TAG,"onPause");
    }

    @Override
    public void onStop(@NonNull LifecycleOwner owner) {
        LogUtil.d(TAG,"onStop");
    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
        LogUtil.d(TAG,"onDestroy");
    }
}
