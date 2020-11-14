package com.mumuxi.testapplication.javabase.designmodel.singletontest;
/**
 * Created by mumuxi on 2019/7/4
 * Double Check Lock
 * 优点：需要时才进行实例化，且保证线程安全，对象实例化之后调用getInstance不进行同步锁
 */
public class DoubleCheck {

    private static volatile DoubleCheck singleton;

    private DoubleCheck() {
    }

    public static DoubleCheck getInstance() {
        if (singleton == null) {
            synchronized (DoubleCheck.class) {
                if (singleton == null) {
                    singleton = new DoubleCheck();
                }
            }
        }
        return singleton;
    }
}