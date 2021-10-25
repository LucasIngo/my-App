package com.example.finazen_2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnEinzahlen, btnAuszahlen, btnBier, btnOpenSchulden;

    //Dinger Schulden

    EditText einzahlung, auszahlung;
    TextView guthaben;

    double aktuellerStand, ergebnis;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "guthaben";

    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadData();
        updateViews();

        btnEinzahlen = (Button) findViewById(R.id.bEinzahlen);
        btnAuszahlen = (Button) findViewById(R.id.bAuszahlen);
        btnBier = (Button) findViewById(R.id.bBier);
        btnOpenSchulden = (Button) findViewById(R.id.bSchuldenliste);

        einzahlung = (EditText) findViewById(R.id.nEinzahlen) ;
        auszahlung = (EditText) findViewById(R.id.nAuszahlen);
        guthaben = (TextView) findViewById(R.id.guthaben);

        btnEinzahlen.setOnClickListener(this);
        btnAuszahlen.setOnClickListener(this);
        btnBier.setOnClickListener(this);

        guthaben.setText(String.valueOf(aktuellerStand).toString());

        btnOpenSchulden.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivitySchulden();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bEinzahlen:
                ergebnis = aktuellerStand + Double.parseDouble(einzahlung.getText().toString());
                guthaben.setText(String.valueOf(ergebnis));
                einzahlung.setText(null);
                break;
            case R.id.bAuszahlen:
                ergebnis = aktuellerStand - Double.parseDouble(auszahlung.getText().toString());
                guthaben.setText(String.valueOf(ergebnis));
                auszahlung.setText(null);
                break;
            case R.id.bBier:
                ergebnis = aktuellerStand +1;
                guthaben.setText(String.valueOf(ergebnis));
        }
        saveData();
    }
    public void onStop() {
        super.onStop();
        saveData();
    }
    public void saveData(){

        aktuellerStand = Double.parseDouble(guthaben.getText().toString());

        SharedPreferences file = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = file.edit();

        editor.putString(TEXT, String.valueOf(aktuellerStand));
        editor.apply();
    }

    public void loadData(){

        SharedPreferences file = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = file.getString(TEXT, "0");
    }

    public void updateViews(){
        aktuellerStand = Double.parseDouble(text.toString());
    }

    public void openActivitySchulden(){
        double guthabenInt = aktuellerStand;

        Intent intent = new Intent(this, Schuldenliste.class);
        startActivity(intent);
    }

}