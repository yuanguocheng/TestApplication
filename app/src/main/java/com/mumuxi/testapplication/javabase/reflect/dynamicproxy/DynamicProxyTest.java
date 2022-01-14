package com.mumuxi.testapplication.javabase.reflect.dynamicproxy;



/**
 * @author mumuxi
 * @date 2022/1/13
 */
public class DynamicProxyTest {

    public static void main(String[] args) {
        People people = new PeopleImpl();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        People proxy = (People) myInvocationHandler.getProxy(people);
        proxy.test();
    }
}


