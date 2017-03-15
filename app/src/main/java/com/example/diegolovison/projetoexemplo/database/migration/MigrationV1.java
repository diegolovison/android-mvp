package com.example.diegolovison.projetoexemplo.database.migration;

import android.database.sqlite.SQLiteDatabase;

import com.example.diegolovison.projetoexemplo.contact.repository.entry.ContactEntry;
import com.example.diegolovison.projetoexemplo.commons.database.patch.Patch;
import com.example.diegolovison.projetoexemplo.visit.repository.entry.VisitEntry;

/**
 * Created by diego.lovison on 04/01/2016.
 */
public class MigrationV1 extends Patch {

    public static final String SQL_CREATE_TABLE_CONTACT =

            create_table(ContactEntry.TABLE_NAME) + " ( " +
                    pk(ContactEntry._ID) + comma() +
                    text(ContactEntry.COLUMN_NAME_REF_ID) +
            " )";

    public static final String SQL_CREATE_TABLE_VISIT =

            create_table(VisitEntry.TABLE_NAME) + " ( " +
                    pk(VisitEntry._ID) + comma() +
                    integer(VisitEntry.COLUMN_NAME_CONTACT_ID) + comma() +
                    timestamp(VisitEntry.COLUMN_NAME_VISIT_DATE) + comma() +
                    fk(VisitEntry.COLUMN_NAME_CONTACT_ID, ContactEntry.TABLE_NAME, ContactEntry._ID) +
            " )";


    @Override
    public void apply(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_TABLE_CONTACT);
        db.execSQL(SQL_CREATE_TABLE_VISIT);
    }

    @Override
    public void revert(SQLiteDatabase db) {

    }
}
