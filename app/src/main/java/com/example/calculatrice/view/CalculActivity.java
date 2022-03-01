package com.example.calculatrice.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculatrice.DivideExeption;
import com.example.calculatrice.EnumOperation;
import com.example.calculatrice.R;

public class CalculActivity extends AppCompatActivity {
    private  Integer premierElement = 0;
    private Integer deuxiemeElement = 0;
    private EnumOperation typeOperation;
    private TextView textViewCalcule;
    private Integer BornHaute = 9999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul);
        textViewCalcule = findViewById(R.id.ResCalcule);

        Button Division = findViewById(R.id.Division);
        Division.setOnClickListener(view -> AjoutTypeOperation(typeOperation.DIVISE));
        Button Mulitplication = findViewById(R.id.Multiplication);
        Mulitplication.setOnClickListener(view -> AjoutTypeOperation(typeOperation.MULTIPLY));
        Button Soustraction = findViewById(R.id.Soustraction);
        Soustraction.setOnClickListener(view -> AjoutTypeOperation(typeOperation.SUBSTRACT));
        Button Addition = findViewById(R.id.Addition);
        Addition.setOnClickListener(view -> AjoutTypeOperation(typeOperation.ADD));

        Button Sept = findViewById(R.id.Sept);
        Sept.setOnClickListener(view -> AjouteValeur(7));
        Button Huit = findViewById(R.id.Huit);
        Huit.setOnClickListener(view -> AjouteValeur(8));
        Button Neuf = findViewById(R.id.Neuf);
        Neuf.setOnClickListener(view -> AjouteValeur(9));

        Button Quatre = findViewById(R.id.Quatre);
        Quatre.setOnClickListener(view -> AjouteValeur(4));
        Button Cinq = findViewById(R.id.Cinq);
        Cinq.setOnClickListener(view -> AjouteValeur(5));
        Button Six = findViewById(R.id.Six);
        Six.setOnClickListener(view -> AjouteValeur(6));

        Button Un = findViewById(R.id.Un);
        Un.setOnClickListener(view -> AjouteValeur(1));
        Button Deux = findViewById(R.id.Deux);
        Deux.setOnClickListener(view -> AjouteValeur(2));
        Button Trois = findViewById(R.id.Trois);
        Trois.setOnClickListener(view -> AjouteValeur(3));

        Button Zero = findViewById(R.id.Zero);
        Zero.setOnClickListener(view -> AjouteValeur(0));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //Quand l'activiter est appeler, on appel le menu
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar,menu);

        MenuItem toolbarCalculer = menu.findItem(R.id.CalculerToolBar);
        MenuItem toolbarNettoyer = menu.findItem(R.id.NettoyerToolBar);

        toolbarCalculer.setOnMenuItemClickListener(menuItem -> calculResultat());
        toolbarNettoyer.setOnMenuItemClickListener(menuItem -> nettoyerText());
        return true;
    }

    private void AjoutTypeOperation(EnumOperation TypeOperation){
        this.typeOperation = TypeOperation;
        majTextView();
    }

    private void AjouteValeur(Integer valeur){
        if(typeOperation == null){
            if(10*premierElement* valeur > BornHaute){
                Toast.makeText(this,getString(R.string.ValeurTropGrande),Toast.LENGTH_LONG).show();
            }else{
                premierElement = 10 * premierElement + valeur;
            }
        }else {
            if(10 * deuxiemeElement + valeur > BornHaute){
                Toast.makeText(this,getString(R.string.ValeurTropGrande),Toast.LENGTH_LONG).show();
            }else{
                deuxiemeElement = 10 * deuxiemeElement + valeur;
            }
        }

        majTextView();
    }

    private void majTextView() {
        String TextAfficher = "";
        if(typeOperation == null){
            TextAfficher = premierElement.toString();
        }else{
            TextAfficher = premierElement + " " + typeOperation.getSymbol() + " " + deuxiemeElement;
        }
        textViewCalcule.setText(TextAfficher);
    }

    private boolean nettoyerText() {
        textViewCalcule.setText("");
        premierElement = 0;
        typeOperation = null;
        deuxiemeElement = 0;
        return true;
    }

    private boolean calculResultat() {
        try {
            Double resultat = 0.0;
            if(typeOperation != null){
                switch (typeOperation){
                    case ADD:
                        resultat = Double.valueOf(premierElement) + Double.valueOf(deuxiemeElement);break;
                    case DIVISE:
                        if(deuxiemeElement == 0){
                            throw new DivideExeption();
                        }else{
                            resultat = Double.valueOf(premierElement) / Double.valueOf(deuxiemeElement);break;
                        }
                    case MULTIPLY:
                        resultat = Double.valueOf(premierElement) * Double.valueOf(deuxiemeElement);break;
                    case SUBSTRACT:
                        resultat = Double.valueOf(premierElement) - Double.valueOf(deuxiemeElement);break;
                }
                ouvreLastComputeActivity(resultat);
            }else{
                Toast.makeText(this, getString(R.string.CalculIncomplet),Toast.LENGTH_LONG).show();
            }
        }catch (DivideExeption e){
            Toast.makeText(this, R.string.DivisionParZeroErr, Toast.LENGTH_LONG).show();
        }

        return true;
    }

    private void ouvreLastComputeActivity(Double resultat) {
        Intent i = new Intent(this, LastComputeActivity.class);

        //Envoie des données
        i.putExtra("premierElement", premierElement);
        i.putExtra("deuxiemeElement", deuxiemeElement);
        i.putExtra("symbole", typeOperation.getSymbol());
        i.putExtra("resultat", resultat);

        startActivity(i);
    }
}