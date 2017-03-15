package com.example.diegolovison.projetoexemplo.contact.presenter;

import android.content.Intent;

import com.example.diegolovison.projetoexemplo.contact.domain.Contact;

/**
 * Created by diego.lovison on 04/01/2016.
 */
public interface ContactPresenter {

    int CONTACT_PICKER_RESULT = 1001;

    void startAndroidContact();

    void handleActivityResult(int requestCode, int resultCode, Intent data);

    void loadContactData();

    void createVisit(Contact contact);
}
