package com.example.diegolovison.projetoexemplo.contact.repository.entry;

import android.provider.BaseColumns;

public interface ContactEntry extends BaseColumns {

    String TABLE_NAME = "contact";

    String COLUMN_NAME_REF_ID = "refId";
}