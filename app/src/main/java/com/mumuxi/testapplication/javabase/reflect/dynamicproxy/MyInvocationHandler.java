package com.mumuxi.testapplication.javabase.reflect.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author mumuxi
 * @date 2022/1/13
 */
class MyInvocationHandler implements InvocationHandler {

    Object obj;

    public Object getProxy(Object obj){
        this.obj = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBefore();
        method.invoke(obj, args);
        doAfter();
        return null;
    }

    private void doBefore() {
        System.out.println("[Proxy]一些前置处理");
    }

    private void doAfter() {
        System.out.println("[Proxy]一些后置处理");
    }

}
