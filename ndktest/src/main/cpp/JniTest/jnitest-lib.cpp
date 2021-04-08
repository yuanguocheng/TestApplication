#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_mumuxi_ndktest_JniUtil_getString(JNIEnv *env, jobject thiz) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_mumuxi_ndktest_JniUtil_sum(JNIEnv *env, jobject thiz, jint x, jint y) {
    jint mInt = x + y;
    return mInt;
}