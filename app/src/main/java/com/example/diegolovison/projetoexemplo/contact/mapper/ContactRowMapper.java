package com.example.diegolovison.projetoexemplo.contact.mapper;

import android.database.Cursor;

import com.example.diegolovison.projetoexemplo.commons.mapper.RowMapper;
import com.example.diegolovison.projetoexemplo.contact.domain.Contact;
import com.example.diegolovison.projetoexemplo.contact.repository.entry.ContactEntry;

import static com.example.diegolovison.projetoexemplo.commons.util.CursorUtils.*;

/**
 * Created by diego.lovison on 12/01/2016.
 */
public class ContactRowMapper extends RowMapper<Contact> {

    @Override
    public Contact mapRow(Cursor cursor) {

        Contact contact = new Contact();
        contact.setContactId(getLong(cursor, ContactEntry._ID));
        contact.setRefId(getString(cursor, ContactEntry.COLUMN_NAME_REF_ID));

        return contact;
    }
}
