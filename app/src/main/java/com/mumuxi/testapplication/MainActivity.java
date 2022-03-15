package com.mumuxi.testapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mumuxi.testapplication.R;
import com.mumuxi.testapplication.android.fourcomponent.activity.TestActivity;
import com.mumuxi.testapplication.android.utils.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author mumuxi
 * @version 2019/7/7
 * <p>
 * 1.ButterKnife使用
 * 2.App启动时间测试
 */
public class MainActivity extends Activity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();

    /**
     * App启动时间测试
     * 1.方法一
     * am start -W com.mumuxi.testapplication/.MainActivity 执行该指令
     * WaitTime 返回从 startActivity 到应用第一帧完全显示这段时间. 就是总的耗时，
     * 包括前一个应用 Activity pause 的时间和新应用启动的时间；
     * ThisTime 表示一连串启动 Activity 的最后一个 Activity 的启动耗时；
     * TotalTime 表示新应用启动的耗时，包括新进程的启动和 Activity 的启动，
     * 但不包括前一个应用Activity pause的耗时。
     * 开发者一般只要关心 TotalTime 即可，这个时间才是自己应用真正启动的耗时。
     * <p>
     * 2. 方法二
     * 执行以下命令，就可以看到activity启动时间，但是不包括数据加载的时间，在代码中数据加载完之后调用
     * reportFullyDrawn();方法就可以统计出从从初始化到数据加载完的时间
     * 2.1 adb shell
     * 2.2 logcat |grep ActivityManager
     * （注意过滤的值可能会发生变化，如果不行可以试试Displayed）
     */

    @BindView(R.id.btn_test_activity)
    public Button mBtnTestActivity;

    @BindView(R.id.btn_exit_application)
    public Button mBtnExitApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //绑定初始化ButterKnife
        ButterKnife.bind(this);
        mBtnTestActivity.setOnClickListener(this);
        mBtnExitApplication.setOnClickListener(this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        LogUtil.d(TAG, "onNewIntent");
        super.onNewIntent(intent);
    }

    @Override
    protected void onResume() {
        LogUtil.d(TAG, "onResume");
        //测试统计应用启动时间的reportFullyDrawn();方法
        //通过 命令 top -H -p + pid(进程号) 可以查看进程CPU使用情况，
        // 所以每个线程在new的时候一定需要起线程名方便查问题
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    //使用此方法可以看到一些一些类似以下打印信息，即可知道加载数据所用的时间
                    //Fully drawn com.mumuxi.testapplication/.MainActivity: +3s516ms
                    reportFullyDrawn();
                }
            }
        }, "TESTTHREAD").start();
        super.onResume();
    }

    @Override
    protected void onPause() {
        LogUtil.d(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        LogUtil.d(TAG, "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test_activity:
                startActivity(new Intent(MainActivity.this, TestActivity.class));
                break;
            case R.id.btn_exit_application:
                ((MyApplication) getApplication()).exit();
                break;
            default:
                break;
        }
    }


}
