package com.example.wlwlxgg.simplemusic.activity;


import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wlwlxgg.simplemusic.R;
import com.example.wlwlxgg.simplemusic.domain.MusicInfo;
import com.example.wlwlxgg.simplemusic.service.DownloadService;
import com.jaeger.library.StatusBarUtil;

import java.io.IOException;

/**
 * Created by wlwlxgg on 2017/2/7.
 */

public class PlayActivity extends BaseActivity implements View.OnClickListener {
    private ImageView search;
    private TextView music_name;
    private ImageView down, album, play_way, last, play, next, download;
    private MusicInfo musicInfo;
    private DownloadService.MyBinder myBinder;
    private ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder = (DownloadService.MyBinder) service;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        StatusBarUtil.setColor(PlayActivity.this, 0xffffff, 0);
        initView();
    }

    private void initView() {
        search = (ImageView) findViewById(R.id.search);
        search.setOnClickListener(this);
        music_name = (TextView) findViewById(R.id.music_name);
        down = (ImageView) findViewById(R.id.down);
        down.setOnClickListener(this);
        album = (ImageView) findViewById(R.id.album);
        play_way = (ImageView) findViewById(R.id.play_way);
        play_way.setOnClickListener(this);
        last = (ImageView) findViewById(R.id.last);
        last.setOnClickListener(this);
        play = (ImageView) findViewById(R.id.play);
        play.setOnClickListener(this);
        next = (ImageView) findViewById(R.id.next);
        next.setOnClickListener(this);
        download = (ImageView) findViewById(R.id.download);
        download.setOnClickListener(this);
    }

    private void initData() {
        if (getIntent().getExtras()!= null) {
            Intent intent = new Intent();
            intent.putExtras(getIntent().getExtras());
            intent.setClass(PlayActivity.this, DownloadService.class);
            bindService(intent, connection, BIND_AUTO_CREATE);
            musicInfo = (MusicInfo) getIntent().getExtras().getSerializable("musicInfo");
            music_name.setText(musicInfo.getData().getSongList().get(0).getSongName());
            play.setImageResource(R.mipmap.pause);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search:
                startActivity(new Intent(PlayActivity.this, SearchActivity.class));
                break;
            case R.id.play:
                if (myBinder.isPlaying()) {
                    play.setImageResource(R.mipmap.play_play);
                    myBinder.pauseMusic();
                } else {
                    play.setImageResource(R.mipmap.pause);
                    myBinder.startMusic();
                }
            case R.id.download:
                Intent intent = new Intent();
                intent.putExtra("musicInfo", musicInfo);
                intent.setClass(this, DownloadService.class);
                startService(intent);
        }
    }

    @Override
    protected void onResume() {
        initData();
        super.onResume();
    }

    @Override
    protected void onRestart() {
        myBinder.releaseMusic();
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        myBinder.releaseMusic();
        super.onDestroy();
    }

    @Override
    protected void setStatusBar() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
    }
}
