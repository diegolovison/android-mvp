package com.example.diegolovison.projetoexemplo.commons.presenter;

import android.content.Context;

import com.example.diegolovison.projetoexemplo.commons.view.AbstractView;

/**
 * Created by diego.lovison on 12/01/2016.
 */
public abstract class AbstractPresenter<T extends AbstractView> {

    protected T view;

    public AbstractPresenter(T view, Context context) {

        this.view = view;
    }
}
