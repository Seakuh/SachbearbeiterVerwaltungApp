package com.example.iu4;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.annotation.Nullable;

public class loginas extends SachbearbeiterS {

    Activity act = this;
    LoginK kontrolle = new LoginK();

    Button.OnClickListener okKnopfLauscher = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {

            String benutzername = ((EditText) findViewById(R.id.benutzernameEditText)).getText().toString();
            String passwort = ((EditText) findViewById(R.id.sachbearbeiter_passwort)).getText().toString();

            boolean admin = ((RadioButton) findViewById((R.id.adminRadio))).isChecked();
            boolean normal = ((RadioButton) findViewById(((R.id.sachbearbeiterRadio)))).isChecked();

            if (admin) {
                if (kontrolle.kontrolleEingabe(benutzername, passwort).equals("admin")) {
                    Intent intent = new Intent(act, AdministratorAS.class);
                    act.startActivity(intent);
                } else {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(loginas.this);
                    builder1.setMessage("Benutzername, Passwort oder Berechtigung falsch!");
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


            } else if (normal) {
                if (kontrolle.kontrolleEingabe(benutzername, passwort).equals("normal")) {
                    Intent intent = new Intent(act, SachbearbeiterAS.class);
                    act.startActivity(intent);
                } else {

                    AlertDialog.Builder builder1 = new AlertDialog.Builder(loginas.this);
                    builder1.setMessage("Benutzername, Passwort oder Berechtigung falsch!");
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
        }

    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginaas);
        Button okKnopf = (Button) this.findViewById(R.id.okbutton);
        okKnopf.setOnClickListener(this.okKnopfLauscher);
    }
}