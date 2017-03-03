package com.example.wlwlxgg.simplemusic.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.example.wlwlxgg.simplemusic.R;
import com.jaeger.library.StatusBarUtil;

/**
 * Created by wlwlxgg on 2017/2/8.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBar();
    }
    protected void setStatusBar() {
        StatusBarUtil.setColor(this, 0xffffff, 0);
    }
}
