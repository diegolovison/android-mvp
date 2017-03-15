package com.example.diegolovison.projetoexemplo.contact.service;

import android.content.Context;

import com.example.diegolovison.projetoexemplo.commons.service.AbstractService;
import com.example.diegolovison.projetoexemplo.contact.domain.Contact;
import com.example.diegolovison.projetoexemplo.contact.repository.ContactPhoneRepository;
import com.example.diegolovison.projetoexemplo.contact.repository.ContactPhoneRepositoryImpl;
import com.example.diegolovison.projetoexemplo.contact.repository.ContactRepository;
import com.example.diegolovison.projetoexemplo.contact.repository.ContactRepositoryImpl;
import com.example.diegolovison.projetoexemplo.visit.domain.Visit;
import com.example.diegolovison.projetoexemplo.visit.service.VisitService;
import com.example.diegolovison.projetoexemplo.visit.service.VisitServiceImpl;

import org.joda.time.Days;
import org.joda.time.LocalDateTime;

import java.util.List;

/**
 * Created by diego.lovison on 12/01/2016.
 */
public class ContactServiceImpl extends AbstractService implements ContactService {

    private ContactPhoneRepository contactPhoneRepository;
    private ContactRepository contactRepository;

    private VisitService visitService;

    public ContactServiceImpl(Context context) {

        super(context);

        this.contactRepository = new ContactRepositoryImpl(context);
        this.contactPhoneRepository = new ContactPhoneRepositoryImpl(context);

        this.visitService = new VisitServiceImpl(context);
    }

    @Override
    public Contact insert(Contact contact) {

        return this.contactRepository.insert(contact);
    }

    @Override
    public List<Contact> findAllWithVisit() {

        List<Contact> result = this.contactRepository.findAll();

        for (Contact contact : result) {

            contact.setDiffBetweenVisitDateAndToday(
                    getDiffBetweenVisitDateAndToday(contact));

            loadContactDataFromAgenda(contact, contact.getRefId());
        }

        return result;
    }

    @Override
    public Contact findByRefId(String refId) {

        Contact contact = this.contactRepository.findByRefId(refId);

        if (contact == null) {

            contact = new Contact();
            contact.setRefId(refId);
        }

        loadContactDataFromAgenda(contact, refId);

        return contact;
    }

    public Integer getDiffBetweenVisitDateAndToday(Contact contact) {

        Visit visit = this.visitService.findLastByContactId(contact.getContactId());

        Integer diff = null;

        if (visit != null) {

            diff = getDiffBetweenVisitDateAndToday(visit);
        }

        return diff;
    }

    private void loadContactDataFromAgenda(Contact contact, String refId) {

        Contact contactFromAgenda = this.contactPhoneRepository.findByRefId(refId);
        contact.setName(contactFromAgenda.getName());
    }

    private int getDiffBetweenVisitDateAndToday(Visit visit) {

        int days = Days.daysBetween(
                visit.getVisitDate(),
                new LocalDateTime())
                .getDays();

        return days;
    }
}
