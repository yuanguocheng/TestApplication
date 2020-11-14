package com.mumuxi.testapplication.javabase.designmodel.singletontest;
/**
 * Created by mumuxi on 2019/7/4
 * 懒汉模式，多线程安全
 * 缺点：每次调用时都进行同步，造成不必要的同步和开销
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