package com.mumuxi.testapplication.javabase.reflect;

/**
 * @author mumuxi
 * @version 2022/4/30
 */
public class TestReflect {

    public static void main(String[] args) {
        /*测试获取单例类,通过Class.getDeclaredMethod直接获取单例获取方法，
        然后invoke就可以了*/
        try {
            Class ct = Class.forName(
                        "com.mumuxi.testapplication.javabase.designmodel.singletontest.DoubleCheck");
            Object object  = ReflectUtil.invoke(ct,null,"getInstance");
            ReflectUtil.invoke(ct,object,"test");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
