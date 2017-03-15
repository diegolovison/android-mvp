package com.example.diegolovison.projetoexemplo.commons.database.template;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.diegolovison.projetoexemplo.commons.database.DatabaseHelper;

/**
 * Created by diego.lovison on 04/01/2016.
 */
public class JdbcTemplate {

    SQLiteDatabase db;

    public JdbcTemplate(Context context) {

        DatabaseHelper helper = new DatabaseHelper(context);

        db = helper.getWritableDatabase();
    }

    public long insert(String table, String nullColumnHack, ContentValues values) {

        return db.insert(table, nullColumnHack, values);
    }

    public Cursor query(String table, String[] columns, String selection,
                        String[] selectionArgs, String groupBy, String having,
                        String orderBy) {

        return db.query(table, columns, selection,
                selectionArgs, groupBy, having, orderBy);
    }

    public Cursor rawQuery(String sql, String[] selectionArgs) {

        return db.rawQuery(sql, selectionArgs);
    }
}
