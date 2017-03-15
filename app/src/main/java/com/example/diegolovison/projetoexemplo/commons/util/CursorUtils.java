package com.example.diegolovison.projetoexemplo.commons.util;

import android.database.Cursor;

import org.joda.time.LocalDateTime;

/**
 * Created by diego.lovison on 12/01/2016.
 */
public abstract class CursorUtils {

    public static Long getLong(Cursor cursor, String columnName) {

        Long value = cursor.getLong(cursor.getColumnIndex(columnName));

        return value;
    }

    public static String getString(Cursor cursor, String columnName) {

        String value = cursor.getString(cursor.getColumnIndex(columnName));

        return value;
    }

    public static Long getDateTime(LocalDateTime date) {

        return date.toDate().getTime();
    }

    public static LocalDateTime getDateTime(Cursor cursor, String columnName) {

        LocalDateTime date = null;

        Long value = cursor.getLong(cursor.getColumnIndex(columnName));

        if (value != null) {

            date = new LocalDateTime(value);
        }

        return date;
    }
}
