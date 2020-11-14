package com.mumuxi.testapplication.android.fourcomponent.activity;

import android.app.Activity;
import android.os.Bundle;

import com.mumuxi.testapplication.R;
import com.mumuxi.testapplication.android.utils.LogUtil;

/**
 * @author mumuxi
 * @date   2019/9/14
 *
 * 使用命令行查看当前所有Activity的命令
 * adb shell dumpsys activity
*/
public class TestActivity2 extends Activity {

    private static final String TAG = TestActivity2.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        //通过调用overridePendingTransition可以设置activity转场动画
//        overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.d(TAG,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.d(TAG,"onResume");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.d(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.d(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.d(TAG,"onDestroy");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        //通过调用overridePendingTransition可以设置activity转场动画
//        overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
    }
}
