package com.mumuxi.testapplication.alldimen;

/**
 * 适配所有分辨率
 * <p>
 * 使用前需关闭项目的aapt自动化打包 <br>
 * 解决方案 在gradle.properties中添加如下代码，禁用aapt2编译 <br>
 * android.enableAapt2=false <br>
 * 可以参考这个来生成一些文件
 *
 * @author mumuxi
 * @version 2022/2/24
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class AllDimen {

    private final static String rootPath = "./app/src/main/res/values-{0}x{1}";

    private final static float dw = 1920f;
    private final static float dh = 1080f;

    private final static String WTemplate = "<dimen name=\"w{0}\">{1}px</dimen>\n";
    private final static String HTemplate = "<dimen name=\"h{0}\">{1}px</dimen>\n";

    public static void main(String[] args) {

        makeString(854, 480);
        makeString(1280, 720);
        makeString(1920, 1080);
        makeString(2560, 1440);
        makeString(3840, 2160);
        makeString(4096, 3112);

    }

    public static void makeString(int w, int h) {

        StringBuffer sb = new StringBuffer();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
        sb.append("<resources>");
        float cellw = w / dw;
        for (int i = 1; i < 1920; i++) {
            sb.append(WTemplate.replace("{0}", i + "").replace("{1}", change(cellw * i) + ""));
        }
        sb.append(WTemplate.replace("{0}", "1920").replace("{1}", w + ""));
        sb.append("</resources>");

        StringBuffer sb2 = new StringBuffer();
        sb2.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
        sb2.append("<resources>");
        float cellh = h / dh;
        for (int i = 1; i < 1080; i++) {
            sb2.append(HTemplate.replace("{0}", i + "").replace("{1}", change(cellh * i) + ""));
        }
        sb2.append(HTemplate.replace("{0}", "1080").replace("{1}", h + ""));
        sb2.append("</resources>");

        String path = rootPath.replace("{0}", w + "").replace("{1}", h + "");
        File rootFile = new File(path);
        if (!rootFile.exists()) {
            rootFile.mkdirs();
        }
        File layxFile = new File(path, "lay_x.xml");
        File layyFile = new File(path, "lay_y.xml");
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(layxFile));
            pw.print(sb.toString());
            pw.close();
            pw = new PrintWriter(new FileOutputStream(layyFile));
            pw.print(sb2.toString());
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static float change(float a) {
        int temp = (int) (a * 100);
        return temp / 100f;
    }
}
