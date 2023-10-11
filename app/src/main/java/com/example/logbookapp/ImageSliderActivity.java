package com.example.logbookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class ImageSliderActivity extends AppCompatActivity {

    ImageView imageView;

    Button btnNext, btnPrevious;

    int[] images = {R.drawable.group, R.drawable.ic_launcher_background, android.R.drawable.btn_star_big_on, R.drawable.ic_launcher_foreground, android.R.drawable.checkbox_off_background, android.R.drawable.btn_radio};
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_slider);

        imageView = findViewById(R.id.image_slider_view);
        btnNext = findViewById(R.id.btn_next);
        btnPrevious = findViewById(R.id.btn_previous);

        imageView.setImageResource(images[index]);

        btnNext.setOnClickListener(view -> {
            if (index == images.length - 1) {
                index = 0;
            } else {
                index++;
            }
            imageView.setImageResource(images[index]);
        });

        btnPrevious.setOnClickListener(view -> {
            if (index == 0) {
                index = images.length - 1;
            } else {
                index--;
            }
            imageView.setImageResource(images[index]);
        });
    }
}