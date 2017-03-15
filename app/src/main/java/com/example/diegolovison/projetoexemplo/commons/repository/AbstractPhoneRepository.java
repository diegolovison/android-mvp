package com.example.diegolovison.projetoexemplo.commons.repository;

import android.content.ContentResolver;
import android.content.Context;

import com.example.diegolovison.projetoexemplo.commons.database.template.JdbcTemplate;

/**
 * Created by diego.lovison on 12/01/2016.
 */
public abstract class AbstractPhoneRepository {

    private Context context;

    public AbstractPhoneRepository(Context context) {

        this.context = context;
    }

    protected ContentResolver getContentResolver() {

        return context.getContentResolver();
    }
}
