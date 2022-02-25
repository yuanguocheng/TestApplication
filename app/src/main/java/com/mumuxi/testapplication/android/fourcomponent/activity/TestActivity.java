package com.mumuxi.testapplication.android.fourcomponent.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.mumuxi.testapplication.R;

import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author mumuxi
 * @version 2019/7/9
 * <p>
 * 1.生命周期
 * 2.onWindowFocusChanged方法妙用
 * 3.theme主题
 * 4.启动模式和intent设置的flag
 * 5.task（任务）和 back stack（回退堆栈）
 */
public class TestActivity extends Activity {

    private static final String TAG = TestActivity.class.getSimpleName();
    @BindView(R.id.btn_test_activity)
    public Button mButton;

    @Override
    protected void attachBaseContext(Context newBase) {
        Log.d(TAG, "attachBaseContext: ");
        super.attachBaseContext(newBase);
    }

    @Override
    public void onAttachedToWindow() {
        Log.d(TAG, "onAttachedToWindow: ");
        super.onAttachedToWindow();
    }

    /**
     * 第一种情况：activity launchMode为singleTask或者singleInstance
     * 1、activity  a start activity b
     * 2、activity b start activity a
     * 在第二步被执行后，activitya就会顺序执行 onNewIntent onRestart onStart onResume
     * <p>
     * 第二种情况：activity launchMode为singleTop singleTask singleInstance
     * 1、start activity a
     * 2、activity a start activity a
     * 在第二步被执行后，activitya就会顺序执行onPause onNewIntent onResume
     */
    @Override
    protected void onNewIntent(Intent intent) {
        Log.e(TAG, "----onnewintent");
        super.onNewIntent(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        ButterKnife.bind(this);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TestActivity.this, TestActivity2.class));
            }
        });
        Log.e(TAG, "----oncreate");
    }

    /**
     * 表示Activity正在重新启动。一般情况下，
     * 在当前Activity从不可见重新变为可见的状态时onRestart就会被调用
     */
    @Override
    protected void onRestart() {
        Log.e(TAG, "----onrestart");
        super.onRestart();
    }

    /**
     * 与onStop配对，表示Activity正在被启动，并且即将开始。但是这个时候要注意它与onResume的区别。
     * 两者都表示Activity可见，但是onStart时Activity还正在加载其他内容，
     * 正在向我们展示，用户还无法看到，即无法交互。
     */
    @Override
    protected void onStart() {
        Log.e(TAG, "----onstart");
        super.onStart();
    }

    /**
     * 与onPause配对，表示Activity已经创建完成，并且可以开始活动了，
     * 这个时候用户已经可以看到界面了，
     * 并且即将与用户交互（完成该周期之后便可以响应用户的交互事件了）。
     */
    @Override
    protected void onResume() {
        Log.e(TAG, "----onresume");
        super.onResume();
    }

    /**
     * pause表示暂停，当Activity要跳到另一个Activity或应用正常退出时都会执行这个方法。
     * 此时Activity在前台并可见，我们可以进行一些轻量级的存储数据和去初始化的工作，
     * 不能太耗时，因为在跳转Activity时只有当一个Activity执行完了onPause方法后另一个Activity才会启动，
     * 而且android中指定如果onPause在500ms即0.5秒内没有执行完毕的话就会强制关闭Activity。
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "----onpause");
    }


    @Override
    protected void onStop() {
        Log.e(TAG, "----onstop");
        super.onStop();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    @Override
    protected void onDestroy() {
        Log.e(TAG, "----ondestroy");
        //调用finish方法可以kill掉activity
        finish();
        super.onDestroy();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.e(TAG, "----onwindwofocuschange");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
       /* 此方法直接将当前Activity所在的Task移到后台，同时保留activity顺序和状态。
         这样按返回键的话就可以类似于实现按home键的效果*/
        //moveTaskToBack(true);
    }

    /**
     * 按home键和启动新的activity也会回调此函数，但这个函数的真正用处在于Activity被异常终止的情况下,
     * 通过onRestoreInstanceState或者onCreate方法来判断 activity是否被重建了
     *
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.e(TAG, "----onsaveinstance");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.e(TAG, "----onrestoreinstance");
        super.onRestoreInstanceState(savedInstanceState);
    }


    /**
     * 通过startactivityforresult启动另一个activity时可以通过重写这个方法获得范湖的数据
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
