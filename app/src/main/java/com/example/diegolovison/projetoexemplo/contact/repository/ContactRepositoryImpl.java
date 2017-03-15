package com.example.diegolovison.projetoexemplo.contact.repository;

import android.content.ContentValues;
import android.content.Context;

import com.example.diegolovison.projetoexemplo.commons.repository.AbstractRepository;
import com.example.diegolovison.projetoexemplo.contact.domain.Contact;
import com.example.diegolovison.projetoexemplo.contact.mapper.ContactRowMapper;
import com.example.diegolovison.projetoexemplo.contact.repository.entry.ContactEntry;

import java.util.List;

/**
 * Created by diego.lovison on 04/01/2016.
 */
public class ContactRepositoryImpl extends AbstractRepository<Contact> implements ContactRepository {

    public ContactRepositoryImpl(Context context) {

        super(context);
    }

    @Override
    public Contact insert(Contact contact) {

        ContentValues values = new ContentValues();
        values.put(ContactEntry.COLUMN_NAME_REF_ID, contact.getRefId());

        long id = getJdbcTemplate().insert(
                ContactEntry.TABLE_NAME,
                null,
                values);

        contact.setContactId(id);

        return contact;
    }

    @Override
    public List<Contact> findAll() {

        String sql =
                "SELECT " +
                    ContactEntry._ID + ", " +
                    ContactEntry.COLUMN_NAME_REF_ID + " " +
                "FROM " + ContactEntry.TABLE_NAME;

        List<Contact> contacts = query(sql, null, new ContactRowMapper());

        return contacts;
    }

    @Override
    public Contact findByRefId(String refId) {

        String sql =
                "SELECT " +
                    ContactEntry._ID + ", " +
                    ContactEntry.COLUMN_NAME_REF_ID + " " +
                "FROM " + ContactEntry.TABLE_NAME + " " +
                "WHERE " + ContactEntry.COLUMN_NAME_REF_ID + " = ? ";

        Contact contact = queryForObject(
                sql,
                new Object[] {
                        refId
                },
                new ContactRowMapper());

        return contact;
    }
}
