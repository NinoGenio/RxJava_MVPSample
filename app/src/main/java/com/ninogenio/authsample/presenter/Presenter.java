package com.ninogenio.authsample.presenter;

import com.ninogenio.authsample.util.AppScheduler;
import com.ninogenio.authsample.util.Scheduler;

import java.util.ArrayList;
import java.util.List;

import rx.Subscription;

/**
 * Created by gentr on 11-Feb-16.
 */
public class Presenter {

    private List<Subscription> subscriptions = new ArrayList<>();
    protected Scheduler scheduler;

    public Presenter() {
        scheduler = new AppScheduler();
    }

    protected void addSubscription(Subscription subscription) {
        subscriptions.add(subscription);
    }

    public void finish() {
        for (Subscription sub : subscriptions) {
            sub.unsubscribe();
        }
    }

}
