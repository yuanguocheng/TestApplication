package com.mumuxi.testapplication.android.fourcomponent.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * 广播
 *
 * @author mumuxi
 * @version 2022/3/1
 * <p>
 * 分类：
 * <p>
 * 广播可以分为有序广播、无序广播、本地广播、粘性广播、前台广播、后台广播<br>
 * 本地广播用于应用内部传递消息，比broadcastReceiver更加高效 <br>
 * 本地广播只在应用内部有效，所以不需要考虑安全问题。普通的BroadcastReceiver<br>
 * 用于应用之间的传递消息，本质上它是跨应用的，所以在使用它时必须要考虑到不要被别的应用滥用；<br>
 * <p>
 * 1.调用 Context的 sendBroadcast 发送普通广播
 * <p>
 * 2. 调用 Context的 sendOrderedBroadcast 发送有序广播
 * <p>
 * (1) 有序广播可以用priority来调整优先级 取值范围-1000~+1000，默认为0，
 * 数值越大优先级越高，优先级越高越优先获得广播响应。
 * (2) abortBroadcast()可来终止该广播的传播，对更低优先级的屏蔽，注意只对有序广播生效。
 * (3) 有序广播在传播数据中会发生比如setResultData()，getResultData()，
 * 在传播过程中，可以从新设置数据
 * <p>
 * 3.本地广播，通过LocalBroadcastManager来实现发送广播和注册本地广播接收器
 * 发送广播：LocalBroadcastManager.getInstance(Context).sendBroadcast(new Intent("这里放一个action"));
 * 注册广播接收器：LocalBroadcastManager.getInstance(Context).registerReceiver(localReceiver);
 * <p>
 * 4. 调用 Context的 sendStickyBroadcast 发送粘性广播
 * <p>
 * (粘性消息在发送后就一直存在于系统的消息容器里面，
 * 等待对应的处理器去处理，如果暂时没有处理器处理这个消息则
 * 一直在消息容器里面处于等待状态，粘性广播的Receiver
 * 如果被销毁，那么下次重建时会自动接收到消息数据。
 * 在 android 5.0/api 21中deprecated,不再推荐使用，
 * 相应的还有粘性有序广播，同样已经deprecated)
 * <p>
 * <p>
 * 5. 前台广播与后台广播
 * 根据发送的广播Intent是否带有Intent.FLAG_RECEIVER_FOREGROUND,
 * 来决定将广播放入AMS中的前台广播队列(mFgBroadcastQueue) ,
 * 还是后台广播队列(mBgBroadcastQueue)，主要影响到的是ANR的广播的
 * onReceive()函数的时间判断，前台广播（BroadcastReceiver）的
 * onReceive()函数时10秒没有处理完成则会发生ANR，后台广播为60秒。
 * <p>
 * 注册广播：
 * <p>
 * 注册广播方式一般有两种：
 * 1.动态注册在代码中注册；
 * 2.静态注册在 AndroidManifest.xml 中注册；
 * <p>
 * 广播优先级：
 * 1、动态广播优先级
 * ①无序广播以并行或者无序方式发送，无优先级
 * ②有序广播按照串行方式发送，有优先级
 * <p>
 * 2、静态广播优先级
 * ①无序广播并行或者无序发送
 * ②有序广播串行方式执行，如果是同等优先级，按照app安装的先后执行，因为静态广播注册到系统中，由PMS管理。
 * <p>
 * 3、静态广播与动态广播的优先级
 * ①对于无序广播，动态广播优先发送A
 * ②对于有序广播，动态广播和静态广播按照优先级合并之后发送，此外，如果优先级相同(算法决定)，那么依然是动态态广播先接收
 */
public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(MyBroadcastReceiver.class.getSimpleName(), "onReceive");
        //do something

    }
}
