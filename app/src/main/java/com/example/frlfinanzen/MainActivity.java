package com.example.frlfinanzen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    Button btnEinzahlen, btnAuszahlen;

    //Dinger Schulden
    Button btnDownAndre, btnDownDetlef, btnDownLucas, btnDownMike, btnDownReik, btnDownRene, btnDownRico;
    Button btnUpAndre, btnUpDetlef, btnUpLucas, btnUpMike, btnUpReik, btnUpRene, btnUpRico;
    TextView wertAndre, wertDetlef, wertLucas, wertMike, wertReik, wertRene, wertRico;

    EditText einzahlung, auszahlung;
    TextView guthaben;

    double aktuellerStand, ergebnis;

    int wert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        tabLayout.setupWithViewPager(viewPager);

        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new fragment1(), "Finanzen");
        vpAdapter.addFragment(new fragment2(), "Schuldenliste");
        viewPager.setAdapter(vpAdapter);

        btnEinzahlen = (Button) findViewById(R.id.bEinzahlen);
        btnAuszahlen = (Button) findViewById(R.id.bAuszahlen);

        einzahlung = (EditText) findViewById(R.id.nEinzahlen) ;
        auszahlung = (EditText) findViewById(R.id.nAuszahlen);
        guthaben = (TextView) findViewById(R.id.guthaben);

        //Dinger Schuldenliste
        btnDownAndre = (Button) findViewById(R.id.downAndre);
        btnDownDetlef = (Button) findViewById(R.id.downDetlef);
        btnDownLucas = (Button) findViewById(R.id.downLucas);
        btnDownMike = (Button) findViewById(R.id.downMike);
        btnDownReik  = (Button) findViewById(R.id.downReik);
        btnDownRene = (Button) findViewById(R.id.downRene);
        btnDownRico = (Button) findViewById(R.id.downRico);

        btnUpAndre = (Button) findViewById(R.id.upAndre);
        btnUpDetlef = (Button) findViewById(R.id.upDetlef);
        btnUpLucas = (Button) findViewById(R.id.upLucas);
        btnUpMike = (Button) findViewById(R.id.upMike);
        btnUpReik  = (Button) findViewById(R.id.upReik);
        btnUpRene = (Button) findViewById(R.id.upRene);
        btnUpRico = (Button) findViewById(R.id.upRico);

        wertAndre = (TextView) findViewById(R.id.wertAndre);
        wertDetlef = (TextView) findViewById(R.id.wertDetlef);
        wertLucas = (TextView) findViewById(R.id.wertLucas);
        wertMike = (TextView) findViewById(R.id.wertMike);
        wertReik = (TextView) findViewById(R.id.wertReik);
        wertRene = (TextView) findViewById(R.id.wertRene);
        wertRico = (TextView) findViewById(R.id.wertRico);
        //Dinger Schuldenliste Ende


        /*
        btnEinzahlen.setOnClickListener(this);
        btnAuszahlen.setOnClickListener(this);

        btnDownAndre.setOnClickListener(this);
        btnDownDetlef.setOnClickListener(this);
        btnDownLucas.setOnClickListener(this);
        btnDownMike.setOnClickListener(this);
        btnDownReik.setOnClickListener(this);
        btnDownRene.setOnClickListener(this);
        btnDownRico.setOnClickListener(this);

        btnUpAndre.setOnClickListener(this);
        btnUpDetlef.setOnClickListener(this);
        btnUpLucas.setOnClickListener(this);
        btnUpMike.setOnClickListener(this);
        btnUpReik.setOnClickListener(this);
        btnUpRene.setOnClickListener(this);
        btnUpRico.setOnClickListener(this);


*/
        //Werte aus Preferences holen
        SharedPreferences myPreferences = getSharedPreferences("MyFile", 0);

        //guthaben.setText(myPreferences.getString("letzterWert", "0"));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.bEinzahlen:
                ergebnis = aktuellerStand + Double.parseDouble(einzahlung.getText().toString());
                guthaben.setText(String.valueOf(ergebnis));
                aktuellerStand = ergebnis;
                break;
            case R.id.bAuszahlen:
                ergebnis = aktuellerStand - Double.parseDouble(einzahlung.getText().toString());
                guthaben.setText(String.valueOf(ergebnis));
                aktuellerStand = ergebnis;
                break;
                //---------Ereignisse Schuldenliste down-------
            case R.id.downAndre:
                wert = Integer.parseInt(wertAndre.getText().toString());
                wertAndre.setText(String.valueOf(wert--));
                break;
            case R.id.downDetlef:
                wert = Integer.parseInt(wertDetlef.getText().toString());
                wertDetlef.setText(String.valueOf(wert--));
                break;
            case R.id.downLucas:
                wert = Integer.parseInt(wertLucas.getText().toString());
                wertLucas.setText(String.valueOf(wert--));
                break;
            case R.id.downMike:
                wert = Integer.parseInt(wertMike.getText().toString());
                wertMike.setText(String.valueOf(wert--));
                break;
            case R.id.downReik:
                wert = Integer.parseInt(wertReik.getText().toString());
                wertReik.setText(String.valueOf(wert--));
                break;
            case R.id.downRene:
                wert = Integer.parseInt(wertRene.getText().toString());
                wertRene.setText(String.valueOf(wert--));
                break;
            case R.id.downRico:
                wert = Integer.parseInt(wertRico.getText().toString());
                wertRico.setText(String.valueOf(wert--));
                break;
            //---------Ereignisse Schuldenliste up-------
            case R.id.upAndre:
                wert = Integer.parseInt(wertAndre.getText().toString());
                wertAndre.setText(String.valueOf(wert++));
                break;
            case R.id.upDetlef:
                wert = Integer.parseInt(wertDetlef.getText().toString());
                wertDetlef.setText(String.valueOf(wert++));
                break;
            case R.id.upLucas:
                wert = Integer.parseInt(wertLucas.getText().toString());
                wertLucas.setText(String.valueOf(wert++));
                break;
            case R.id.upMike:
                wert = Integer.parseInt(wertMike.getText().toString());
                wertMike.setText(String.valueOf(wert++));
                break;
            case R.id.upReik:
                wert = Integer.parseInt(wertReik.getText().toString());
                wertReik.setText(String.valueOf(wert++));
                break;
            case R.id.upRene:
                wert = Integer.parseInt(wertRene.getText().toString());
                wertRene.setText(String.valueOf(wert++));
                break;
            case R.id.upRico:
                wert = Integer.parseInt(wertRico.getText().toString());
                wertRico.setText(String.valueOf(wert++));
                break;

        }

    }
    protected void onStop(){
        super.onStop();
        SharedPreferences file = getSharedPreferences("MyFile", 0);

        SharedPreferences.Editor editor = file.edit();

        editor.putString("letzterWert", String.valueOf(aktuellerStand));

        editor.commit();

    }
}