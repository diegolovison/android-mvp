package com.example.diegolovison.projetoexemplo.visit.repository;

import com.example.diegolovison.projetoexemplo.visit.domain.Visit;

/**
 * Created by diego.lovison on 12/01/2016.
 */
public interface VisitRepository {

    Visit findLastByContactId(Long contactId);

    Visit insert(Visit visit);
}
