package com.mumuxi.testapplication.ipc;

import java.io.Serializable;

/**
 * @author mumuxi
 * @date 2019/7/8
 * 1.静态成员变量属于类不属于对象，所以不会参加序列化
 * 2.用transient关键字标记的成员变量不参与序列化过程
 */
public class TestSerializable implements Serializable {
    public static final long serialVersionUID = 1L;

    public TestSerializable() {
    }
}
