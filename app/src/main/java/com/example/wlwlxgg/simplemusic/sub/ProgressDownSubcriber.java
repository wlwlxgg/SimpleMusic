package com.example.wlwlxgg.simplemusic.sub;

import com.example.wlwlxgg.simplemusic.domain.DownInfo;
import com.example.wlwlxgg.simplemusic.domain.DownState;
import com.example.wlwlxgg.simplemusic.net.DownloadResponseBody;
import com.example.wlwlxgg.simplemusic.net.HttpDownManager;
import com.example.wlwlxgg.simplemusic.net.HttpProgressOnNextListener;

import java.lang.ref.WeakReference;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by wlwlxgg on 2017/3/14.
 */

public class ProgressDownSubcriber<T> extends Subscriber<T> implements DownloadResponseBody.DownloadProgressListener {
    /**
     * 弱引用结果回调
     */
    private WeakReference<HttpProgressOnNextListener> mSubscriberOnNextListener;

    /**
     * 下载数据
     */
    private DownInfo downInfo;

    public ProgressDownSubcriber(DownInfo downInfo) {
        this.mSubscriberOnNextListener = new WeakReference<>(downInfo.getListener());
        this.downInfo = downInfo;
    }

    /**
     * 订阅开始时调用
     * 显示ProgressBar
     */
    @Override
    public void onStart() {
        if (mSubscriberOnNextListener.get() != null) {
            mSubscriberOnNextListener.get().onStart();
        }
        downInfo.setState(DownState.START);
    }

    /**
     * 订阅完成时调用
     * 隐藏progressbar
     */
    @Override
    public void onCompleted() {
        if (mSubscriberOnNextListener.get() != null) {
            mSubscriberOnNextListener.get().onComplete();
        }
    }

    /**
     * 将onNext方法中的返回结果交给Activity或Fragment自己处理
     *
     * @param t 创建Subscriber时的泛类型
     */
    @Override
    public void onNext(T t) {
        if (mSubscriberOnNextListener.get() != null) {
            mSubscriberOnNextListener.get().onNext(t);
        }
    }

    /**
     * 对错误进行统一处理，隐藏ProgressBar
     *
     * @param e
     */
    @Override
    public void onError(Throwable e) {
        /*停止下载*/
        HttpDownManager.getInstance().stopDown(downInfo);
        if (mSubscriberOnNextListener.get() != null) {
            mSubscriberOnNextListener.get().onError(e);
        }
        downInfo.setState((DownState.ERROR));
    }

    @Override
    public void updata(long read, long count, boolean done) {
        if (downInfo.getCountLength() > count) {
            read = downInfo.getCountLength() - count + read;
        } else {
            downInfo.setCountLength(count);
        }
        downInfo.setReadLength(read);
        if (mSubscriberOnNextListener.get() != null) {
            /*接受进度消息，造成UI阻塞，如果不需要显示进度可去掉实现逻辑，减少压力*/
            rx.Observable.just(read).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<Long>() {
                        @Override
                        public void call(Long aLong) {
                            /*如果暂停或者停止状态延迟，不需要继续发送回调，影响显示*/
                            if (downInfo.getState() == DownState.PAUSE || downInfo.getState() == DownState.STOP)
                                return;
                            downInfo.setState(DownState.DOWN);
                            mSubscriberOnNextListener.get().updateProgress(aLong, downInfo.getCountLength());
                        }
                    });
        }

    }
}
