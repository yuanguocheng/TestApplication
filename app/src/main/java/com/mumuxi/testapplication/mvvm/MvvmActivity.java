package com.mumuxi.testapplication.mvvm;


import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.mumuxi.testapplication.R;
import com.mumuxi.testapplication.android.utils.ToastUtils;
import com.mumuxi.testapplication.databinding.MvvmBinding;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

/**
 * @author mumuxi
 * @version 2022/3/17
 */
public class MvvmActivity extends AppCompatActivity {

    MvvmBinding mMvvmBinding;
    MyViewModel mMyViewModel;
    EventListener mEventListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMvvmBinding = DataBindingUtil.setContentView(this, R.layout.mvvm);
        mMyViewModel = new MyViewModel();
        mEventListener = new EventListener();
        mMvvmBinding.setPerson(mMyViewModel.getPerson());
        mMvvmBinding.setEventListener(mEventListener);

    }

    public class EventListener {

        public void onClick(View view) {
            mMyViewModel.getPerson().setName("修改名字了");

        }

    }


}
