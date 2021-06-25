package com.example.diriodecalorias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class Calculos2 extends AppCompatActivity {

    EditText numCafe,numAlmoco,numJanta,numExterno;
    ImageButton bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculos2);



        numCafe = (EditText) findViewById(R.id.numCafe);
        numAlmoco = (EditText) findViewById(R.id.numAlmoco);
        numJanta = (EditText) findViewById(R.id.numJanta);
        numExterno = (EditText) findViewById(R.id.numExterno);
        bt = (ImageButton) findViewById(R.id.btCalcular2);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cafe = numCafe.getText().toString();
                String almoco = numAlmoco.getText().toString();
                String janta = numJanta.getText().toString();
                String externo = numExterno.getText().toString();
                if(!erro(cafe, janta, almoco, externo)){
                    SharedPreferences.Editor editor = getSharedPreferences("dados", MODE_PRIVATE).edit();
                    editor.putString("cafe",cafe);
                    editor.putString("almoco",almoco);
                    editor.putString("janta",janta);
					if(externo.length() == 0){
						editor.putString("outros","0");
					}else{
						editor.putString("outros",externo);					
					}
                    editor.apply();
                    Intent intent = new Intent(Calculos2.this, Resultados.class);
                    startActivity(intent);
                }else{
                    Snackbar.make(v, getString(R.string.erro_msg), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });



    }

    private boolean erro(String cafe, String almoco, String janta, String externo){
        if(cafe.length() == 0 || almoco.length() == 0
                || janta.length() == 0){
            return true;
        }



        return false;
    }

}
