package com.mumuxi.testapplication.javabase.utils;

import com.mumuxi.testapplication.android.utils.CommonUtil;

/**
 * Create By mumuxi On 2019-3-10
 */
public class FileUtil {

    private static final String TAG = FileUtil.class.getSimpleName();

    private FileUtil() {
    }

    /**
     * 设置文件或文件夹读写权限
     *
     * @param permission 权限
     * @param path       路径
     * @return 是否设置成功
     */
    public static void setFileOrDirRW(final String permission, final String path) {
        String command = "chmod" + " " + permission + " " + path;
        boolean result = CommonUtil.exceuteCommand(command);
        if (!result) {
            throw new IllegalAccessError("no file operation permission");
        }
    }


}
