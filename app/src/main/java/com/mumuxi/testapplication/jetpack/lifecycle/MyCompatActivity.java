package com.mumuxi.testapplication.jetpack.lifecycle;

import android.os.Bundle;

import com.mumuxi.testapplication.R;
import com.mumuxi.testapplication.android.utils.LogUtil;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



/**
 * @author mumuxi
 * @version 2022/3/17
 */
public class MyCompatActivity extends AppCompatActivity {

    public static final String TAG = MyCompatActivity.class.getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        LogUtil.d(TAG,"onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        getLifecycle().addObserver(new BasePresenter());

    }

    @Override
    protected void onResume() {
        LogUtil.d(TAG,"onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        LogUtil.d(TAG,"onResume");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        LogUtil.d(TAG,"onDestroy");
        super.onDestroy();
    }
}
