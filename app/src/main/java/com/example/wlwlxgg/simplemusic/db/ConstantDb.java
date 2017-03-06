package com.example.wlwlxgg.simplemusic.db;

/**
 * 数据库常量类
 * Created by wlwlxgg on 2017/3/3.
 */

public class ConstantDb {
    /**
     * 数据库名称
     */
    public static final String DBNAME = "sm.db";
    /**
     * 表名
     */
    public static final String TABLE_NAME = "sm_table";
    /**
     * 用户名
     */
    public static final String USER_NAME = "sm_user_name";
    /**
     * 歌曲id
     */
    public static final String SONG_ID = "sm_song_id";
    /**
     * 歌曲是否被下载
     */
    public static final String IS_DOWNLOAD = "sm_is_download";
    /**
     * 歌曲本地存放路径
     */
    public static final String SONG_PATH = "sm_song_path";
    /**
     * 歌曲下载进度
     */
    public static final String DOWNLOAD_PROGRESS = "sm_download_progress";
    /**
     * 歌曲名
     */
    public static final String SONG_NAME = "sm_song_name";
    /**
     * 歌曲链接
     */
    public static final String SONG_LINK = "sm_song_link";
    /**
     * 歌词链接
     */
    public static final String LRC_LINK = "sm_lrc_link";
    /**
     * 歌手名称
     */
    public static final String SINGER_NAME = "sm_singer_name";
    /**
     * 专辑名称
     */
    public static final String ALBUM_NAME = "sm_album_name";
    /**
     * 专辑链接
     */
    public static final String ALBUM_LINK = "sm_album_link";

    /**
     * 建表语句
     */
    public static final String CREATE_TABLE = "create table if not exists "
            + TABLE_NAME + "( _id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + SONG_ID + "TEXT,"
            + IS_DOWNLOAD + "TEXT,"
            + SONG_NAME + "TEXT,"
            + SONG_LINK + "TEXT,"
            + LRC_LINK + "TEXT,"
            + SINGER_NAME + "TEXT,"
            + ALBUM_NAME + "TEXT,"
            + ALBUM_LINK + "TEXT)";





}
