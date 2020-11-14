package com.mumuxi.testapplication.android.utils;

import java.lang.reflect.Method;

/**
 * @author mumuxi
 * @date 2019/7/18
 */
public class SystemProperties {
    private static final String TAG = SystemProperties.class.getSimpleName();

    private SystemProperties() {
    }

    public static String get(String key, String def) {
        try {
            Class<?> SystemProperties = Class.forName("android.os.SystemProperties");
            Method m = SystemProperties.getMethod("get", String.class, String.class);
            String result = (String) m.invoke(null, key, "");
            LogUtil.i(TAG, "getSystemProperties:" + key + ":" + result);
            return result;
        } catch (Exception var4) {
            var4.printStackTrace();
            LogUtil.w(TAG, "getSystemProperties error" + var4);
            return def;
        }
    }

    public static boolean set(String key, String value) {
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method set = c.getMethod("set", String.class, String.class);
            set.invoke(c, key, value);
            LogUtil.i(TAG, "setSystemProperties:" + key + ":" + value);
            return true;
        } catch (Throwable var4) {
            LogUtil.w(TAG, "setSystemProperties error" + var4);
            return false;
        }
    }
}