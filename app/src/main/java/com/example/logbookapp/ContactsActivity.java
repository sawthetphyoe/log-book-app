package com.example.logbookapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ContactsActivity extends AppCompatActivity {

    FloatingActionButton btnAddNewContact;
    RecyclerView recyclerView;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        recyclerView = findViewById(R.id.contacts_recyclerview);

        databaseHelper = new DatabaseHelper(this);

        ArrayList<Contact> contactList = databaseHelper.getAllContacts();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hasFixedSize();

        ContactViewAdapter adapter = new ContactViewAdapter(this, contactList);

        recyclerView.setAdapter(adapter);

        btnAddNewContact = findViewById(R.id.btn_add_new_contact);

        btnAddNewContact.setOnClickListener(view -> {
            Intent intent = new Intent(ContactsActivity.this, AddContactActivity.class);
            startActivity(intent);
        });
    }

}