package com.example.diegolovison.projetoexemplo.home.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.example.diegolovison.projetoexemplo.R;
import com.example.diegolovison.projetoexemplo.commons.activity.AbstractActivity;
import com.example.diegolovison.projetoexemplo.contact.activity.ContactActivity;
import com.example.diegolovison.projetoexemplo.commons.database.DatabaseHelper;
import com.example.diegolovison.projetoexemplo.home.presenter.HomePresenter;
import com.example.diegolovison.projetoexemplo.home.presenter.HomePresenterImpl;
import com.example.diegolovison.projetoexemplo.home.view.HomeView;

public class HomeActivity extends AbstractActivity implements HomeView {

    private HomePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageButton b1 = (ImageButton) findViewById(R.id.imageButton1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                presenter.openContact();
            }
        });

        ImageButton b2 = (ImageButton) findViewById(R.id.imageButton2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getApplicationContext().deleteDatabase(DatabaseHelper.DATABASE_NAME);
            }
        });

        this.presenter = new HomePresenterImpl(this, getApplicationContext());
    }

    @Override
    public void startContact() {

        Intent i = new Intent(this, ContactActivity.class);
        startActivity(i);
    }
}
