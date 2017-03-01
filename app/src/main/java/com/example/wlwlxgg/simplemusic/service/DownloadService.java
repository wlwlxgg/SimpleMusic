package com.example.wlwlxgg.simplemusic.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;

import com.example.wlwlxgg.simplemusic.domain.MusicInfo;

import java.io.IOException;

/**
 * Created by wlwlxgg on 2017/3/1.
 */

public class DownloadService extends Service{

    private MediaPlayer mediaPlayer = new MediaPlayer();
    private MyBinder myBinder = new MyBinder();
    private MusicInfo musicInfo;

    @Override
    public void onCreate() {

        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Bundle bundle = intent.getExtras();
        musicInfo = (MusicInfo) bundle.getSerializable("musicInfo");
        return myBinder;
    }

    public class MyBinder extends Binder{
        public void startMusic() {
            try {
                String songLink = musicInfo.getData().getSongList().get(0).getSongLink();
                mediaPlayer.setDataSource(songLink);
                mediaPlayer.prepare();
                mediaPlayer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void pauseMusic() {
            mediaPlayer.pause();
        }
        public boolean isPlaying() {
            if (mediaPlayer.isPlaying())return true;
            else return false;
        }
        public void releaseMusic() {
            mediaPlayer.release();
        }

    }
}
