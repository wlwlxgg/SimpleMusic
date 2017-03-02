package com.example.wlwlxgg.simplemusic.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.wlwlxgg.simplemusic.constant.MusicMsg;
import com.example.wlwlxgg.simplemusic.util.PrefsUtil;


/**
 * Created by wlwlxgg on 2017/3/1.
 */

public class MusicPlayService extends Service {

    private MediaPlayer mediaPlayer;
    private PrefsUtil prefsUtil;
    private int msg = 0;
    private String url;

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = new MediaPlayer();
        prefsUtil = PrefsUtil.getInstance();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        msg = intent.getIntExtra("Msg", 0);
        url = intent.getStringExtra("Url");
        switch (msg) {
            case MusicMsg.PLAY_MSG:
                play();
                break;
            case MusicMsg.PAUSE_MSG:
                pause();
                break;
            case MusicMsg.CONTINUE_MSG:
                resum();

        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void play() {
        prefsUtil.putInt("isPlay", 2);
        mediaPlayer.reset();
        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pause() {
        mediaPlayer.pause();
        prefsUtil.putInt("isPlay", 1);
    }

    public void resum() {
        mediaPlayer.start();
        prefsUtil.putInt("isPlay", 2);
    }
}
