package com.mumuxi.testapplication.android.serialize;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author mumuxi
 * @version 2019/7/8
 * <p>
 * 1.反序列化是生成了一个新的对象,跟原对象只是内容上的一致，并不是同一个对象
 * 2.Parcelable 是 android的序列化方式，缺点使用麻烦，但效率高，parcelable主要用在内存序列化上，
 * 通过parcelable将对象序列化到存储设备中或者将对象序列化后通过网络传输也都是可以的，但过程稍复杂，
 * 因此在这两种情况下建议大家使用serializable
 */
public class TestParcelable implements Parcelable {
    private int mInt = 8;
    private String mString = "test";
    private boolean mBoolean = false;

    public int getInt() {
        return mInt;
    }

    public void setInt(int anInt) {
        this.mInt = anInt;
    }

    public TestParcelable() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mInt);
        dest.writeString(this.mString);
        dest.writeByte(this.mBoolean ? (byte) 1 : (byte) 0);
    }

    protected TestParcelable(Parcel in) {
        this.mInt = in.readInt();
        this.mString = in.readString();
        this.mBoolean = in.readByte() != 0;
    }

    public static final Creator<TestParcelable> CREATOR = new Creator<TestParcelable>() {
        @Override
        public TestParcelable createFromParcel(Parcel source) {
            return new TestParcelable(source);
        }

        @Override
        public TestParcelable[] newArray(int size) {
            return new TestParcelable[size];
        }
    };
}
