package com.mumuxi.testapplication.javabase.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


/**
 * @author mumuxi
 * @date   2020/11/15
 * 反射工具，参考滴滴VirtualApk框架
*/
@SuppressWarnings("rawtypes")
public class ReflectUtil {

    /**
     * 获取指定对象的某成员变量
     * @param clazz 该对象的类对象
     * @param target 指定对象实例
     * @param name 成员变量名称
     * @return 返回需要的成员变量
     * @throws Exception
     */
    public static Object getField(Class clazz, Object target, String name) throws Exception {
        Field field = clazz.getDeclaredField(name);
        field.setAccessible(true);
        return field.get(target);
    }

    /**
     * 获取指定对象的某成员变量
     * @param clazz 该对象的类对象
     * @param target 指定对象实例
     * @param name 成员变量名称
     * @return 返回需要的成员变量
     */
    public static Object getFieldNoException(Class clazz, Object target, String name) {
        try {
            return ReflectUtil.getField(clazz, target, name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 设置指定对象的某成员变量
     * @param clazz 该对象的类对象
     * @param target 指定对象实例
     * @param name 成员变量名称
     * @param value 需要设置的值
     * @throws Exception
     */
    public static void setField(Class clazz, Object target, String name, Object value) throws Exception {
        Field field = clazz.getDeclaredField(name);
        field.setAccessible(true);
        field.set(target, value);
    }

    /**
     * 设置指定对象的某成员变量
     * @param clazz 该对象的类对象
     * @param target 指定对象实例
     * @param name 成员变量名称
     * @param value 需要设置的值
     */
    public static void setFieldNoException(Class clazz, Object target, String name, Object value) {
        try {
            ReflectUtil.setField(clazz, target, name, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过反射调用某对象隐藏的方法
     * @param clazz 该对象的类对象
     * @param target 指定对象实例
     * @param name 方法名称
     * @param args 需要传入的参数
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static Object invoke(Class clazz, Object target, String name, Object... args)
            throws Exception {
        Class[] parameterTypes = null;
        if (args != null) {
            parameterTypes = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                parameterTypes[i] = args[i].getClass();
            }
        }

        Method method = clazz.getDeclaredMethod(name, parameterTypes);
        method.setAccessible(true);
        return method.invoke(target, args);
    }

    /**
     * 通过反射调用某对象隐藏的方法
     * @param clazz 该对象的类对象
     * @param target 指定对象实例
     * @param name 方法名称
     * @param parameterTypes 需要传入的参数的类数组
     * @param args 需要传入的参数
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static Object invoke(Class clazz, Object target, String name, Class[] parameterTypes, Object... args)
            throws Exception {
        Method method = clazz.getDeclaredMethod(name, parameterTypes);
        method.setAccessible(true);
        return method.invoke(target, args);
    }


    /**
     * 通过反调用某对象隐藏的方法
     * @param clazz 该对象的类对象
     * @param target 指定对象实例
     * @param name 方法名称
     * @param parameterTypes 需要传入的参数的类数组
     * @param args 需要传入的参数
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static Object invokeNoException(Class clazz, Object target, String name, Class[] parameterTypes, Object... args) {
        try {
            return invoke(clazz, target, name, parameterTypes, args);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 通过反射某类的构造函数来创建一个实例
     * @param clazz 该对象的类对象
     * @param parameterTypes 需要传入的参数的类数组
     * @param args 需要传入的参数
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static Object invokeConstructor(Class clazz, Class[] parameterTypes, Object... args)
            throws Exception {
        Constructor constructor = clazz.getDeclaredConstructor(parameterTypes);
        constructor.setAccessible(true);
        return constructor.newInstance(args);
    }

}
