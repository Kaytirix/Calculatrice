package com.example.calculatrice.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculatrice.R;

public class LastComputeActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_last_compute);
        Button boutonPrecedent = findViewById(R.id.precedent);
        TextView txtViewCalcule = findViewById(R.id.LastCompute_TxtViewCalcule);

        //Récupération des données
        Integer premierElement = getIntent().getIntExtra("premierElement", 0);
        Integer deuxiemeElement = getIntent().getIntExtra("deuxiemeElement", 0);
        String symbole = getIntent().getStringExtra("symbole");
        Double resultat = getIntent().getDoubleExtra("resultat", 0.0);

        if(symbole != null){
            txtViewCalcule.setText(premierElement + " " + symbole + " " + deuxiemeElement + " = " + resultat);
        }else{
            txtViewCalcule.setText(" ");
        }

        boutonPrecedent.setOnClickListener(view -> finish()); //Termine la fenetre
    }


}