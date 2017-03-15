package com.example.diegolovison.projetoexemplo.contact.repository;

import com.example.diegolovison.projetoexemplo.contact.domain.Contact;

import java.util.List;

/**
 * Created by diego.lovison on 04/01/2016.
 */
public interface ContactRepository {

    Contact insert(Contact contact);

    List<Contact> findAll();

    Contact findByRefId(String refId);
}
