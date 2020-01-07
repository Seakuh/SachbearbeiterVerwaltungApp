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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.administratoras);

        Button adminSachbearbeiterEditierenKnopf = (Button) this.findViewById(R.id.Adminsachbearbeitereditieren);
        adminSachbearbeiterEditierenKnopf.setOnClickListener(sachbearbeiterEditieren);
        //Button adminSachbearbeiterErstellenKnopf = (Button) this.findViewById(R.id.);
        //adminSachbearbeiterErstellenKnopf.setOnClickListener();


    }
}
