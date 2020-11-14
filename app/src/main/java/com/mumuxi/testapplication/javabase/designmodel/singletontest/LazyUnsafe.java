package com.mumuxi.testapplication.javabase.designmodel.singletontest;
/**
 * Created by mumuxi on 2019/7/4
 * 懒汉模式 非线程安全
 */
public class LazyUnsafe {
    private static LazyUnsafe instance;

    private LazyUnsafe() {
    }

    public static LazyUnsafe getInstance() {
        if (instance == null) {
            instance = new LazyUnsafe();
        }
        return instance;
    }
}