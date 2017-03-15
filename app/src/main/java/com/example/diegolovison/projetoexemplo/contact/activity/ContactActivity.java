package com.example.diegolovison.projetoexemplo.contact.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.diegolovison.projetoexemplo.R;
import com.example.diegolovison.projetoexemplo.commons.activity.AbstractActivity;
import com.example.diegolovison.projetoexemplo.contact.adapter.ContactAdapter;
import com.example.diegolovison.projetoexemplo.contact.domain.Contact;
import com.example.diegolovison.projetoexemplo.contact.presenter.ContactPresenter;
import com.example.diegolovison.projetoexemplo.contact.presenter.ContactPresenterImpl;
import com.example.diegolovison.projetoexemplo.contact.view.ContactView;
import com.example.diegolovison.projetoexemplo.commons.widget.ConfirmDialog;

import java.util.List;

public class ContactActivity extends AbstractActivity implements ContactView {

    private ContactPresenter presenter;

    private ListView contactsList;

    private ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_contact);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.btnContactAdd);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                presenter.startAndroidContact();
            }
        });

        this.adapter = new ContactAdapter(this);

        this.contactsList = (ListView) findViewById(R.id.lstContact);
        this.contactsList.setAdapter(this.adapter);
        this.contactsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                ConfirmDialog.show(ContactActivity.this, R.string.visit, R.string.confirm_visit,
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Contact contact = (Contact) contactsList.getItemAtPosition(position);

                                presenter.createVisit(contact);
                            }
                        }, null);
            }
        });

        this.presenter = new ContactPresenterImpl(this, getApplicationContext());
        this.presenter.loadContactData();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        presenter.handleActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void startAndroidContact() {

        Intent i = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(i, ContactPresenter.CONTACT_PICKER_RESULT);
    }

    @Override
    public void addContact(Contact contact) {

        adapter.add(contact);
    }

    @Override
    public void setContactData(List<Contact> contats) {

        for (Contact contact : contats) {

            addContact(contact);
        }
    }

    @Override
    public void updateDiffBetweenVisitDateAndToday() {

        this.adapter.notifyDataSetChanged();
    }
}
