package com.example.wlwlxgg.simplemusic.db.dao;

import android.content.ContentValues;
import android.content.Context;

import com.example.wlwlxgg.simplemusic.db.ConstantDb;
import com.example.wlwlxgg.simplemusic.db.DataBaseOperation;
import com.example.wlwlxgg.simplemusic.domain.MusicInfo;
import com.example.wlwlxgg.simplemusic.util.LogUtil;
import com.example.wlwlxgg.simplemusic.util.PrefsUtil;

/**
 * Created by wlwlxgg on 2017/3/6.
 * 数据库业务类
 * 对用户表的操作类
 */

public class UserDao {

    private Context mContext = null;
    public UserDao(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * 保存歌曲信息
     */
    public void saveMusicInfo(MusicInfo musicInfo) {
        MusicInfo.DataBean.SongListBean mi = musicInfo.getData().getSongList().get(0);
        ContentValues values = new ContentValues();
        values.put(ConstantDb.ALBUM_LINK, mi.getSongPicBig());
        values.put(ConstantDb.ALBUM_NAME, mi.getAlbumName());
        values.put(ConstantDb.LRC_LINK, mi.getLrcLink());
        values.put(ConstantDb.SINGER_NAME, mi.getArtistName());
        values.put(ConstantDb.SONG_ID, mi.getSongId());
        values.put(ConstantDb.SONG_LINK, mi.getSongLink());
        values.put(ConstantDb.SINGER_NAME, mi.getSongName());
        values.put(ConstantDb.USER_NAME, PrefsUtil.getInstance().getString("userName"));
        values.put(ConstantDb.IS_DOWNLOAD, "0");
        values.put(ConstantDb.SONG_PATH, "0");
        values.put(ConstantDb.DOWNLOAD_PROGRESS, "0");
        DataBaseOperation dataBaseOperation = new DataBaseOperation(mContext);
        dataBaseOperation.insert(ConstantDb.TABLE_NAME, values);
        LogUtil.i("MSG", "数据插入成功");
    }

    /**
     * 更新歌曲信息
     */
    public void updateMusicInfo(String is_download, String download_progress, String path, String songId) {
        ContentValues values = new ContentValues();
        values.put(ConstantDb.IS_DOWNLOAD, is_download);
        values.put(ConstantDb.DOWNLOAD_PROGRESS, download_progress);
        values.put(ConstantDb.SONG_PATH, path);
        DataBaseOperation dataBaseOperation = new DataBaseOperation(mContext);
        dataBaseOperation.update(ConstantDb.TABLE_NAME, values,
                ConstantDb.USER_NAME + " = ? AND " + ConstantDb.SONG_ID + " = ?",
                new String[]{PrefsUtil.getInstance().getString("userName"), songId});
        LogUtil.i("MSG", "数据更新成功");
    }

}
