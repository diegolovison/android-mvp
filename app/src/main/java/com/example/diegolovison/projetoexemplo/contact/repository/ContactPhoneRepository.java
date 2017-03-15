package com.example.diegolovison.projetoexemplo.contact.repository;

import com.example.diegolovison.projetoexemplo.contact.domain.Contact;

/**
 * Created by diego.lovison on 12/01/2016.
 */
public interface ContactPhoneRepository {

    Contact findByRefId(String id);
}
