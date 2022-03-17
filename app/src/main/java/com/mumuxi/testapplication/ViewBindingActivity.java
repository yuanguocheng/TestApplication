package com.mumuxi.testapplication;

import android.os.Bundle;
import android.view.View;

import com.mumuxi.testapplication.android.utils.ToastUtils;
import com.mumuxi.testapplication.databinding.TestBinding;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author mumuxi
 * @version 2022/3/17
 */
public class ViewBindingActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * 这里是根据需要绑定的layout文件自动生成的
     * 例：layout 文件名是 test.xml ，
     * 则生成的绑定类名为：TestBinding
     */
    TestBinding mTestBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTestBinding = TestBinding.inflate(getLayoutInflater());
        View view = mTestBinding.getRoot();
        setContentView(view);
        //mTestBinding.btnTestViewBinding就是布局文件里面按钮实例化出来的。
        mTestBinding.btnTestViewBinding.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test_view_binding:
                ToastUtils.showToast(ViewBindingActivity.this, "viewbingshow", 5000);
                break;
            default:
                break;
        }
    }
}
