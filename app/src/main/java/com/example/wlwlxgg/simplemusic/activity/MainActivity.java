package com.example.wlwlxgg.simplemusic.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.wlwlxgg.simplemusic.R;
import com.example.wlwlxgg.simplemusic.adapter.MyGridViewAdapter;
import com.example.wlwlxgg.simplemusic.domain.PlayList;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener{
    GridView gv1, gv2;
    List<PlayList> mList;
    LinearLayout play;
    View myScrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myScrollView = findViewById(R.id.mViewNeedOffset);
        StatusBarUtil.setTranslucentForImageView(MainActivity.this, 0, myScrollView);
        initView();
    }
    private void initView() {
        gv1 = (GridView) findViewById(R.id.gv_1);
        gv2 = (GridView) findViewById(R.id.gv_2);
        mList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            PlayList playList = new PlayList();
//            playList.setCover(R.mipmap.cover);
            playList.setCover_name("Heaven");
            playList.setCover_num(60);
            mList.add(playList);
        }

        int size = mList.size();
        int length = 100;
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        float density = dm.density;
        int gridviewWidth = (int) (size * (length + 4) * density);
        int itemWidth = (int) (length * density);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                gridviewWidth, LinearLayout.LayoutParams.FILL_PARENT);
        gv1.setLayoutParams(params); // 设置GirdView布局参数,横向布局的关键
        gv1.setColumnWidth(itemWidth); // 设置列表项宽
        gv1.setHorizontalSpacing(40); // 设置列表项水平间距
        gv1.setStretchMode(GridView.NO_STRETCH);
        gv1.setNumColumns(size); // 设置列数量=列表集合数
        gv2.setLayoutParams(params); // 设置GirdView布局参数,横向布局的关键
        gv2.setColumnWidth(itemWidth); // 设置列表项宽
        gv2.setHorizontalSpacing(40); // 设置列表项水平间距
        gv2.setStretchMode(GridView.NO_STRETCH);
        gv2.setNumColumns(size); // 设置列数量=列表集合数
        gv1.setAdapter(new MyGridViewAdapter(MainActivity.this, mList));
        gv2.setAdapter(new MyGridViewAdapter(MainActivity.this, mList));
        play = (LinearLayout)findViewById(R.id.play);
        play.setOnClickListener(this);
    }

    @Override
    protected void setStatusBar() {
        myScrollView = findViewById(R.id.mViewNeedOffset) ;
        StatusBarUtil.setTranslucentForImageView(MainActivity.this, myScrollView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play:
                Intent intent = new Intent(MainActivity.this, PlayActivity.class);
                startActivity(intent);
                break;
        }
    }
}
