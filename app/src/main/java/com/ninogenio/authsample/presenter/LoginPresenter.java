package com.ninogenio.authsample.presenter;

import android.content.Context;

import com.ninogenio.authsample.interactor.UserInteractor;
import com.ninogenio.authsample.model.UserModel;
import com.ninogenio.authsample.view.LoginView;

import rx.Subscriber;

/**
 * Created by gentr on 11-Feb-16.
 */
public class LoginPresenter extends Presenter {

    private Context context;
    private LoginView loginView;

    private UserInteractor userInteractor;

    public LoginPresenter(Context context, LoginView loginView) {
        this.context = context;
        this.loginView = loginView;

        userInteractor = new UserInteractor();
    }

    public void onLoginClick(String email, String password) {
        addSubscription(userInteractor.login(email, password)
                .subscribeOn(scheduler.backgroundThread())
                .observeOn(scheduler.mainThread())
                .subscribe(new Subscriber<UserModel>() {

                    @Override
                    public void onStart() {
                        super.onStart();
                        loginView.setLoading(true);
                        loginView.setInputEnabled(false);
                    }

                    @Override
                    public void onCompleted() {
                        loginView.setLoading(false);
                        loginView.setInputEnabled(true);
                    }

                    @Override
                    public void onError(Throwable e) {
                        loginView.setLoading(false);
                        loginView.setInputEnabled(true);
                        loginView.showMessage(e.getMessage());
                    }

                    @Override
                    public void onNext(UserModel userModel) {
                        loginView.showMessage("Hello " + userModel.getName() + ". You have logged-in");
                        // Usually this is where we call an Intent to the Home Activity
                    }
                }));
    }

}
