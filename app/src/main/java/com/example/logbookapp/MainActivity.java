package com.example.logbookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnCalculator, btnImages, btnContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalculator = findViewById(R.id.btn_calculator);
        btnImages = findViewById(R.id.btn_images);
        btnContacts = findViewById(R.id.btn_contacts);

        btnCalculator.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CalculatorActivity.class);
            startActivity(intent);
        });

        btnImages.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ImageSliderActivity.class);
            startActivity(intent);
        });

        btnContacts.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ContactsActivity.class);
            startActivity(intent);
        });
    }
}