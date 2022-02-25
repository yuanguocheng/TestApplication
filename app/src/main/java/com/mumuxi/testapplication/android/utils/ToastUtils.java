package com.mumuxi.testapplication.android.utils;

import android.content.Context;
import android.os.Handler;
import android.view.Gravity;
import android.widget.Toast;

/**
 * @author mumuxi
 * @version 2022/2/25
 */
public class ToastUtils {

    private static final int INTEGER_3000 = 3000;
    private static final int INTEGER_3500 = 3500;

    private ToastUtils() {
    }

    public static void showToastShort(Context context, String text) {
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public static void showToastLong(Context context, String text) {
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * extend toast show time，at most show 6.5 seconds
     *
     * @param context
     * @param text    the message you want to show
     * @param time    the toast you wan to show time,unit（millisecond）,it must less than 6500
     */
    public static void showToast(final Context context, final String text, long time) {
        if (time < INTEGER_3500) {
            return;
        }
        //需要延时的时间长短
        long delayTime = time - INTEGER_3500;
        if (delayTime > INTEGER_3000) {
            delayTime = INTEGER_3000;
        }
        final Toast toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setText(text);
        toast.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        }, delayTime);
    }


}
