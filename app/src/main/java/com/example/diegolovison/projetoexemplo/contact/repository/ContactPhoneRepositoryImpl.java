package com.example.diegolovison.projetoexemplo.contact.repository;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

import com.example.diegolovison.projetoexemplo.commons.repository.AbstractPhoneRepository;
import com.example.diegolovison.projetoexemplo.contact.domain.Contact;

/**
 * Created by diego.lovison on 12/01/2016.
 */
public class ContactPhoneRepositoryImpl extends AbstractPhoneRepository implements ContactPhoneRepository {

    public ContactPhoneRepositoryImpl(Context context) {
        super(context);
    }

    @Override
    public Contact findByRefId(String id) {

        Cursor cursor = null;
        Contact contact = null;

        try {

            cursor = getContentResolver().query(
                    Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, id),
                    null, null, null, null);

            // let's just get the first email
            if (cursor.moveToFirst()) {

                String name = cursor.getString(
                        cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

                contact = new Contact();
                contact.setName(name);
                contact.setRefId(id);
            }

        } finally {

            if (cursor != null) {
                cursor.close();
            }
        }

        return contact;
    }
}
