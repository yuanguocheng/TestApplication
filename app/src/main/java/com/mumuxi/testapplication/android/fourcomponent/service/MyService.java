package com.mumuxi.testapplication.android.fourcomponent.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

/**
 * @author mumuxi
 * @version 2022/2/25
 */
public class MyService extends Service {

    private static final String TAG = MyService.class.getSimpleName();

    public MyService() {
    }

    /**
     * Service的onCreate是在主线程（ActivityThread）中调用的，耗时操作会阻塞UI
     */
    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate: ");
        //前台服务
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
            startForeground(1, new Notification());
        } else {
            Log.d(TAG, "onCreate: " + Build.VERSION.SDK_INT);
        }
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        //调用stopself可以关闭服务
        stopSelf();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.d(TAG, "onRebind: ");
        super.onRebind(intent);
    }
}
