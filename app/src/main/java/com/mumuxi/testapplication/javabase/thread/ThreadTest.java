package com.mumuxi.testapplication.javabase.thread;

/**
 * @author mumuxi
 * @date 2019/9/14
 * 创建线程的三种方式
 * 1.继承Thread类
 * 2.实现Runnable接口
 * 3.实现Callable接口 如果：使用的是2创建的线程的话，可以直接这样启动：
 * 4.线程池
 */
public class ThreadTest {

    public ThreadTest() {
        new TestThread().start();
        new Thread(new TestRunable()).start();
    }
}
