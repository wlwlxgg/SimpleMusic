package com.example.wlwlxgg.simplemusic.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.wlwlxgg.simplemusic.R;
import com.jaeger.library.StatusBarUtil;

/**
 * Created by wlwlxgg on 2017/2/7.
 */

public class PlayActivity extends BaseActivity implements View.OnClickListener{
    private ImageView search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        StatusBarUtil.setColor(PlayActivity.this, 0xffffff, 0);
        initView();
    }

    private void initView() {
        search = (ImageView)findViewById(R.id.search);
        search.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search:
                startActivity(new Intent(PlayActivity.this, SearchActivity.class));
                break;
        }
    }

    @Override
    protected void setStatusBar() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
    }
}
