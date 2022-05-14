package com.mumuxi.testapplication.android.utils;

import android.util.Log;

public class LauncherTimer {

    private static long time;

    public static void startRecord() {
        time = System.currentTimeMillis();
    }

    public static void endRecord(String msg) {
        long cost = System.currentTimeMillis() - time;
        Log.d("LauncherTimer", msg + " cost time = " + cost);
    }

}
