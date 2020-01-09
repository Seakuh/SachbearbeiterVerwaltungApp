package com.example.iu4;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;

public class SachbearbeiterAuswaehlenAAS extends Activity {

    private Class naechsteAktivitaet;
    public static String GEWAEHLTER_SACHBEARBEITER;
    SachbearbeiterAuswaehlenK kontrolle = new SachbearbeiterAuswaehlenK();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sachbearbeiter_auswaehlenaas);
        Intent aktuellerIntent = this.getIntent();
        this.naechsteAktivitaet = (Class)aktuellerIntent.getSerializableExtra(SachbearbeiterS.NEXT);
    }

    protected void onStart() {
        super.onStart();
        final ListView sachbearbeiterListe = (ListView) this.findViewById(R.id.auswahllistview);
        String[] alleSachbearbeiter = kontrolle.gibAlleNamen();
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, R.layout.simple_item, alleSachbearbeiter);
        sachbearbeiterListe.setAdapter(itemsAdapter);
        sachbearbeiterListe.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String gewaehlterSachbearbeiter = (String) sachbearbeiterListe.getAdapter().getItem(position);
                        GEWAEHLTER_SACHBEARBEITER = gewaehlterSachbearbeiter;
                        Intent naechsterIntent = new Intent(SachbearbeiterAuswaehlenAAS.this, naechsteAktivitaet);
                        naechsterIntent.putExtra(GEWAEHLTER_SACHBEARBEITER, gewaehlterSachbearbeiter);
                        startActivity(naechsterIntent);
                    }
                });
    }




}

