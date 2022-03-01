package com.mumuxi.testapplication.android.fourcomponent.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * 服务
 * <p>
 * 一、概述：Service(服务)是一个一种可以在后台执行长时间运行操作而没有用户界面的应用组件。
 * 服务可由其他应用组件启动（如Activity），服务一旦被启动将在后台一直运行，即使启动服
 * 务的组件（Activity）已销毁也不受影响。 此外，组件可以绑定到服务，以与之进行交互，
 * 甚至是执行进程间通信 (IPC)。例如，服务可以处理网络事务、播放音乐，执行文件 I/O
 * 或与内容提供程序交互，而所有这一切均可在后台进行。
 * <p>
 * 二、状态分类：
 * 1.启动状态
 * 当应用组件（如 Activity）通过调用 startService() 启动服务时，服务即处于“启动”状态。
 * 一旦启动，服务即可在后台无限期运行，即使启动服务的组件已被销毁也不受影响，
 * 除非手动调用才能停止服务， 已启动的服务通常是执行单一操作，而且不会将结果返回给调用方。
 * <p>
 * 2.绑定状态
 * 当应用组件通过调用 bindService() 绑定到服务时，服务即处于“绑定”状态。
 * 绑定服务提供了一个客户端-服务器接口，允许组件与服务进行交互、发送请求、
 * 获取结果，甚至是利用进程间通信(IPC) 跨进程执行这些操作。
 * 仅当与另一个应用组件绑定时，绑定服务才会运行。 多个组件可以同时绑定到该服务，
 * 但全部取消绑定后，该服务即会被销毁。
 * <p>
 * 三、服务需要在 AndroidManifest.xml中声明
 * <p>
 * 四、启动服务以及终止服务
 * 1.启动服务： Context 的 startService 、bindService 方法
 * 2.终止服务： Context 的 stopService或者服务自身调用stopSelf也可以终止服务。
 * 但如果是被绑定的服务，需要调用unBindService方法，被多个组件绑定的服务，全部取
 * 消绑定后服务才会被销毁。
 * <p>
 * 注意：如果服务同时被启动和绑定过，则需要解除绑定且调用stopService或者服务
 * 自身调用stopSelf才可以终止服务
 * <p>
 * 五、生命周期
 * <p>
 * 1.新服务启动，调用了startervice后，会依次回调onCreate()、onStartCommand方法。
 * 2.新服务绑定，调用了bindService后，会依次回调onCreate()、onBind()方法。
 * 3.已经启动的服务，再次被调用bindService来绑定，onCreate()不会再回调，只会回调onBind。
 * <p>
 * onBind()
 * 当另一个组件想通过调用 bindService() 与服务绑定（例如执行 RPC）时，系统将调用此方法。
 * 在此方法的实现中，必须返回 一个IBinder接口的实现类，供客户端用来与服务进行通信。
 * 无论是启动状态还是绑定状态，此方法必须重写，但在启动状态的情况下直接返回 null。
 * <p>
 * onCreate()
 * 首次创建服务时，系统将调用此方法来执行一次性设置程序（在调用 onStartCommand()
 * 或onBind() 之前）。如果服务已在运行，则不会调用此方法，该方法只调用一次
 * <p>
 * onStartCommand()
 * 当另一个组件（如 Activity）通过调用 startService() 请求启动服务时，系统将调用此方法。
 * 一旦执行此方法，服务即会启动并可在后台无限期运行。如果自己实现此方法，则需要在服务工作完成后，
 * 通过调用 stopSelf() 或 stopService() 来停止服务。（在绑定状态下，无需实现此方法。）
 * <p>
 * onDestroy()
 * 当服务不再使用且将被销毁时，系统将调用此方法。服务应该实现此方法来清理所有资源，
 * 如线程、注册的侦听器、接收器等，这是服务接收的最后一个调用。
 * <p>
 * 六、前台服务与后台服务
 * 前台服务被认为是用户主动意识到的一种服务，因此在内存不足时，系统也不会考虑将其终止。
 * 前台服务必须为状态栏提供通知，状态栏位于“正在进行”标题下方，这意味着除非服务停止或从前台删除，
 * 否则不能清除通知。例如将从服务播放音乐的音乐播放器设置为在前台运行，这是因为用户明确意识到其操作。
 * 状态栏中的通知可能表示正在播放的歌曲，并允许用户启动 Activity 来与音乐播放器进行交互。
 * 如果需要设置服务运行于前台， 我们该如何才能实现呢？Android官方给我们提供了两个方法，
 * 分别是startForeground()和stopForeground()，这两个方式解析如下：
 * <p>
 * startForeground(int id, Notification notification)
 * 该方法的作用是把当前服务设置为前台服务，其中id参数代表唯一标识通知的整型数，需要注意的是提供给
 * startForeground() 的整型 ID 不得为0，而notification是一个状态栏的通知。
 * <p>
 * stopForeground(boolean removeNotification)
 * 该方法是用来从前台删除服务，此方法传入一个布尔值，指示是否也删除状态栏通知，true为删除。
 * 注意该方法并不会停止服务。 但是，如果在服务正在前台运行时将其停止，则通知也会被删除。
 *
 * @author mumuxi
 * @version 2022/2/25
 */
public class MyService extends Service {

    private static final String TAG = MyService.class.getSimpleName();

    public MyService() {
    }

    /**
     * Service的onCreate是在主线程（ActivityThread）中调用的，耗时操作会阻塞UI
     */
    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate: ");
        //前台服务
        /*if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
            startForeground(1, new Notification());
        } else {
            Log.d(TAG, "onCreate: " + Build.VERSION.SDK_INT);
        }*/
        super.onCreate();
    }

    /**
     * 只有调用了startService()方法才会被回调
     *
     * @param intent
     * @param flags
     * @param startId
     * @return 实际上onStartCommand的返回值int类型才是最最值得注意的，它有三种可选值，
     * START_STICKY，START_NOT_STICKY，START_REDELIVER_INTENT，它们具体含义如下：
     * <p>
     * START_STICKY
     * 当Service因内存不足而被系统kill后，一段时间后内存再次空闲时，系统将会尝试重新创建此Service，
     * 一旦创建成功后将回调onStartCommand方法，但其中的Intent将是null，除非有挂起的Intent，
     * 如pendingintent，这个状态下比较适用于不执行命令、但无限期运行并等待作业的媒体播放器或类似服务。
     * <p>
     * START_NOT_STICKY
     * 当Service因内存不足而被系统kill后，即使系统内存再次空闲时，系统也不会尝试重新创建此Service。
     * 除非程序中再次调用startService启动此Service这是最安全的选项，可以避免在不必要时以及应用能够
     * 轻松重启所有未完成的作业时运行服务。
     * <p>
     * START_REDELIVER_INTENT
     * 当Service因内存不足而被系统kill后，则会重建服务，并通过传递给服务的最后一个 Intent
     * 调用 onStartCommand()，任何挂起Intent均依次传递。与START_STICKY不同的是，
     * 其中的传递的Intent将是非空，是最后一次调用startService中的intent
     * 。这个值适用于主动执行应该立即恢复的作业（例如下载文件）的服务。
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        //调用stopself可以关闭服务
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * 只有调用了bindService()方法才会被会回调
     *
     * @param intent
     * @return
     */
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: ");
        // TODO: Return the communication channel to the service.
        return new Binder();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    /**
     * 当service中的 onUnBind() 方法返回true的情况下，再次绑定服务会被调用，否则不执行
     *
     * @param intent
     */
    @Override
    public void onRebind(Intent intent) {
        Log.d(TAG, "onRebind: ");
        super.onRebind(intent);
    }

}
