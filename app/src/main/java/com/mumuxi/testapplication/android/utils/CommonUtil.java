package com.mumuxi.testapplication.android.utils;

import android.app.ActivityManager;
import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.Executor;

import androidx.annotation.NonNull;

/**
 * Create By mumuxi On 2019-3-10
 * 通用工具
 */
public class CommonUtil {

    private CommonUtil() {
    }

    public static Executor getThreadPool() {
        return AsyncTask.THREAD_POOL_EXECUTOR;
    }

    /**
     * 按键模拟
     */
    public static void sendKeyEvent(final int keyCode) {
        getThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Instrumentation inst = new Instrumentation();
                    inst.sendKeyDownUpSync(keyCode);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 执行命令
     *
     * @param command
     * @return
     */
    public static boolean exceuteCommand(String command) {
        try {
            Runtime runtime = Runtime.getRuntime();
            runtime.exec(command);
            return true;
        } catch (Throwable e) {
            LogUtil.d("ygc", "exceuteCommand error");
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取命令的输出
     *
     * @param command
     * @return
     */
    public static String getResultByCommand(String command) {
        StringBuffer result = new StringBuffer();
        try {
            Runtime runtime = Runtime.getRuntime();
            Process p = Runtime.getRuntime().exec(command);
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            p.waitFor();
            is.close();
            reader.close();
            p.destroy();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    /**
     * 根据包名检查一个package是否处于电视的前端,需要系统权限
     *
     * @param pkgName 包名
     * @return true or false
     */
    public static boolean isPackageOnTop(String pkgName, @NonNull Context context) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        ComponentName cn;
        if (am != null) {
            try {
                List<ActivityManager.RunningTaskInfo> runningTaskInfoList = am.getRunningTasks(1);
                if (!runningTaskInfoList.isEmpty()) {
                    cn = runningTaskInfoList.get(0).topActivity;
                    if (cn.getPackageName().equals(pkgName)) {
                        return true;
                    }
                } else {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
        return false;
    }
}
