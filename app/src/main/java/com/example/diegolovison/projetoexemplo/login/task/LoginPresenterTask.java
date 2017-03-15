package com.example.diegolovison.projetoexemplo.login.task;

import com.example.diegolovison.projetoexemplo.R;
import com.example.diegolovison.projetoexemplo.login.domain.OAuth2Response;
import com.example.diegolovison.projetoexemplo.login.view.LoginView;

/**
 * Created by diego.lovison on 21/12/2015.
 */
public class LoginPresenterTask {

    LoginView loginView;

    public LoginPresenterTask(LoginView loginView) {
        this.loginView = loginView;
    }

    public void login(String username, String password) {

        LoginTask mAuthTask = new LoginTask(username, password) {

            @Override
            protected void onPostExecute(final OAuth2Response response) {

                loginView.showProgress(false);

                if (response != null) {

                    loginView.startHome();

                } else {

                    loginView.invalidatePasswordField(R.string.error_incorrect_password);
                }
            }

            @Override
            protected void onCancelled() {

                loginView.showProgress(false);
            }
        };
        mAuthTask.execute((Void) null);
    }
}
