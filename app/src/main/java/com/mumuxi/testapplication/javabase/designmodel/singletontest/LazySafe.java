package com.mumuxi.testapplication.javabase.designmodel.singletontest;

/**
 * 懒汉模式，多线程安全
 * <p>
 * 缺点：每次调用时都进行同步，造成不必要的同步和开销
 *
 * @author mumuxi
 * @version 2022/2/25
 */
public class LazySafe {
    private static LazySafe instance;

    private LazySafe() {
    }

    public static synchronized LazySafe getInstance() {
        if (instance == null) {
            instance = new LazySafe();
        }
        return instance;
    }
}