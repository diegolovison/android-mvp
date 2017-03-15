package com.example.diegolovison.projetoexemplo.contact.service;

import com.example.diegolovison.projetoexemplo.contact.domain.Contact;

import java.util.List;

/**
 * Created by diego.lovison on 12/01/2016.
 */
public interface ContactService {

    Contact insert(Contact contact);

    List<Contact> findAllWithVisit();

    Contact findByRefId(String id);
}
