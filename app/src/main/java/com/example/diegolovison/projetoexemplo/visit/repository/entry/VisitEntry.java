package com.example.diegolovison.projetoexemplo.visit.repository.entry;

import android.provider.BaseColumns;

/**
 * Created by diego.lovison on 12/01/2016.
 */
public interface VisitEntry extends BaseColumns {

    String TABLE_NAME = "visit";

    String COLUMN_NAME_CONTACT_ID = "contactId";

    String COLUMN_NAME_VISIT_DATE = "visitDate";
}
