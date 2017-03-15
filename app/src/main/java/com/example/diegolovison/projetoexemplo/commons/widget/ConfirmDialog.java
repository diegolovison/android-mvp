package com.example.diegolovison.projetoexemplo.commons.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.example.diegolovison.projetoexemplo.R;

/**
 * Created by diego.lovison on 08/01/2016.
 */
public class ConfirmDialog {

    public static void show(Context context,
                            int title, int message,
                            DialogInterface.OnClickListener positiveButtonListener,
                            DialogInterface.OnClickListener negativeButtonListener) {

        new AlertDialog.Builder(context)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(R.string.yes, positiveButtonListener)
                .setNegativeButton(R.string.no, negativeButtonListener)
                .show();
    }
}
