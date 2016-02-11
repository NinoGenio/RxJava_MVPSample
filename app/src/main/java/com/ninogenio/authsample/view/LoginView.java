package com.ninogenio.authsample.view;

/**
 * Created by gentr on 11-Feb-16.
 */
public interface LoginView {

    void setInputEnabled(boolean enabled);

    void setLoading(boolean loading);

    void showMessage(String message);

}
