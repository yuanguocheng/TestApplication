package com.mumuxi.testapplication.android.optimize;

import android.app.Activity;
import android.os.Bundle;

import com.mumuxi.testapplication.R;

import androidx.annotation.Nullable;

/**
 * UI优化分析
 *
 * @author mumuxi
 * @version 2019/10/4
 */
public class ViewOptimizeTest extends Activity {

    /**
     * UI优化
     * 1.将Activity 的根背景放到主题中去或移除
     * <p>
     * 2.硬件加速
     * 2.1activity 或 application开启加速
     * android:hardwareAccelerated="true"
     * <p>
     * 2.2 window 开启加速
     * getWindow().setFlags(
     * WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
     * WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
     * <p>
     * 2.3
     * 你可以在运行时使用以下代码禁止个别的View的硬加速：
     * myView.setLayerType(View.LAYER_TYPE_SOFTWARE,null);
     * <p>
     * 2.4
     * View.isHardwareAccelerated()：如果View附加到一个硬加速的window上就返回true．
     * Canvas.isHardwareAccelerated()：如果Canvas被硬加速了就返回true．
     * <p>
     * 3.布局优化常用标签
     * 3.1 <include/> 布局复用
     * 3.2 <merge /> 减少冗余布局
     * 3.3 <ViewStub /> 延迟部分view的加载，缩短首次加载时间，以及减少不必要的内存分配，需要时才设置可见性
     * 4.Hierarchy Viewer 工具的使用
     * 5. 通过真机开发者选项找到GPU过度绘制调试，开启该功能，可以看到，屏幕会根据每个像素被绘制的册数，以不同的
     * 色块加以区分，不同的色块代表着过度绘制的次数。
     * <p>
     * 6.GPU渲染分析（但目前不知道从代码哪里入手，只是可以看到优化结果）
     * 可以通过命令 adb shell dumpsys gfxinfo <package_nama> 比较优化结果
     * 7.Systrace 较难使用，还未知怎么使用
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_optimize_test);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (hasFocus) {
            getWindow().setBackgroundDrawable(null);
        }
        super.onWindowFocusChanged(hasFocus);
    }
}
