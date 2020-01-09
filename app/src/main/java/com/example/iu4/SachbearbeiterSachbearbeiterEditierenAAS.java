package com.example.iu4;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

public class SachbearbeiterSachbearbeiterEditierenAAS extends FragmentActivity {


    Activity act = this;
    AdminSachbearbeiterEditierenK kontrolle = new AdminSachbearbeiterEditierenK();

    String aktSachbearbeiter = SachbearbeiterAuswaehlenAAS.GEWAEHLTER_SACHBEARBEITER;

    String name;
    String nameneu;
    String passwort;

    boolean admin;
    boolean normal;

    Button.OnClickListener okButtonListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {

            name = getIntent().getStringExtra(SachbearbeiterAuswaehlenAAS.GEWAEHLTER_SACHBEARBEITER);

            nameneu = ((EditText) findViewById(R.id.benutzernameEditText)).getText().toString();
            passwort = ((EditText) findViewById(R.id.sachbearbeiter_passwort)).getText().toString();

            if (kontrolle.kontrolliereEingabe(nameneu, passwort, "normal", name)) {
                Intent intent = new Intent(act, SachbearbeiterAS.class);
                act.startActivity(intent);
            } else {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(com.example.iu4.SachbearbeiterSachbearbeiterEditierenAAS.this);
                builder1.setMessage("Ungueltige Eingabe");
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


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sachbearbeiter_sachbearbeiter_editierenaas);


        Button okknopf = (Button) findViewById(R.id.okbutton);
        okknopf.setOnClickListener(okButtonListener);


    }


}



