package com.example.iu4;


import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.annotation.Nullable;

public class AdminSachbearbeiterEditierenAAS extends Activity {

    AdminSachbearbeiterEditierenK kontrolle = new AdminSachbearbeiterEditierenK();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_sachbearbeiter_editierenaas);

        String aktSachbearbeiter = SachbearbeiterAuswaehlenAAS.GEWAEHLTER_SACHBEARBEITER;

        String name = ((EditText) findViewById(R.id.sachbearbeiter_name_s)).getText().toString();
        String passwort = ((EditText) findViewById(R.id.sachbearbeiter_passwort)).getText().toString();


        boolean admin = ((RadioButton) findViewById((R.id.adminRadio))).isChecked();
        boolean normal = ((RadioButton) findViewById(((R.id.sachbearbeiterRadio)))).isChecked();


    }
}
