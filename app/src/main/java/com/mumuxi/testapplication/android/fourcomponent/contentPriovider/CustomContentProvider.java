package com.mumuxi.testapplication.android.fourcomponent.contentPriovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * 内容提供者
 *
 * @author mumuxi
 * @version 2022/3/1
 * <p>
 * 一、作用
 * 进程间 进行数据交互 & 共享，即跨进程通信
 * <p>
 * 二、统一资源标识符（URI）
 * 作用：唯一标识 ContentProvider & 其中的数据，
 * 外界进程通过 URI 找到对应的ContentProvider & 其中的数据，再进行数据操作
 * <p>
 * Uri uri = Uri.parse("content://com.carson.provider/User/1")
 * 上述URI指向的资源是：名为"com.carson.provider"的"ContentProvider"中表名为"User"中的 "id"
 * 为1的数据
 * <p>
 * 三、ContentProvider类
 * 1.ContentProvider类并不会直接与外部进程交互，而是通过ContentResolver类
 * 2.了解其需要实现的方法即可
 * 四、ContentResolver类
 * 1.统一管理不同 ContentProvider间的操作
 * 2.外部进程通过 ContentResolver类 从而与ContentProvider类进行交互
 * 3.为什么要使用通过ContentResolver类从而与ContentProvider类进行交互，而不直接访问ContentProvider类？
 * <p>
 * 一般来说，一款应用要使用多个ContentProvider，若需要了解每个ContentProvider的不同实现从而再完成数据交互，操作成本高 & 难度大
 * 所以再ContentProvider类上加多了一个 ContentResolver类对所有的ContentProvider进行统一管理。
 * 五、ContentUris类
 * 作用：操作 URI
 * 具体使用
 * 核心方法有两个：withAppendedId（） &parseId（）
 * 六、 ContentObserver类
 * 作用：观察 Uri引起 ContentProvider 中的数据变化 & 通知外界（即访问该数据访问者）
 */
public class CustomContentProvider extends ContentProvider {

    /**
     * ContentProvider创建后 或 打开系统后其它进程第一次访问该ContentProvider时 由系统进行调用
     * 注：运行在ContentProvider进程的主线程，故不能做耗时操作
     *
     * @return
     */
    @Override
    public boolean onCreate() {

        return false;
    }

    /**
     * 外部应用 获取 ContentProvider 中的数据
     *
     * @param uri
     * @param projection
     * @param selection
     * @param selectionArgs
     * @param sortOrder
     * @return
     */
    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection,
                        @Nullable String selection, @Nullable String[] selectionArgs,
                        @Nullable String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    /**
     * 外部进程向 ContentProvider 中添加数据
     *
     * @param uri
     * @param values
     * @return
     */
    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    /**
     * 外部进程 删除 ContentProvider 中的数据
     *
     * @param uri
     * @param selection
     * @param selectionArgs
     * @return
     */
    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection,
                      @Nullable String[] selectionArgs) {
        return 0;
    }

    /**
     * 外部进程更新 ContentProvider 中的数据
     *
     * @param uri
     * @param values
     * @param selection
     * @param selectionArgs
     * @return
     */
    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values,
                      @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
