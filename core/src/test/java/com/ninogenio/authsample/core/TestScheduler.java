package com.ninogenio.authsample.core;

import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * This scheduler runs all work immediately on the current thread
 * This makes testing code that may be done asynchronously easier
 *
 * @author zsiegel
 */
public class TestScheduler implements com.ninogenio.authsample.util.Scheduler {
    @Override
    public Scheduler mainThread() {
        return Schedulers.immediate();
    }

    @Override
    public Scheduler backgroundThread() {
        return Schedulers.immediate();
    }
}
