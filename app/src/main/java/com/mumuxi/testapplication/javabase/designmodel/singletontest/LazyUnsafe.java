package com.mumuxi.testapplication.javabase.designmodel.singletontest;

/**
 * 懒汉模式 非线程安全
 *
 * @author mumuxi
 * @version 2022/2/25
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