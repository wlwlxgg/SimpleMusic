package com.example.wlwlxgg.simplemusic.activity;

import android.os.Bundle;

import com.example.wlwlxgg.simplemusic.R;
import com.jaeger.library.StatusBarUtil;

/**
 * Created by wlwlxgg on 2017/2/22.
 */

public class SearchActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        StatusBarUtil.setColor(SearchActivity.this, 0xffffff, 0);
    }
}
