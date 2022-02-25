package com.mumuxi.testapplication.android.optimize;

import android.os.StrictMode;
import android.os.Bundle;


import com.mumuxi.testapplication.BuildConfig;
import com.mumuxi.testapplication.R;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author mumuxi
 * @version 2019/10/6
 * <p>
 * 内存优化
 * 1.数据类型的选择，选择最优数据类型
 * 1.1 Sparse数组 代替hashmap (hashmap 更耗内存，但是执行时间更快，这个需要权衡，hashmap可以到处到其他android
 * 平台使用，sparse不行)
 * 1.2 ArrayMap
 * 1.3 对接集合迭代所选择的方式（for循环、while循环、iterator循环）
 * 1.4 枚举 用 @IntDef  @StringDef 代替
 * 2. 如果静态变量声明为static final ,它们会被存储在dex文件中，节约内存
 * 3.对象管理，尽量少的创建临时对象，因为它们会频繁地触发垃圾回收
 * （不过需要注意的是，常驻对象占内存，临时对象会引起的是内存抖动）
 * 3.1 字符串的创建 String string = "example"更符合内存对性能的要求
 * 3.2 字符串连接 用StringBuilder和StingBuffer ，二者的区别是StringBuilder非线程安全，所以更快，
 * Stringbuffer线程安全
 * 3.4 数组与集合的选择 https://www.bigocheatsheet.com
 * 3.5 内存设计模式
 * 3.5.1 对象池模式
 * 3.5.2 享元模式
 * 内存泄漏注意：
 * 1.IO流的关闭
 * 2.activity泄漏
 * 3.静态字段
 * 4.单例
 * 5.匿名内部类
 * 6.handlers
 * <p>
 * 内存分析：
 * 1.通过ActivityManager提供的一些方法可用于获得当前的内存的消耗/可用情况
 * 2.logcat 看日志信息分析
 * 可参考地址：
 * https://blog.csdn.net/itachi85/article/details/73149305
 * <p>
 * 2.1 Dalvik内存日志 ，格式如下
 * D/dalvikvm: <GcReason> <AmountFreed>,<HeapStats>,
 * <ExternalMemoryStats>,<PauseTime>
 * GC Reason就是指引起GC原因，有以下几种：
 * GC_CONCURRENT：当堆开始填充时，并发GC可以释放内存。
 * GC_FOR_MALLOC：当堆内存已满时，app尝试分配内存而引起的GC，系统必须停止app并回收内存。
 * GC_HPROF_DUMP_HEAP：当你请求创建 HPROF 文件来分析堆内存时出现的GC。
 * GC_EXPLICIT：显示的GC，例如调用System.gc()（应该避免调用显示的GC，信任GC会在需要时运行）。
 * GC_EXTERNAL_ALLOC：仅适用于 API 级别小于等于10 ，用于外部分配内存的GC。
 * <p>
 * Amount_freed：本次GC释放内存的大小。
 * Heap_stats：堆的空闲内存百分比 （已用内存）/（堆的总内存）。
 * External_memory_stats：API 级别 10 及更低级别的内存分配 （已分配的内存）/（引起GC的阀值）。
 * Pause time：暂停时间，更大的堆会有更长的暂停时间。并发暂停时间显示了两个暂停：
 * 一个出现在垃圾收集开始时，另一个出现在垃圾收集快要完成时。
 * <p>
 * 2.2 ART内存日志
 * ART的GC日志与DVM不同，ART 不会为没有明确请求的垃圾收集打印GC日志。
 * 只有在认为GC速度慢时才会打印GC日志，更确切来说，仅在GC暂停超过5ms 或GC持续时间超过
 * 100ms 时才会打印GC日志。如果app未处于可察觉的暂停进程状态，那么它的GC不会被认为是慢速的。
 * ART的GC日志始终会记录显式的垃圾收集。
 * <p>
 * ...参考上面提到的网址
 * 3.启用StrictMode来检测内存问题。
 * 4. dumpsys meminfo + packagename 来查看应用内存使用信息
 * Pss : 应用程序占用的内存总大小
 * <p>
 * 5.adb shell dumpsys procstats packagename --hours 3 查看过去三小时内的内存变化情况
 */
public class MemoryOptimizeTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_optimize_test);
        //开启strictmode
        if (BuildConfig.DEBUG) {
            StrictMode.VmPolicy policy =
                    new StrictMode.VmPolicy.Builder().detectActivityLeaks().detectAll().penaltyLog().build();
            StrictMode.setVmPolicy(policy);
        }

    }
}
