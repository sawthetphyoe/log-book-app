package com.example.logbookapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DBNAME = "log_book_database";
    private static final String TABLE_NAME = "contacts";
    public static final String ID = "_id"; //cursor adapter//primary key
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String DOB = "dob";

    private SQLiteDatabase database;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DBNAME, null, 3);
        database = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createContactTable = "CREATE TABLE " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT, " + EMAIL + " TEXT, " + DOB + " TEXT)";
        db.execSQL(createContactTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropContactTable = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(dropContactTable);
        onCreate(db);
    }

    public long saveContact(Contact contact) {
        ContentValues values = new ContentValues();
        values.put(NAME, contact.getName());
        values.put(EMAIL, contact.getEmail());
        values.put(DOB, contact.getDob());

        return database.insertOrThrow(TABLE_NAME, null, values);
    }

    public ArrayList<Contact> getAllContacts() {
        database = getReadableDatabase();

        Cursor results = database.query(TABLE_NAME, new String[]{ID, NAME, EMAIL, DOB},
                null, null, null, null, NAME);

        ArrayList<Contact> contactList = new ArrayList<>();

        results.moveToFirst();

        while (!results.isAfterLast()) {
            int id = results.getInt(0);
            String name = results.getString(1);
            String email = results.getString(2);
            String dob = results.getString(3);

            Contact contact = new Contact(id, name, email, dob);

            contactList.add(contact);

            results.moveToNext();
        }

        return contactList;
    }
}
