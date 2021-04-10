package com.mumuxi.testapplication.javabase.exception;

/**
 * @author mumuxi
 * @date 2019/7/8
 * 自定义异常,抛出明确的异常类型，方便分析问题和给用户不同的提示
 *
 * 面试常见问题
 *
 * 1. Error 和 Exception 区别是什么？
 * Error 类型的错误通常为虚拟机相关错误，如系统崩溃，内存不足，堆栈溢出等，
 * 编译器不会对这类错误进行检测，JAVA 应用程序也不应对这类错误进行捕获，一旦这类错误发生，
 * 通常应用程序会被终止，仅靠应用程序本身无法恢复；
 * Exception 类的错误是可以在应用程序中进行捕获并处理的，通常遇到这种错误，应对其进行处理，
 * 使应用程序可以继续正常运行。
 * <p>
 *
 * 2. 运行时异常和一般异常区别是什么？
 * 编译器不会对运行时异常进行检测，没有 try-catch，方法签名中也没有 throws 关键字声明，
 * 编译依然可以通过。如果出现了 RuntimeException, 那一定是程序员的错误。
 * 一般异常如果没有 try-catch，且方法签名中也没有用 throws 关键字声明可能抛出的异常，
 * 则编译无法通过。这类异常通常为应用环境中的错误，即外部错误，非应用程序本身错误，如文件找不到等。
 * <p>
 *
 * 3.NoClassDefFoundError 和 ClassNotFoundException 区别？
 * NoClassDefFoundError 是一个 Error 类型的异常，是由 JVM 引起的，不应该尝试捕获这个异常。
 * 引起该异常的原因是 JVM 或 ClassLoader 尝试加载某类时在内存中找不到该类的定义，
 * 该动作发生在运行期间，即编译时该类存在，但是在运行时却找不到了，可能是变异后被删除了等原因导致；
 * ClassNotFoundException 是一个受查异常，需要显式地使用 try-catch 对其进行捕获和处理，
 * 或在方法签名中用 throws 关键字进行声明。当使用 Class.forName, ClassLoader.loadClass
 * 或 ClassLoader.findSystemClass 动态加载类到内存的时候，通过传入的类路径参数没有找到该类，
 * 就会抛出该异常；另一种抛出该异常的可能原因是某个类已经由一个类加载器加载至内存中，
 * 另一个加载器又尝试去加载它。
 * <p>
 *
 * 4. JVM 是如何处理异常的？
 * 在一个方法中如果发生异常，这个方法会创建一个一场对象，并转交给 JVM，该异常对象包含异常名称，
 * 异常描述以及异常发生时应用程序的状态。创建异常对象并转交给 JVM 的过程称为抛出异常。
 * 可能有一系列的方法调用，最终才进入抛出异常的方法，这一系列方法调用的有序列表叫做调用栈。
 * JVM 会顺着调用栈去查找看是否有可以处理异常的代码，如果有，则调用异常处理代码。
 * 当 JVM 发现可以处理异常的代码时，会把发生的异常传递给它。
 * 如果 JVM 没有找到可以处理该异常的代码块，
 * JVM 就会将该异常转交给默认的异常处理器（默认处理器为 JVM 的一部分），
 * 默认异常处理器打印出异常信息并终止应用程序。
 * <p>
 *
 * 5. throw 和 throws 的区别是什么？
 * throw 关键字用来抛出方法或代码块中的异常，受查异常和非受查异常都可以被抛出。
 * throws 关键字用在方法签名处，用来标识该方法可能抛出的异常列表。
 * 一个方法用 throws 标识了可能抛出的异常列表，调用该方法的方法中必须包含可处理异常的代码，
 * 否则也要在方法签名中用 throws 关键字声明相应的异常。
 * <p>
 *
 * 6. 常见的 RuntimeException 有哪些？
 * ClassCastException(类转换异常)
 * IndexOutOfBoundsException(数组越界)
 * NullPointerException(空指针)
 * ArrayStoreException(数据存储异常，操作数组时类型不一致)
 * 还有IO操作的BufferOverflowException异常
 *
 */
public class DataIllegalException extends Exception {
    
    public static final String EXCEPTION_MESSAGE = "数据异常";
    private static final long serialVersionUID = 1L;

    public DataIllegalException() {
        super(EXCEPTION_MESSAGE);
    }

    public DataIllegalException(String message) {
        super(message);
    }
}
