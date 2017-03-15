package com.example.diegolovison.projetoexemplo.home.presenter;

import android.content.Context;

import com.example.diegolovison.projetoexemplo.commons.presenter.AbstractPresenter;
import com.example.diegolovison.projetoexemplo.home.view.HomeView;

/**
 * Created by diego.lovison on 22/12/2015.
 */
public class HomePresenterImpl extends AbstractPresenter<HomeView> implements HomePresenter {

    public HomePresenterImpl(HomeView view, Context context) {

        super(view, context);
    }

    @Override
    public void openContact() {

        this.view.startContact();
    }
}
