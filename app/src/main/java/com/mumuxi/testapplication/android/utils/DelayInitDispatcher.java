package com.mumuxi.testapplication.android.utils;

import android.os.Looper;
import android.os.MessageQueue;

import java.util.LinkedList;
import java.util.Queue;


/*** 延迟初始化分发器 */
public class DelayInitDispatcher {

    private Queue<Runnable> mDelayTasks = new LinkedList<>();

    private MessageQueue.IdleHandler mIdleHandler = new MessageQueue.IdleHandler() {
        @Override
        public boolean queueIdle() {
            if (mDelayTasks.size() > 0) {
                mDelayTasks.poll().run();
            }
            return !mDelayTasks.isEmpty();
        }
    };

    public DelayInitDispatcher addTask(Runnable task) {
        mDelayTasks.add(task);
        return this;
    }

    public void start() {
        Looper.myQueue().addIdleHandler(mIdleHandler);
    }

}
