package com.example.wlwlxgg.simplemusic.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wlwlxgg.simplemusic.R;
import com.example.wlwlxgg.simplemusic.constant.MusicMsg;
import com.example.wlwlxgg.simplemusic.domain.MusicInfo;
import com.example.wlwlxgg.simplemusic.service.MusicPlayService;
import com.example.wlwlxgg.simplemusic.util.PrefsUtil;
import com.jaeger.library.StatusBarUtil;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by wlwlxgg on 2017/2/7.
 */

public class PlayActivity extends BaseActivity implements View.OnClickListener {
    private ImageView search;
    private TextView music_name;
    private ImageView down, album, play_way, last, play, next, download;
    private MusicInfo musicInfo;
    private int isPlay = 0;
    private PrefsUtil prefsUtil = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        StatusBarUtil.setColor(PlayActivity.this, 0xffffff, 0);
        initView();
        initData();
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
        prefsUtil = PrefsUtil.getInstance();
        isPlay = prefsUtil.getInt("isPlay");
        //从搜索界面返回
        if (getIntent().getExtras() != null) {
            prefsUtil.putInt("isPlay", 1);
            musicInfo = (MusicInfo) getIntent().getExtras().getSerializable("musicInfo");
            music_name.setText(musicInfo.getData().getSongList().get(0).getSongName());
            play.setImageResource(R.mipmap.pause);
            getImage(album);
            Intent intent = new Intent(PlayActivity.this, MusicPlayService.class);
            intent.putExtra("Msg", MusicMsg.PLAY_MSG);
            intent.putExtra("Url", musicInfo.getData().getSongList().get(0).getSongLink());
            startService(intent);
        }
        //非搜索界面返回
        else {
            if (prefsUtil.getObject("MusicInfo", MusicInfo.class) != null) {
                musicInfo = prefsUtil.getObject("MusicInfo", MusicInfo.class);
                //是否重启应用
                if (prefsUtil.getInt("isRestart") == 1) {
                    prefsUtil.putInt("isRestart", 0);
                    music_name.setText(musicInfo.getData().getSongList().get(0).getSongName());
                    play.setImageResource(R.mipmap.play_play);
                    getImage(album);
                    prefsUtil.putInt("isPlay", 3);
                }
                //从其他页面进入
                else {
                    switch (isPlay) {
                        case 1:
                            music_name.setText(musicInfo.getData().getSongList().get(0).getSongName());
                            play.setImageResource(R.mipmap.play_play);
                            getImage(album);
                            break;
                        case 2:
                            music_name.setText(musicInfo.getData().getSongList().get(0).getSongName());
                            play.setImageResource(R.mipmap.pause);
                            getImage(album);
                            break;
                        case 3:
                            music_name.setText(musicInfo.getData().getSongList().get(0).getSongName());
                            play.setImageResource(R.mipmap.play_play);
                            getImage(album);
                            break;
                    }
                }
            } else
                prefsUtil.putInt("isPlay", 0);
        }
    }

    private void getImage(ImageView imageView) {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageForEmptyUri(R.mipmap.album)
                .showImageOnFail(R.mipmap.album)
                .showImageOnLoading(R.mipmap.album)
                .cacheInMemory(false)
                .cacheOnDisk(true)
                .build();
        ImageLoader.getInstance().displayImage(
                musicInfo.getData().getSongList().get(0).getSongPicRadio(),
                imageView,
                options);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search:
                startActivity(new Intent(PlayActivity.this, SearchActivity.class));
                PlayActivity.this.finish();
                break;
            case R.id.play:
                isPlay = prefsUtil.getInt("isPlay");
                if (isPlay == 1) {
                    play.setImageResource(R.mipmap.pause);
                    Intent intent = new Intent(PlayActivity.this, MusicPlayService.class);
                    intent.putExtra("Msg", MusicMsg.CONTINUE_MSG);
                    intent.putExtra("Url", musicInfo.getData().getSongList().get(0).getSongLink());
                    startService(intent);
                } else if (isPlay == 2) {
                    play.setImageResource(R.mipmap.play_play);
                    Intent intent = new Intent(PlayActivity.this, MusicPlayService.class);
                    intent.putExtra("Msg", MusicMsg.PAUSE_MSG);
                    intent.putExtra("Url", musicInfo.getData().getSongList().get(0).getSongLink());
                    startService(intent);
                } else if (isPlay == 3) {
                    play.setImageResource(R.mipmap.pause);
                    Intent intent = new Intent(PlayActivity.this, MusicPlayService.class);
                    intent.putExtra("Msg", MusicMsg.PLAY_MSG);
                    intent.putExtra("Url", musicInfo.getData().getSongList().get(0).getSongLink());
                    startService(intent);
                }
            case R.id.download:
                Intent intent = new Intent();
                intent.putExtra("musicInfo", musicInfo);
                intent.setClass(this, MusicPlayService.class);
                startService(intent);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void setStatusBar() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
    }

}
