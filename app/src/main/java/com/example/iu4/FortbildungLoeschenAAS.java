package com.example.iu4;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class FortbildungLoeschenAAS extends Activity {

    String name;
    String fortbildung;
    String gewaehlterFortbildung;

    public static void setIstAdmin(boolean istAdmin) {
        FortbildungLoeschenAAS.istAdmin = istAdmin;
    }

    public static boolean istAdmin = false;

    FortbildungLoeschenK kontrolle = new FortbildungLoeschenK();

    Button.OnClickListener okListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            boolean versehen = ((CheckBox) findViewById(R.id.radioButtonVersehen)).isChecked();
            if (versehen) {
                kontrolle.loescheVersehendlich(name, fortbildung);
                if (istAdmin) {
                    Intent intent = new Intent(FortbildungLoeschenAAS.this, AdministratorAS.class);
                    //intent.putExtra(SachbearbeiterS.NEXT, FortbildungLoeschenAAS.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(FortbildungLoeschenAAS.this, SachbearbeiterAS.class);
                    //intent.putExtra(SachbearbeiterS.NEXT, FortbildungLoeschenAAS.class);
                    startActivity(intent);
                }

            } else {
                if (kontrolle.loescheFortbildung(name, fortbildung)) {
                    TextView status = (TextView) findViewById(R.id.textViewStatus);
                    status.setText("Fortbildung wurde geloescht");
                } else {
                    TextView status = (TextView) findViewById(R.id.textViewStatus);
                    status.setText("Fortbildung kann nicht geloescht werden");
                }
                //Intent intent = new Intent(FortbildungLoeschenAAS.this, SachbearbeiterAuswaehlenAAS.class);
                //intent.putExtra(SachbearbeiterS.NEXT, FortbildungLoeschenAAS.class);
                //startActivity(intent);
            }


        }
    };

    Button.OnClickListener abbruchLauscher = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(istAdmin){
                Intent intent = new Intent(FortbildungLoeschenAAS.this, AdministratorAS.class);
                //intent.putExtra(SachbearbeiterS.NEXT, FortbildungLoeschenAAS.class);
                startActivity(intent);
            }else{
                Intent intent = new Intent(FortbildungLoeschenAAS.this, SachbearbeiterAS.class);
                //intent.putExtra(SachbearbeiterS.NEXT, FortbildungLoeschenAAS.class);
                startActivity(intent);
            }

        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fortbildung_loeschenaas);

        name = getIntent().getStringExtra(SachbearbeiterAuswaehlenAAS.GEWAEHLTER_SACHBEARBEITER);
        final SachbearbeiterEK aktSach = SachbearbeiterEK.gib(name);

        final ListView FortbildungListe = this.findViewById(R.id.listviewZuordnungLoeschen);
        String[] alleFortbildungen = Fortbildung.gibAlleFortbildungen();


        TextView nameEinfuegen = (TextView) findViewById(R.id.einsetzenSachbearbeiter);
        nameEinfuegen.setText(name);

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
                fortbildung = gewaehlterFortbildung;

                TextView status = (TextView) findViewById(R.id.textViewStatus);
                status.setText("Status: " + SachbearbeiterEK.getStatus(aktSach, Fortbildung.gib(gewaehlterFortbildung)));

            }
        });

        Button okKnopf = (Button) findViewById(R.id.buttonBesteatigen);
        okKnopf.setOnClickListener(okListener);

        Button abbruchKnopf = (Button) findViewById(R.id.buttonAbbruchFortbildungLoeschen);
        abbruchKnopf.setOnClickListener(abbruchLauscher);
    }
}
