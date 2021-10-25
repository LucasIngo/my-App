package com.example.finazen_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Schuldenliste extends AppCompatActivity implements View.OnClickListener {

    Button down0, down1, down2, down3, down4, down5, down6;
    Button up0, up1, up2, up3, up4, up5, up6;
    TextView wert0, wert1, wert2, wert3, wert4, wert5, wert6;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String[] w = {"wert0", "wert1", "wert2", "wert3", "wert4", "wert5", "wert6"};

    /*
    public static final String w0 = "wert0";
    public static final String w1 = "wert1";
    public static final String w2 = "wert2";
    public static final String w3 = "wert3";
    public static final String w4 = "wert4";
    public static final String w5 = "wert5";
    public static final String w6 = "wert6";
    */

    private int[] dummy = new int[7];
    private String text, text1, text2, text3, text4, text5, text6;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schuldenliste);

        loadData();

        down0 = findViewById(R.id.down0);
        down1 = findViewById(R.id.down1);
        down2 = findViewById(R.id.down2);
        down3 = findViewById(R.id.down3);
        down4 = findViewById(R.id.down4);
        down5 = findViewById(R.id.down5);
        down6 = findViewById(R.id.down6);

        up0 = findViewById(R.id.up0);
        up1 = findViewById(R.id.up1);
        up2 = findViewById(R.id.up2);
        up3 = findViewById(R.id.up3);
        up4 = findViewById(R.id.up4);
        up5 = findViewById(R.id.up5);
        up6 = findViewById(R.id.up6);

        wert0 = findViewById(R.id.wert0);
        wert1 = findViewById(R.id.wert1);
        wert2 = findViewById(R.id.wert2);
        wert3 = findViewById(R.id.wert3);
        wert4 = findViewById(R.id.wert4);
        wert5 = findViewById(R.id.wert5);
        wert6 = findViewById(R.id.wert6);

        down0.setOnClickListener(this);
        down1.setOnClickListener(this);
        down2.setOnClickListener(this);
        down3.setOnClickListener(this);
        down4.setOnClickListener(this);
        down5.setOnClickListener(this);
        down6.setOnClickListener(this);

        up0.setOnClickListener(this);
        up1.setOnClickListener(this);
        up2.setOnClickListener(this);
        up3.setOnClickListener(this);
        up4.setOnClickListener(this);
        up5.setOnClickListener(this);
        up6.setOnClickListener(this);

        wert0.setText(text);
        wert1.setText(text1);
        wert2.setText(text2);
        wert3.setText(text3);
        wert4.setText(text4);
        wert5.setText(text5);
        wert6.setText(text6);
    }

    @Override
    public void onClick(View v) {
        int wert = 0;
        switch (v.getId()){
            case R.id.down0:
                wert = Integer.parseInt(wert0.getText().toString());
                wert--;
                wert0.setText(String.valueOf(wert));
                break;
            case R.id.down1:
                wert = Integer.parseInt(wert1.getText().toString());
                wert--;
                wert1.setText(String.valueOf(wert));
                break;
            case R.id.down2:
                wert = Integer.parseInt(wert2.getText().toString());
                wert--;
                wert2.setText(String.valueOf(wert));
                break;
            case R.id.down3:
                wert = Integer.parseInt(wert3.getText().toString());
                wert--;
                wert3.setText(String.valueOf(wert));
                break;
            case R.id.down4:
                wert = Integer.parseInt(wert4.getText().toString());
                wert--;
                wert4.setText(String.valueOf(wert));
                break;
            case R.id.down5:
                wert = Integer.parseInt(wert5.getText().toString());
                wert--;
                wert5.setText(String.valueOf(wert));
                break;
            case R.id.down6:
                wert = Integer.parseInt(wert6.getText().toString());
                wert--;
                wert6.setText(String.valueOf(wert));
                break;
            case R.id.up0:
                wert = Integer.parseInt(wert0.getText().toString());
                wert++;
                wert0.setText(String.valueOf(wert));
                break;
            case R.id.up1:
                wert = Integer.parseInt(wert1.getText().toString());
                wert++;
                wert1.setText(String.valueOf(wert));
                break;
            case R.id.up2:
                wert = Integer.parseInt(wert2.getText().toString());
                wert++;
                wert2.setText(String.valueOf(wert));
                break;
            case R.id.up3:
                wert = Integer.parseInt(wert3.getText().toString());
                wert++;
                wert3.setText(String.valueOf(wert));
                break;
            case R.id.up4:
                wert = Integer.parseInt(wert4.getText().toString());
                wert++;
                wert4.setText(String.valueOf(wert));
                break;
            case R.id.up5:
                wert = Integer.parseInt(wert5.getText().toString());
                wert++;
                wert5.setText(String.valueOf(wert));
                break;
            case R.id.up6:
                wert = Integer.parseInt(wert6.getText().toString());
                wert++;
                wert6.setText(String.valueOf(wert));
                break;
        }
        saveData();
    }
    public void onStop() {
        super.onStop();
        saveData();
    }
    public void saveData(){
        dummy[0] = Integer.parseInt(wert0.getText().toString());
        dummy[1] = Integer.parseInt(wert1.getText().toString());
        dummy[2] = Integer.parseInt(wert2.getText().toString());
        dummy[3] = Integer.parseInt(wert3.getText().toString());
        dummy[4] = Integer.parseInt(wert4.getText().toString());
        dummy[5] = Integer.parseInt(wert5.getText().toString());
        dummy[6] = Integer.parseInt(wert6.getText().toString());

        SharedPreferences file = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = file.edit();

        editor.putString(w[0],String.valueOf(dummy[0]));
        editor.putString(w[1],String.valueOf(dummy[1]));
        editor.putString(w[2],String.valueOf(dummy[2]));
        editor.putString(w[3],String.valueOf(dummy[3]));
        editor.putString(w[4],String.valueOf(dummy[4]));
        editor.putString(w[5],String.valueOf(dummy[5]));
        editor.putString(w[6],String.valueOf(dummy[6]));
        editor.apply();

        //In for-Schleife geht es nicht
        /*
        for (int i = 0; i >= 7; i++){
            editor.putString(w[0],String.valueOf(dummy[0]));
            editor.apply();
        }
        */

    }

    public void loadData(){

        SharedPreferences file = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = file.getString(w[0], "0");
        text1 = file.getString(w[1], "0");
        text2 = file.getString(w[2], "0");
        text3 = file.getString(w[4], "0");
        text4 = file.getString(w[4], "0");
        text5 = file.getString(w[5], "0");
        text6 = file.getString(w[6], "0");
        //text = file.getString(TEXT, "0");
    }


}
