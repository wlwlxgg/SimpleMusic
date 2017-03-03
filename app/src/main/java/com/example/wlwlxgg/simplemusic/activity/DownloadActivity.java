package com.example.wlwlxgg.simplemusic.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.wlwlxgg.simplemusic.R;

/**
 * Created by wlwlxgg on 2017/3/3.
 */

public class DownloadActivity extends BaseActivity implements View.OnClickListener{
    private Button is_doing, is_down;
    private View is_doing_view, is_down_view;
    private TextView no_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        initView();
    }

    private void initView() {
        is_doing = (Button) findViewById(R.id.is_doing);
        is_doing.setOnClickListener(this);
        is_down = (Button) findViewById(R.id.is_down);
        is_down.setOnClickListener(this);
        is_doing_view = (View) findViewById(R.id.is_doing_view);
        is_down_view = (View) findViewById(R.id.is_down_view);
        no_content = (TextView) findViewById(R.id.no_content);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.is_doing:
                is_doing_view.setVisibility(View.INVISIBLE);
                is_down_view.setVisibility(View.VISIBLE);
                break;
            case R.id.is_down:
                is_doing_view.setVisibility(View.VISIBLE);
                is_down_view.setVisibility(View.INVISIBLE);
                break;
        }
    }
}
