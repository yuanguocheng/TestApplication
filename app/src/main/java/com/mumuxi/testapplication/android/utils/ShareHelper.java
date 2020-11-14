package com.mumuxi.testapplication.android.utils;

import android.content.Context;
import android.content.SharedPreferences;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author mumuxi
 * @date   2019/7/18
*/

public class ShareHelper {

    public static final String TABLE_NAME = "table";

    private ShareHelper() {
    }

    public static void saveArray(Context context, @NonNull String keyArrsy[], @NonNull String valuesArrsy[]) {
        SharedPreferences sp = context.getSharedPreferences(TABLE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        for (int i = 0; i < keyArrsy.length; i++) {
            editor.putString(keyArrsy[i], valuesArrsy[i]);
        }
        editor.apply();
    }

    public static String[] getArray(Context context, String keyArrsy[]) {
        SharedPreferences sp = context.getSharedPreferences(TABLE_NAME, Context.MODE_PRIVATE);
        String[] valuesArrsy = new String[]{};
        for (int i = 0; i < keyArrsy.length; i++) {
            valuesArrsy[i] = sp.getString(keyArrsy[i], null);
        }
        return valuesArrsy;
    }

    public static List<String> getList(Context context, @NonNull String keyArrsy[]) {
        SharedPreferences sp = context.getSharedPreferences(TABLE_NAME, Context.MODE_PRIVATE);
        List<String> valueList = new ArrayList<>();
        for (int i = 0; i < keyArrsy.length; i++) {
            valueList.add(sp.getString(keyArrsy[i], ""));
        }
        return valueList;
    }

    public static Map<String, String> getMap(Context context, @NonNull String keyArrsy[]) {
        SharedPreferences sp = context.getSharedPreferences(TABLE_NAME, Context.MODE_PRIVATE);
        Map<String, String> valueMap = new HashMap<>();
        for (int i = 0; i < keyArrsy.length; i++) {
            valueMap.put(keyArrsy[i], sp.getString(keyArrsy[i], ""));
        }
        return valueMap;
    }


    public static void save(Context context, String key, String value) {
        SharedPreferences sp = context.getSharedPreferences(TABLE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.apply();
    }

    @Nullable
    public static String get(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(TABLE_NAME, Context.MODE_PRIVATE);
        return sp.getString(key, null);
    }

}
