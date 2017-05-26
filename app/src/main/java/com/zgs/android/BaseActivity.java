package com.zgs.android;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2017/5/26 0026.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        onCreateDate(savedInstanceState);
    }

    protected abstract void onCreateDate(@Nullable Bundle savedInstanceState);

    @LayoutRes
    protected abstract int getLayoutId();

}
