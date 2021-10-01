package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView cityTextView;
    private TextView weatherTextView;
    private TextView tempTextView;
    private TextView sunriseTextView;
    private TextView sunsetTextView;
    private EditText cityEditText;
    private Button button1;
    private ImageView weatherIcon;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityTextView = findViewById(R.id.city_textview);
        weatherTextView = findViewById(R.id.weather_textview);
        tempTextView = findViewById(R.id.temp_textview);
        sunriseTextView = findViewById(R.id.sunrise_textview);
        sunsetTextView = findViewById(R.id.sunset_textview);
        cityEditText = findViewById(R.id.city_edittext);
        button1 = findViewById(R.id.button);

    }
}