package com.mumuxi.testapplication.javabase.designmodel.singletontest;
/**
 * Created by mumuxi on 2019/7/4
 * 饿汗模式
 */
public class Hungry {
    private static Hungry instance = new Hungry();

    private Hungry() {
    }

    public static Hungry getInstance() {
        return instance;
    }
}