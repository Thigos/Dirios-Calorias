package com.example.diriodecalorias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void irParaSobre(View view) {
        Intent chamarSobre = new Intent(this, SobreGrupo.class);
        startActivity(chamarSobre);
    }
    public void irParaDicas(View view) {
        Intent chamarDicas = new Intent(this, Dicas.class);
        startActivity(chamarDicas);
    }
    public void irParaCalculos(View view) {
        Intent chamarCalculos = new Intent(this, Calculos.class);
        startActivity(chamarCalculos);
    }
}