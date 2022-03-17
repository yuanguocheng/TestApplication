package com.mumuxi.testapplication.mvvm;

import com.mumuxi.testapplication.android.utils.LogUtil;

import androidx.lifecycle.ViewModel;

/**
 * ViewModel 类旨在以注重生命周期的方式存储和管理界面相关的数据
 *
 * @author mumuxi
 * @version 2022/3/17
 */
public class MyViewModel extends ViewModel {

    public static final String TAG = MyViewModel.class.getSimpleName();

    private Person mPerson;

    /**
     * 旋转MvvmActivity之后，构造函数并没有重新执行，
     * 证明旋转之后 是同一个MyViewModel 实例。
     */
    public MyViewModel() {
        LogUtil.d(TAG, "init");
        mPerson = new Person("阿木木", 23);
    }


    public Person getPerson() {
        return mPerson;
    }

    public void setPerson(Person person) {
        mPerson = person;
    }

    @Override
    protected void onCleared() {
        LogUtil.d(TAG, "onCleared");
        super.onCleared();
    }
}
