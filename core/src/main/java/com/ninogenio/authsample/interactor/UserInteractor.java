package com.ninogenio.authsample.interactor;

import com.ninogenio.authsample.dummy.UserDummy;
import com.ninogenio.authsample.model.UserModel;
import com.ninogenio.authsample.util.TextUtils;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by gentr on 11-Feb-16.
 */
public class UserInteractor {

    public Observable<UserModel> login(final String email, final String password) {
        return Observable.create(new Observable.OnSubscribe<UserModel>() {
            @Override
            public void call(Subscriber<? super UserModel> subscriber) {
                // Check if email/password is empty/null
                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    subscriber.onError(new Throwable("Email or password is empty"));
                }

                // Simulate API call loading
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    subscriber.onError(e);
                }

                // Simulate server logic for logging-in. Check email/password auth
                if (email.equals(UserDummy.EMAIL) && password.equals(UserDummy.PASSWORD)) {
                    // Simulate API response body
                    UserModel user = new UserModel();
                    user.setEmail(UserDummy.EMAIL);
                    user.setPassword(UserDummy.PASSWORD);
                    user.setName(UserDummy.NAME);

                    // Return the response to the subscriber
                    subscriber.onNext(user);
                    subscriber.onCompleted();
                } else {
                    // Simulate wrong email/password
                    subscriber.onError(new Throwable("Wrong email or password"));
                }
            }
        });
    }

}
