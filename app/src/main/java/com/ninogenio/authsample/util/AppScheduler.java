package com.ninogenio.authsample.util;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by gentr on 11-Feb-16.
 */
public class AppScheduler implements Scheduler {
    @Override
    public rx.Scheduler mainThread() {
        return AndroidSchedulers.mainThread();
    }

    @Override
    public rx.Scheduler backgroundThread() {
        return Schedulers.io();
    }
}
