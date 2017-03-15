package com.example.diegolovison.projetoexemplo.commons.activity;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.diegolovison.projetoexemplo.commons.view.AbstractView;

/**
 * Created by diego.lovison on 12/01/2016.
 */
public abstract class AbstractActivity extends AppCompatActivity implements AbstractView {

    @Override
    public void showMessage(int message) {

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
