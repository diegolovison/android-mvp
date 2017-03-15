package com.example.diegolovison.projetoexemplo.visit.domain;

import com.example.diegolovison.projetoexemplo.contact.domain.Contact;

import org.joda.time.LocalDateTime;

/**
 * Created by diego.lovison on 12/01/2016.
 */
public class Visit {

    private Long visitId;
    private Contact contact;
    private LocalDateTime visitDate;

    public Long getVisitId() {
        return visitId;
    }

    public void setVisitId(Long visitId) {
        this.visitId = visitId;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public LocalDateTime getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDateTime visitDate) {
        this.visitDate = visitDate;
    }
}
