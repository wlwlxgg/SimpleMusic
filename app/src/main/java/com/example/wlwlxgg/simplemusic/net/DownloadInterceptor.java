package com.example.wlwlxgg.simplemusic.net;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by wlwlxgg on 2017/3/13.
 */

public class DownloadInterceptor implements Interceptor {
    private DownloadResponseBody.DownloadProgressListener downloadProgressListener;

    public DownloadInterceptor(DownloadResponseBody.DownloadProgressListener downloadProgressListener) {
        this.downloadProgressListener = downloadProgressListener;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        return originalResponse.newBuilder()
                .body(new DownloadResponseBody(originalResponse.body(), downloadProgressListener))
                .build();
    }
}
