package com.mumuxi.ndktest;

/**
 * @author mumuxi
 * @date 2020/11/16
 */
public class JniUtil {

    public native String getString();

    public native int sum(int x,int y);
}
