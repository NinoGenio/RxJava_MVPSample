package com.ninogenio.authsample.core;

import junit.framework.Assert;

import rx.Subscriber;

/**
 * Created by gentr on 11-Feb-16.
 */
public abstract class TestSubscriber<T> extends Subscriber<T> {

    @Override
    public void onError(Throwable e) {
        if (e instanceof AssertionError) {
            Assert.fail(e.getMessage());
        }
    }
}
