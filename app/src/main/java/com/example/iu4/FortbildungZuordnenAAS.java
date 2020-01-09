package com.example.iu4;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class FortbildungZuordnenAAS extends Activity {


    Activity act = this;

    public static String gewaehlterFortbildung;

    String[] fortbildungen;
    String name;
    public static boolean admin;
    FortbildungZuordnenK kontrolle = new FortbildungZuordnenK();
    boolean belegt = false;
    boolean bestanden = false;

    public static void setAdmin(boolean admin) {
        FortbildungZuordnenAAS.admin = admin;
    }

    //ButtonListener

    Button.OnClickListener zuordnen = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {


            belegt = ((RadioButton) findViewById(R.id.radioButtonBelegt)).isChecked();
            bestanden = ((RadioButton) findViewById((R.id.radioButtonBestanden))).isChecked();
            name = getIntent().getStringExtra(SachbearbeiterAuswaehlenAAS.GEWAEHLTER_SACHBEARBEITER);


            if (belegt) {

                if (kontrolle.bucheFortbildung(name, gewaehlterFortbildung, "Belegt")) {
                    if (admin) {
                        Intent intent = new Intent(FortbildungZuordnenAAS.this, AdministratorAS.class);
                        //intent.putExtra(SachbearbeiterS.NEXT, AdminSachbearbeiterEditierenAAS.class);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(FortbildungZuordnenAAS.this, SachbearbeiterAS.class);
                        //intent.putExtra(SachbearbeiterS.NEXT, AdminSachbearbeiterEditierenAAS.class);
                        startActivity(intent);
                    }

                } else {

                    AlertDialog.Builder builder1 = new AlertDialog.Builder(FortbildungZuordnenAAS.this);
                    builder1.setMessage("Fortbildung kann nicht Zugeordnet werden");
                    builder1.setCancelable(true);

                    builder1.setNeutralButton(
                            "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    startActivity(getIntent());
                                }
                            });

                    AlertDialog alert11 = builder1.create();
                    alert11.show();

                    if (admin) {
                        Intent intent = new Intent(FortbildungZuordnenAAS.this, AdministratorAS.class);
                        //intent.putExtra(SachbearbeiterS.NEXT, AdminSachbearbeiterEditierenAAS.class);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(FortbildungZuordnenAAS.this, SachbearbeiterAS.class);
                        //intent.putExtra(SachbearbeiterS.NEXT, AdminSachbearbeiterEditierenAAS.class);
                        startActivity(intent);
                    }
                }

            } else if (bestanden) {
                if (kontrolle.bucheFortbildung(name, gewaehlterFortbildung, "Bestanden")) {

                } else {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(FortbildungZuordnenAAS.this);
                    builder1.setMessage("Kann nicht zugeordnet werden");
                    builder1.setCancelable(true);

                    builder1.setNeutralButton(
                            "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    startActivity(getIntent());
                                }
                            });

                    AlertDialog alert11 = builder1.create();
                    alert11.show();


                }
            } else {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(FortbildungZuordnenAAS.this);
                builder1.setMessage("Keine Zuordnung ausgewaehlt");
                builder1.setCancelable(true);

                builder1.setNeutralButton(
                        "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                startActivity(getIntent());
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        }
    };


    Button.OnClickListener abbrechen = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (admin) {
                Intent intent = new Intent(FortbildungZuordnenAAS.this, AdministratorAS.class);
                //intent.putExtra(SachbearbeiterS.NEXT, AdminSachbearbeiterEditierenAAS.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(FortbildungZuordnenAAS.this, SachbearbeiterAS.class);
                //intent.putExtra(SachbearbeiterS.NEXT, AdminSachbearbeiterEditierenAAS.class);
                startActivity(intent);
            }


        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fortbildung_zuordnenaas);
        name = getIntent().getStringExtra(SachbearbeiterAuswaehlenAAS.GEWAEHLTER_SACHBEARBEITER);


        fortbildungen = Fortbildung.gibAlleFortbildungen();


        final ListView FortbildungListe = this.findViewById(R.id.listviewZuordnung);
        String[] alleFortbildungen = Fortbildung.gibAlleFortbildungen();

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, alleFortbildungen);
        FortbildungListe.setAdapter(itemsAdapter);
        FortbildungListe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                for (int j = 0; j < FortbildungListe.getChildCount(); j++)
                    FortbildungListe.getChildAt(j).setBackgroundColor(Color.TRANSPARENT);

                // change the background color of the selected element
                view.setBackgroundColor(Color.LTGRAY);



                gewaehlterFortbildung = (String) FortbildungListe.getAdapter().getItem(position);
                System.out.println("Fortbildung gewählt " + gewaehlterFortbildung);

                TextView statusErscheinen = (TextView) findViewById(R.id.setStatusTextZuweisen);
                statusErscheinen.setText(SachbearbeiterEK.getStatus(SachbearbeiterEK.gib(name),Fortbildung.gib(gewaehlterFortbildung)));

            }
        });

        Button zuordnenButton = (Button) this.findViewById(R.id.buttonZuordnen);
        zuordnenButton.setOnClickListener(zuordnen);

        Button abbruchButton = (Button) this.findViewById(R.id.buttonAbbrechen);
        abbruchButton.setOnClickListener(abbrechen);


    }
}

