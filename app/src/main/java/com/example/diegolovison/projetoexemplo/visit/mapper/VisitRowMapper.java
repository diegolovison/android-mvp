package com.example.diegolovison.projetoexemplo.visit.mapper;

import android.database.Cursor;

import com.example.diegolovison.projetoexemplo.commons.mapper.RowMapper;
import static com.example.diegolovison.projetoexemplo.commons.util.CursorUtils.*;
import com.example.diegolovison.projetoexemplo.contact.domain.Contact;
import com.example.diegolovison.projetoexemplo.visit.domain.Visit;
import com.example.diegolovison.projetoexemplo.visit.repository.entry.VisitEntry;

/**
 * Created by diego.lovison on 12/01/2016.
 */
public class VisitRowMapper extends RowMapper<Visit> {

    @Override
    public Visit mapRow(Cursor cursor) {

        Contact contact = new Contact();
        contact.setContactId(getLong(cursor, VisitEntry.COLUMN_NAME_CONTACT_ID));

        Visit visit = new Visit();
        visit.setVisitId(getLong(cursor, VisitEntry._ID));
        visit.setVisitDate(getDateTime(cursor, VisitEntry.COLUMN_NAME_VISIT_DATE));
        visit.setContact(contact);

        return visit;
    }
}
