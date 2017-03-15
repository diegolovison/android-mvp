package com.example.diegolovison.projetoexemplo.commons.database.patch;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by diego.lovison on 04/01/2016.
 */
public abstract class Patch {

    public abstract void apply(SQLiteDatabase db);

    public abstract void revert(SQLiteDatabase db);

    public static String create_table(String tableName) {

        return " create table " + tableName;
    }

    public static String pk(String columnName) {
        return columnName + " integer primary key autoincrement ";
    }

    public static String fk(String columnName, String refTableName, String refColumnName) {
        return " foreign key (" + columnName + ") references " + refTableName + " (" + refColumnName + ") ";
    }

    public static String integer(String columnName) {
        return columnName + " integer ";
    }

    public static String timestamp(String columnName) {
        return columnName + " long ";
    }

    public static String text(String columnName) {
        return columnName + " text ";
    }

    public static String comma() {
        return " , ";
    }
}
