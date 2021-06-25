package com.example.diriodecalorias.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.diriodecalorias.R;

public class Tmb extends Fragment {

    String cafe,almoco,janta,outros;
    TextView txtResult1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tmb, container, false);

        SharedPreferences prefs = getContext().getSharedPreferences("dados", 0);
        float tmb = prefs.getFloat("tmb", 0);
        txtResult1 = (TextView) v.findViewById(R.id.txtResult1);

        txtResult1.setText(getContext().getString(R.string.msgTmb) + tmb);


        return v;
    }
}
