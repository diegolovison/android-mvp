package com.example.diegolovison.projetoexemplo.commons.service;

import android.content.Context;

/**
 * Created by diego.lovison on 12/01/2016.
 */
public abstract class AbstractService {

    private Context context;

    public AbstractService(Context context) {

        this.context = context;
    }
}
