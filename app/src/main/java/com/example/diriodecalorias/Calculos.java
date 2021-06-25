package com.example.diriodecalorias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Calculos extends AppCompatActivity {

    Spinner spFatores;
    RadioGroup rgSexo;
    EditText edtIdade, edtPeso, edtAlt;
    ImageButton btCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculos);

        //Chamar Views
        spFatores = (Spinner) findViewById(R.id.spFatores);
        rgSexo = (RadioGroup) findViewById(R.id.rgSexos);
        edtIdade = (EditText) findViewById(R.id.numIdade);
        edtAlt = (EditText) findViewById(R.id.etAltura);
        edtPeso = (EditText) findViewById(R.id.etPeso);
        btCalc = (ImageButton) findViewById(R.id.btCalcular);

        //Adapter do Spinner (spFatores)
        ArrayAdapter adapter  = ArrayAdapter.createFromResource(this, R.array.fatores, android.R.layout.simple_dropdown_item_1line);
        spFatores.setAdapter(adapter);

        //onClick btCalc
        btCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idSexo = rgSexo.getCheckedRadioButtonId();
                String peso = edtPeso.getText().toString();
                String alt = edtAlt.getText().toString();
                String idade = edtIdade.getText().toString();
				if(!erro(idSexo,peso,alt,idade)){
                    SharedPreferences.Editor editor = getSharedPreferences("dados", MODE_PRIVATE).edit();
                    editor.putFloat("tmb", Calcular(idSexo,peso,alt,idade));
                    editor.apply();
                    Intent intent = new Intent(Calculos.this, Calculos2.class);
                    startActivity(intent);

				}else {
                    Snackbar.make(v, getString(R.string.erro_msg), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
    }

    private float Calcular(int idSexo, String peso,String alt, String idade){
        float basal = 0;
        double fatorNum = 0;

        switch(spFatores.getSelectedItemPosition()){
            case 1:
                fatorNum = 1.2;
                break;
            case 2:
                fatorNum = 1.375;
                break;
            case 3:
                fatorNum = 1.55;
                break;
            case 4:
                fatorNum = 1.725;
                break;

        }
        if(idSexo == R.id.rbFem){
            //Sexo Fem
            basal = (float) ((665+ (9.6*Double.parseDouble(peso)) + (1.8*Double.parseDouble(alt)) -
                                (4.7 * Double.parseDouble(idade)))*fatorNum);
        }
        if(idSexo == R.id.rbMas){
            //Sexo Masc
            basal = (float) ((66.5 + (13.7*Double.parseDouble(peso)) + (5.0*Double.parseDouble(alt)) -
                                (6.8 * Double.parseDouble(idade)))*fatorNum);
        }

        return basal;
    }

    private boolean erro(int idSexo, String peso,String alt, String idade){
        if(idSexo == -1){
            return true;
        }
        if(spFatores.getSelectedItemPosition() == 0){
            return true;
        }
        if(peso.length() == 0 ||
                alt.length() == 0 ||
                idade.length() == 0){
            return true;
        }

        return false;
    }

}
