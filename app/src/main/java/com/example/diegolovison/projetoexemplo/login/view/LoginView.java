package com.example.diegolovison.projetoexemplo.login.view;

import com.example.diegolovison.projetoexemplo.commons.view.AbstractView;

/**
 * Created by diego.lovison on 21/12/2015.
 */
public interface LoginView extends AbstractView {

    void showProgress(final boolean show);

    void finish();

    void invalidatePasswordField(int label);

    void invalidateUsernameField(int label);

    void resetForm();

    void startHome();
}
