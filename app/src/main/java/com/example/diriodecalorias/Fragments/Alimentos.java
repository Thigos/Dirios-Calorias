package com.example.diriodecalorias.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import com.google.android.material.snackbar.Snackbar;

import com.example.diriodecalorias.R;

public class Alimentos extends Fragment {

    TextView txtResult2;
    LinearLayout lyAlim;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_alim, container, false);

        SharedPreferences prefs = getContext().getSharedPreferences("dados", 0);
        float cafe = Float.parseFloat(prefs.getString("cafe", ""));
        float almoco = Float.parseFloat(prefs.getString("almoco", ""));
        float janta = Float.parseFloat(prefs.getString("janta", ""));
		float outros = Float.parseFloat(prefs.getString("outros", ""));

        float tmb = prefs.getFloat("tmb", 0);

        txtResult2 = (TextView) v.findViewById(R.id.txtResult2);
        lyAlim = (LinearLayout) v.findViewById(R.id.lyAlim);


        float calc = cafe+almoco+janta+outros;
		if(calc <= (tmb-151)){
            txtResult2.setText("Hmmmmmmm\n\nDesse jeito você vai emagrecer");
            lyAlim.setBackground(getContext().getResources().getDrawable(R.drawable.shap_verde));
		
		}	

		if(calc <= (tmb-500)){
            txtResult2.setText("Hmmmmmmm\n\nTente consumir mais calorias\n O recomendado é que você diminua apenas 500kcal");
            lyAlim.setBackground(getContext().getResources().getDrawable(R.drawable.shap_amarelo));
        }

		if(calc <= (tmb-1001)){
            txtResult2.setText("OK OK\n\nIsso realmente está fugindo das recomendações, consuma mais colorias!\n O recomendado é que você diminua apenas 500kcal");
            lyAlim.setBackground(getContext().getResources().getDrawable(R.drawable.shap_vermelho));
        }

        
		
			

        if(calc >= (tmb-150) && calc <= (tmb+150)){
            txtResult2.setText("Hmmmmmmm\n\nÉ isso, vai ficar na mesma.");
        }

		if(calc >= (tmb+151) && calc <= (tmb+500)){
            txtResult2.setText("Hmmmmmmm\n\nDesse jeito você vai engordar ");
            lyAlim.setBackground(getContext().getResources().getDrawable(R.drawable.shap_verde));
        } 
		if(calc >= (tmb+551) && calc <= (tmb+1000)){
            txtResult2.setText("Hmmmmmmm\n\nTente consumir menos calorias\n O recomendado é que você consuma apenas 500kcal a mais");
            lyAlim.setBackground(getContext().getResources().getDrawable(R.drawable.shap_amarelo));
        } 
		if(calc >= (tmb+1001) && calc <= (tmb+2000)){
            txtResult2.setText("OK OK\n\nIsso realmente está fugindo das recomendações, consuma menos colorias!\n O recomendado é que você consuma apenas 500kcal a mais");
            lyAlim.setBackground(getContext().getResources().getDrawable(R.drawable.shap_vermelho));
        }
		if(calc >= (tmb+2001) && calc <= (tmb+3000)){
            txtResult2.setText("OK OK\n\nIsso realmente está fugindo das recomendações, consuma menos colorias!\n O recomendado é que você consuma apenas 500kcal a 		mais");
            lyAlim.setBackground(getContext().getResources().getDrawable(R.drawable.shap_vermelho));
        }
		

        return v;
    }
}
