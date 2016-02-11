package com.ninogenio.authsample.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Toast;

import com.ninogenio.authsample.R;
import com.ninogenio.authsample.presenter.LoginPresenter;
import com.ninogenio.authsample.view.LoginView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements LoginView {

    private LoginPresenter loginPresenter;

    @Bind(R.id.pb_login_progress)
    ProgressBar pbLoginPrgress;
    @Bind(R.id.sv_login_form)
    ScrollView svLoginForm;
    @Bind(R.id.et_email)
    EditText etEmail;
    @Bind(R.id.et_password)
    EditText etPassword;
    @Bind(R.id.btn_sign_in)
    Button btnSignIn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginPresenter = new LoginPresenter(this, this);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.onLoginClick(etEmail.getText().toString(),
                        etPassword.getText().toString());
            }
        });
    }

    @Override
    public void setInputEnabled(boolean enabled) {
        etEmail.setEnabled(enabled);
        etPassword.setEnabled(enabled);
        btnSignIn.setEnabled(enabled);
    }

    @Override
    public void setLoading(boolean loading) {
        if (loading) {
            pbLoginPrgress.setVisibility(View.VISIBLE);
            svLoginForm.setVisibility(View.GONE);
        } else {
            pbLoginPrgress.setVisibility(View.GONE);
            svLoginForm.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

