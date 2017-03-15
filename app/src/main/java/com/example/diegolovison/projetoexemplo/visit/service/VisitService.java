package com.example.diegolovison.projetoexemplo.visit.service;

import com.example.diegolovison.projetoexemplo.contact.domain.Contact;
import com.example.diegolovison.projetoexemplo.visit.domain.Visit;

/**
 * Created by diego.lovison on 12/01/2016.
 */
public interface VisitService {

    Visit findLastByContactId(Long contactId);

    Visit insert(Contact contact);
}
