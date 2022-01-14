package com.mumuxi.testapplication.javabase.objectclone;

/**
 * @author mumuxi
 * @date 2022/1/14
 *
 * 浅克隆实现
 *
 * 一般步骤是（浅克隆）：
 *
 * 1. 被复制的类需要实现Clonenable接口（不实现的话在调用clone方法会抛出CloneNotSupportedException异常)， 该接口为标记接口(不含任何方法)
 *
 * 2. 覆盖clone()方法，访问修饰符设为public。方法中调用super.clone()方法得到需要的复制对象。
 *
 * 浅克隆缺点：
 * Object 的 clone() 方法是浅拷贝，即如果类中属性有自定义引用类型，只拷贝引用，
 * 不拷贝引用指向的对象，使用clone方法也是可以的，但是会很麻烦。
 *  参考文章 https://www.jianshu.com/p/6a698f522903 内讲到的对象拷贝模块
 */
public class TestClone {

    public static void main(String[] args) throws CloneNotSupportedException {
        //创建对象 Person p1
        Person p1 = new Person(1, "ConstXiong");
        //克隆对象 p1
        Person p2 = (Person)p1.clone();
        //修改 p2的name属性，p1的name未变
        p2.setName("其不答");
        System.out.println(p1);
        System.out.println(p2);
    }

}


class Person implements Cloneable {

    private int pid;

    private String name;

    public Person(int pid, String name) {
        this.pid = pid;
        this.name = name;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Person [pid:"+pid+", name:"+name+"]";
    }

}

