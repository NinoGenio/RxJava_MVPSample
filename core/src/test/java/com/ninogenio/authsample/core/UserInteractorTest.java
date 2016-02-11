package com.ninogenio.authsample.core;

import com.ninogenio.authsample.dummy.UserDummy;
import com.ninogenio.authsample.interactor.UserInteractor;
import com.ninogenio.authsample.model.UserModel;
import com.ninogenio.authsample.util.Scheduler;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by gentr on 11-Feb-16.
 */
public class UserInteractorTest {

    private UserInteractor userInteractor;
    private Scheduler scheduler;

    @Before
    public void initTest() {
        userInteractor = new UserInteractor();
        scheduler = new TestScheduler();
    }

    @Test
    public void login_emailEmptyPasswordEmpty_shouldRejectRequest() {
        userInteractor.login("", "")
                .subscribeOn(scheduler.backgroundThread())
                .observeOn(scheduler.mainThread())
                .subscribe(new TestSubscriber<UserModel>() {
                    @Override
                    public void onCompleted() {
                        Assert.fail("It shouldn't have completed the request. There should be an error");
                    }

                    @Override
                    public void onNext(UserModel userModel) {
                        Assert.fail("API shouldn't have returned a success response");
                    }
                });
    }

    @Test
    public void login_emailNullPasswordNull_shouldRejectRequest() {
        userInteractor.login(null, null)
                .subscribeOn(scheduler.backgroundThread())
                .observeOn(scheduler.mainThread())
                .subscribe(new TestSubscriber<UserModel>() {
                    @Override
                    public void onCompleted() {
                        Assert.fail("It shouldn't have completed the request. There should be an error");
                    }

                    @Override
                    public void onNext(UserModel userModel) {
                        Assert.fail("API shouldn't have returned a success response");
                    }
                });
    }

    @Test
    public void login_wrongEmail_shouldRejectRequest() {
        userInteractor.login("whateveryouwant@ninogenio.com", UserDummy.PASSWORD)
                .subscribeOn(scheduler.backgroundThread())
                .observeOn(scheduler.mainThread())
                .subscribe(new TestSubscriber<UserModel>() {
                    @Override
                    public void onCompleted() {
                        Assert.fail("It shouldn't have completed the request. There should be an error");
                    }

                    @Override
                    public void onNext(UserModel userModel) {
                        Assert.fail("API shouldn't have returned a success response");
                    }
                });
    }

    @Test
    public void login_wrongPassword_shouldRejectRequest() {
        userInteractor.login(UserDummy.EMAIL, "ipsumlorem")
                .subscribeOn(scheduler.backgroundThread())
                .observeOn(scheduler.mainThread())
                .subscribe(new TestSubscriber<UserModel>() {
                    @Override
                    public void onCompleted() {
                        Assert.fail("It shouldn't have completed the request. There should be an error");
                    }

                    @Override
                    public void onNext(UserModel userModel) {
                        Assert.fail("API shouldn't have returned a success response");
                    }
                });
    }

    @Test
    public void login_allInputTrue_shouldAcceptResponseWithNonEmptyUserName() {
        userInteractor.login(UserDummy.EMAIL, UserDummy.PASSWORD)
                .subscribeOn(scheduler.backgroundThread())
                .observeOn(scheduler.mainThread())
                .subscribe(new TestSubscriber<UserModel>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onNext(UserModel userModel) {
                        Assert.assertTrue("User's name not empty or null", !userModel.getName().isEmpty());
                    }
                });
    }

}
