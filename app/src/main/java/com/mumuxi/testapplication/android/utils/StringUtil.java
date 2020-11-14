package com.mumuxi.testapplication.android.utils;
/**
 * @author mumuxi
 * @date   2019/7/18
*/
public class StringUtil {

    private StringUtil() {
    }

    public static String replace(String value, String[] replace) {
        String afterReplace = value;
        for (String str : replace) {
            afterReplace = afterReplace.replace(str, "");
        }
        return afterReplace;
    }

}
