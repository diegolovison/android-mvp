package com.example.diegolovison.projetoexemplo.contact.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.diegolovison.projetoexemplo.R;
import com.example.diegolovison.projetoexemplo.contact.domain.Contact;

import java.util.ArrayList;

/**
 * Created by diego.lovison on 04/01/2016.
 */
public class ContactAdapter extends ArrayAdapter<Contact> {

    private static class ViewHolder {

        TextView name;
        TextView unreadMessage;
    }

    public ContactAdapter(Context context) {

        super(context, 0, new ArrayList<Contact>());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_item_contact, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.unreadMessage = (TextView) convertView.findViewById(R.id.unread_count);
            convertView.setTag(viewHolder);

        } else {

            viewHolder = (ViewHolder) convertView.getTag();
        }

        Contact contact = getItem(position);

        viewHolder.name.setText(contact.getName());

        if (contact.getDiffBetweenVisitDateAndToday() != null) {

            viewHolder.unreadMessage.setVisibility(View.VISIBLE);
            viewHolder.unreadMessage.setText(
                    String.valueOf(contact.getDiffBetweenVisitDateAndToday()));
        }

        return convertView;
    }
}
