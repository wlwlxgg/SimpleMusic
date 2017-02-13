package com.example.wlwlxgg.simplemusic.util;

import android.content.Context;

/**
 * @Title 常用工具类
 * Created by wlwlxgg on 2017/2/6.
 * @Description 功能描述
 */

public class CommonUtils {
    /**
     * @param context
     * @param dipValue
     * @return dip转换为px
     */
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}
