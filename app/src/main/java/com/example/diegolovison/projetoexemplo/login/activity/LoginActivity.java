package com.example.diegolovison.projetoexemplo.login.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.diegolovison.projetoexemplo.R;
import com.example.diegolovison.projetoexemplo.commons.activity.AbstractActivity;
import com.example.diegolovison.projetoexemplo.home.activity.HomeActivity;
import com.example.diegolovison.projetoexemplo.login.presenter.LoginPresenter;
import com.example.diegolovison.projetoexemplo.login.presenter.LoginPresenterImpl;
import com.example.diegolovison.projetoexemplo.login.view.LoginView;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AbstractActivity implements LoginView {

    // UI references.
    private EditText mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set up the login form.
        mEmailView = (EditText) findViewById(R.id.email);
        mEmailView.setText("user");

        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setText("password");

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                presenter.login(getUsername(), getPassword());
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);

        presenter = new LoginPresenterImpl(this, getApplicationContext());
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @Override
    public void showProgress(final boolean show) {

        int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

        mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            }
        });

        mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
        mProgressView.animate().setDuration(shortAnimTime).alpha(
                show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            }
        });
    }

    @Override
    public void invalidatePasswordField(int label) {

        mPasswordView.setError(getString(label));
        mPasswordView.requestFocus();
    }

    @Override
    public void invalidateUsernameField(int label) {

        mEmailView.setError(getString(label));
        mEmailView.requestFocus();
    }

    @Override
    public void resetForm() {

        mEmailView.setError(null);
        mPasswordView.setError(null);
    }

    @Override
    public void startHome() {

        Intent i = new Intent(this, HomeActivity.class);
        startActivity(i);
    }

    private String getUsername() {

        return mEmailView.getText().toString();
    }

    private String getPassword() {

        return mPasswordView.getText().toString();
    }
}

