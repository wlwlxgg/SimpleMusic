package com.example.wlwlxgg.simplemusic.application;

import android.app.Application;
import android.content.Context;

import com.example.wlwlxgg.simplemusic.util.PrefsUtil;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

/**
 * Created by wlwlxgg on 2017/3/2.
 */

public class MyApplication extends Application {
    private static Context context;
    private PrefsUtil prefsUtil;
    @Override
    public void onCreate() {
        PrefsUtil.init(getApplicationContext(), "SimpleMusic", Context.MODE_PRIVATE);
        context = getApplicationContext();
        initData();
        super.onCreate();
    }

    public void initData() {
        initImageLoader();

        //判断应用是否重启。
        prefsUtil = PrefsUtil.getInstance();
        prefsUtil.putInt("isRestart", 1);
    }

    /**
     * ImageLoader初始化
     */
    public void initImageLoader() {
        File cacheDir = StorageUtils.getOwnCacheDirectory(context, "SimpleMusic/Cache");
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .threadPoolSize(3).threadPriority(Thread.NORM_PRIORITY - 2)
                .memoryCache(new WeakMemoryCache())
                .denyCacheImageMultipleSizesInMemory()
                .diskCache(new UnlimitedDiskCache(cacheDir))
                .build();
        ImageLoader.getInstance().init(config);

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
