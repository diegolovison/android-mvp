package com.example.diegolovison.projetoexemplo.contact.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.example.diegolovison.projetoexemplo.R;
import com.example.diegolovison.projetoexemplo.commons.presenter.AbstractPresenter;
import com.example.diegolovison.projetoexemplo.contact.domain.Contact;
import com.example.diegolovison.projetoexemplo.contact.service.ContactService;
import com.example.diegolovison.projetoexemplo.contact.service.ContactServiceImpl;
import com.example.diegolovison.projetoexemplo.contact.view.ContactView;
import com.example.diegolovison.projetoexemplo.visit.service.VisitService;
import com.example.diegolovison.projetoexemplo.visit.service.VisitServiceImpl;

/**
 * Created by diego.lovison on 04/01/2016.
 */
public class ContactPresenterImpl extends AbstractPresenter<ContactView> implements ContactPresenter {

    private ContactService service;
    private VisitService visitService;

    public ContactPresenterImpl(ContactView view, Context context) {

        super(view, context);
        
        this.service = new ContactServiceImpl(context);
        this.visitService = new VisitServiceImpl(context);
    }

    @Override
    public void startAndroidContact() {

        this.view.startAndroidContact();
    }

    @Override
    public void handleActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == Activity.RESULT_OK) {

            switch (requestCode) {

                case CONTACT_PICKER_RESULT:

                    handleContactPickerResult(data);

                    break;
            }

        } else {

            Log.w("debug", "Warning: activity result not ok");
        }
    }

    @Override
    public void loadContactData() {

        this.view.setContactData(this.service.findAllWithVisit());
    }

    @Override
    public void createVisit(Contact contact) {

        this.visitService.insert(contact);

        this.view.showMessage(R.string.confirmed_visit);

        this.view.updateDiffBetweenVisitDateAndToday();
    }

    private  void handleContactPickerResult(Intent data) {

        Uri uriContact = data.getData();
        String contactId = uriContact.getLastPathSegment();

        Contact contact = this.service.findByRefId(contactId);

        if (contact != null && contact.getContactId() == null) {

            this.service.insert(contact);

            view.addContact(contact);

            view.showMessage(R.string.synchronized_contact);

        } else {

            view.showMessage(R.string.existing_contact);
        }
    }
}
