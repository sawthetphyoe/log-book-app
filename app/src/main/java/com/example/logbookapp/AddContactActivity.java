package com.example.logbookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddContactActivity extends AppCompatActivity {

    EditText nameInput, emailInput;
    TextView datePickerDisplay;
    Button btnSaveContact;
    String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        databaseHelper = new DatabaseHelper(this);

        nameInput = findViewById(R.id.name_input);
        emailInput = findViewById(R.id.email_input);
        datePickerDisplay = findViewById(R.id.date_picker_display);
        btnSaveContact = findViewById(R.id.btn_save_contact);

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        datePickerDisplay.setOnClickListener(view -> openCalendar());

        btnSaveContact.setOnClickListener(view -> saveContact());
    }

    private void openCalendar() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePicker = new DatePickerDialog(this, dateSet(), year, month, day);
        datePicker.show();
    }

    private DatePickerDialog.OnDateSetListener dateSet() {
        return (view, year, month, dayOfMonth) -> datePickerDisplay.setText(months[month] + " " + dayOfMonth + ", " + year);
    }

    private void saveContact() {
        long id;
        String name = nameInput.getText().toString();
        String email = emailInput.getText().toString();
        String dob = datePickerDisplay.getText().toString();

        Contact contact = new Contact(name, email, dob);
        id = databaseHelper.saveContact(contact);

        if (id > 0) {
            Intent intent = new Intent(AddContactActivity.this, ContactsActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Error adding contacts", Toast.LENGTH_LONG).show();
        }

        nameInput.setText("");
        emailInput.setText("");
        datePickerDisplay.setText(R.string.choose_date_of_birth);
    }
}