package com.example.wlwlxgg.simplemusic.db.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.wlwlxgg.simplemusic.db.ConstantDb;
import com.example.wlwlxgg.simplemusic.db.DataBaseOperation;
import com.example.wlwlxgg.simplemusic.domain.MusicInfo;
import com.example.wlwlxgg.simplemusic.domain.NativeInfo;
import com.example.wlwlxgg.simplemusic.util.LogUtil;
import com.example.wlwlxgg.simplemusic.util.PrefsUtil;

import java.util.ArrayList;

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
        values.put(ConstantDb.SONG_NAME, mi.getSongName());
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

    /**
     * 获取歌曲信息列表
     */
    public ArrayList<NativeInfo> getMusicInfo(String userName) {
        ArrayList<NativeInfo> mList = new ArrayList<NativeInfo>();
        DataBaseOperation dataBaseOperation = new DataBaseOperation(mContext);
        NativeInfo info = null;
        String sql = "select * from " + ConstantDb.TABLE_NAME + " WHERE "
                + ConstantDb.USER_NAME + " = ?";
        Cursor cursor = dataBaseOperation.rawQuery(sql, new String[]{userName});
        while (cursor != null && cursor.moveToNext()) {
            info = new NativeInfo();
            info.setAlbumLink(cursor.getString(cursor.getColumnIndex(ConstantDb.ALBUM_LINK)));
            info.setAlbumName(cursor.getString(cursor.getColumnIndex(ConstantDb.ALBUM_NAME)));
            info.setDownloadProgress(cursor.getString(cursor.getColumnIndex(ConstantDb.DOWNLOAD_PROGRESS)));
            info.setIsDownload(cursor.getString(cursor.getColumnIndex(ConstantDb.IS_DOWNLOAD)));
            info.setLrcLink(cursor.getString(cursor.getColumnIndex(ConstantDb.LRC_LINK)));
            info.setSingerName(cursor.getString(cursor.getColumnIndex(ConstantDb.SINGER_NAME)));
            info.setSongId(cursor.getString(cursor.getColumnIndex(ConstantDb.SONG_ID)));
            info.setSongLink(cursor.getString(cursor.getColumnIndex(ConstantDb.SONG_LINK)));
            info.setSongPath(cursor.getString(cursor.getColumnIndex(ConstantDb.SONG_PATH)));
            info.setUserName(cursor.getString(cursor.getColumnIndex(ConstantDb.USER_NAME)));
            info.setSongName(cursor.getString(cursor.getColumnIndex(ConstantDb.SONG_NAME)));
            mList.add(info);
        }
        if (cursor != null) {
            cursor.close();
        }
        LogUtil.i("MSG", "获取歌曲信息列表成功");
        return mList;
    }

}
