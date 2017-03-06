package com.example.wlwlxgg.simplemusic.util;

import android.util.Log;

/**
 * Created by wlwlxgg on 2017/3/6.
 * 定制自己的日志工具
 * 开发时候 LEVEL = VERBOSE 可以把需要的日志都打出来
 * 打包上线时候LEVEL = NOTHING 日志就都隐藏了；
 */

public class LogUtil
{

    public static final int VERBOSE = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
    public static final int WANR = 4;
    public static final int ERROR = 5;
    public static final int NOTHING = 6;
    public static final int LEVEL = VERBOSE;

    public static void v(String tag, String msg)
    {
        if (LEVEL <= VERBOSE)
        {
            Log.v(tag, msg);
        }
    }

    public static void d(String tag, String msg)
    {
        if (LEVEL <= DEBUG)
        {
            Log.d(tag, msg);
        }
    }

    public static void i(String tag, String msg)
    {
        if (LEVEL <= INFO)
        {
            Log.i(tag, msg);
        }
    }

    public static void w(String tag, String msg)
    {
        if (LEVEL <= WANR)
        {
            Log.w(tag, msg);
        }
    }

    public static void e(String tag, String msg)
    {
        if (LEVEL <= ERROR)
        {
            Log.e(tag, msg);
        }
    }

}