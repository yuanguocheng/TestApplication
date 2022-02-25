package com.mumuxi.testapplication.javabase.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import androidx.annotation.IntDef;

/**
 * 注解类
 * <p>实现源码阶段保留的注解
 * @author mumuxi
 * @version  2022/2/24
*/
public class SourceAnnotation {

    public static final int SUNDAY = 0;
    public static final int MONDAY = 1;
    public static final int TUESDAY = 2;
    public static final int WEDNESDAY = 3;
    public static final int THURSDAY = 4;
    public static final int FRIDAY = 5;
    public static final int SATURDAY = 6;

    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD,ElementType.PARAMETER})
    @IntDef({SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY})
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

}
