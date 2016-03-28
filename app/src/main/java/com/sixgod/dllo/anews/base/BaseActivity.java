package com.sixgod.dllo.anews.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by dllo on 16/3/2.
 */
public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        initView();
        initData();
    }

    protected abstract void initView();
    protected  abstract void initData ();
    protected abstract int setLayout();

}
