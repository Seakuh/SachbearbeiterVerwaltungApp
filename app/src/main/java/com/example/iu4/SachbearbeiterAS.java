
package com.example.iu4;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class SachbearbeiterAS extends Activity {


    Button.OnClickListener sachbearbeiterEditieren = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            //startActivity(new Intent(AdministratorAS.this, AdminSachbearbeiterEditierenAAS.class));
            Intent intent = new Intent(SachbearbeiterAS.this, SachbearbeiterAuswaehlenAAS.class);
            intent.putExtra(SachbearbeiterS.NEXT, SachbearbeiterSachbearbeiterEditierenAAS.class);
            startActivity(intent);
        }
    };


    Button.OnClickListener fortbildungZuweisen = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            FortbildungZuordnenAAS.setAdmin(false);
            Intent intent = new Intent(SachbearbeiterAS.this, SachbearbeiterAuswaehlenAAS.class);
            intent.putExtra(SachbearbeiterS.NEXT, FortbildungZuordnenAAS.class);
            startActivity(intent);
        }
    };


    Button.OnClickListener fortbildungLoeschen = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            FortbildungLoeschenAAS.setIstAdmin(false);
            Intent intent = new Intent(SachbearbeiterAS.this, SachbearbeiterAuswaehlenAAS.class);
            intent.putExtra(SachbearbeiterS.NEXT, FortbildungLoeschenAAS.class);
            startActivity(intent);

        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sachbearbeiteras);

        Button adminSachbearbeiterEditierenKnopf = (Button) this.findViewById(R.id.sachbearbeitersachbearbeitereditieren);
        adminSachbearbeiterEditierenKnopf.setOnClickListener(sachbearbeiterEditieren);
        //Button adminSachbearbeiterErstellenKnopf = (Button) this.findViewById(R.id.);
        //adminSachbearbeiterErstellenKnopf.setOnClickListener();

        Button adminFortbildungZuweisenKnopf = (Button) this.findViewById((R.id.sachbearbeiterforbildungzuweisen));
        adminFortbildungZuweisenKnopf.setOnClickListener(fortbildungZuweisen);

        Button adminFortbildungLoeschenKnopf = (Button) this.findViewById(R.id.sachbearbeiterfortbildungloeschen);
        adminFortbildungLoeschenKnopf.setOnClickListener(fortbildungLoeschen);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(SachbearbeiterAS.this, loginas.class);
        startActivity(intent);
    }
}
