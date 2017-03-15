package com.example.diegolovison.projetoexemplo.contact.domain;

import android.provider.BaseColumns;

/**
 * Created by diego.lovison on 04/01/2016.
 */
public class Contact {

    private Long contactId;
    private String refId;
    private String name;
    private Integer diffBetweenVisitDateAndToday;

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDiffBetweenVisitDateAndToday() {
        return diffBetweenVisitDateAndToday;
    }

    public void setDiffBetweenVisitDateAndToday(Integer diffBetweenVisitDateAndToday) {
        this.diffBetweenVisitDateAndToday = diffBetweenVisitDateAndToday;
    }
}
