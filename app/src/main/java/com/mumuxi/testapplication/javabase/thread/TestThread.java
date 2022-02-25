package com.mumuxi.testapplication.javabase.thread;

/**
 * @author mumuxi
 * @version 2022/2/23
 */
public class TestThread {

    public static final String TAG = TestThread.class.getSimpleName();

    public static void main(String[] args) throws Exception {

        /**
         * 1、start() 启动线程
         * 2、setPriority()  设置线程优先级
         * 3、getPriority()   获取线程优先级
         * 4、Thread.currentThread()   线程类的静态方法，用来获取当前线程
         * 5、Thread.sleep()   线程类的静态方法，线程休眠，让当前线程进入睡眠阻塞状态
         * 6、setDaemon()    将该线程标记为守护线程或用户线程
         * 7、interrupt()  interrupt() 方法只是改变中断状态而已，它不会中断一个正在运行的线程。如果线程被Object.wait, Thread
         * .join和Thread.sleep三种方法之一阻塞，此时调用该线程的interrupt()方法，那么该线程将抛出一个 InterruptedException中断异常。
         * 8、isAlive   判断线程是否处于活动状态。
         * 9、join() 等待线程执行指定时间或执行完后再继续执行
         */

        Thread thread = new MyThread();
        Thread thread1 = new MyThread("你好");

        //调用start()方法启动线程，多次调用会抛出 IllegalThreadStateException 异常
        thread.start();

        //通过setPriority方法设置线程优先级
        thread.setPriority(4);

        //通过getPriority方法获取线程优先级
        System.out.println(thread.getPriority());

        //Thread类的静态方法，用来获取当前线程
        Thread.currentThread();

        //该方法判断当前线程是否处于活动状态。
        System.out.println("thread isAlive = " + thread.isAlive());

        //获取线程唯一标识,这个ID是同步递增的
        System.out.println(thread.getId());
        System.out.println(thread1.getId());

        //getName()获取线程名称
        System.out.println(thread.getName());
        System.out.println(thread1.getName());

        //getState()获取线程的状态
        System.out.println(thread.getState());
        System.out.println(thread1.getState());

        //等待该线程终止的时间最长为 millis 毫秒,不指定时间的话，会一直等待改线程结束后才继续执行
        thread.join(2000);
        System.out.println("join 2 seconds end");
        thread.join();
        System.out.println("join end");

        //打断线程的sleep状态
//        thread.interrupt();

    }

    static class MyThread extends Thread {

        public MyThread() {
            super();
        }

        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println("thread start work");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("throw InterruptedException");
                e.printStackTrace();
            }
            System.out.println("thread end");
        }
    }

}
