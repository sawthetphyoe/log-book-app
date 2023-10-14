package com.example.logbookapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactViewAdapter extends RecyclerView.Adapter<ContactViewHolder> {


    Context context;
    ArrayList<Contact> contactList;

    public ContactViewAdapter(Context context, ArrayList<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item_layout, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = contactList.get(position);
        holder.imageView.setImageResource(R.drawable.user_avatar);
        holder.textName.setText(contact.getName());
        holder.textEmail.setText(contact.getEmail());
        holder.textDob.setText(contact.getDob());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }
}
