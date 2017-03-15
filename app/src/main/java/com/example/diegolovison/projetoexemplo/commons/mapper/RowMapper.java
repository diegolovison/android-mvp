package com.example.diegolovison.projetoexemplo.commons.mapper;

import android.database.Cursor;

/**
 * Created by diego.lovison on 12/01/2016.
 */
public abstract class RowMapper<T> {

    public abstract T mapRow(Cursor cursor);
}
