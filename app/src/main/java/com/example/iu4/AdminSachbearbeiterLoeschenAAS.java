package com.example.iu4;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

public class AdminSachbearbeiterLoeschenAAS extends FragmentActivity {

    String name;
    Activity act = this;


    AdminSachbearbeiterLoeschenK kontrolle = new AdminSachbearbeiterLoeschenK();

    Button.OnClickListener okButtonListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {
            name = getIntent().getStringExtra(SachbearbeiterAuswaehlenAAS.GEWAEHLTER_SACHBEARBEITER);
            kontrolle.loescheSachbearbeiter(name);


            AlertDialog.Builder builder1 = new AlertDialog.Builder(AdminSachbearbeiterLoeschenAAS.this);
            builder1.setMessage("Sachbearbeiter wurde geloescht");
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

            Intent intent = new Intent(act, AdministratorAS.class);
            act.startActivity(intent);

        }

    };


    Button.OnClickListener abbrechenButtonListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(act, AdministratorAS.class);
            act.startActivity(intent);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_sachbearbeiter_loeschenaas);


        name = getIntent().getStringExtra(SachbearbeiterAuswaehlenAAS.GEWAEHLTER_SACHBEARBEITER);

        System.out.println(name + " sollte der Name sein der ausgewaehlt wurde");

        TextView nameErscheinen = (TextView) findViewById(R.id.ausgewahlterLoescheSachbearbeiter);
        nameErscheinen.setText(name);


        Button okknopf = (Button) findViewById(R.id.bestaetigenloeschenbuttonadmin);
        okknopf.setOnClickListener(okButtonListener);

        Button abbrechenknopf = (Button) findViewById(R.id.abbrechenloeschenbuttonadmin);


    }


}
