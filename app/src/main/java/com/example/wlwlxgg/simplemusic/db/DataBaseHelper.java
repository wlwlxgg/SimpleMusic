package com.example.wlwlxgg.simplemusic.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.wlwlxgg.simplemusic.util.LogUtil;

/**
 * Created by wlwlxgg on 2017/3/6.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DataBaseHelper";

    /**
     * 构造方法
     *
     * @param context
     *            上下文对象
     * @param name
     *            数据库的名称
     * @param version
     *            数据库的版本号
     */
    public DataBaseHelper(Context context, String name, int version) {
        super(context, name, null, version);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * 数据库一创建就会调用，在此方法中创建各种表
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ConstantDb.CREATE_TABLE);
        LogUtil.i(TAG, "创建了歌曲信息表" + ConstantDb.CREATE_TABLE);
    }
}
