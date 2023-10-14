package com.example.logbookapp;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ContactViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView textName, textEmail, textDob;

    public ContactViewHolder(View view) {
        super(view);

        imageView = view.findViewById(R.id.avatar);

        textName = view.findViewById(R.id.contact_name);

        textEmail = view.findViewById(R.id.contact_email);

        textDob = view.findViewById(R.id.contact_dob);
    }
}
