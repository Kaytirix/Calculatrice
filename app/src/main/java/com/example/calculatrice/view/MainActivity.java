package com.example.calculatrice.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.calculatrice.R;
import com.example.calculatrice.view.CalculActivity;
import com.example.calculatrice.view.LastComputeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Pointe vers ressource, layout, activity main
        Button boutonCalculer = findViewById(R.id.BoutonCalculer);
        Button boutonDernierCalcule = findViewById(R.id.DernierCalcule);

        boutonCalculer.setOnClickListener( view -> lanceActiviterCalculer());
        boutonDernierCalcule.setOnClickListener( view -> lancerActiviterDernierCalcule());
    }

    private void lanceActiviterCalculer() {
        Intent i = new Intent(this, CalculActivity.class);
        startActivity(i);
    }

    private void lancerActiviterDernierCalcule(){
        Intent i = new Intent(this, LastComputeActivity.class);
        startActivity(i);
    }
}