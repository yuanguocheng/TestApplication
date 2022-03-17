package com.mumuxi.testapplication.mvvm;

/**
 * @author mumuxi
 * @version 2022/3/17
 */
public class MyViewModel {

    private Person mPerson;

    public MyViewModel() {
        mPerson = new Person("阿木木", 23);
    }


    public Person getPerson() {
        return mPerson;
    }

    public void setPerson(Person person) {
        mPerson = person;
    }
}
