package com.example.iu4;


public class FortbildungLoeschenK {


    public boolean loescheFortbildung(String sachB, String fort) {
        if (Fortbildung.gib(fort).getVorraussetzung()) {
            return false;
        } else {
            SachbearbeiterEK.gib(sachB).getFortbildungen().remove(Fortbildung.gib(fort));
            return true;
        }


    }

    public void loescheVersehendlich(String sachB, String fort) {
        SachbearbeiterEK.loescheFortbildungVersehentlich(SachbearbeiterEK.gib(sachB), Fortbildung.gib(fort));
    }


}
