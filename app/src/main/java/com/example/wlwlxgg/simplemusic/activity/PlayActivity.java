package com.example.wlwlxgg.simplemusic.activity;


import android.os.Bundle;

import com.example.wlwlxgg.simplemusic.R;
import com.jaeger.library.StatusBarUtil;

/**
 * Created by wlwlxgg on 2017/2/7.
 */

public class PlayActivity extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        StatusBarUtil.setColor(PlayActivity.this, 0xffffff, 0);
    }

    @Override
    protected void setStatusBar() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
    }
}
