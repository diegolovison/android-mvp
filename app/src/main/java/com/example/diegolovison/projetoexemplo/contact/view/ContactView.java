package com.example.diegolovison.projetoexemplo.contact.view;

import com.example.diegolovison.projetoexemplo.commons.view.AbstractView;
import com.example.diegolovison.projetoexemplo.contact.domain.Contact;

import java.util.List;

/**
 * Created by diego.lovison on 04/01/2016.
 */
public interface ContactView extends AbstractView {

    void startAndroidContact();

    void addContact(Contact contact);

    void setContactData(List<Contact> contats);

    void updateDiffBetweenVisitDateAndToday();
}
