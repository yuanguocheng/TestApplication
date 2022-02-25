package com.mumuxi.testapplication.javabase.designmodel.singletontest;

/**
 * @author mumuxi
 * @version 2022/2/25
 */
public class Hungry {
    private static Hungry instance = new Hungry();

    private Hungry() {
    }

    public static Hungry getInstance() {
        return instance;
    }
}