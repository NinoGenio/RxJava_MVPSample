package com.ninogenio.authsample.util;

/**
 * Created by gentr on 11-Feb-16.
 */
public interface Scheduler {

    rx.Scheduler mainThread();

    rx.Scheduler backgroundThread();

}