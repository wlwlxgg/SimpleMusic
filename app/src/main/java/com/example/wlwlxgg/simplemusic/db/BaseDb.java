package com.example.wlwlxgg.simplemusic.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by wlwlxgg on 2017/3/6.
 * 数据库基类，打开关闭数据库
 */

public class BaseDb {
    /**
     * 数据库的版本号
     */
    private static int dbversion = 1;
    /**
     * 定义一个Tag标记
     */
    protected static final String TAG = "BaseDb";
    /**
     * 数据库操作类对象
     */
    private DataBaseHelper mHelper = null;
    /**
     * 数据库操作对象
     */
    private SQLiteDatabase db = null;
    /**
     * 上下文对象
     */
    private Context mContext = null;
    /**
     * 实例对象
     */
    private static BaseDb instances = null;

    /**
     * @param context
     *            上下文对象
     * @return BaseDb对象
     */
    public static BaseDb getInstances(Context context) {
        if(instances == null){
            instances = new BaseDb(context);
        }
        return instances;
    }
    /**
     * 数据库操作基类的构造方法
     *
     * @param context
     */
    public BaseDb(Context context) {
        this.mContext = context;
    }
    /**
     * 打开数据库
     */
    public void OpenDbConnect() {
        mHelper = new DataBaseHelper(mContext, ConstantDb.DBNAME, dbversion);
        db = mHelper.getWritableDatabase();
    }

    /**
     * 关闭数据库
     */
    public void CloseDbConnect() {
        if (db != null) {
            db.close();
        }
        if (mHelper != null) {
            mHelper.close();
        }
    }

    /**
     * 获取数据库操作类对象
     *
     * @return 数据库操作类对象
     */
    public DataBaseHelper getHelper() {
        return mHelper;
    }

    /**
     * 获取数据库操作对象
     *
     * @return 数据库操作对象
     */
    public SQLiteDatabase getDB() {
        return db;
    }
}
