package com.mumuxi.testapplication.android.annotation;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.IntDef;
import androidx.annotation.StringDef;

/**
 * @author mumuxi
 * @date 2019/10/4
 * 注解例子，用IntDef、StringDef代替枚举
 */
public class DefExample {

    public static final int SUNDAY = 0;
    public static final int MONDAY = 1;
    public static final int TUESDAY = 2;
    public static final int WEDNESDAY = 3;
    public static final int THURSDAY = 4;
    public static final int FRIDAY = 5;
    public static final int SATURDAY = 6;

    @IntDef({SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface WeekDays {
    }

    @WeekDays
    int currentDay = SUNDAY;

    public int getCurrentDay(@WeekDays int day) {
        if (day == -1) {
            return currentDay;
        }
        return day;
    }



    public static final String TAG_DAY_SELECTED = "daySelected";
    public static final String TAG_GOOD_LIFE = "goodLife";
    public static final String TAG_RECOMMEND_BOOK = "recommendBook";

    @Retention(RetentionPolicy.SOURCE)
    //这里使用@StringDef来代替Enum枚举。它会帮我检测像Enum枚举一样，在编译时期检查变量的赋值情况！
    @StringDef({TAG_DAY_SELECTED, TAG_GOOD_LIFE, TAG_RECOMMEND_BOOK})
    //接口定义
    public @interface HomeTagType {
    }

    @HomeTagType
    public static String type = TAG_DAY_SELECTED;

}
