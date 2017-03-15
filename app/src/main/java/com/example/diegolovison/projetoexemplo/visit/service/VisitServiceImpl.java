package com.example.diegolovison.projetoexemplo.visit.service;

import android.content.Context;

import com.example.diegolovison.projetoexemplo.commons.service.AbstractService;
import com.example.diegolovison.projetoexemplo.contact.domain.Contact;
import com.example.diegolovison.projetoexemplo.visit.domain.Visit;
import com.example.diegolovison.projetoexemplo.visit.repository.VisitRepository;
import com.example.diegolovison.projetoexemplo.visit.repository.VisitRepositoryImpl;

import org.joda.time.LocalDateTime;

/**
 * Created by diego.lovison on 12/01/2016.
 */
public class VisitServiceImpl extends AbstractService implements VisitService {

    private VisitRepository visitRepository;

    public VisitServiceImpl(Context context) {

        super(context);

        this.visitRepository = new VisitRepositoryImpl(context);
    }

    @Override
    public Visit findLastByContactId(Long contactId) {

        Visit visit = this.visitRepository.findLastByContactId(contactId);

        return visit;
    }

    @Override
    public Visit insert(Contact contact) {

        Visit visit = new Visit();
        visit.setContact(contact);
        visit.setVisitDate(new LocalDateTime());

        this.visitRepository.insert(visit);

        contact.setDiffBetweenVisitDateAndToday(0);

        return visit;
    }
}
