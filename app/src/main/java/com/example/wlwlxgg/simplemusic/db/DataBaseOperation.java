package com.example.wlwlxgg.simplemusic.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.wlwlxgg.simplemusic.util.LogUtil;

/**
 * Created by wlwlxgg on 2017/3/6.
 */

public class DataBaseOperation extends BaseDb {

    /**
     * 构造方法
     *
     * @param context
     *            上下文
     */
    public DataBaseOperation(Context context) {
        super(context);
    }

    /**
     * 创建数据库中各表的方法
     *
     * @param tableName
     *            创建表的sq语句,表名
     */
    public void creatTable(String tableName) {
        try {
            OpenDbConnect();
            getDB().execSQL(tableName);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.i(TAG, "创建数据库表失败:" + tableName);
        } finally {
            CloseDbConnect();
        }
    }

    /**
     * 插入数据的方法
     *
     * @param tableName
     *            表名
     * @param values
     *            数据
     */
    public void insert(String tableName, ContentValues values) {
        try {
            OpenDbConnect();
            getDB().insert(tableName, null, values);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.i(TAG, "插入数据库失败:" + tableName);
        } finally {
            CloseDbConnect();
        }
    }

    /**
     * 删除数据的方法
     *
     * @param tableName
     *            表名
     * @param whereClause
     *            赛选条件
     * @param whereArgs
     *            赛选赋值
     */
    public void delete(String tableName, String whereClause, String[] whereArgs) {
        try {
            OpenDbConnect();
            getDB().delete(tableName, whereClause, whereArgs);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.i(TAG, "删除数据库失败：" + tableName);
        } finally {
            CloseDbConnect();
        }
    }

    /**
     * 更新数据的方法
     *
     * @param tableName
     *            表名
     * @param values
     *            数据
     * @param whereClause
     *            赛选条件
     * @param whereArgs
     *            赛选赋值
     */
    public void update(String tableName, ContentValues values, String whereClause, String[] whereArgs) {
        try {
            OpenDbConnect();
            getDB().update(tableName, values, whereClause, whereArgs);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.i(TAG, "更新数据库失败：" + tableName);
        } finally {
            CloseDbConnect();
        }
    }

    /**
     * 执行一个sql语句
     *
     * @param sql
     *            执行语句
     */
    public void execSql(String sql) {
        try {
            OpenDbConnect();
            getDB().execSQL(sql);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.i(TAG, "执行sql语句失败：" + sql);
        } finally {
            CloseDbConnect();
        }
    }

    /**
     *
     * 根据特定条件查询数据
     *
     * @param columns
     *            列名称数组
     * @param selection
     *            条件子句，相当于where
     * @param selectionArgs
     *            条件语句的参数数组
     * @param groupBy
     *            分组
     * @param having
     *            分组条件
     * @param orderBy
     *            排序类
     * @return 结果集ResultSet
     */
    public Cursor query(String tableName, String[] columns, String selection, String[] selectionArgs, String groupBy,
                        String having, String orderBy) {
        Cursor cursor = null;
        try {
            OpenDbConnect();
            cursor = getDB().query(tableName, columns, selection, selectionArgs, groupBy, having, orderBy);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.i(TAG, "查询数据库失败：" + tableName);
        } finally {
        }
        return cursor;
    }

    /**
     * 根据特定条件查询数据
     */
    public Cursor rawQuery(String sql, String[] selectionArgs) {

        Cursor mCursor = null;

        try {
            OpenDbConnect();
            mCursor = getDB().rawQuery(sql, selectionArgs);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.i(TAG, "错误信息描述：" + e.toString());
        } finally {
        }
        return mCursor;
    }

}
