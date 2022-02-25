package com.mumuxi.testapplication.javabase.designmodel.singletontest;

/**
 * @author mumuxi
 * @version 2022/2/25
 * 静态内部类实现单例，这是推荐的单例实现模式
 * 出现背景：
 * DCL虽然在一定程度上解决了资源消耗、多余的同步、线程安全等问题，但它还是在某些情况下出现
 * 失效的情况，这个问题被称为双中检查锁定（DCL）失效。
 * <p>
 * 虚拟机保证一个类的构造器在多线程环境中被正确地加多、同步，如果多个线程同时去初始化一个类，
 * 那么只会有一个线程去执行这个类的加载器，其他线程都需要阻塞等待
 */
public class StaticInner {

    private StaticInner() {
    }

    private static class SingletonInstance {
        private static final StaticInner INSTANCE = new StaticInner();
    }

    public static StaticInner getInstance() {
        return SingletonInstance.INSTANCE;
    }
}