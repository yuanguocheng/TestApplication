package com.mumuxi.testapplication.javabase.designmodel.singletontest;

/**
 * Double Check Lock
 * <p>
 * 优点：需要时才进行实例化，且保证线程安全，对象实例化之后调用getInstance不进行同步锁
 *
 * @author mumuxi
 * @version 2022/2/25
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

    private void test(){
        System.out.println("test");
    }
}