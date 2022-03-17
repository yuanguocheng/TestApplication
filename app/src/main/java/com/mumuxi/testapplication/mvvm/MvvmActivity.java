package com.mumuxi.testapplication.mvvm;


import android.os.Bundle;
import android.view.View;

import com.mumuxi.testapplication.R;
import com.mumuxi.testapplication.android.utils.LogUtil;
import com.mumuxi.testapplication.databinding.MvvmBinding;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

/**
 * @author mumuxi
 * @version 2022/3/17
 */
public class MvvmActivity extends AppCompatActivity {

    public static final String TAG = MvvmActivity.class.getSimpleName();
    MvvmBinding mMvvmBinding;
    MyViewModel mMyViewModel;
    EventListener mEventListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.d(TAG, "onCreate");
        mMvvmBinding = DataBindingUtil.setContentView(this, R.layout.mvvm);
        mMyViewModel = new ViewModelProvider(MvvmActivity.this).get(MyViewModel.class);
        //hashcode值没有发生变化，是同一个实例。
        LogUtil.d(TAG, mMyViewModel.hashCode() + "");
        mEventListener = new EventListener();
        mMvvmBinding.setPerson(mMyViewModel.getPerson());
        mMvvmBinding.setEventListener(mEventListener);
    }

    public class EventListener {

        public void onClick(View view) {
            mMyViewModel.getPerson().setName("修改名字了");
        }
    }

    @Override
    protected void onPause() {
        LogUtil.d(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        LogUtil.d(TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
