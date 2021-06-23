package com.example.diriodecalorias;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Calculos extends AppCompatActivity {
Spinner spFatores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculos);

        spFatores = (Spinner) findViewById(R.id.spFatores);

        ArrayAdapter adapter  = ArrayAdapter.createFromResource(this, R.array.fatores, android.R.layout.simple_dropdown_item_1line);

        spFatores.setAdapter(adapter);
    }
}