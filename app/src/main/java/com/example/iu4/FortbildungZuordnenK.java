package com.example.iu4;

public class FortbildungZuordnenK {


    public boolean bucheFortbildung(String name, String fortbildung, String status) {

        SachbearbeiterEK zuweisung = SachbearbeiterEK.gib(name);
        Fortbildung fortB = Fortbildung.gib(fortbildung);

        boolean belegt = SachbearbeiterEK.fortbildungBelegt(zuweisung, fortB);
        boolean hatvorraussetzung = Fortbildung.hatVorraussetzungen(fortB);
        boolean vorraussetzungenErfüllt = SachbearbeiterEK.pruefeVorraussetzung(zuweisung, fortB);

        System.out.println(belegt);
        System.out.println(hatvorraussetzung);
        System.out.println(vorraussetzungenErfüllt);

        if (!belegt && !hatvorraussetzung) {

            zuweisung.bucheFortbildung(fortB);

            System.out.println(
                    ">>Fortbildung: " + fortB.getTitel() + " wurde " + zuweisung.getBenutzerName() + " zugewiesen");
            SachbearbeiterEK.druckeFortbildungenStatus(zuweisung);
            return true;


        } else if (!belegt && vorraussetzungenErfüllt) {
            zuweisung.bucheFortbildung(fortB);
            return true;

        } else if (belegt) {
            zuweisung.setStatus(zuweisung, fortB, "Bestanden");
            return true;

        } else {

            return false;

        }


    }
}
