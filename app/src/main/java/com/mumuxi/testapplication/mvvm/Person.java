package com.mumuxi.testapplication.mvvm;

import com.mumuxi.testapplication.BR;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/**
 * @author mumuxi
 * @version 2022/3/17
 */
public class Person extends BaseObservable {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
