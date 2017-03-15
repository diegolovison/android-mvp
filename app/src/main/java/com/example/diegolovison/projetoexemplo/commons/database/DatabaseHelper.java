package com.example.diegolovison.projetoexemplo.commons.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.diegolovison.projetoexemplo.database.migration.MigrationV1;
import com.example.diegolovison.projetoexemplo.commons.database.patch.Patch;

/**
 * Created by diego.lovison on 04/01/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "app.db";

    private static final Patch[] PATCHES = {

            new MigrationV1()
    };

    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, PATCHES.length);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for (int i = 0; i < PATCHES.length; i++) {
            PATCHES[i].apply(db);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        for (int i = 0; i < PATCHES.length; i++) {
            PATCHES[i].apply(db);
        }
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        for (int i = 0; i < PATCHES.length; i++) {
            PATCHES[i].revert(db);
        }
    }
}
