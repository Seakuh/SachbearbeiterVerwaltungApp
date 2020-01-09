package com.example.iu4;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class AdministratorAS extends Activity {

    Button.OnClickListener sachbearbeiterEditieren = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            //startActivity(new Intent(AdministratorAS.this, AdminSachbearbeiterEditierenAAS.class));
            Intent intent = new Intent(AdministratorAS.this, SachbearbeiterAuswaehlenAAS.class);
            intent.putExtra(SachbearbeiterS.NEXT, AdminSachbearbeiterEditierenAAS.class);
            startActivity(intent);
        }
    };

    Button.OnClickListener sachbearbeiterErstellen = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(AdministratorAS.this, AdminSachbearbeiterErzeugenAAS.class);
            //intent.putExtra(SachbearbeiterS.NEXT, AdminSachbearbeiterEditierenAAS.class);
            startActivity(intent);
        }
    };

    Button.OnClickListener sachbearbeiterLoeschen = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(AdministratorAS.this, SachbearbeiterAuswaehlenAAS.class);
            intent.putExtra(SachbearbeiterS.NEXT, AdminSachbearbeiterLoeschenAAS.class);
            startActivity(intent);
        }
    };

    Button.OnClickListener fortbildungZuweisen = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            FortbildungZuordnenAAS.setAdmin(true);
            Intent intent = new Intent(AdministratorAS.this, SachbearbeiterAuswaehlenAAS.class);
            intent.putExtra(SachbearbeiterS.NEXT, FortbildungZuordnenAAS.class);
            startActivity(intent);
        }
    };


    Button.OnClickListener fortbildungLoeschen = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            FortbildungLoeschenAAS.setIstAdmin(true);
            FortbildungZuordnenAAS.setAdmin(true);
            Intent intent = new Intent(AdministratorAS.this, SachbearbeiterAuswaehlenAAS.class);
            intent.putExtra(SachbearbeiterS.NEXT, FortbildungLoeschenAAS.class);
            startActivity(intent);

        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.administratoras);

        Button adminSachbearbeiterEditierenKnopf = (Button) this.findViewById(R.id.Adminsachbearbeitereditieren);
        adminSachbearbeiterEditierenKnopf.setOnClickListener(sachbearbeiterEditieren);
        //Button adminSachbearbeiterErstellenKnopf = (Button) this.findViewById(R.id.);
        //adminSachbearbeiterErstellenKnopf.setOnClickListener();

        Button adminSachbearbeiterErstellenKnopf = (Button) this.findViewById(R.id.Sachbearbeitererzeugen);
        adminSachbearbeiterErstellenKnopf.setOnClickListener(sachbearbeiterErstellen);

        Button adminSachbearbeiterLoeschenKnopf = (Button) this.findViewById(R.id.Adminsachbearbeiterloeschen);
        adminSachbearbeiterLoeschenKnopf.setOnClickListener(sachbearbeiterLoeschen);

        Button adminFortbildungZuweisenKnopf = (Button) this.findViewById((R.id.adminforbildungzuweisen));
        adminFortbildungZuweisenKnopf.setOnClickListener(fortbildungZuweisen);

        Button adminFortbildungLoeschenKnopf = (Button) this.findViewById(R.id.Adminfortbildungloeschen);
        adminFortbildungLoeschenKnopf.setOnClickListener(fortbildungLoeschen);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(AdministratorAS.this, loginas.class);
        startActivity(intent);
    }
}
