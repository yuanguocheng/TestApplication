package com.mumuxi.testapplication.android.utils;

import android.util.Log;

import com.mumuxi.testapplication.BuildConfig;

/**
 * @author mumuxi
 * @version 2020/11/15
 */

public class LogUtil {

    public static final boolean DEBUG = BuildConfig.DEBUG;


    public static final boolean openLog =
            SystemProperties.get("test.debuggable", "false").equals("true");

    /**
     * 解决log信息超长，显示不完整 debug message
     *
     * @param tag
     * @param msg
     */
    public static void d(String tag, String msg) {
        if (DEBUG || openLog) {
            int strLength = msg.length();
            int start = 0;
            int logMaxLength = 2000;
            int end = logMaxLength;
            for (int i = 0; i < 100; i++) {
                //剩下的文本还是大于规定长度则继续重复截取并输出
                if (strLength > end) {
                    Log.d(tag + i, msg.substring(start, end));
                    start = end;
                    end = end + logMaxLength;
                } else {
                    Log.e(tag, msg.substring(start, strLength));
                    break;
                }
            }
        }
    }


    /**
     * information message
     *
     * @param tag
     * @param msg
     */
    public static void i(String tag, String msg) {
        int strLength = msg.length();
        int start = 0;
        int logMaxLength = 2000;
        int end = logMaxLength;
        for (int i = 0; i < 100; i++) {
            //剩下的文本还是大于规定长度则继续重复截取并输出
            if (strLength > end) {
                Log.d(tag + i, msg.substring(start, end));
                start = end;
                end = end + logMaxLength;
            } else {
                Log.e(tag, msg.substring(start, strLength));
                break;
            }
        }

    }


    /**
     * error message
     *
     * @param tag
     * @param message
     */
    public static void e(String tag, String message) {
        if (DEBUG || openLog) {
            Log.e(tag, message);
        }
    }

    /**
     * warning message
     *
     * @param tag
     * @param message
     */
    public static void w(String tag, String message) {
        if (DEBUG || openLog) {
            Log.w(tag, message);
        }
    }

}
