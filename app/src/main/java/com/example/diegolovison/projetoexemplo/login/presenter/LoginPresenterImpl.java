package com.example.diegolovison.projetoexemplo.login.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.example.diegolovison.projetoexemplo.R;
import com.example.diegolovison.projetoexemplo.commons.presenter.AbstractPresenter;
import com.example.diegolovison.projetoexemplo.login.task.LoginPresenterTask;
import com.example.diegolovison.projetoexemplo.login.view.LoginView;

/**
 * Created by diego.lovison on 21/12/2015.
 */
public class LoginPresenterImpl extends AbstractPresenter<LoginView> implements LoginPresenter {

    public LoginPresenterImpl(LoginView view, Context context) {

        super(view, context);
    }

    @Override
    public void login(String username, String password) {

        this.view.resetForm();

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(password)) {

            this.view.invalidatePasswordField(R.string.error_invalid_password);

        } else if (TextUtils.isEmpty(username)) {

            this.view.invalidateUsernameField(R.string.error_field_required);

        } else {

//            this.view.showProgress(true);

            if ("teste".equals(username) && "1".equals(password)) {

                this.view.startHome();

            } else {

                this.view.invalidatePasswordField(R.string.error_incorrect_password);
            }

            //LoginPresenterTask task = new LoginPresenterTask(this.view);
            //task.login(username, password);
        }
    }
}
